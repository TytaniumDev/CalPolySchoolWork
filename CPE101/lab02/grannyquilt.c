/* Granny Quilt program - to figure out the area,
   circumference, total cost, and 
   cost per person of the quilt.
   Made by Tyler Holland, Didier Jourdain CPE 101-01/02
*/

/* Include standard input/output and math for ceil(x) */
#include <stdio.h>
#include <math.h>

#define PI 3.141593      /* Define Pi for equations */
#define BUTTON_COST 2    /* Cost per Button in cents */
#define FRINGE_COST 20   /* Cost of Fringe per foot in cents */

int main(void)
{
   int diameter;         /* Diameter in feet of the quilt */
   int fabricCost;       /* Cost of fabric per square foot, in cents */
   int numOfPpl;         /* Number of people who will be sewing the quilt */
   int radius;           /* Radius of the Quilt */
   double area;          /* Area of the Quilt */
   double circumference; /* Circumference of the Quilt */
   double totalCost;        /* Total cost in whole cents */
   double costPerPerson;    /* Cost per person in whole cents */

   /* Input (Keyboard):   Diameter in feet            */
   /*                     Fabric cost per square foot */ 
   /*                     Number of people sewing     */
   printf("Enter integer diameter of the Quilt in feet: ");
   scanf("%d", &diameter);

   printf("Enter the fabric cost per square foot (in cents): ");
   scanf("%d", &fabricCost);

   printf("Enter the number of people sewing the quilt: ");
   scanf("%d", &numOfPpl);

   /* Functions */
   radius = diameter / 2;
   
   area = PI * radius * radius;

   circumference = PI * 2 * radius;

   totalCost = (fabricCost * area) + (BUTTON_COST * 12 * (radius * 4))
                  + (FRINGE_COST * circumference);

   costPerPerson = totalCost / numOfPpl;

   totalCost = ceil(totalCost);

   costPerPerson = ceil(costPerPerson);


   /* Outputs (on screen): Area of the Quilt                      */
   /*                      Circumference of the Quilt             */
   /*                      Total Cost in whole cents              */
   /*                      Amount owed per person, in whole cents */
   printf("The area of the quilt is %.2f square feet.\n", area);
   printf("The circumference of the quilt is %.2f square feet.\n", circumference);
   printf("The total cost for the quilt is %.0f cents.\n", totalCost);
   printf("The cost per person is %.0f cents.\n", costPerPerson);

return(0);

}
