#ifndef PARSERH
#define PARSERH

#include "stringlist.h"
#include "pipeline.h"

struct yylval {
  union {
    char    *string;
    clstage stage;
    slist   list;
  } v;
};

#define YYSTYPE struct yylval

extern int lineno;
extern int clerror;
extern pipeline parseresult;

extern int yyparse(void);       /* the parser made by yacc */
extern int yylex(void);         /* the scanner made by lex */
extern void set_scanstring(char *str); /* set the string to scan */

extern YYSTYPE yylval;

extern int matchedeof;          /* DEBUG */

#include "y.tab.h"

#endif
