/* Basic number manipulator (+ - * /)   */
/* Made by Tyler Holland, CPE101-01/02  */
/* Created on 10/5/08 */


/* Declarations */
#include <stdio.h>

/* Start Function */
int main(void)
{

/* Get numbers */
   double num1; /* Number 1 */
   double num2; /* Number 2 */
   double add; /* Addition value */
   double subtract; /* Subtraction value */
   double multiply; /* Multiplication value */
   double division; /* Division Value */

/* Get Input */
   printf("Enter an integer: ");
   scanf("%lf", &num1);

   printf("Enter another integer: ");
   scanf("%lf", &num2);

/* Calculations */
   add = num1 + num2;
  
   subtract = num1 - num2;

   multiply = num1 * num2;

   division = num1 / num2;

/* Display to screen */

   printf("The sum of your two numbers is %.0f.\n", add);

   printf("The difference between your two numbers is %.0f.\n", subtract);

   printf("The product of your two numbers is %.0f.\n", multiply);

   printf("The quotient of your two numbers (rounded to hundredths) is %.2f.\n", division);

return(0);

}
