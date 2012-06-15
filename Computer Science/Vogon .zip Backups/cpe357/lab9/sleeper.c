/**
 * Lab 9: Sleeper
 * Made by Tyler Holland
 */
 
 #include <unistd.h>
 #include <stdlib.h>
 #include <stdio.h>
 #include <signal.h>
 #include <string.h>

static void handler(int signum) /*Based on textbook*/
{
   (void)write(STDOUT_FILENO, "I'm sleeping\n", 13);
}
 
int main(int argc, char *argv[])
{
   struct sigaction act;
   
   memset(&act, 0, sizeof(act));
   act.sa_handler = handler;
   
   if((sigaction(SIGINT, &act, NULL)) != 0)
   {
      fprintf(stderr, "Sigaction SIGINT failure\n");
      _exit(EXIT_FAILURE);
   }
   if((sigaction(SIGTSTP, &act, NULL)) != 0)
   {
      fprintf(stderr, "Sigaction SIGTSTP failure\n");
      _exit(EXIT_FAILURE);
   }
   if((sigaction(SIGHUP, &act, NULL)) != 0)
   {
      fprintf(stderr, "Sigaction SIGHUP failure\n");
      _exit(EXIT_FAILURE);
   }
   if((sigaction(SIGTERM, &act, NULL)) != 0)
   {
      fprintf(stderr, "Sigaction SIGTERM failure\n");
      _exit(EXIT_FAILURE);
   }
   if((sigaction(SIGSEGV, &act, NULL)) != 0)
   {
      fprintf(stderr, "Sigaction SIGSEGV failure\n");
      _exit(EXIT_FAILURE);
   }
   
   while(1) /*Continually sleep*/
   {
      sleep(3); /*Sleep for 3 seconds */
   }
   return 0;
}
