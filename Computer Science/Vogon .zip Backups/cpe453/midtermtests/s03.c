#include <stdio.h>
int main(void)
{
	printf("Hello.\n");
	fork();
	fork();
	fork();
	printf("Goodbye!\n");
	return 0;
}
