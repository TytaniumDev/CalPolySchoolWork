%{
#include <stdlib.h>
#include <stdio.h>
#include "pipeline.h"
#include "parser.h"

static void yyerror(char *s);

int      clerror;                /* a flag to indicate a error  */
pipeline parseresult;            /* global for the result of the parse */
YYSTYPE  yylval;

%}

%token T_string
%token T_pipe
%token T_into
%token T_from
%token T_newline
%token T_badstring

%%
cl:       commandlist T_newline {
                                  parseresult=make_pipeline($1.v.stage);
                                  free_stagelist($1.v.stage);
                                  clerror = check_pipeline(parseresult,lineno);
                                  YYACCEPT;
                                }
        | commandlist           {
                                  parseresult=make_pipeline($1.v.stage);
                                  free_stagelist($1.v.stage);
                                  clerror = check_pipeline(parseresult,lineno);
                                  YYACCEPT;
                                }
        ;

commandlist: command            {
                                  $$.v.stage = $1.v.stage;
                                }
        | commandlist T_pipe command
                                {
                                  $$.v.stage =
                                    append_stage($1.v.stage,
                                                 $3.v.stage);
                                }
        ;

command:  wordlist              {
                                  $$.v.stage = make_stage($1.v.list);
                                  free_slist($1.v.list);
                                }
        | command T_from word   {
                                  $$.v.stage = $1.v.stage;
                                  if ( $$.v.stage->inname == NULL ) {
                                    $$.v.stage->inname = $3.v.list->str;
                                    $3.v.list->str=NULL;
                                    free_slist($3.v.list);
                                  } else {
                                    /* duplication */
                                    yyerror("Ambiguous input redirection");
                                    free_slist($3.v.list);
                                  }
                                }
        | command T_into word   {
                                  $$.v.stage = $1.v.stage;
                                  if ( $$.v.stage->outname == NULL ) {
                                    $$.v.stage->outname = $3.v.list->str;
                                    $3.v.list->str=NULL;
                                    free_slist($3.v.list);
                                  } else {
                                    /* duplication */
                                    yyerror("Ambiguous output redirection");
                                    free_slist($3.v.list);
                                  }
                                }
        ;

wordlist: /* empty */           { /* create a new wordlist */
                                  $$.v.list=NULL;
                                }
        | wordlist word         { /* append this word onto the wordlist */
                                  $$.v.list=append_slist($1.v.list,
                                                         $2.v.list);
                                }
        ;

word:     T_string              {
                                  $$.v.list=new_slist_node($1.v.string,
                                                           NULL);
                                  free($1.v.string);
                                }
        | T_badstring           {
                                  $$.v.list=new_slist_node($1.v.string,
                                                           NULL);
                                  free($1.v.string);
                                  clerror++;
                                }
        ;

%%

static void yyerror(char *msg) {
  /* print the error message and consume the rest of the line*/
  fprintf(stderr,"%s, line %d.\n",msg,lineno);
  clerror++;                    /* flag the error */
}

