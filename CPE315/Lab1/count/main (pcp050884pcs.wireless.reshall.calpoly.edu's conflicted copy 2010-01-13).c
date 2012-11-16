#include <stdio.h>

int main (void) {
	double input;
	int current;
	int lastOne = 0;
	int adj = 0;
	int adjtotal = 0;
	printf("Enter a number: ");
	scanf("%lf", &input);
	
	/*Division loop*/
	while(input != 0)
	{
		current = (int)input % 2;
		if(current == 1)
		{
			if (lastOne == 1)
			{
				if (adj == 1)
				{
					adjtotal++;
				}
				adjtotal++;
			}
			else 
			{
				lastOne = 1;
			}
			adj++;
		}
		else if(current == 0)
		{
			adj = 0;
			lastOne = 0;
		}
		input = input/2;
	}
	
	printf("Your number has %d adjacent 1's", adjtotal);
	return 0;
}
