/* Lab exam 1 */
/* Made by Tyler Holland */

/* Definitions + include */
#include <stdio.h>

/* Start function */
int main(void) {

   /* Variables */
      /* Car 1 */
   int miles1; /* Total # of miles driven */
   double gCons1; /* # of gallons consumed by the car */
   double gCost1; /* Cost of gas per gallon */
   double mpg1; /* mpg of car 1 */
   double totalCost1; /* Cost to drive the car that many miles */
      /* Car 2 */
   int miles2; /* Total # of miles driven */
   double gCons2; /* # of gallons consumed by the car */
   double gCost2; /* Cost of gas per gallon */
   double mpg2; /* mpg of car 2 */
   double totalCost2; /* Cost to drive the car that many miles */
      /* Car 3 */
   int miles3; /* Total # of miles driven */
   double gCons3; /* # of gallons consumed by the car */
   double gCost3; /* Cost of gas per gallon */
   double mpg3; /* mpg of car 3 */
   double totalCost3; /* Cost to drive the car that many miles */
      /* Other Variables */
   double bestMPG; /* Best fuel efficiency */
   double avgMiles; /* Final avg miles driven */
   double totalMoney; /* Total cost of gas */

   /* Input: int miles, double gallons, double cost */
   scanf("%d %lf %lf", &miles1, &gCons1, &gCost1); /* Car 1 */

   scanf("%d %lf %lf", &miles2, &gCons2, &gCost2); /* Car 2 */

   scanf("%d %lf %lf", &miles3, &gCons3, &gCost3); /* Car 3 */

   /* Calculate fuel efficiency */
   mpg1 = miles1 / gCons1;
   mpg2 = miles2 / gCons2;
   mpg3 = miles3 / gCons3;

   /* Calculate best fuel efficiency */
   bestMPG = 0;
   if (bestMPG < mpg1) {
      bestMPG = mpg1;
   }
   if (bestMPG < mpg2) {
      bestMPG = mpg2;
   }
   if (bestMPG < mpg3) {
      bestMPG = mpg3;
   }
   /* Calculate average miles driven */
   avgMiles = (miles1 + miles2 + miles3) / 3;

   /* Calculate money spent on each car */
   totalCost1 = gCons1 * gCost1;
   totalCost2 = gCons2 * gCost2;
   totalCost3 = gCons3 * gCost3;

   /* Calculate total $ spent on gas */
   totalMoney = totalCost1 + totalCost2 + totalCost3;

   /* Print final output to screen */
   printf("The best fuel efficiency is %.1f miles per gallon\n", bestMPG);
   printf("The average number of miles driven is %.0f miles\n", avgMiles);
   printf("The total amount of money we've spent on gasoline has been $ %.2f \n", totalMoney);

return(0);
}
