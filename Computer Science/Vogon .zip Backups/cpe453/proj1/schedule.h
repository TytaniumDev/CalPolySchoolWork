/**
 * Project 1 : Schedule
 * Made by Tyler Holland
 */
 
 #include <unistd.h>
 #include <stdlib.h>
 #include <stdio.h>
 #include <sys/types.h>
 #include <sys/wait.h>
 #include <sys/time.h>
 #include <string.h>
 #include <fcntl.h>
 #include <errno.h>
 
typedef struct
{
   int sargc;
   char **sargv;
   pid_t pid;
   pid_t cwait;
   int status;
   int alive;
} Prog;

void catcher (int sig);
void childcatch (int sig);

/*Some global variables */
pid_t parent;

