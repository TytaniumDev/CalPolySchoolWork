%{
/*
 * lexer.l:  A scanner for cracking shell pipelines.  Rather than
 * reading stdin, though, this parser is set up to read from a
 * passed string.
 *
 * $Log: lexer.l,v $
 * Revision 1.6  2003-04-15 18:11:33-07  pnico
 * Checkpointing before distribution
 *
 * Revision 1.5  2003-04-10 19:35:30-07  pnico
 * Checkpointing distribution version
 *
 * Revision 1.4  2003-04-10 14:33:03-07  pnico
 * checkpointing the lexer before abandonin the approach ofo
 * multi-line strings
 *
 * Revision 1.3  2003-04-09 18:18:19-07  pnico
 * checkpointing before trying to clean the scanner for
 * Minix
 *
 * Revision 1.2  2003-04-06 15:34:22-07  pnico
 * scanner properly supports strings.  Checkpointing
 * before removing line-oriented interface.
 *
 * Revision 1.1  2003-04-06 14:16:27-07  pnico
 * Initial revision
 *
 * Revision 1.1  2003-04-06 14:15:21-07  pnico
 * Initial revision
 *
 *
 */

#include "config.h"

#include <stdio.h>
#include "stringstuff.h"
#include "parser.h"
#include <unistd.h>

int lineno=1;

#ifdef DEBUG_SCANNER
#define announce(s)             {fprintf(stdout,s);    fflush(stdout);}
#define announce1(s,arg)        {fprintf(stdout,s,arg);fflush(stdout);}
#else
#define announce(s)             /* nothing */
#define announce1(s,arg)        /* nothing */
#endif

/* Set up the input appropriately for the scanner.  Normally
 * working with lex/flex is very easy, but this parser has to
 * work on several different versions of unix.  That, naturally,
 * breeds complication...
 */
#ifdef FLEX_SCANNER
  #if ((YY_FLEX_MAJOR_VERSION < 2) || \
      ((YY_FLEX_MAJOR_VERSION <= 2) && (YY_FLEX_MINOR_VERSION < 5)))
    /* Set up the input to read from a string, not from standard in
     * This is for "old" versions of flex
     */
    #ifdef YY_INPUT
    #undef YY_INPUT
    #endif
    #define YY_INPUT(buf,result,max_size) {\
                          int c;                                \
                          c=nextfromstring();                   \
                          if (c==EOF) {                         \
                            result=YY_NULL;                     \
                          } else {                              \
                            *buf = c;                           \
                            result=1;                           \
                          }                                     \
                        }
  extern int nextfromstring(void); /* give it a prototype... */
  #else
  /* newer versions of FLEX can do it all by themselves. */
  #define SCANSTRING_DEFINED
  #endif
#else
  /* for real lex */
  #undef input
  #define input()  nextfromstring()
  #undef unput
  #define unput(c) putbackonstring(c)
#endif
/************************* Done setting up the input. ************/
%}


wordchar  ([^" \t\n<>|]|\\\") 

word {wordchar}+

quoted \"({wordchar}|[ \t])*\"?

string ({word}|{quoted}) 

%%

\%[^\n]*                { /* ignore comment */; }

[ \t]+                  { /* ignore whitespace*/; }

"\n"                    { lineno++; return T_newline; }

"<"                     { announce("<T_from>\n"); return T_from; }

">"                     { announce("<T_into>\n"); return T_into; }

"|"                     { announce("<T_pipe>\n"); return T_pipe; }

{string}                {
			  int token,ok;
			  ok=matchquotes(yytext);
                          yylval.v.string=cleancpystring(yytext);
                          if ( ok  ) {
                            announce1("<T_string(%s)>\n",yylval.v.string);
			    token=T_string;
                          } else {
                            announce1("<T_badstring(%s)>\n",yylval.v.string);
			    fprintf(stderr,"Unterminated string, line %d.\n",
				    lineno);
			    token=T_badstring;
                          } 
                          lineno += countlines(yylval.v.string);
                          return token;
                        }

%%

/* yywrap must be defined, but all it has to do is to tell lex
 * that there is no more input by returning true.
 */
#ifndef yywrap
int yywrap() {return 1;}
#endif


#ifndef SCANSTRING_DEFINED

/* these data and routines are only needed if yy_scan_string is not
 * defined
 */
static char *parsestring=NULL;
static int  atend;
static int  sindex;
static int  pushedback=FALSE;
static int  unputchar;

int nextfromstring(void) {
  /* return the next element from the string, or a newline 
   * at the end of the string.
   *   NOTE:  This means that when using this input method
   * the scanner will _never_ see an EOF.  It does avoid a 
   * problem under old flex where the scanner latches the EOF
   * state and never relinquishes it.
   */
  int res;

  if (pushedback) {
    res = unputchar;
    pushedback = FALSE;
  } else if ( ( parsestring == NULL) || 
              ( parsestring[sindex] == '\0' ) ) {
    res =  '\n';
  } else {
    res = parsestring[sindex++];
  }
  return res;
}

void putbackonstring(int c) {
  /* put back a character we didn't want after all */
  if ( pushedback ) {
    fprintf(stderr,
            "%s: Pushed back too many characters.\n",
            "putbackonstring");
    exit(-1);
  } else {
    pushedback=TRUE;
    unputchar=c;
  }
}

#endif

void set_scanstring(char *str) {
  /* set up flex to scan from a particular string */

  #ifdef SCANSTRING_DEFINED
    yy_scan_string(str);			/* use flex's interface */
  #else
    parsestring = str;
    atend = FALSE;
    sindex=0;
    pushedback=FALSE;
  #endif
}

