/* Programming Project 4 */
/* Can only remember up to 20 of each type of item at once */
/* Made by Tyler Holland, CPE101-01/02 */

/* Declarations */
#include <stdio.h>
#define NAME 30
#define NUMITEMS 20

/* Structs */

typedef struct{
   int dollars;
   int cents;
} usd;

typedef struct{
   int month;
   int day;
   int year;
} dateT;

typedef struct{
   char item[NAME]; /* Item name string */
   int price; /* Item price in cents */
} itemT;

typedef struct{
   itemT info; /* Item name and price */
   char meatType; /* Meat Type */
   dateT packDate; /* Packaging date */
   dateT expire; /* Expiration date */
} meatT;

typedef struct{
   itemT info; /* Item name and price */
   char proType; /* Produce type */
   dateT receive; /* Date received */
} produceT;

typedef struct{
   itemT info; /* Item name and price */
   dateT expire; /* Expiration date */
} dairyT;

typedef struct{
   itemT info; /* Item name and price */
   dateT expire; /* Expiration date */
   int aisle; /* Aisle Number */
   char side; /* Aisle side */
} cannedT;

typedef struct{
   itemT info; /* Item name and price */
   char type; /* Category type */
   int aisle; /* Aisle number */
   char side; /* Aisle side */
} nonfoodT;

typedef struct{
   meatT meat; /* Meat info */
   produceT produce; /* Produce info */
   dairyT dairy; /* Dairy info */
   cannedT canned; /* Canned goods info */
   nonfoodT nonfood; /* Nonfood info */
} storeT;

/* Functions */

usd Pricer(int totalcost) /* Converts cents to dollars and cents */
{
   usd cost; /* Cost in dollars/cents */

   cost.dollars = totalcost / 100;
   cost.cents = totalcost % 100;

   return cost;
}

void PrintMeat(storeT item[], int n)
{
   usd price;

   price = Pricer(item[n].meat.info.price);

   printf("We have %s in our ", item[n].meat.info.item);

   switch (item[n].meat.meatType) {
      case 'R':
         printf("Red Meat Dept. ");
         break;
      case 'P':
         printf("Poultry Dept. ");
         break;
      case 'F':
         printf("Fish Dept. ");
         break;
   }

   printf("that costs $%d.%.2d per pound. It was packed on ", price.dollars,
                                                              price.cents);

   printf("%d%d%d and will ", item[n].meat.packDate.month,
                              item[n].meat.packDate.day,
                              item[n].meat.packDate.year);

   printf("expire on %d%d%d.", item[n].meat.expire.month,
                               item[n].meat.expire.day,
                               item[n].meat.expire.year);
}

void PrintProduce(storeT item[], int n)
{
   usd price;

   price = Pricer(item[n].produce.info.price);

   printf("We have %s in our ", item[n].produce.info.item);

   switch (item[n].produce.proType) {
      case 'V':
         printf("Vegetable Dept. ");
         break;
      case 'F':
         printf("Fruit Dept. ");
         break;
   }

   printf("that costs $%d.%.2d per pound. It was received on ", price.dollars,
                                                            price.cents);

   printf("%d%d%d.", item[n].produce.receive.month,
                     item[n].produce.receive.day,
                     item[n].produce.receive.year);
}

void PrintDairy(storeT item[], int n)
{
   usd price;

   price = Pricer(item[n].dairy.info.price);

   printf("We have %s in our Dairy Dept. ", item[n].dairy.info.item);

   printf("that costs $%d.%.2d per item. It will ", price.dollars, price.cents);

   printf("expire on %d%d%d.", item[n].dairy.expire.month,
                               item[n].dairy.expire.day,
                               item[n].dairy.expire.year);
}

void PrintCanned(storeT item[], int n)
{
   usd price;

   price = Pricer(item[n].canned.info.price);

   printf("We have %s in aisle %d ", item[n].canned.info.item,
                                     item[n].canned.aisle);

   switch (item[n].canned.side) {
      case 'A':
         printf("side A ");
         break;
      case 'B':
         printf("side B ");
         break;
   }

   printf("that costs $%d.%.2d per item. It will ", price.dollars, price.cents);

   printf("expire in %d%d.", item[n].meat.expire.month,
                             item[n].meat.expire.year);
}

void PrintNon(storeT item[], int n)
{
   usd price;

   price = Pricer(item[n].nonfood.info.price);

   printf("We have %s in our ", item[n].nonfood.info.item);

   switch (item[n].nonfood.type) {
      case 'C':
         printf("Cleaning Dept., ");
         break;
      case 'P':
         printf("Pharmacy, ");
         break;
      case 'O':
         printf("Other Dept., ");
         break;
   }
   printf("aisle %d side %c. ", item[n].nonfood.aisle, item[n].nonfood.side);

   printf("It costs $%d.%.2d per item.", price.dollars, price.cents);
}

/* Main */
int main(void)
{
   /* Variables */
   storeT item[NUMITEMS]; /* Item storage array */
   char selection; /* Product category selection */
   int i = 0; /* Counting variable for array placement */
   int j = 0; /* LCV for print loop */
   char itemType[NUMITEMS]; /* Tracks what item type is in each array slot */

   /* Set itemType to Q default */
   for(j = 0; j < NUMITEMS; j++) {
      itemType[j] = 'Q';
   }

   /* Loop to get input */
   do {
      printf("\nEnter product category (M,P,D,C,N,Q) -> ");
      scanf(" %c", &selection);
      printf("\n");
      switch (selection) {
         case 'M':
            printf("Enter item name -> ");
            scanf(" %s", &item[i].meat.info.item[0]);

            printf("\nEnter cost of item (in cents) -> ");
            scanf("%d", &item[i].meat.info.price);

            printf("\nEnter meat type (R,P,F) -> ");
            scanf(" %c", &item[i].meat.meatType);

            printf("\nEnter date of packaging (#-#-#) -> ");
            scanf("%d %d %d", &item[i].meat.packDate.month,
                              &item[i].meat.packDate.day,
                              &item[i].meat.packDate.year);

            printf("\nEnter date of expiration (#-#-#) -> ");
            scanf("%d %d %d", &item[i].meat.expire.month,
                              &item[i].meat.expire.day,
                              &item[i].meat.expire.year);
            itemType[i] = 'M';
            break;

         case 'P':
            printf("Enter item name -> ");
            scanf(" %s", &item[i].produce.info.item[0]);

            printf("\nEnter cost of item (in cents) -> ");
            scanf("%d", &item[i].produce.info.price);

            printf("\nEnter produce type (F,V) -> ");
            scanf(" %c", &item[i].produce.proType);

            printf("\nEnter date received (#-#-#) -> ");
            scanf("%d %d %d", &item[i].produce.receive.month,
                              &item[i].produce.receive.day,
                              &item[i].produce.receive.year);
            itemType[i] = 'P';
            break;

         case 'D':
            printf("Enter item name -> ");
            scanf(" %s", &item[i].dairy.info.item[0]);

            printf("\nEnter cost of item (in cents) -> ");
            scanf("%d", &item[i].dairy.info.price);

            printf("\nEnter date of expiration (#-#-#) -> ");
            scanf("%d %d %d", &item[i].dairy.expire.month,
                              &item[i].dairy.expire.day,
                              &item[i].dairy.expire.year);
            itemType[i] = 'D';
            break;

         case 'C':
            printf("Enter item name -> ");
            scanf(" %s", &item[i].canned.info.item[0]);

            printf("\nEnter cost of item (in cents) -> ");
            scanf("%d", &item[i].canned.info.price);

            printf("\nEnter aisle number -> ");
            scanf("%d", &item[i].canned.aisle);

            printf("\nEnter aisle side (A,B) -> ");
            scanf(" %c", &item[i].canned.side);

            printf("\nEnter date of expiration (#-#-#) -> ");
            scanf("%d %d %d", &item[i].canned.expire.month,
                              &item[i].canned.expire.day,
                              &item[i].canned.expire.year);
            itemType[i] = 'C';
            break;

         case 'N':
            printf("Enter item name -> ");
            scanf(" %s", &item[i].nonfood.info.item[0]);

            printf("\nEnter cost of item (in cents) -> ");
            scanf("%d", &item[i].nonfood.info.price);

            printf("\nEnter category (C,P,O) -> ");
            scanf(" %c", &item[i].nonfood.type);

            printf("\nEnter aisle number -> ");
            scanf("%d", &item[i].nonfood.aisle);

            printf("\nEnter aisle side (A,B) -> ");
            scanf(" %c", &item[i].nonfood.side);
            itemType[i] = 'N';
            break;

         case 'Q':
            break;

         default:
            printf("Error: Unrecognized product category.\n");
      }
      i = i + 1;
   } while(selection != 'Q');

   j = 0; /* Reset j */
   printf("Here is our stock:\n\n");
   while (itemType[j] != 'Q') {
      switch (itemType[j]) {
         case 'M':
               PrintMeat(item, j);
            break;
         case 'P':
               PrintProduce(item, j);
            break;
         case 'D':
               PrintDairy(item, j);
            break;
         case 'C':
               PrintCanned(item, j);
            break;
         case 'N':
               PrintNon(item, j);
            break;
      }
      printf("\n\n");
      j = j + 1;
   }

   return(0);
}
