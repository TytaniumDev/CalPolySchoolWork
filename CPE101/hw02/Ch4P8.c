/* Program to calculate emissions */
/* Made by Tyler Holland, Chp 4 program 8 */
/* CPE 101-01/02, 10/19/08 */
/* Fixed on 10/22/08 */

/* Declarations */
#include <stdio.h>
#define CUTOFF 50000 /* Cutoff between first 50k miles and second */
#define CM1 3.4 /* Pollutant 1 < cutoff */
#define CM2 4.2 /* Pollutant 1 > cutoff */
#define HC1 0.31 /* Pollutant 2 < cutoff */
#define HC2 0.39 /* Pollutant 2 > cutoff */
#define NO1 0.4 /* Pollutant 3 < cutoff */
#define NO2 0.5 /* Pollutant 3 > cutoff */
#define NH1 0.25 /* Pollutant 4 < cutoff */
#define NH2 0.31 /* Pollutant 4 > cutoff */

/* start main function */
int main(void)
{
   /* get variables */
   int pollute; /* pollutant number */
   double gpm; /* grams emitted per mile */
   int odometer; /* odometer reading */

   /* Get input */
   printf("(1) Carbon monoxide\n");
   printf("(2) Hydrocarbons\n");
   printf("(3) Nitrogen oxides\n");
   printf("(4) Nonmethane hydrocarbons\n");
   printf("Enter pollutant number>> ");
   scanf("%d", &pollute);
   printf("Enter number of grams emitted per mile>> ");
   scanf("%lf", &gpm);
   printf("Enter odometer reading>> ");
   scanf("%d", &odometer);

   /* Switch statement based on pollutant */
   switch (pollute) {

      case 1:
         if (odometer > CUTOFF) {
            if (gpm > CM2) {
               printf("Emissions exceed permitted level ");
               printf("of %.1f grams/mile.\n", CM2);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         else if (odometer < CUTOFF) {
            if (gpm > CM1) {
               printf("Emissions exceed permitted level ");
               printf("of %.1f grams/mile.\n", CM1);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         break;

      case 2:
         if (odometer > CUTOFF) {
            if (gpm > HC2) {
               printf("Emissions exceed permitted level ");
               printf("of %.2f grams/mile.\n", HC2);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         else if (odometer < CUTOFF) {
            if (gpm > HC1) {
               printf("Emissions exceed permitted level ");
               printf("of %.2f grams/mile.\n", HC1);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         break;

      case 3:
         if (odometer > CUTOFF) {
            if (gpm > NO2) {
               printf("Emissions exceed permitted level ");
               printf("of %.1f grams/mile.\n", NO2);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         else if (odometer < CUTOFF) {
            if (gpm > NO1) {
               printf("Emissions exceed permitted level ");
               printf("of %.1f grams/mile.\n", NO1);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         break;

      case 4:
         if (odometer > CUTOFF) {
            if (gpm > NH2) {
               printf("Emissions exceed permitted level ");
               printf("of %.2f grams/mile.\n", NH2);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         else if (odometer < CUTOFF) {
            if (gpm > NH1) {
               printf("Emissions exceed permitted level ");
               printf("of %.2f grams/mile.\n", NH1);
            }
            else {
               printf("Emissions are within permitted level.\n");
            }
         }
         break;
   }
   return(0);
}
