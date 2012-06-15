#include <stdio.h>

void editword(char theword[])
{
   char *realword = "poopslol";
   (realword)[2] = 'Z';
   printf("realword: %s\n", realword);
   /*theword[2] = realword[2];*/
}

int main (void)
{
   char theword[21] = "thisisbadasdasd";
   editword(theword);
   printf("%s\n",theword);
   return 0;
   
}
