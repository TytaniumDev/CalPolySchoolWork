/* Day of the year converter, in if/else statements     */
/* Made by Tyler Holland, CPE101-01/02 10:42 AM Oct 8th */

/* Declarations */
#include <stdio.h>

/* Set month to how many days are in them */
#define JANUARY 31
#define FEBRUARY 28
#define LEAP_FEBRUARY 29 /* Feb. in leap year */
#define MARCH 31
#define APRIL 30
#define MAY 31
#define JUNE 30
#define JULY 31
#define AUGUST 31
#define SEPTEMBER 30
#define OCTOBER 31
#define NOVEMBER 30
#define DECEMBER 31

int main(void) 
{
/* Variables */
   int month; /* Month given by the user */
   int day; /* Day given by the user */
   int year; /* Year given by the user */
   int actualDay; /* Calculated day of the year */
   char quit; /* Variable used to quit the loop */

/* Get Input and initialize quit*/
   printf("Hello and Welcome\n\n");
   quit = 'n';
/* Start Loop */
   do {
   /* Get month,day,year */
      printf("Enter a month number: ");
      scanf("%d", &month);
      printf("Enter a day of that month: ");
      scanf("%d", &day);
      printf("Enter the year: ");
      scanf("%d", &year);


   /* Print day number to screen */
      printf("That is the %d day of the year!\n", actualDay);

   /* Quit loop? */
      printf("Would you like to quit (y/n)? ");
      scanf(" %c", &quit);
/* Quit the loop */
   } while (quit == 'n' || quit == 'N');

return(0);
}
