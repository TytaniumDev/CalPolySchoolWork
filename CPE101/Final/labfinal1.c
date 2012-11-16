/* Lab final program 1 */
/* Made by Tyler Holland, CPE101-01 */

#define MAXINT 10
#include <stdio.h>

int main(void)
{
   int counter = -1;
   int firstin[MAXINT];
   int secondin[MAXINT];
   int i = 0;
   int acounter = 0;

   printf("Enter up to 10 integers, ending with 0: ");

   do {
      counter = counter + 1;
      scanf("%d", &firstin[counter]);
   }while (firstin[counter] != 0 && counter != MAXINT);

   printf("Enter another sequence, with exactly %d integers: ", counter);
   for(i = 0; i < counter - 1; i++) {
      scanf("%d", &secondin[i]);
   }

   if(counter == (MAXINT - 1)){
      counter = counter + 1;
   }

   for(i = 0; i < counter - 1; i++) {
      if(firstin[i] > secondin[i]) {
         acounter = acounter + 1;
         firstin[i] = 1;
      } else {
         firstin[i] = 0;
      }
   }
   printf("The first sequence is larger at these %d indexes:", acounter);
   for(i = 0; i < MAXINT; i++) {
      if(firstin[i] == 1){
         printf(" %d", i);
      }
   }
   printf("\n");
   return(0);
}
