/* Program to calculate projectile movement */
/* Made by Tyler Holland, Chp 3 program 4 */
/* CPE 101-01/02, 10/19/08 */
/* Fixed on 10/22/08 */

/* Declarations */
#include <stdio.h>
#include <math.h>
#define G 32.17 /* gravitational constant */

/* Instruction Function */
void Instruct(void)
{
   printf("Please input the angle in radians, distance in ft, and ");
   printf("velocity in ft/sec in the appropriate prompts:\n");
}

/* Start main function */
int main(void)
{

   /* Variables */
   double theta; /* angle in radians of elevation */
   double distance; /* distance in ft to target */
   double velocity; /* projectile velocity in ft/s */
   double time; /* time in seconds of flight */
   double height; /* height at impact */

   /* Get input */
   Instruct();
   printf("Angle: ");
   scanf("%lf", &theta);

   printf("Distance: ");
   scanf("%lf", &distance);

   printf("Velocity: ");
   scanf("%lf", &velocity);

   /* Calculations */
   time = (distance) / (velocity * cos(theta));

   height = velocity * sin(theta) * time - (G * pow(time, 2)) / (2);

   /* Output to screen */
   printf("The duration of the flight was %f seconds.\n", time);
   printf("The projectile stopped at a height of %f feet.\n", height);

   return(0);
}
