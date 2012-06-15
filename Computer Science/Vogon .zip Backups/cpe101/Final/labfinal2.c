/* final problem 2*/
/* made by Tyler Holland, CPE101-01 */

#include <stdio.h>
#include <string.h>
#define WORD 18
#define MAP 22

int main(void){

   char search[MAP][WORD];
   char replace[MAP][WORD];
   char what[MAP][WORD];
   char final[MAP][WORD];
   int i = 0;
   int j = 0;
   int k = 0;
   int write = 0;

   do{
      scanf(" %s %s", search[i], replace[i]);
      i = i + 1;
   }while(strcmp(search[i - 1], "DONE") != 0 && strcmp(replace[i - 1], "DONE") != 0);

   do{
      scanf("%s", what[j]);
   }while(strcmp(what[j], ".") != 0);

   for(write = 0; write < j; write++){
      for(k = 0; k < i; k++){
         if(strcmp(search[k], what[k]) == 0) {
            strcpy(final[write],replace[k]);
         }
      }
   }

   for(i = 0; i < j; i++){
      printf("%s\n", final[i]);
   }

   return(0);
}
