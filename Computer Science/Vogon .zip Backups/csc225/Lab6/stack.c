#include <stdio.h>
#include "stack.h"

int myStack[10]; //Holds the stack
int *top = &myStack[0]; //Holds the address of the top stack location
int *max = &myStack[10]; //Holds the address of the max of the stack

int push(int value)
{
	if (top >= max) //Top of the stack is at or above the max, overflow
	{
		return 1;
	}
	else
	{
		*top = value;
		top = top + 1;
		return 0;
	}
}

int pop(int *value)
{
	if (top <= &myStack[0])
	{
		return 1;
	}
	else 
	{
		top = top - 1;
		*value = *top;
		return 0;
	}
}


void printStack(int mode)
{	
	printf("Stack: ");
	int *count = &myStack[0]; 
	while (count < top)
	{
		switch (mode) 
		{
			case 0:
				printf("%d ", *count);
				break;
			case 1:
				printf("%x ", *count);
				break;
			case 2:
				printf("%c ", *count);
				break;
		}
		count = count + 1;
	}
	printf("\n\n");
}
