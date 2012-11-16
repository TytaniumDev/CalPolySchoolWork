/* Basic number manipulator (+ - * /) using functions  */
/* Made by Tyler Holland, CPE101-01/02  */
/* Created on 10/19/08 */
/* Fixed on 10/22/08 */

/* Declarations */
#include <stdio.h>

/* Functions */
double Addition(double num1, double num2)
{
   double answer;
   answer = num1 + num2;
   return answer;
}

double Subtraction(double num1, double num2)
{
   double answer;
   answer = num1 - num2;
   return answer;
}
double Multiply(double num1, double num2)
{
   double answer;
   answer = num1 * num2;
   return answer;
}
double Division(double num1, double num2)
{
   double answer;
   answer = num1 / num2;
   return answer;
}

/* Start main function */
int main(void)
{
   /* Get variables */
   double num1; /* First number */
   double num2; /* Second number */

   /* Get input */
   printf("Enter an integer: ");
   scanf("%lf", &num1);

   printf("Enter another integer: ");
   scanf("%lf", &num2);

   /* Print output */
   printf("The sum of your two numbers is %.0f.\n", Addition(num1, num2));

   printf("The difference between your ");
   printf("two numbers is %.0f.\n", Subtraction(num1, num2));

   printf("The product of your two numbers is %.0f.\n", Multiply(num1, num2));

   printf("The quotient of your two numbers ");
   printf("(rounded to hundredths) is %.2f.\n", Division(num1, num2));

   return(0);
}
