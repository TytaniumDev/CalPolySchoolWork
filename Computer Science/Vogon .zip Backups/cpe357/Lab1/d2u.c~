/* Name: Tyler Holland */
/* Program: Lab 1 */

#include <stdio.h>

int main(void)
{
   char input1 = ' ';
   char input2 = ' ';
   char lastInput = ' ';
   int r = 0;
   
   while(input1 != EOF)
   {
      lastInput = input1;
      r = scanf("%c", &input1);
      /*Error checking*/
      if(r == EOF)
      {
         if(ferror(stdin))
         {
            perror("scanf failure on input");
            return 1;
         }
         if(lastInput != '\n')
         {
            r = putchar('\n');
            /*Found an Error*/
            if(r == EOF)
            {
               if(ferror(stdout))
               {
                  perror("putchar failure on output");
                  return  1;
               }
               return 0;
            }
         }
         return 0;
      }
      else if (r != 1)
      {
         perror("non-ASCII character in data stream");
         return 1;
      }
      /*Scanned in a <CR>*/
      if(input1 == '\r')
      {
         /*Check for <NL>*/
         r = scanf("%c", &input2);
         /*Error Checking*/
         if(r == EOF)
         {
            if(ferror(stdin))
            {
               perror("scanf failure on input");
               return 1;
            }
            if(lastInput != '\n')
            {
               r = putchar('\n');
               /*Found an Error*/
               if(r == EOF)
               {
                  if(ferror(stdout))
                  {
                     perror("putchar failure on output");
                     return  1;
                  }
                  return 0;
               }
            }
            return 0;
         }
         else if (r != 1)
         {
            perror("non-ASCII character in data stream");
            return 1;
         } 
         /*Scanned in a <NL> after <CR>*/
         if(input2 == '\n')
         {
            /*Print out <NL>, fixed*/
            r = putchar('\n');
            /*Found an Error*/
            if(r == EOF)
            {
               if(ferror(stdout))
               {
                  perror("putchar failure on output");
                  return  1;
               }
               return 0;
            }
         }
         /*Scanned in <CR> alone, print back out plus input2*/
         else
         {
            r = putchar('\r');
            /*Found an Error*/
            if(r == EOF)
            {
               if(ferror(stdout))
               {
                  perror("putchar failure on output");
                  return  1;
               }
               return 0;
            }
            r = putchar(input2);
            /*Found an Error*/
            if(r == EOF)
            {
               if(ferror(stdout))
               {
                  perror("putchar failure on output");
                  return  1;
               }
               return 0;
            }
         }
      }
      else
      {
         r = putchar(input1);
         /*Found an Error*/
         if(r == EOF)
         {
            if(ferror(stdout))
            {
               perror("putchar failure on output");
               return  1;
            }
            return 0;
         }
      }
   }
   return 0;	
}
