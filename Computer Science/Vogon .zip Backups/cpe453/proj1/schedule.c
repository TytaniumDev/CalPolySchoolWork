/**
 * Project 1 : Schedule
 * Made by Tyler Holland
 */
 
#include "schedule.h"

/* Catch SIGALRM, pause current process, reset timer, run next process */
void catcher (int sig)
{
   struct itimerval value;
   extern pid_t parent;
   
   if(getpid() == parent)
   {
      /*Don't stop this process*/
   }
   else if(raise(SIGSTOP) != 0)
   {
      perror("getitimer");
      exit(EXIT_FAILURE);
   }
   getitimer(ITIMER_REAL, &value);
   setitimer(ITIMER_REAL, &value, NULL);
}

/* Catch SIGCHLD, for children stuff */
void childcatch (int sig)
{
   /* Do Nothing */
} 
int main(int argc, char *argv[])
{
   Prog *process = NULL;
   int i; /*Counter*/
   int j; /*Counter*/
   int killcount = 0;
   int quantum = 0;
   int argcount = 0;
   int colonlast = 1;
   int argstart = 2;
   int totalargs = 0;
   extern pid_t parent;
   struct itimerval value;
   struct sigaction sig1, sig2;
   
   sigemptyset(&sig1.sa_mask);
   sig1.sa_handler = catcher;
   sigemptyset(&sig2.sa_mask);
   sig2.sa_handler = childcatch;
   sigaction(SIGALRM, &sig1, NULL);
   sigaction(SIGCHLD, &sig2, NULL);
   
   parent = getpid();
   
   /*Get input*/
   if(argc < 2)
   {
      fprintf(stderr, "usage: ./schedule <quantum(ms)> p1 [ p1 args ] : "
                      "p2 [p2 args] : [...]\n");
      exit(EXIT_FAILURE);
   }
   else
   {
      quantum = strtol(argv[1], NULL, 10);
      /*Convert from milli to norm*/
      value.it_interval.tv_sec = quantum / 1000;
      /*Convert from milli to micro*/
      value.it_interval.tv_usec = (quantum % 1000) * 1000;
      /*Set it to quantum time*/
      /*Convert from milli to norm*/
      value.it_value.tv_sec = quantum / 1000;
      /*Convert from milli to micro*/
      value.it_value.tv_usec = (quantum % 1000) * 1000;
   
      if(setitimer(ITIMER_REAL, &value, 0) < 0)
      {
         perror("setitimer");
         exit(EXIT_FAILURE);
      }
      
      for(i = 2; i < argc; i++)
      {
         if(strcmp(argv[i], ":") == 0) /* Hit a colon, allocate previous line */
         {
            /*malloc or realloc to get the right size */
            process = (Prog *)realloc(process, sizeof(Prog) * (totalargs + 1));
            process[totalargs].sargc = argcount; /*Set argcount*/
            process[totalargs].alive = 1; /* The process is alive */
            process[totalargs].status = -1;;
            process[totalargs].sargv = calloc(argcount, sizeof(char *));
            for(j = 0; j < argcount; j++)
            {
               process[totalargs].sargv[j] = argv[argstart+j];
            }
            argcount = 0;
            colonlast = 1;
            totalargs++;
         }
         else /* An argument line */
         {
            argcount++;
            if(colonlast == 1)
            {
               argstart = i;
            }
            colonlast = 0;
         }
      }
      /*malloc or realloc to get the right size */
      totalargs++;
      process = (Prog *)realloc(process, sizeof(Prog) * (totalargs));
      process[totalargs - 1].sargc = argcount; /*Set argcount*/
      process[totalargs - 1].alive = 1; /* The process is alive */
      process[totalargs - 1].status = -1;
      process[totalargs - 1].sargv = calloc(argcount, sizeof(char *));
      for(j = 0; j < argcount; j++)
      {
         process[totalargs - 1].sargv[j] = argv[argstart+j];
      }
      argcount = 0;
      colonlast = 1;;
   }
   
   for(i = 0; i < totalargs; i++) /*Fork all children*/
   {
      process[i].pid = fork();
      if(process[i].pid < 0)
      {
         perror("pid");
         /*Free it all*/
         for(i = 0; i < totalargs; i++)
         {
            free(process[i].sargv);
         }
         free(process);
         exit(EXIT_FAILURE);
      }
      if(process[i].pid == 0) /*Child i*/
      {
         /*Exec the children*/
         if((execvp(process[i].sargv[0], process[i].sargv)) < 0)
         {
            perror("execvp");
            /*Free it all*/
            for(i = 0; i < totalargs; i++)
            {
               free(process[i].sargv);
            }
            free(process);
            exit(EXIT_FAILURE);
         }
      }
      /*Stop the children*/
      if(kill(process[i].pid,SIGSTOP)< 0)
      {
         perror("stop pid");
         /*Free it all*/
         for(i = 0; i < totalargs; i++)
         {
            free(process[i].sargv);
         }
         free(process);
         exit(EXIT_FAILURE);
      }
   }
   
   /*Wait for all children*/
   /*for(i = 0; i < totalargs; i++)*/
   i = 0;
   while(killcount < totalargs)
   {
      if(process[i].alive == 1)
      {
         if(kill(process[i].pid,SIGCONT)< 0)
         {
            perror("continue pid");
            /*Free it all*/
            for(i = 0; i < totalargs; i++)
            {
               free(process[i].sargv);
            }
            free(process);
            exit(EXIT_FAILURE);
         }
         pause();
         if((process[i].cwait = waitpid(process[i].pid, &(process[i].status), 
                                        WUNTRACED)) == 0)
         {
            /*Just wait*/
         }
         else if(errno != EINTR) /*Check for interrupt*/
         {
            perror("waitpid");
            /*Free it all*/
            for(i = 0; i < totalargs; i++)
            {
               free(process[i].sargv);
            }
            free(process);
            exit(EXIT_FAILURE);
         }
         if(WIFEXITED(process[i].status)) /*Check if it actually died*/
         {
            process[i].alive = 0;
            killcount++;
         }
      }
      i++;
      if(i >= totalargs)
      {
         i = 0;
      }
   }
   
   /*Free it all*/
   for(i = 0; i < totalargs; i++)
   {
      free(process[i].sargv);
   }
   free(process);
   return 0;
}
