/* Lab 8c, file printout + reverse program */
/* Made by Tyler Holland, CPE101-01/02 */

/* Includes */
#include <stdio.h>
#define STRLENGTH 20
#define STRHEIGHT 100

/* Combined Function from parts a and b */
void filePrintReverse(char fileName[])
{
   FILE *filep; /* File to be opened */
   int i; /* LCV */
   int j = 0; /* Another LCV for vertical change in 2D array */
   int k = 0; /* Another LCV for nested for loop */
   int counter; /* For loop counter */
   char check; /* EOF Checker */
   char tempWord[STRLENGTH]; /* Temp word for easier scanning */
   char fileWords[STRHEIGHT][STRLENGTH]; /* Array of chars in the file */

   filep = fopen(fileName, "r");

   /* First printout */
   printf("The file before reversing:\n");
   check = fscanf(filep, "%s", tempWord); 
   while (check != EOF) {
      printf("%s\n", tempWord);
      check = fscanf(filep, "%s", tempWord); 
   }
   printf("\n");

   fclose(filep);
   filep = fopen(fileName, "r");

   /* Second, reversed printout */
   check = fscanf(filep, "%s", tempWord); 
   while (check != EOF) {
      counter = 0;

      for (i = 0; tempWord[i] != '\0'; i++) {
         counter = counter + 1;
      }

      /* Reverse the words into main array */
      for (i = 0; i < counter; i++) {
         fileWords[j][counter - 1 - i] = tempWord[i];
      }
      fileWords[j][counter] = '\0';

      check = fscanf(filep, "%s", tempWord);
      j = j + 1;
   }
   /* Print to screen */
   printf("The file reversed:");
   for(k = 0; k <= j; k++) {
      printf("%s\n", fileWords[j - k]);
   }
   printf("\n");

   fclose(filep);
}

/* Main Function */
int main(void)
{
   char fileName[STRLENGTH]; /* File name */

   /* Get input */
   printf("Enter a file to reverse: ");
   scanf("%s", fileName);

   filePrintReverse(fileName);

   return(0);
}
