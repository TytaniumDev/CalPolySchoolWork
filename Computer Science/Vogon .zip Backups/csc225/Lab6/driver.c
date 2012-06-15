/*
 *  driver.c
 *  Lab6
 *
 *  Created by Tyler Holland on 11/11/09.
 *
 */

#include <stdio.h>
#include "stack.h"

int main (int argc, char * argv[])
{
	printf("Welcome to the Stack Program\n\n");
	
	char input = 'a';
	int value = -9000;
	int error = 0; //Error check on push and pop
	int mode = 0;
	
	while (input != 'x')
	{
		printf("Enter Option: ");
		scanf(" %c", &input);
		switch (input) 
		{
			case 'u':
				printf("What number? ");
				scanf(" %d", &value);
				error = push(value);
				if (error == 1)
				{
					printf("Overflow!!!\n");
				}
				printStack(mode);
				break;
				
			case 'o':
				printf("Popped: ");
				error = pop(&value);							//CHECK
				if (error == 1)
				{
					printf("Underflow!!!\n");
				}
				else 
				{
					printf("%d\n", value);
				}
				printStack(mode);
				break;
				
			case 'h':
				mode = 1;
				printStack(mode);
				break;

			case 'd':
				mode = 0;
				printStack(mode);
				break;
				
			case 'c':
				mode = 2;
				printStack(mode);
				break;
				
			case 'x':
				break;
				
			default:
				printf("error, it defaulted");
				break;
		}
	}
	printf("Goodbye!");
	return 0;
}