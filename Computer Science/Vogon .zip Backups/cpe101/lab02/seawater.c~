/* Use linear interpolation to compute the freezing point of seawater. */
/* Made by Tyler Holland, CPE101-01/02                                 */

#include <stdio.h>

int main(void)
{

/* Declaring Variables */
   int salinity1;
   int salinity2;
   int newsalinity;
   double temp1;
   double temp2;
   double predictedtemp;

/* Functions */

   printf("For data entry, salinity units are parts per thousand (integer)\n");
   printf("temperature is degrees Fahrenheit (floating point).\n");
   printf("Enter first observed salinity and temperature: ");
   scanf("%d %lf", &salinity1, &temp1);
  /* printf("Enter first observed temperature: ");
   scanf("%lf", &temp1); */
   printf("Enter second observed salinity and temperature: ");
   scanf("%d %lf", &salinity2, &temp2);
   /* printf("Enter second observed temperature: ");
   scanf("%lf", &temp2); */
   printf("Enter new salinity: ");
   scanf("%d", &newsalinity);

/* Computation */
   predictedtemp = temp1 + ((double) newsalinity - (double) salinity1)/((double) salinity2 - (double) salinity1) * (temp2 - temp1);

/* Display Result */
   printf("Interpolated freezing temperature: %f\n", predictedtemp);

return(0);

}







