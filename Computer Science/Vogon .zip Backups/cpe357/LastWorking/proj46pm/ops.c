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
 
/**
 * A function to do all work for brighten
 * @param maxval The current max value
 * @param array The array that stores the image
 * @param value The amount to brighten
 * @param height The height of the image
 * @param width The width of the image
 * @return The new max value
 */
int brightenfunc(int maxval, int **array, int value, int height, int width)
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

/**
 * A function to do all work for darken
 * @param maxval The current max value
 * @param array The array that stores the image
 * @param value The amount to darken
 * @param height The height of the image
 * @param width The width of the image
 * @return The new max value
 */
int darkenfunc(int maxval, int **array, int value, int height, int width)
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

/**
 * A function to do all work for smooth
 * @param array The array that stores the image
 * @param height The height of the image
 * @param width The width of the image
 */
void smoothfunc(int **array, int height, int width)
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

/**
 * A function to do all work for calculating max values
 * @param maxval The current max value
 * @param readmaxval The max value from the file itself
 * @param array The array that holds the image
 * @param height The height of the image
 * @param width The width of the image
 * @return The new max value
 */
int maxvaledit(int maxval, int readmaxval, int **array, int height, int width)
{
   double tempdoub = 0.0;
   double scaler = 0.0;
   int i;
   int j;
   
   if(maxval == -1)
   {
      maxval = readmaxval;
   }
   if(maxval != readmaxval) /*Scale the values*/
   {
      scaler = (double)maxval / (double)readmaxval;
      for(i = 0; i < height; i++)
      {
         for(j = 0; j < width; j++)
         {
            tempdoub = array[i][j];
            tempdoub = tempdoub * scaler;
            array[i][j] = round(tempdoub);
         }
      }
   }
   return maxval;
}

/**
 * @param value1 The value to be devided by
 * @param value2 The value to divide by
 * @return The rounded answer
 */
int divandround(int value1, int value2)
{
   int remain;
   int divisor;
   
   if(value1 == 0) /*Can't average a 0, creates errors*/
   {
      return 0;
   }
   remain = value1 % value2;
   divisor = value1 / value2;
   if(remain == 0) /*Whole number, no need for rounding*/
   {
      return divisor;
   }
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

/**
 * @param number A double to round, following project 4 rules
 * @return The rounded number, as an int
 */
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
