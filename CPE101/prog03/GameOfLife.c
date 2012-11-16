/* Programming project 3, THE GAME OF LIFE */
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>
#define BOARDH 25 /* Board height */
#define BOARDW 25 /* Board width */
/* Function Prototypes: */

void PrintSetup(void);
void Setup(int liveArray[BOARDH][BOARDW]);
void TheGame(int liveArray[BOARDH][BOARDW], int tempArray[BOARDH][BOARDW]);
void Copier(int liveArray[BOARDH][BOARDW], int tempArray[BOARDH][BOARDW]);
void Change(int tempArray[BOARDH][BOARDW], int liveArray[BOARDH][BOARDW]);
void Printer(int liveArray[BOARDH][BOARDW]);
int NumLiving(int tempArray[BOARDH][BOARDW], int x, int y);

/* Start main function */
int main(void)
{
   /* Variables */
   int liveBoard[BOARDH][BOARDW]; /* Live game board */
   int tempBoard[BOARDH][BOARDW]; /* Temporary game board */
   int i; /* Height LCV */
   int j; /* Width LCV */

   /* Array Setting to 0 */
   for(i = 0; i < BOARDH; i++) {
      for(j = 0; j < BOARDW; j++) {
         liveBoard[i][j] = 0;
         tempBoard[i][j] = 0;
      }
   }

   PrintSetup();
   Setup(liveBoard);

   printf("You chose:\n");
   Printer(liveBoard);

   TheGame(liveBoard, tempBoard);

   return(0);
}

/* Functions */
void PrintSetup(void)
{
   int x; /* X coord on game board */
   int y; /* Y coord on game board */
   int cell = 0; /* Cell # */
   int i; /* LCV for line */

   for(y = 0; y < BOARDH; y++) {
      for(x = 1; x <= BOARDW; x++) {
         cell = (y * BOARDW) + x;
         if (x == BOARDW) {
            if (cell < 10) {
               printf("| %d |", cell);
            }
            else if (cell < 100) {
               printf("| %d|", cell);
            }
            else {
               printf("|%d|", cell);
            }
         }
         else if (cell < 10) {
            printf("| %d ", cell);
         }
         else if (cell < 100) {
            printf("| %d", cell);
         }
         else {
            printf("|%d", cell);
         }
      }
      printf("\n");
      for (i = 0; i < BOARDW; i++) {
         printf("----");
      }
      printf("-\n");
   }
}

void Setup(int liveArray[BOARDH][BOARDW])
{
   int cell; /* Cell # */
   int x; /* X coord on game board */
   int y; /* Y coord on game board */

   printf("Enter # of cells to make living (Type 0 to stop):\n");
   do {
      printf("Cell # (0 to stop): ");
      scanf("%d", &cell);
      if (cell > (BOARDW * BOARDH) || cell < 0) {
         printf("Error: cell # out of bounds.\n");
      }
      else {
         y = cell / BOARDH;
         x = cell - (y * BOARDH) - 1;
         liveArray[y][x] = 1;
      }
   } while (cell != 0);
}

void TheGame(int liveArray[BOARDH][BOARDW], int tempArray[BOARDH][BOARDW])
{
   int i = 1; /* Counter */
   char generation = 'y'; /* Keep playing the game y/n variable */

   do {
      Copier(liveArray, tempArray);

      Change(tempArray, liveArray);

      printf("Generation %d:\n", i);
      Printer(liveArray);

      printf("Print next generation? (y/n): ");
      scanf(" %c", &generation);

      i++;
   } while(generation == 'y');
}

void Copier(int liveArray[BOARDH][BOARDW], int tempArray[BOARDH][BOARDW])
{
   int i; /* Height LCV */
   int j; /* Width LCV */

   for(i = 0; i < BOARDH; i++) {
      for(j = 0; j < BOARDW; j++) {
         tempArray[i][j] = liveArray[i][j];
      }
   }
}

void Change(int tempArray[BOARDH][BOARDW], int liveArray[BOARDH][BOARDW])
{
   int i; /* Height LCV */
   int j; /* Width LCV */
   int neighbor = 0; /* Number of neighbors */

   for(i = 0; i < BOARDH; i++) {
      for(j = 0; j < BOARDW; j++) {
         neighbor = NumLiving(tempArray, j, i);
         if (neighbor < 2) {
            liveArray[i][j] = 0;
         }
         if (neighbor > 3) {
            liveArray[i][j] = 0;
         }
         if (neighbor == 3) {
            liveArray[i][j] = 1;
         }
      }
   }
}

void Printer(int liveArray[BOARDH][BOARDW])
{
   int x; /* X coord on game board */
   int y; /* Y coord on game board */
   int i; /* LCV for printing line */

   for(y = 0; y < BOARDH; y++) {
      for(x = 0; x < BOARDW; x++) {
         if (x == (BOARDW - 1)) {
            if(liveArray[y][x] == 0) {
               printf("|   |");
            }
            else {
               printf("| X |");
            }
         }
         else {
            if(liveArray[y][x] == 0) {
               printf("|   ");
            }
            else {
               printf("| X ");
            }
         }
      }
      printf("\n");
      for (i = 0; i < BOARDW; i++) {
         printf("----");
      }
      printf("-\n");
   }
}

int NumLiving(int tempArray[BOARDH][BOARDW], int x, int y)
{
   int numLive = 0;

   /* Top Row */
   if (y != 0 && x != 0 && tempArray[y - 1][x - 1] == 1) {
      numLive = numLive + 1;
   }
   if (y != 0 && tempArray[y - 1][x] == 1) {
      numLive = numLive + 1;
   }
   if (y != 0 && x != (BOARDW - 1) && tempArray[y - 1][x + 1] == 1) {
      numLive = numLive + 1;
   }

   /* Middle Row */
   if (x != 0 && tempArray[y][x - 1] == 1) {
      numLive = numLive + 1;
   }
   if (x != (BOARDW - 1) && tempArray[y][x + 1] == 1) {
      numLive = numLive + 1;
   }

   /* Bottom Row */
   if (y != (BOARDH -1) && x != 0 && tempArray[y + 1][x - 1] == 1) {
      numLive = numLive + 1;
   }
   if (y != (BOARDH -1) && tempArray[y + 1][x] == 1) {
      numLive = numLive + 1;
   }
   if (y != (BOARDH - 1) && x != (BOARDW - 1) && tempArray[y + 1][x + 1] == 1) {
      numLive = numLive + 1;
   }
   return numLive;
}
