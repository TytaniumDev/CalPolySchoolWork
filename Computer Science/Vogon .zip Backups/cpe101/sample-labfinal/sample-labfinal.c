/* Sample lab final program */
/* Made by Tyler Holland, CPE101-01/02 */
/* Teacher: C. Turner */

/* Declarations */
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define MAX_NAME 18
#define MAX_STORE 22

typedef struct{
   char first[MAX_NAME]; /* Person's first name */
   char last[MAX_NAME]; /* Person's last name */
   int age; /* Person's age */
} personT;

int main(void)
{
   /* Variables */
   personT people[MAX_STORE]; /* Person storage */
   char firstQ[MAX_NAME]; /* First name scan */
   char firstC[MAX_NAME]; /* copy of firstQ to convert to lowercase */
   int firsts = 0; /* # of first names matching firstQ */
   char lastQ[MAX_NAME]; /* Last name scan */
   char lastC[MAX_NAME]; /* cope of lastQ to convert to lowercase */
   int lasts = 0; /* # of last names matching lastQ */
   int firstAge = 0; /* Total of firsts' ages */
   int lastAge = 0; /* Total of lasts' ages */
   int totalAge = 0; /* Total age overall */
   int i = 0; /* do while counter */
   int j; /* For LCV */
   int k; /* another for LCV */

   do{
      scanf("%s %s %d", &people[i].first[0], &people[i].last[0],
                        &people[i].age);
         i = i + 1;
   } while (strcmp(people[i - 1].first, "DONE") != 0 ||
            strcmp(people[i - 1].last, "DONE") != 0 || people[i - 1].age != 0);

   scanf(" %s", &firstQ[0]);
   scanf( "%s", &lastQ[0]);

   /* Convert everything to lowercase */
   strcpy(firstC, firstQ);
   strcpy(lastC, lastQ);
   for(j = 0; j < strlen(firstC); j++) {
      firstC[j] = tolower(firstC[j]);
   }
   for(j = 0; j < strlen(lastC); j++) {
      lastC[j] = tolower(lastC[j]);
   }
   for(j = 0; j < MAX_STORE; j++) {
      for(k = 0; k < strlen(people[j].first); k++) {
         people[j].first[k] = tolower(people[j].first[k]);
      }
      for(k = 0; k < strlen(people[j].last); k++) {
         people[j].last[k] = tolower(people[j].last[k]);
      }
   }

   for(j = 0; j < i; j++) {
      if (strcmp(firstC, people[j].first) == 0) {
         firsts = firsts + 1;
         firstAge = firstAge + people[j].age;
      }
      if (strcmp(lastC, people[j].last) == 0) {
         lasts = lasts + 1;
         lastAge = lastAge + people[j].age;
      }
      totalAge = totalAge + people[j].age;
   }

   printf("%d people.  Total age is %d.\n", i - 1, totalAge);
   printf("%d people with first name %s.  ", firsts, firstQ);
   printf("Total age is %d.\n", firstAge);
   printf("%d people with last name %s.  ", lasts, lastQ);
   printf("Total age is %d.\n", lastAge);

   return(0);
}
