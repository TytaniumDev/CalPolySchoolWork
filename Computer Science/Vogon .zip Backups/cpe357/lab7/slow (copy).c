/**
 * Lab 7: Spinner
 * Made by Tyler Holland
 */
 
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <termios.h>

int main (int argc, char* argv[])
{
   time_t currentTime = time(0);
   char* tempstring;
   int counter = 0;
   unsigned int sleeptime = 1; /* Sleep for 1 second */
   unsigned int sleepleft = 0;
   int i = 0;

   setbuf(stdout, 0);
   printf("\n");
   while(sleepleft == 0)
   {
      i = 0;
      currentTime = time(0);
      tempstring = ctime(&currentTime);
      while(tempstring[i] != '\n')
      {
         i++;
      }
      
      tempstring[i] = '\0';
      printf("\r%s ", tempstring);
      switch(counter)
      {
         case 0:
            printf("|");
            break;
         case 1:
            printf("/");
            break;
         case 2:
            printf("-");
            break;
         case 3:
            printf("\\");
            break;
         default:
            break;
      }
      if(counter == 3)
      {
         counter = 0;
      }
      else
      {
         counter++;
      }
      sleepleft = sleep(sleeptime);
   }
   return 0;
}
