/*
*
*   Number Juggling
*
*   CPE 101 Lab Activity
*   
*   *** student name goes here ***
*
*/
#include <stdio.h>

int main (void)
{
   int age;           /* person's age */
   int year;          /* Birth Year */
   int part1, part2;  /* partial results */
   double result;     /* final result */

   /* Get User Input */
   
   printf("Here is a clever number juggling trick.\n\n");

   printf( "Enter the year of your birth (positive 4-digit integer): "); 
   scanf("%d", &year);
   
   printf( "Enter your current age (positive integer): ");
   scanf("%d", &age);  
   
   /* Do some math magic */

   part1 =((year * 2) + 5) * 50;
   part2 = part1 + age;
   result = (part2 - 250) / 100.0;
   
   /* Display Results*/

   printf ("... and after juggling the numbers, the result is: ");
   printf ("%.2f\n",result);
   printf ("Isn't that amazing?\n");
   return 0;
}
