/*
 Cable Revenue Program
 This program calculates the revenue generated from  
 installing coaxial cable, given the number of installations
 and the yards of cable used.  Each installation earns $25
 and each foot of cable earns $2.  For example,
 for input of 3 installations and 15 yards of cable,
 the revenue earned would be $165.
*/

#include <stdio.h>

#define SERVICE_CHARGE 25   /*   service charge per installation */
#define PRICE_PER_FOOT 2     /*   unit cable price */

int main(void)
{
  int      installations;           /* number of installations */
  int      yardsOfCable;            /* yards of cable used */
  int      feetOfCable;             /* feet of cable used */
  int      revenue;                 /* dollars generated */

  /* Input (keyboard):  The number of installations */
  /*                    The yards of cable installed */

  printf ("Enter the number of installations: ");
  scanf("%d", &installations);
  
  printf ("Enter the yards of cable used: ");
  scanf("%d", &yardsOfCable);

  /* Computations */

  feetOfCable = yardsOfCable * 3;

   revenue = (installations * SERVICE_CHARGE) +
     (PRICE_PER_FOOT * feetOfCable);

   /* Output (screen):   The revenue generated*/ 

if (installations < 1) {
	printf("You did not generate any revenue because you did not complete an installation :(\n");
}
else {
	printf("The revenue generated is %d dollars.\n\n", revenue);
}
return 0;  
  
}
