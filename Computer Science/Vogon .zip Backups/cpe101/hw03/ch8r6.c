/* Number reversing program, Review problem 6 in Chapter 8 */
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>
#define ARRAYSIZE 5

/* Functions */
void Reverse (int x[], int y[], int n)
{
   int i; /* counting variable in for loop */
   int count; /* set n value for loop */
   count = n;

   for(i = 0; i < count; i++) {
      y[i] = x[n-1];
      n = n - 1;
   }
}

/* Start main function */
int main(void)
{
   /* Variables */
   int i; /* Counting variable for print loop */
   int x[ARRAYSIZE] = {1,2,3,4,5}; /* x array */
   int y[ARRAYSIZE] = {0,0,0,0,0}; /* y array */
   int n = ARRAYSIZE; /* Size of array */

   /* Call function */
   Reverse(x, y, ARRAYSIZE);

   /* Print output loop */
   for (i = 0; i < ARRAYSIZE; i++) {
      printf("Contents of y array #%d : %d\n", i, y[i]);
   }

   return(0);
}
