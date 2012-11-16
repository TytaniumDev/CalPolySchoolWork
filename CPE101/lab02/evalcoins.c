/* EvalCoins.c
   Coin conversion. Compute pennies and nickels
	converted to dollars and change. 
	Tyler Holland
*/
#include <stdio.h>

int main(void)
{
    /* Data fields */
    double pennies; /* input - the number of pennies */
    double nickels; /* input - the number of nickels */
    double dimes;   /* input - the number of dimes */
    double bank;    /* the calculated total worth (in cents) */
    double dollars; /* the dollar portion of the total */
	  
    /* Obtain input amounts */ 
    printf("How many pennies: ");
    scanf("%lf", &pennies);
	 
    printf("How many nickels: ");
    scanf("%lf", &nickels);

    printf("How many dimes: ");
    scanf("%lf", &dimes);

   /* Calculate the total amount in cents */
   bank =  (10.0 * dimes) + (5.0 * nickels) + pennies;

   /* Calculate the dollar portion */
   dollars = bank / 100.0;

   /* Display results */
   printf("Your collection is worth:\n $%.2f\n", dollars);

   return 0;
}
