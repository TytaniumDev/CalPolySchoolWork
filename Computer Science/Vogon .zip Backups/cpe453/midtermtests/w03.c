#include <stdio.h>
void recurse(int i)
{
	int p, status;
	if (i > 3 )
		printf("execl\n");
	p = fork();
	if(!p)
	{
		printf("apple %d\n", i);
		recurse(i + 1);
	}
	else
	{
		wait(&status);
		printf("orange %d\n", i);
	}
}
int main(int argc, char *argv[])
{
	recurse(0);
	return 0;
}

