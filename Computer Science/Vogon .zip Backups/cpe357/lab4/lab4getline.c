/* Driver file for lab 4 with getline
 * Made by Tyler Holland
 * Class: CPE357
 */

#define _GNU_SOURCE
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "myline.h"

#define BUFL 1024

int main(void)
{
   char *buffer = NULL;
   int readLength;
   int writeLength;
   size_t length;
   FILE *fp;
   
   fp = stdin;
   if(fp == NULL)
   {
      exit(EXIT_FAILURE);
   }
   
   while((readLength = getline(&buffer, &length, fp)) > 0)
   {
      printf("readLength: %d\n", readLength);
      printf("length: %d\n", length);
      printf("buffer: ");
      if((writeLength = fwrite(buffer, 1, readLength, stdout)) != readLength)
      {
         if(writeLength >= 0)
         {
            fputs("Short fwrite to stdout\n", stderr);
         }
         else
         {
            perror("write to stdout");
         }
         exit(EXIT_FAILURE);
      }
   }
   
   if(buffer)
   {
      free(buffer);
   }
   return 0;
}
