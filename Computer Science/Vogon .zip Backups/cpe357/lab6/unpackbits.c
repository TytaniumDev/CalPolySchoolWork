/**
 * Lab 6: Unpack Bits
 * Made by Tyler Holland
 * Turns input from stdin into ASCII '1' and '0' characters.
 * Used code examples from Kevin O'Gorman
 */
 
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <termios.h>

#define LENGTH 7

int main (int argc, char* argv[])
{
   int ch;
   unsigned char bit;
   int i;
   int infd = STDIN_FILENO;
   struct termios origattr, newattr;
   
   /*O'Gorman code */
   /* Make interactive terminals VERY interactive */
   if (isatty(infd)) {
      /* Get original attributes of input */
      if (tcgetattr(infd, &origattr) != 0) {  
         perror("tcgetattr");
         exit(EXIT_FAILURE);
      }
      newattr = origattr;
      newattr.c_lflag &= ~ (ICANON | ECHO);   /* remove canonic processing and echo */
      newattr.c_cc[VMIN] = 1;                 /* go to reading one byte at a time */
      newattr.c_cc[VTIME] = 0;                /* do not wait for any more */
      if (tcsetattr(infd, TCSANOW, &newattr) != 0) {  /* set new attributes */
         perror("tcsetattr");
         exit(EXIT_FAILURE);
      }
   }
   
   setbuf(stdout, 0);  /* set non-buffered output */
   /*End O'Gorman code */

   while ((ch = getchar()) != EOF)
   {
      for(i = LENGTH; i >= 0; i--)
      {  
         bit = ((ch >> i) & 0x01);
         if(bit == 1)
         {
            putchar('1');
         }
         else if(bit == 0)
         {
            putchar('0');
         }
      }
      putchar(' ');
   }
   
   /*O'Gorman code */
   if (isatty(infd)) {
      if (tcsetattr(infd, TCSANOW, &origattr) != 0) {
         perror("tcsetattr");
         exit(EXIT_FAILURE);
      }
   }
   /*End O'Gorman code */
   return 0;
}
