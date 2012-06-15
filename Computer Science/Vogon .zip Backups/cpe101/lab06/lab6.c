/* Lab 6, File cleaning program */
/* Replaces tabs with 3 spaces and removes newlines */
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>

/* Start main function */
int main(void)
{
   /* Declare variables */
   FILE *infilep; /* input file pointer */
   FILE *outfilep; /* output file pointer */
   int counter = 0; /* Initialize counter variable for loop */
   char copy; /* character to copy to cleanfile */

   /* Open files */
   infilep = fopen("Junkfile", "r");
   outfilep = fopen("Cleanfile", "w");

   /* Start copy without tabs or newlines */
   counter = fscanf(infilep, "%c", &copy);
   while (counter != EOF) {
      if (copy == '\n') {
      } /* Don't copy anything to outfile */
      else if (copy == '\t') {
         fprintf(outfilep, "   ");
      }
      else {
         fprintf(outfilep, "%c", copy);
      }
      counter = fscanf(infilep, "%c", &copy);
   }
   fclose(infilep);
   fclose(outfilep);
   return(0);
}