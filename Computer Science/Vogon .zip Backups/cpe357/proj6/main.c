/*
 * cpl:  A shell pipeline cracker
 *
 * Author: Dr. Phillip Nico
 *         Department of Computer Science
 *         California Polytechnic State University
 *         One Grand Avenue.
 *         San Luis Obispo, CA  93407  USA
 *
 * Email:  pnico@csc.calpoly.edu
 *
 * Revision History:
 *         $Log: main.c,v $
 *
 *         Revision 1.5  2010-03-11 15:31:32 by Tyler Holland (username: tyhollan)
 *         Added changes to make it work with kogorman's 
 *         CPE357 Project 6 specifications.
 *
 *         Revision 1.4  2003-04-15 18:11:34-07  pnico
 *         Checkpointing before distribution
 *
 *         Revision 1.3  2003-04-12 10:37:22-07  pnico
 *         added config.h to list of inclusions
 *
 *         Revision 1.2  2003-04-11 08:38:55-07  pnico
 *         Ready for first release of mice
 *
 *         Revision 1.1  2003-04-10 19:36:24-07  pnico
 *         Initial revision
 *
 *
 */
#include "config.h"

#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>

/* 357 : more #includes */
#include <signal.h>
#include <string.h>
#include <sys/wait.h>
#include <errno.h>
#include <sys/stat.h>
#include <fcntl.h>
/* End 357 */

#include "pipeline.h"
#include "longstr.h"
#include "parser.h"

/* 357 : Change the prompt to Squeak */
#define PROMPT "Squeak? "
/* End 357 */

static void printusage(char *name);
static void prompt(char *prompt);
/* 357 : Create a signal handler for SIGINT */
static void handler(int signum)
{
  /* Print newline, and continue to run mice */
  (void)write(STDOUT_FILENO, "\n", 1);
  fflush(stdout);
}
/* End 357 */

int main(int argc, char *argv[]){
  char *line;
  pipeline pl;
  int run;
  char *promptstr;
  /* 357 more variables */
  int exitvar = FALSE;
  int fd = 0;
  /* End 357 */
  
  /* 357 : Handle the SIGINT signal, need to change back for children */
  struct sigaction act;
  
  memset(&act, 0, sizeof(act));
  act.sa_handler = handler;
  
  if((sigaction(SIGINT, &act, NULL)) != 0)
  {
    fprintf(stderr, "Sigaction SIGINT failure\n");
    _exit(EXIT_FAILURE);
  }
  /* End 357 */

  /* check for the right number of arguments */
  /* 357 : change it to argc > 2 for support of input files */
  if ( argc > 2 ) {
    printusage(argv[0]);
    exit(-1);
  }
  else if(argc == 2) /* Read from file */
  {
    fd = open(argv[1], O_RDONLY);
    if(fd < 0)
    {
      perror(argv[1]);
      exit(EXIT_FAILURE);
    }
    dup2(fd, STDIN_FILENO);
    exitvar = TRUE;
  }
  /* End 357 */

  /* set prompt */
  /* 357 : Prompt is MICEPROMPT if it exists, otherwise it's default*/
  if(getenv("MICEPROMPT") != NULL)
  {
    promptstr = getenv("MICEPROMPT");
  }
  else
  {
    promptstr = PROMPT;
  }
  /* End 357 */
  
  run = TRUE;
  prompt(promptstr);
  while ( run ) {
    if ( NULL == (line = readLongString(stdin)) ) {
      if ( feof(stdin) )
      {
        run = FALSE;
      }
    } else {
      /* We got a line, send it off to the pipeline cracker and
       * launch it
       */
      pl = crack_pipeline(line);

      /*
       * Show that it worked.  This is where you're going to do
       * something radically different: rather than printing the
       * pipeline, you're going to execute it.
       */
      if ( pl != NULL ) {
        /* 357 : instead of print_pipeline, use do_pipeline (in pipeline.c) */
        /* Deal with cd/exit, they will be the first and only command on the line */
        if(pl->stage[0].argv[0])
        {
          if((strcmp((pl->stage[0].argv[0]), "cd")) == 0)
          {
            if(chdir(pl->stage[0].argv[1]) == -1)
            {
              perror("cd");
              exit(EXIT_FAILURE);
            }
          }
          else if((strcmp((pl->stage[0].argv[0]), "exit")) == 0)
          {
            run = FALSE;
            exitvar = TRUE;
          }
          else
          {
            do_pipeline(pl);
          }
        }
      }
      free_pipeline(pl);          /* also frees line */
      lineno++;  /* readLongString trims newlines, so increment it manually */
    }
    if (run )                 /* assuming we still want to run */
      prompt(promptstr);
  }

  /* 357 : Print a newline after an EOF is hit, and before the program quits */
  if(exitvar == FALSE)
  {
    printf("\n");
  }
  /* End 357 */
  return 0;
}

static void prompt(char *pr) {
  /* If this is an interactive shell, flush the output streams and
   * print a prompt
   */

  if ( isatty(STDIN_FILENO) && isatty(STDOUT_FILENO) ) {
    printf("%s", pr);
    fflush(stdout);
  }
}

static void printusage(char *name){
  fprintf(stderr,"usage: %s\n",name);
}
