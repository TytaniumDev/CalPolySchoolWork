/* Day of the year converter, in switch statements      */
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

int main(void) {
/* Variables */
   int month; /* Month given by the user */
   int day; /* Day given by the user */
   int year; /* Year given by the user */
   int actualDay; /* Calculated day of the year */
   int leap; /* States if leap year is true or false */
   char quit; /* Variable used to quit the loop */

/* Get Input, initialize quit and actualDay*/
   printf("Hello and Welcome");
   quit = 'n';
   actualDay = 0;
/* Start Loop */
   do {
   /* Get month,day,year */
      printf("\n\nEnter a month number: ");
      scanf("%d", &month);
      printf("\nEnter a day of that month: ");
      scanf("%d", &day);
      printf("\nEnter the year: ");
      scanf("%d", &year);
   /* Determine leap year */
      if ((year%4) == 0) {
         if ((year%100) == 0) {
            if ((year%400) == 0) {
               leap = 1;
            }
            else 
               leap = 0;
         }
         else
            leap = 1;
      }
      else
         leap = 0;

   /* Start switch statement */
   switch (leap) { /* Leap year switch */
   case 1:

      switch (month) { /* Leap year month switch */

         case 1:
            actualDay = day;
            break;

         case 2:
            actualDay = JANUARY + day;
            break;

         case 3:
            actualDay = JANUARY + LEAP_FEBRUARY + day;
            break;

         case 4:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + day;
            break;

         case 5:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + day;
            break;

         case 6:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + day;
            break;

         case 7:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY 
                         + JUNE + day;
            break;

         case 8:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + day;
            break;

         case 9:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + day;
            break;

         case 10:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + day;
            break;

         case 11:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + OCTOBER + day; 
            break;

         case 12:
            actualDay = JANUARY + LEAP_FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + OCTOBER + NOVEMBER + day;
            break;
         }

      break;
   
   case 0:

      switch (month) { /* Normal year month switch */

         case 1:
            actualDay = day;
            break;

         case 2:
            actualDay = JANUARY + day;
            break;

         case 3:
            actualDay = JANUARY + FEBRUARY + day;
            break;

         case 4:
            actualDay = JANUARY + FEBRUARY + MARCH + day;
            break;

         case 5:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + day;
            break;

         case 6:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + day;
            break;

         case 7:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + day;
            break;

         case 8:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE 
                      + JULY + day;
            break;

         case 9:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + day;
            break;

         case 10:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + day;
            break;

         case 11:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + OCTOBER + day; 
            break;

         case 12:
            actualDay = JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE 
                         + JULY + AUGUST + SEPTEMBER + OCTOBER + NOVEMBER + day;
            break;
         }

      break;
   }


   /* Error Checking for final print */
   if (month <= 0 || month > 12) {
      printf("\nError there are only 12 months.\n\n\n");
   }
   else if (day > 31) {
      printf("\nError: no months have more than 31 days\n\n\n");
   }
   else if (day < 0) {
      printf("\nError: there are no days less than 0\n\n\n");
   }
   else if (month == 1 && day > JANUARY) {
      printf("\nError: that month only has %d days\n\n\n", JANUARY);
   }
   else if (month == 2 && day > LEAP_FEBRUARY && leap == 1) {
      printf("\nError: it's a leap year, but that month only has %d days\n\n\n", LEAP_FEBRUARY);
   }
   else if (month == 2 && day > FEBRUARY && leap == 0) {
      printf("\nError: that month only has %d days\n\n\n", FEBRUARY);
   }
   else if (month == 3 && day > MARCH) {
      printf("\nError: that month only has %d days\n\n\n", MARCH);
   }
   else if (month == 4 && day > APRIL) {
      printf("\nError: that month only has %d days\n\n\n", APRIL);
   }
   else if (month == 5 && day > MAY) {
      printf("\nError: that month only has %d days\n\n\n", MAY);
   }
   else if (month == 6 && day > JUNE) {
      printf("\nError: that month only has %d days\n\n\n", JUNE);
   }
   else if (month == 7 && day > JULY) {
      printf("\nError: that month only has %d days\n\n\n", JULY);
   }
   else if (month == 8 && day > AUGUST) {
      printf("\nError: that month only has %d days\n\n\n", AUGUST);
   }
   else if (month == 9 && day > SEPTEMBER) {
      printf("\nError: that month only has %d days\n\n\n", SEPTEMBER);
   }
   else if (month == 10 && day > OCTOBER) {
      printf("\nError: that month only has %d days\n\n\n", OCTOBER);
   }
   else if (month == 11 && day > NOVEMBER) {
      printf("\nError: that month only has %d days\n\n\n", NOVEMBER);
   }
   else if (month == 12 && day > DECEMBER) {
      printf("\nError: that month only has %d days\n\n\n", DECEMBER);
   }
   else {
      printf("\nThat is the %d day of the year!\n\n\n", actualDay);
   }

   /* Quit loop? */
      printf("Would you like to quit (y/n)? ");
      scanf(" %c", &quit);
/* Quit the loop */
   } while (quit == 'n' || quit == 'N');

return(0);
}
