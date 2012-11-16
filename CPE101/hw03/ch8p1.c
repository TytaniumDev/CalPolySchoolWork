/* Exam grading program, chapter 8 programming problem 1 */
/* Based on a 3 student class */
/* I could possibly make a more than 3 student based program
 * by scanning the input file until it finds EOF, but I am 
 * unsure how I would track their individual scores then without
 * having either a variable array or an insanely large array.
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>
#define QUESTIONS 50 /* # of possible Q's on multiple choice test */
#define STUDENTS 3 /* # of students */

/* Functions */
void FGetAnswers(FILE *infilep, char ans[], int quests) /* Retrieves answers */
{
   int i; /* For loop counter */

   for(i = 0; i < quests; i++) {
      fscanf(infilep, " %c", &ans[i]);
   } 
}

int Grade(char ans[], char student[], int miss[], int quests) /* Grades */
{
   int wrong; /* # of questions student got wrong */
   int right; /* # of right questions */
   int i; /* counting variable for loop */
   wrong = 0; /* Initialize wrong */
   right = 0; /* Initialize right */

   for(i = 0; i < quests; i++) {
      if (student[i] != ans[i]) {
         wrong = wrong + 1;
         miss[i] = miss[i] + 1;
      }
      else {
         right = right + 1;
      }
   }
   return wrong;
}

/* Start main function */
int main(void)
{
   /* Variables */
   FILE *infilep; /* Input file, examdat.txt */
   FILE *outfilep; /* Output file, report.txt */
   int quests; /* # of actual questions on test */
   int idscan; /* Temp value for scanning IDs */
   int studid[STUDENTS]; /* Student ID numbers array */
   double stuperc[STUDENTS]; /* Percentage for each student */
   char anskey[QUESTIONS]; /* Answer key array */
   char stuans1[QUESTIONS]; /* Student 1's answers */
   char stuans2[QUESTIONS]; /* Student 2's answers */
   char stuans3[QUESTIONS]; /* Student 3's answers */
   int miss[QUESTIONS]; /* Counts wrong answers per problem */
   int right[STUDENTS]; /* Total number right per student */
   int i; /* Counting variable */
   /* More students can be added manually */

   /* Open files */
   infilep = fopen("examdat.txt", "r");
   outfilep = fopen("report.txt", "w");

   fscanf(infilep, "%d", &quests); /* # of questions */
   /* Initializers */
   for(i = 0; i < QUESTIONS; i++) {
      anskey[i] = 'f';
      stuans1[i] = 'f';
      stuans2[i] = 'f';
      stuans3[i] = 'f';
      miss[i] = 0; 
   }
   for(i = 0; i < STUDENTS; i++) {
      studid[i] = 0;
      right[i] = 0;
      stuperc[i] = 0;
   }

   FGetAnswers(infilep, anskey, quests); /* Answer key */

   /* Student Answers */
   fscanf(infilep, "%d", &studid[0]);
   FGetAnswers(infilep, stuans1, quests);

   fscanf(infilep, "%d", &studid[1]);
   FGetAnswers(infilep, stuans2, quests);

   fscanf(infilep, "%d", &studid[2]);
   FGetAnswers(infilep, stuans3, quests);

   /* Student percentages calculations */
   right[0] = quests - Grade(anskey, stuans1, miss, quests);
   right[1] = quests - Grade(anskey, stuans2, miss, quests);
   right[2] = quests - Grade(anskey, stuans3, miss, quests);

   for(i = 0; i < STUDENTS; i++) {
      stuperc[i] = ( (double) right[i] / (double) quests ) * 100;
   }

   /* Print to file */
   fprintf(outfilep, "          Exam Report\n\n");
   fprintf(outfilep, "Question"); /* Answer key */
   for(i = 1; i <= quests; i++) {
      fprintf(outfilep, "  %d", i);
   }
   fprintf(outfilep, "\nAnswer  ");
   for(i = 0; i < quests; i++) {
      fprintf(outfilep, "  %c", anskey[i]);
   }

   fprintf(outfilep, "\n ID    Score(%%)\n"); /* Student results */
   for(i = 0; i < STUDENTS; i++) {
      fprintf(outfilep, "%d\t%.0f\n", studid[i], stuperc[i]);
   }

   fprintf(outfilep, "Question "); /* Missed results */
   for(i = 1; i <= quests; i++) {
      fprintf(outfilep, "  %d", i);
   }
   fprintf(outfilep, "\nMissed by");
   for(i = 0; i < quests; i++) {
      fprintf(outfilep, "  %d", miss[i]);
   }

   fclose(infilep);
   fclose(outfilep);

   return(0);
}
