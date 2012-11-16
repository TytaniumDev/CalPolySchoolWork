/* Cylinder content based on color program */
/* Made by Tyler Holland, CPE 101-01/02 */
/* Created on 10/5/08 */


/* Declarations */
#include <stdio.h>

/* Start Function */
int main(void)
{

/* Variables */
   char color; /* Color of the cylinder */

/* Get input */
   printf("What is the color of the cylinder? ");
   scanf("%c", &color);

/* Switch statement to determine contents of cylinder */
   switch (color) {
   case 'O':
   case 'o':
      printf("The cylinder contains Ammonia.\n");
      break;

   case 'B':
   case 'b':
      printf("The cylinder contains Carbon Monoxide.\n");
      break;

   case 'Y':
   case 'y':
      printf("The cylinder contains Hydrogen.\n");
      break;

   case 'G':
   case 'g':
      printf("The cylinder contains Oxygen.\n");
      break;

   default:
      printf("Contents unknown.\n");
}

return(0);

}


