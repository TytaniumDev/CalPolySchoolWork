/**
 *  @file
 *  <pre>CPE 357 Winter 2010
 *  -------------------
 *  ops: has all of the operations for mypgm
 *
 *  @author Tyler Holland
 *  Last Modified: Sat Feb 13 09:34:33 PST 2010
 */
 
#include "mypgm.h"
 
int brighten(int maxval, int **array, int value, int height, int width)
{
   int i = 0;
   int j = 0;
   
   for(i = 0; i < height; i++)
   {
      for(j = 0; j < width; j++)
      {
         array[i][j] = (array[i][j] + value);
         if(array[i][j] > MAXVALUE)
         {
            fprintf(stderr, "Grey value over 65535\n");
            freeall(width, array);
            exit(MAXVALOVERERR);
         }
         if(array[i][j] > maxval)
         {
            maxval = array[i][j];
         }
      }
   }
   
   return maxval;
}

int darken(int maxval, int **array, int value, int height, int width)
{
   int i = 0;
   int j = 0;
   int k = 0;
   int azero = 0;
   
   for(k = 0; k < value; k++) /*Do single darkens to make it easier to increase Maxval*/
   {
      azero = 0;
      /*Look for a 0 grey value*/
      for(i = 0; i < height; i++)
      {
         for(j = 0; j < width; j++)
         {
            if(array[i][j] == 0)
            {
               azero = 1;
               maxval++;
               if(maxval > MAXVALUE)
               {
                  fprintf(stderr, "Maxval over 65535\n");
                  freeall(width,array);
                  exit(MAXVALOVERERR);
               }
               break;
            }
         }
         if(azero == 1)
         {
            break;
         }
      }
      
      if(azero == 0) /*No 0 values, subtract 1 from each grey value*/
      {
         for(i = 0; i < height; i++)
         {
            for(j = 0; j < width; j++)
            {
               array[i][j] = (array[i][j] - 1);
            }
         }
      }
   }
   
   return maxval;
}

void smooth(int **array, int height, int width)
{
   int i = 0;
   int j = 0;
   int m = 0;
   int sum = 0;
   int average = 0;
   int remain = 0;
   int **temparray;
   /*Malloc the temp array*/
   temparray = malloc(height * sizeof(int *));
   if(temparray == NULL)
   {
      fprintf(stderr, "out of memory\n");
      freeall(width, temparray);
      exit(OTHERERR);
   }
   for(m = 0; m < height; m++)
   {
      temparray[m] = malloc(width * sizeof(int));
      if(temparray[m] == NULL)
      {
         fprintf(stderr, "out of memory\n");
         freeall(width, temparray);
         exit(OTHERERR);
      }
   }
   
   /*Copy old array to temp array*/
   for(i = 0; i < height; i++)
   {
      for(j = 0; j < width; j++)
      {
         temparray[i][j] = array[i][j];
      }
   }
   
   /*Smooth it*/
   for(i = 0; i < height; i++)
   {
      for(j = 0; j < width; j++)
      {
         sum = array[i][j];
         m = 1;
         average = 0;
         remain = 0;
         /*Work around the value using ifs, clockwise*/
         /*top left*/
         if((i != 0) && (j != 0))
         {
            sum = sum + temparray[i-1][j-1];
            m++;
         }
         /*top*/
         if(i != 0)
         {
            sum = sum + temparray[i-1][j];
            m++;
         }
         /*top right*/
         if((i != 0) && (j != (width - 1)))
         {
            sum = sum + temparray[i-1][j+1];
            m++;
         }
         /*right*/
         if(j != (width - 1))
         {
            sum = sum + temparray[i][j+1];
            m++;
         }
         /*bottom right*/
         if((i != (height - 1)) && (j != (width - 1)))
         {
            sum = sum + temparray[i+1][j+1];
            m++;
         }
         /*bottom*/
         if(i != (height - 1))
         {
            sum = sum + temparray[i+1][j];
            m++;
         }
         /*bottom left*/
         if((i != (height - 1)) && (j != 0))
         {
            sum = sum + temparray[i+1][j-1];
            m++;
         }
         /*left*/
         if(j != 0)
         {
            sum = sum + temparray[i][j-1];
            m++;
         }
         
         average = divandround(sum, m);
         array[i][j] = average;
      }
   }
   freeall(width, temparray);
}

int divandround(int value1, int value2)
{
   int remain;
   int divisor;
   remain = value1 % value2;
   divisor = value1 / value2;
   if((value2 / remain) >= 2)/*.5 or greater, round up*/
   {
      if((value2 % remain) == 0) /*exactly .5, go to odd number*/
      {
         if((divisor % 2) == 0)/*Even number, round up for next odd*/
         {
            divisor++;
         }
      }
      else
      {
         divisor++;
      }
   }
   /*Otherwise remainder less than .5, keep value in average*/
   return divisor;
}

int round(double number)
{
   double temp;
   double floornum;
   
   temp = number * 10; /*To get the decimal point*/
   temp = floor(temp); /*Make it an integer*/
   floornum = floor(number);
   floornum = floornum * 10; /*To subtract and find decimal value*/
   
   temp = temp - floornum;
   if(temp < 5) /*Round down*/
   {
      return ((int)floor(number));
   }
   else if(temp > 5) /*Round up*/
   {
      return ((int)ceil(number));
   }
   else /*Round to odd number*/
   {
      if(((int)number % 2) == 0) /*Even, round up*/
      {
         return ((int)ceil(number));
      }
      else /*Odd, round down*/
      {
         return ((int)floor(number));
      }
   }
}
