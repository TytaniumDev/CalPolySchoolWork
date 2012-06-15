/* myline.c file for project 2
 * reads in a line and says how long that line was
 * Made by Tyler Holland
 * Class: CPE357
 */
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
 
 ssize_t myline(char **lineptr, size_t *n, FILE *stream)
 {
   int size = 0;
   int input;
   char *temp;
   
   if(!(*lineptr))
   {
      *lineptr = (char*)malloc(sizeof(char));
      *n = sizeof(char);
   }
   
   while((input = getc(stream)) != EOF && input != '\n')
   {
      if(feof(stream) != 0 || ferror(stream) != 0)
      {
         return -1;
      }
      if(ferror(stream) != 0)
      {
         return -1;
      }
      
      /* make sure I'm not going over */
      if(size >= *n)
      {
         temp = realloc(*lineptr, ((*n) * 2));
         if(temp)
         {
            *lineptr = temp;
            *n = ((*n) * 2);
         }
         else /* realloc was NULL */
         {
            return -1;
         }
      }
      (*lineptr)[size] = input;
      size++;
   }

   /* make sure I'm not going over for terminator and \n */
   if(size >= ((*n) - 1))
   {
      temp = realloc(*lineptr, ((*n) * 2));
      if(temp)
      {
         *lineptr = temp;
         *n = ((*n) * 2);
      }
      else /* realloc was NULL */
      {
         return -1;
      }
   }
   
   if(input == '\n')
   {
      (*lineptr)[size] = '\n';
      size++;
   }
   
   /* Write the terminator */
   (*lineptr)[size] = '\0';
   
   if(input == EOF)
   {
      return -1;
   }
   
   return (ssize_t)size;
 }
