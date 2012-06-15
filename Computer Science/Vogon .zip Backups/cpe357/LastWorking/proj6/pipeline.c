/*
 * a set of functions for manipulating pipeline structures.
 *
 * $Log: pipeline.c,v $
 * Revision 1.7  2003-04-15 18:11:34-07  pnico
 * Checkpointing before distribution
 *
 * Revision 1.6  2003-04-12 10:58:10-07  pnico
 * (oops) checked it in before compiling.  Fixed a typo.
 *
 * Revision 1.5  2003-04-12 10:56:53-07  pnico
 * added isempty() to check for NULL pipelines
 *
 * Revision 1.4  2003-04-12 10:37:05-07  pnico
 * *** empty log message ***
 *
 * Revision 1.3  2003-04-12 10:17:37-07  pnico
 * Cleaned up some declarations for porting to MINIX
 *
 */
#include "config.h"

#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
/* 357 : more # includes for do_pipeline */
#include <sys/wait.h>
#include <errno.h>
#include "pipeline.h"
#include "parser.h"


extern pipeline crack_pipeline(char *line) {
  pipeline pl;
  int rval;

  clerror=0;                    /* clear the error flag            */
  parseresult = NULL;           /* catch the case where parseresult is
                                                                       * not set due to errors
                                                                       *                                  */

  set_scanstring(line);         /* point the scanner at the line   */
  rval=yyparse();               /* parse the command line          */
  pl=parseresult;               /* retreive the resulting pipeline */

  if ( clerror ) {
    /* there was a parse error in the command line.  Just free it,
     * return NULL, and move on.
     * errors will have been reported in the parser.
     */
    free_pipeline(pl);
    pl=NULL;
  } else {
    pl->cline = line;            /* attach the command line */
  }

  #ifdef DEBUG_MICE
  fprintf(stdout,"\nyyparse() returned: %d clerror=%d\n",rval,clerror);
  #endif

  return pl;
}


extern void print_pipeline(FILE *where, pipeline pl){
  int i,j,argc;
  /* print out the resulting pipeline */
  if ( pl->cline ) {
    fprintf(where,"\n");
    fprintf(where,"--------\n");
    fprintf(where,"Command Line: \"%s\"\n",pl->cline);
    fprintf(where,"--------\n");
  }
  for(i=0;i<pl->length;i++) {
    fprintf(where,"\n");
    fprintf(where,"--------\n");
    fprintf(where,"Stage %d, length = %d\n",i, pl->length);
    fprintf(where,"--------\n");

    fprintf(where,"     input: %s\n",
            pl->stage[i].inname?pl->stage[i].inname:"(null)");
    fprintf(where,"    output: %s\n",
            pl->stage[i].outname?pl->stage[i].outname:"(null)");

    fprintf(where,"      argc: %d\n",pl->stage[i].argc);
    fprintf(where,"      argv: ");
    argc = pl->stage[i].argc;
    for(j=0;j<argc;j++) {
      fprintf(where,"\"%s\"%s",pl->stage[i].argv[j],
              (j<argc-1)?",":"");
    }
    fprintf(where,"\n");
  }
}

extern void free_pipeline(pipeline pl){
  /* free a pipeline, including all its stages */
  int i,j;
  if ( pl ) {
    if ( pl->cline )
      free(pl->cline);
    if ( pl->stage ) {
      for(i=0;i<pl->length;i++) {
        if ( pl->stage[i].argv ) {
          /* free each string of argv, then argv, if present */
          for(j=0;j<pl->stage[i].argc;j++)
            if ( pl->stage[i].argv[j] )
              free ( pl->stage[i].argv[j] );
          free(pl->stage[i].argv );
        }
      }
      free(pl->stage);        /* finally, toss the stage array */
    }
    free(pl);
  }
}

extern clstage make_stage(slist l){
  /* take the given stringlist and make a pipeline stage
   * out of it.
   *
   * returns a struct, not a pointer.  (careful...)
   */
  clstage stage=NULL;
  int i;

  stage = (clstage) malloc(sizeof(struct clstage));
  if ( !stage )
    perror("malloc");
  else {
    stage->inname   = NULL;
    stage->outname  = NULL;
    stage->argc     = slist_length(l);
    stage->argv     = (char **) malloc((stage->argc+1)* sizeof(char *));
    if ( !stage->argv ) {
      perror("malloc");
      stage->argc = 0;             /* no room -> no commands */
    } else {
      for (i=0;l;l=l->next) {
        stage->argv[i] = (char*)malloc(strlen(l->str)+1);
        if ( !stage->argv[i] )
          perror("malloc");
        else
          strcpy(stage->argv[i++],l->str);
      }
      stage->argv[i]=NULL;              /* add terminal NULL */
    }
    stage->next = NULL;
  }

  return stage;
}

extern void free_stage(clstage stage){
  /* free all the parts of the given stage */
  int i;
  if ( stage ) {
    if (stage->inname)
      free(stage->inname);
    if (stage->outname)
      free(stage->outname);
    if ( stage->argv ) {
      for (i=0; i<stage->argc ; i++)
        free(stage->argv[i]);
    }
    free(stage);
  }
}

extern void free_stagelist(clstage stage){
  /* free the entire stagelist */
  clstage next;
  for(;stage;stage=next) {
    next = stage->next;
    free_stage(stage);
  }
}

extern clstage append_stage(clstage s, clstage t) {
  /* append the list to to the list s and return the result */
  clstage res=NULL;
  if ( !s )
    res = t;
  else
    res = s;
  if ( s ) {
    for ( ; s->next ; s = s->next )
      /* find the end */;
    s->next = t;                /* and add t */
  }
  return res;
}

static int count_stages(clstage l) {
  int len=0;
  for(;l;l=l->next)
    len++;
  return len;
}

extern pipeline make_pipeline(clstage stages) {
  /*
   * take the given stage list and make a proper pipeline structure
   * out of it.
   *
   * make_pipeline steals the strings from the stage list, buty
   * they're not long for this world anyhow.
   *
   * returns the pipeline on success, NULL on failure.
   */
  pipeline pl;
  int i;

  pl = (pipeline)malloc(sizeof(struct pipeline));
  if ( !pl ) {
    perror("malloc");
  } else {
    pl->cline  = NULL;
    pl->length = count_stages(stages);
    pl->stage  = (struct clstage *)malloc(pl->length * sizeof(struct clstage));
    if ( !pl->stage ) {
      perror("malloc");
      pl->length = 0;
    } else {
      for(i=0;i<pl->length;i++){
        pl->stage[i].inname  = stages->inname;
        pl->stage[i].outname = stages->outname;
        pl->stage[i].argc    = stages->argc;
        pl->stage[i].argv    = stages->argv;
        pl->stage[i].next    = NULL;

        stages->inname  = NULL; /* NULL these so they won't be freed */
        stages->outname = NULL;
        stages->argc    = 0;
        stages->argv    = NULL;

        stages = stages->next;
      }
    }

  }

  return pl;
}

extern int check_pipeline(pipeline pl, int lineno) {
  /* check the given pipeline for internal consistency
   * returns 0 on success, 1 on failure.
   *
   * check for the presence of a conflicting redirect and
   * pipe.  This is actually fairly simple:  If there's
   * a redirect in anything other than the first or last
   * stage of the pipeline, there's a problem.
   *
   */
  int i;
  int err=0;
  for(i=0;i<pl->length;i++) {
    if ( (i>0) && (pl->stage[i].inname) ) {
      fprintf(stderr,"Ambiguous input redirection, line %d.\n",lineno);
      err++;
    }
    if ( (i<pl->length-1) && (pl->stage[i].outname) ) {
      fprintf(stderr,"Ambiguous output redirection, line %d.\n",lineno);
      err++;
    }
  }

  return err;
}

/* 357 : A function to do all of the pipeline stuff, based on lab 8 A */
extern void do_pipeline(pipeline pl)
{
  /* At most 2 pipes of fds will be needed at the same time */
  /* backpipefd = input for current child, frontpipefd = output for current child */
  int backpipefd[2];
  int frontpipefd[2];
  /* Arrays of child pid's based on pl length */
  pid_t *cpid;
  pid_t *cwait;
  /* Array of child statuses based on pl length */
  int *status;
  /* Normal variables */
  int i;
  char *append = NULL;
  int infd, outfd; /* fd's for redirected input/output */
  
  /* Malloc the dynamic arrays */
  cpid = (pid_t *)malloc((pl->length) * sizeof(pid_t));
  cwait = (pid_t *)malloc((pl->length) * sizeof(pid_t));
  status = (int*)malloc((pl->length) * sizeof(int));
  /* Clear arrays */
  for(i = 0; i < pl->length; i++)
  {
    cpid[i] = 0;
    cwait[i] = 0;
    status[i] = 0;
  }

  for(i = 0; i < pl->length; i++) /* loop through all of the stages */
  {
    /* Pipe i */
    if(i != 0) /* Not first child, move frontpipe to backpipe */
    {
      backpipefd[0] = frontpipefd[0];
      backpipefd[1] = frontpipefd[1];
    }
    if((i + 1) < pl->length) /* Check if another pipe is needed */
    {
      /* Make a new pipe */
      if(pipe(frontpipefd) == -1)
      {
        *append = (char)(i + 1);
        append = strcat(append, "pipe");
        perror(append);
        exit(EXIT_FAILURE);
      }
    }
    
    /* Fork i */
    if((cpid[i] = fork()) == -1)
    {
      *append = (char)(i + 1);
      append = strcat(append, "fork");
      perror(append);
      exit(EXIT_FAILURE);
    }
    
    /* Start child i */
    if(cpid[i] == 0)
    {
      /* Child i */
      /* Change child's fd's to proper things */
      /* 1 -> pipe -> 0 */
      /* so fd's are: */
      /* input: backpipefd[0] , output: frontpipefd[1] */
      /* Input fd duping */
      if(i == 0) /* Read from stdin or given input file */
      {
        if((pl->stage[i].inname) != NULL) /* There is a given input file */
        {
          infd = open((pl->stage[i].inname), O_RDONLY);
          if(infd < 0)
          {
            perror(pl->stage[i].inname);
            exit(EXIT_FAILURE);
          }
          dup2(infd, 0);
          if(close(infd) == -1) /* Don't leave fds open */
          {
            exit(EXIT_FAILURE);
          }
        }
        /* Otherwise, just let the program run by default */
      }
      else /* Not first stage in pipeline, link things together with fds */
      {
        dup2(backpipefd[0], 0);
        /* Close backpipe */
        if(close(backpipefd[0]) == -1)
        {
          exit(EXIT_FAILURE);
        }
        if(close(backpipefd[1]) == -1)
        {
          exit(EXIT_FAILURE);
        }
      }
      /* Output fd duping */
      if(i == (pl->length - 1)) /* Write to stdout or given output file */
      {
        /* It is the last instruction */
        if((pl->stage[i].outname) != NULL) /* There is a given output file */
        {
          outfd = open((pl->stage[i].outname), O_WRONLY | O_CREAT | O_TRUNC, 
                    S_IRUSR | S_IWUSR, S_IRGRP | S_IROTH);
          if(outfd < 0)
          {
            perror("output file creation error");
            exit(EXIT_FAILURE);
          }
          dup2(outfd, 1);
          if(close(outfd) == -1) /* Don't leave fds open */
          {
            exit(EXIT_FAILURE);
          }
        }
        /* Check if it is a pipeline situation, frontpipefd will still be open */
        if(i != 0)
        {
          if(close(frontpipefd[0]) == -1)
          {
            exit(EXIT_FAILURE);
          }
          if(close(frontpipefd[1]) == -1)
          {
            exit(EXIT_FAILURE);
          }
        }
        /* Otherwise, just let the program run by default */
      }
      else
      {
        dup2(frontpipefd[1], 1);
        /*Close frontpipe */
        if(close(frontpipefd[0]) == -1)
        {
          exit(EXIT_FAILURE);
        }
        if(close(frontpipefd[1]) == -1)
        {
          exit(EXIT_FAILURE);
        }
      }
      
      /* execvp the command */
      execvp((pl->stage[i].argv[0]), (pl->stage[i].argv));
      *append = *(pl->stage[i].argv[0]);
      append = strcat(append, " did not start");
      perror(append);
      _exit(EXIT_FAILURE);
      /* Child should not reach this point */
    }
  }
  /* Parent Process */
  /* Close all fd's in pipefd */
  if(pl->length > 1)
  {
    if(close(frontpipefd[0]) == -1)
    {
      exit(EXIT_FAILURE);
    }
    if(close(frontpipefd[1]) == -1)
    {
      exit(EXIT_FAILURE);
    }
    if(backpipefd[0] != frontpipefd[0])
    {
      if(close(backpipefd[0]) == -1)
      {
        exit(EXIT_FAILURE);
      }
    }
    if(backpipefd[1] != frontpipefd[1])
    {
      if(close(backpipefd[1]) == -1)
      {
        exit(EXIT_FAILURE);
      } 
    }
  }
  
  /* After all forks are done and fd's are closed, start waiting */
  /* Wait for all children */
  for(i = 0; i < pl->length; i++)
  {
    while((cwait[i] = wait(&(status[i]))) < 0) /* Wait for child to cease existing */
    {
      if(errno == EINTR || errno == EAGAIN)
      {
        continue;
      }
      *append = (char)(i + 1);
      append = strcat("Child", append);
      append = strcat(append, "has an error");
      perror(append);
      exit(EXIT_FAILURE);
    }
    fflush(stdout);
  }
  free(cpid);
  free(cwait);
  free(status);
}
/* End 357 */

