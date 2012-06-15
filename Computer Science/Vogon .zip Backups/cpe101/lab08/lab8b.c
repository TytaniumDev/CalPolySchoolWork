/* Lab 8b, file printout program */
/* Made by Tyler Holland, CPE101-01/02 */

/* Includes */
#include <stdio.h>
#define STRLENGTH 20

/* Printout Function */
void filePrint(char fileName[])
{
   FILE *filep; /* File to be opened */
   int i; /* LCV */
   char word[STRLENGTH]; /* Temp word storage */
   char check; /* EOF Checker */

   filep = fopen(fileName, "r");

   check = fscanf(filep, "%s", word); 
   while (check != EOF) {
      printf("%s\n", word);
      check = fscanf(filep, "%s", word); 
   }
   fclose(filep);
}

int main(void)
{
   /* Variables */
   char fileName[STRLENGTH]; /* Input string */

   /* Get input */
   printf("Enter a file to print: ");
   scanf("%s", fileName);

   /* Get # of chars till null */
   filePrint(fileName);

   return 0;
}
