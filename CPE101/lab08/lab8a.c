/* Lab 8a, string reversing program */
/* Made by Tyler Holland, CPE101-01/02 */

/* Includes */
#include <stdio.h>
#define STRLENGTH 20 /* String Length */

/* Reversing Function */
void wordReverse(char input[])
{
   int i; /* Counter for reversing purposes */
   int counter; /* For loop counter */

   counter = 0;
   for (i = 0; input[i] != '\0'; i++) {
      counter = counter + 1;
   }

   /* Print the word backwards from null */
   printf("The word reversed is: ");
   for (i = 0; i <= counter; i++) {
      printf("%c", input[counter - i]);
   }
   printf("\n");
}

int main(void)
{
   /* Variables */
   char input[STRLENGTH]; /* Input string */

   /* Get input */
   printf("Enter a word: ");
   scanf("%s", input);

   /* Get # of chars till null */
   wordReverse(input);

   return 0;
}
