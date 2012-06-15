/* Lab Exam 3 */
/* Made by Tyler Holland CPE 101 */

#include <stdio.h>
#define MAX 100

/* Functions */

/* Main */
int main(void)
{
   /* Variables */
   FILE *outp; /* Pointer to out file */
   char input[MAX]; /* Character Array */
   char final[MAX]; /* Reversed despaced array */
   char check = 0; /* EOF Checker */
   int i = 0; /* counter */
   int j = 0; /* For LCV */

   outp = fopen("RevDeBlanked.txt", "w");

   while (check != EOF){
      check = scanf(" %c", &input[i]);
      i = i + 1;
   }

   for(j = 0; j < i-1; j++) {
      final[j] = input[i-j-2];
   }

   for(j = 0; j < i-1; j++) {
      fprintf(outp, "%c", final[j]);
   }

   fclose(outp);
   return(0);
}
