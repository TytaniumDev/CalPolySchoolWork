#include <stdio.h>
void mystery1 (int *p);
int main(void)
{
   int sum = 254;
   int numbers = 10;
   int avg = 0;
	int num1;
	int num2;
	int num3;
	int num4;
	
	num1 = 3 % 2;
	num2 = 2 % 2;
	printf("3%2 = %d, 2%2 = %d\n", num1, num2);
	num1 = sum % numbers;
	num2 = sum / numbers;
	printf("%d\n%d\n", num1, num2);
	num3 = numbers / num1;
	printf("%d\n",num3);
	num4 = numbers % num1;
	printf("%d\n",num4);

   sum = 265;
   num1 = sum % numbers;
	num2 = sum / numbers;
	printf("%d\n%d\n", num1, num2);
	num3 = numbers / num1;
	printf("%d\n",num3);
	num4 = numbers % num1;
	printf("%d\n",num4);
   
	return 0;
}

void mystery1(int* p)
{
	int num1 = 7;
	int num2 = 9;
	*p = num2;
}
