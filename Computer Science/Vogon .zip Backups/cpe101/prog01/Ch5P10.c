/* Program to determine flow of water through a channel  */
/* and allow the user to guess the depth of the channel  */
/* Made by Tyler Holland, CPE101-01/02 10/14/08 11:27 AM */
/* Fixed on 10/22/08 */

/* Declarations */
#include <stdio.h>
#include <math.h>
#define SLOPE 0.0015 /* Slope of the channel */
#define ROUGHNESS 0.014 /* Roughness coefficient of the channel */
#define SETFLOW 1000.0 /* Set water flow through the channel */
#define K 1.486 /* Unit conversion factor */
/* Start Function */
int main(void)
{
   /* Set Variables */
   int depth; /* Depth of the channel */
   int width; /* Width of the channel */
   double area; /* Area of channel */
   double hRadius; /* Hydraulic radius */
   double guess; /* User's guess of the depth of the water */
   double flow; /* Flow determined by guess */
   double wetPerim; /* Wetted perimeter of the channel */
   double velocity; /* Velocity for calculating flow (V * A = flow) */
   double difference; /* Difference between guess and target flow */
   double error; /* Percent error between guess and target flow */
   double halfDepth; /* Half the depth for initial hint */ 

   /* Get initial input from user */
   printf("Enter the depth of the channel (1 to 50, whole integers): ");
   scanf("%d", &depth);
   printf("\nEnter the width of the channel (1 to 25, whole integers): ");
   scanf("%d", &width);

   /* Depth + Width Error Check */
   if (depth < 1 || depth > 50 || width < 1 || width > 25) {
      printf("\nError: Width and Depth values incorrect\n\n");
   }
   else { /* rest of the program */
   
      /* Calculate initial flow at half channel depth */
      halfDepth = depth / 2.0;
      wetPerim = width + (2 * halfDepth);
      area = (halfDepth / 2) * (2 * width);
      hRadius = (double)area / wetPerim;
      velocity = (K / ROUGHNESS) * (pow(hRadius, 2.0/3.0)) * (pow(SLOPE, .5));
      flow = velocity * area;

      /* Print flow at half depth to screen */
      printf("\n\n\nAt a depth of %.1f feet, the flow is ", halfDepth);
      printf("%.4f cubic feet per second.\n\n", flow);

      printf("Enter your initial guess (0 < guess < 10) ");
      printf("for the water depth\n\n");

      printf("when a flow of %.1f cubic feet ", SETFLOW);
      printf("per second is desired.\n");

      /* Start loop */
      error = 1; /* Initialize error */
      do {
         /* Get Guess */
         printf("\n\nEnter guess>");
         scanf("%lf", &guess);
         /* Error Check */
         if (guess > depth) { /* Too large guess error */
            printf("\nError: Guesses cannot exceed the depth of the channel");
         }
         else if (guess <= 0) { /* Too small guess error */
            printf("\nError: Guesses can not be 0 or negative");
         }
         else {
            /* Calculate */
            wetPerim = width + (2 * guess);
            area = (guess / 2) * (2 * width);
            hRadius = (double)area / wetPerim;
            velocity = (K / ROUGHNESS) * (pow(hRadius, 2.0/3.0)) 
                         * (pow(SLOPE, .5));
            flow = velocity * area;

            /* Calculations for printf's */
            difference = SETFLOW - flow;
            error = difference / 10.0;

            /* Print out results to screen */
            printf("\n\n\nDepth: %.6f ft", guess);
            printf("\tFlow: %.4f cf/s", flow);
            printf("\tTarget: %.1f cf/s\n\n", SETFLOW);
            printf("Difference: %.4f", difference); 
            printf("\tError: %.4f percent\n", error);

         } /* Ends else statement */

      /* End Loop if guess is within .1 percent */
      } while (error >= 0.1 || error <= -0.1); 

       printf("\nGOOD GUESS!\n\n\n");
   }
   return(0);
}
