/* Chapter 6 programming problem 10, Basic Calculator */
/* Made by Tyler Holland, 11/1/08 */
/* Declarations */
#include <stdio.h>
#include <math.h>

/* Functions */
/* Gets input and returns operator and right operand */
void ScanData (char *op, double *input)
{
   scanf(" %c %lf", op, input);
}

/* Does the commanded task and returns the value */
double DoNextOp (char op, double input, double total)
{
   switch (op) {
      case '+':
         total = total + input;
         break;

      case '-':
         total = total - input;
         break;

      case '*':
         total = total * input;
         break;

      case '/':
         if (input == 0) {
            printf("Error: dividing by 0\n");
         }
         else {
            total = total / input;
         }
         break;

      case '^':
         total = pow(total, input);
         break;
   } 
   return total;
}

/* Start main function */
int main(void)
{
   /* Declare variables */
   char op; /* User-input operator */
   double input; /* User-given numerical input */
   double total; /* Total result of the calculation thus far */

   /* Initialize some things */
   total = 0;
   op = 'a';

   /* Start loop, ends when q is the operator */
   do {
      /* Initialize input in loop for error check */
      input = -9000;

      /* Get input with scan_data function */
      ScanData(&op, &input);

      /* Error check, input must be a number */
      if (input != -9000) {
         /* Either quit or do as the user wants */
         if (op == '+' || op == '-' || op == '*' || op == '/' || op == '^') {
            total = DoNextOp(op, input, total);
            printf("result so far is %.1f\n", total);
         }
         else if (op == 'q') {
            printf("final result is %.1f\n", total);
         }
         else {
            printf("Error: Invalid operator\n");
         }
      }
      else {
         printf("Error: Invalid input\n");
      }
   }
   while (op != 'q'); /* End loop when q is the operator */
   return(0);
}
