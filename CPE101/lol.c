#include <stdio.h>

void wut(int *lol)
{
   printf("%d\n", *lol);
   *lol = 9001 + *lol;
}



int main(void)
{
   int lol;
   printf("Enter a number: ");
   scanf("%d", &lol);

   wut(&lol);

   printf("%d IS OVER 9000!", lol);

   return(0);
}
