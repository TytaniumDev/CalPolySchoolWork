/* Driver file for project 2
 * Made by Tyler Holland
 * Class: CPE357
 * Based on example given in man 3 getline
 */

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "myline.h"

int main(void)
{
   FILE *fp;
   char *line = NULL;
   size_t len = 0;
   int read;
   
   fp = stdin;
   if (fp == NULL)
   {
      exit(EXIT_FAILURE);
   }
   
   while((read = myline(&line, &len, fp)) != -1)
   {
      printf("Retrieved line of length %d :\n", read);
      printf("%s", line);
   }
   
   if(line)
   {
      free(line);
   }
   exit(EXIT_SUCCESS);
}
