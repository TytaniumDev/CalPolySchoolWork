#include <stdio.h>

int charCount(char search, char* array, int place)
{
	if (array[place] == search && place < 20) 
	{
		return (1+charCount(search, array, (place+1)));
	}
	else if (place < 20)
	{
		return (charCount(search, array, (place+1)));
	}
	else 
	{
		return 0;
	}

}

int main (int argc, const char * argv[]) 
{
	char array[20];
	char search;
	int count = 0;
	char safety = 'a';
	
	printf("Enter a String: ");
	do 
	{
		scanf("%c", &safety);
		array[count] = safety;
		count++;
	} 
	while (safety != '\n' && count < 20);
	
	printf("Enter a char to search for: ");
	scanf(" %c", &search);
	printf("There are %d characters in that string.\n", charCount(search, array, 0));
    return 0;
}
