/* Lab 10, automobile structs */
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>
#define MAKERNAME 15 /* Length of maker's name */
#define MODELNAME 15 /* Length of model name */

/* Structs */
typedef struct {
   int month;
   int day;
   int year;
} dateT;

typedef struct {
   double cap; /* capacity of the tank */
   double current; /* current fuel level */
} tankT;

typedef struct {
   char maker[MAKERNAME]; /* Company that makes the car */
   char model[MODELNAME]; /* Name of the car */
   int odometer; /* Odometer reading */
   dateT manu; /* Manufacture date */
   dateT purc; /* Purchase date */
   tankT tank; /* Tank info */
} autoT;

/* Functions */
int ScanDate(FILE *infilep, dateT *date)
{
   int end; /* EOF Checker */
   end = fscanf(infilep, "%d %d %d", &date->month, &date->day, &date->year);
   if (end == EOF) {
      return 0;
   }
   else {
      return 1;
   }
}

int ScanTank(FILE *infilep, tankT *tank)
{
   int end; /* EOF Checker */
   end = fscanf(infilep, "%lf %lf", &tank->cap, &tank->current);
   if (end == EOF) {
      return 0;
   }
   else {
      return 1;
   }
}

int ScanAuto(FILE *infilep, autoT *car)
{
   int end; /* EOF Checker */
   end = fscanf(infilep, "%s %s %d", car->maker, car->model, &car->odometer);
   if (end == EOF) {
      return 0;
   }
   else {
      return 1;
   }
}

void PrintDate(autoT car)
{
   printf("The automobile was manufactured on");
   printf(" %d-%d-%d", car.manu.month, car.manu.day, car.manu.year);
   printf(" and purchased on %d-%d-%d.\n\n", car.purc.month, car.purc.day,
           car.purc.year);
}

void PrintTank(autoT car)
{
   printf("The gas tank has a capacity of %.2f gallons", car.tank.cap);
   printf(" and currently holds %.2f gallons.\n\n", car.tank.current);
}

void PrintAuto(autoT car)
{
   printf("The automobile in question is a %s %s", car.maker, car.model);
   printf(" and it has %d miles on the odometer.\n\n", car.odometer);
}

/* Start main function */
int main(void)
{
   /* Variables */
   autoT car; /* Info about the car */
   int check = 1; /* Checks for EOF */
   FILE *infilep; /* Input file */

   infilep = fopen("infile.txt", "r");

   while(check != 0) {
      check = ScanAuto(infilep, &car);
      check = ScanDate(infilep, &car.manu);
      check = ScanDate(infilep, &car.purc);
      check = ScanTank(infilep, &car.tank);

      if(check == 1) {
         PrintAuto(car);
         PrintDate(car);
         PrintTank(car);
      }
   }

   fclose(infilep);

   return(0);
}
