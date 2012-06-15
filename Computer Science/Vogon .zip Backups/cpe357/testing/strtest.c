#include <stdio.h>
void intmystery(int *p)
{
  int num1 = 9;
  *p = num1;
}

void charmystery(char *ptr1, char *ptr2)
{
  /* Only copies the first character, not the whole array */
  char temp;
  temp = *ptr1;
  *ptr1 = *ptr2; 
  *ptr2 = temp;
}
int main(void)
{
  int num1 = 3;
  int num2 = 5;
  char a[] = "Cal";
  char b[] = "Poly";
  int *ptr = &num1;
  intmystery(ptr);
  charmystery(a, b);
  printf("%d\n%d\n", num1, num2);
  printf("%s\n%s\n", a, b);
	return 0;
}
