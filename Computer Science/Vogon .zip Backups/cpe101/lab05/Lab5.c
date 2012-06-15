/* Lab 5 Teller Machine program */
/* Made by Tyler Holland */
/* CPE101-01/02, 10/29/08 */

/*Declarations */
#include <stdio.h>
#include <ctype.h>

/* Function for deposit printout */
void DPrint(int total)
{
   /* Variables for bills */
   int fifty; /* # of fifties */
   int twenty; /* # of twenties */
   int ten; /* # of tens */

   /* Calculations */
   fifty = total / 50;
   twenty = (total - (fifty * 50)) / 20;
   ten =  (total - (fifty * 50) - (twenty * 20)) / 10;

   printf("You put in:\n");
   if (fifty >= 1) {
      if (fifty == 1) {
         printf("\t%d fifty dollar bill\n", fifty);
      }
      else {
         printf("\t%d fifty dollar bills\n", fifty);
      }
   }
   if (twenty >= 1) {
      if (twenty == 1) {
         printf("\t%d twenty dollar bill\n", twenty);
      }
      else {
         printf("\t%d twenty dollar bills\n", twenty);
      }
   }
   if (ten >= 1) {
      if (ten == 1) {
         printf("\t%d ten dollar bill\n", ten);
      }
      else {
         printf("\t%d ten dollar bills\n", ten);
      }
   }
   printf("\n GOODBYE\n\n");
}
/* Function for withdraw printout */
void WPrint(int total)
{
   /* Variables for bills */
   int fifty; /* # of fifties */
   int twenty; /* # of twenties */
   int ten; /* # of tens */

   /* Calculations */
   fifty = total / 50;
   twenty = (total - (fifty * 50)) / 20;
   ten =  (total - (fifty * 50) - (twenty * 20)) / 10;

   printf("You get back:\n");
   if (fifty >= 1) {
      if (fifty == 1) {
         printf("\t%d fifty dollar bill\n", fifty);
      }
      else {
         printf("\t%d fifty dollar bills\n", fifty);
      }
   }
   if (twenty >= 1) {
      if (twenty == 1) {
         printf("\t%d twenty dollar bill\n", twenty);
      }
      else {
         printf("\t%d twenty dollar bills\n", twenty);
      }
   }
   if (ten >= 1) {
      if (ten == 1) {
         printf("\t%d ten dollar bill\n", ten);
      }
      else {
         printf("\t%d ten dollar bills\n", ten);
      }
   }
   printf("\n GOODBYE\n\n");
}

/*Start main function */
int main(void)
{
   /* Variables */
   int error; /* Error check value for user name */
   char one; /* First char of user name */
   char two; /* Second char of user name */
   char three; /* Third char of user name */
   char four; /* Fourth char of user name */
   char action; /* Stores withdraw/deposit action */
   int amount; /* Amount for withdraw/deposit */
   int mult; /* Checks that input is a multiple of 10 */

   amount = 0; /* Initialize amount */
   /* Prompt user */
   printf("Enter the user name (4 characters): ");
   error = scanf("%c%c%c%c", &one, &two, &three, &four);
   if (isalpha(one) && isalpha(two) && isalpha(three) && isalpha(four)) {
      printf("Would you like to make a withdraw or deposit: ");
      scanf(" %c", &action);
      switch (action) { /* Start Switch */

         /* Withdraw */
         case 'w':
         case 'W':
            printf("Enter the amount you would like: ");
            scanf("%d", &amount);
            if (isalnum(amount)) {
               mult = amount % 10;
               if (amount == 0) {
                  printf("You chose not to withdraw anything today\n");
               }
               if (mult != 0) {
                  printf("Invalid entry: needs to be a multiple of 10\n");
               }
               else {
                  WPrint(amount);
               }
            }
            else {
               printf("Invalid entry: needs to be numeric\n");
            }
            break;

         /* Deposit */
         case 'd':
         case 'D':
            printf("Enter the amount you would like to deposit: ");
            scanf("%d", &amount);
            if (isalnum(amount)) {
               mult = amount % 10;
               if (amount == 0) {
                  printf("You chose not to deposit anything today\n");
               }
               if (mult!= 0) {
                  printf("Invalid entry: needs to be a multiple of 10\n");
               }
               else {
                  DPrint(amount);
               }
            }
            else {
               printf("Invalid entry: needs to be numeric\n");
            }
            break;

         /* Non W or D char */
         default:
            printf("Invalid option\n");
      }
   }
   else {
      printf("Invalid user name\n");
   }
   return(0);
}