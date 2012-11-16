/* Chapter 6 problem 2, Lab 4 */
/* Made by Tyler Holland, 10/22/08 */

/* Declarations */
#include <stdio.h>

/* Functions! */
void WallOfText(void) /* Prints out the inital prompt */
{
   printf("\t   GIVE A MEDICAL ORDER IN               CALCULATE RATE IN\n");
   printf("\t(1)   ml/hr & tubing drop factor              drops / ml\n");
   printf("\t(2)   1 L for n hr                            ml / hr\n");
   printf("\t(3)   mg/kg/hr & concentration in mg/ml       ml / hr\n");
   printf("\t(4)   units/hr & concentration in units/ml    ml / hr\n");
   printf("\t(5)   QUIT\n");
   printf("Problem=> ");
}

void OnePrint(double answer) /* Printout at the end of problem 1 */
{
   printf("The drop rate per minute is %.0f\n\n", answer);
}

double OneInput(void) /* Calculations and input for problem 1 */
{
   double mlHR; /* Rate in ml/hr */
   int dropF; /* Tubing's drop factor (drops/ml) */
   double answer; /* Final drop rate per minute */

   printf("Enter rate in ml/hr=> ");
   scanf("%lf", &mlHR);
   printf("Enter tubing's drop factor(drops/ml)=> ");
   scanf("%d", &dropF);

   /* Calculations */
   answer = (mlHR / 60.0) * dropF;
   return(answer);
}

int TwoAll(int hours) /* Calculations of problem 2 */
{
   int answer; /* Final answer for problem 2 */
   answer = 1000 / hours;
   return(answer);
}

void ThreePrint(double answer) /* Printout at the end of problem 3 */
{
   printf("The rate in milliliters per hour is %.0f.\n\n", answer);
}

double ThreeInput(void) /* Calculations and input for problem 3 */
{
   double rate; /* Rate in mg/kg/hr */
   int pWeight; /* Patient weight in kg */
   int conc; /* Concentration in mg/ml */
   double answer; /* Final drop rate per minute */

   printf("Enter rate in mg/kg/hr=> ");
   scanf("%lf", &rate);
   printf("Enter patient weight in kg=> ");
   scanf("%d", &pWeight);
   printf("Enter concentration in mg/ml=> ");
   scanf("%d", &conc);

   /* Calculations */
   answer = (pWeight * rate) / conc;
   return(answer);
}

void FourAll(int rate, int conc) /* Printout and calculations of problem 4 */
{
   int answer; /* Final answer for problem 4 */
   answer = rate / conc;
   printf("The rate in milliliters per hour is %d.\n\n", answer);
}

/* Start main function */
int main(void)
{
   int hoursTwo; /* Hours for problem 2 */
   int rateFour; /* Rate for problem 4 */
   int concFour; /* Concentration for problem 4 */
   int prog; /* Program # */
   double answerOne; /* Answer for problem 1 */
   int answerTwo; /* Answer for problem 2 */
   double answerThree; /* Answer for problem 3 */

   /* Start loop */
   do {
      WallOfText();
      scanf("%d", &prog);
      /* Start wanted program */
      if (prog == 1) {
         answerOne = OneInput();
         OnePrint(answerOne);
      }
      else if (prog == 2) {
         printf("Enter number of hours=> ");
         scanf("%d", &hoursTwo);
         answerTwo = TwoAll(hoursTwo);
         printf("The rate in milliliters per hour is %d.\n\n", answerTwo);
      }
      else if (prog == 3) {
         answerThree = ThreeInput();
         ThreePrint(answerThree);
      }
      else if (prog == 4) {
         printf("Enter rate in units/hr=> ");
         scanf("%d", &rateFour);
         printf("Enter concentration in units/ml=> ");
         scanf("%d", &concFour);
         FourAll(rateFour, concFour);
      }
   } while (prog != 5);
   return(0);
}
