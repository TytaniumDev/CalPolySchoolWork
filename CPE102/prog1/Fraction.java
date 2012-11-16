/**
 * Fraction self-built class, with basic math functions
 *
 * @author Tyler Holland
 * @version Program 1
 * @version CPE102-5
 * @version Fall 2008
 */

public class Fraction
{
   // Fraction variables
   private int numerator;
   private int denominator;

   // Constructors
   public Fraction()
   {
      this.numerator = 0;
      this.denominator = 1;
   }
   public Fraction(int numerator)
   {
      this.numerator = numerator;
      this.denominator = 1;
   }
   public Fraction(int numerator, int denominator)
   {
      int counter = 1;
      int tempNum;
      int tempDen;
      int minValue;

      if(denominator <= 0)
      {
         throw new IllegalArgumentException();
      }
      // Return 0/1 if numerator is 0
      else if(numerator == 0)
      {
         this.numerator = 0;
         this.denominator = 1;
      }
      else
      {
         // Return reduced fraction
         tempNum = Math.abs(numerator);
         tempDen = Math.abs(denominator);
         minValue = Math.min(tempNum, tempDen);
         do
         {
            if((numerator % counter) == 0 && (denominator % counter) == 0)
            {
               numerator = numerator / counter;
               denominator = denominator / counter;
               counter = 1;
            }
            counter = counter + 1;
         }
         while(counter <= minValue);

         this.numerator = numerator;
         this.denominator = denominator;
      }
   }

   // Methods
   public Fraction add(Fraction other)
   {
      Fraction newFrac = new Fraction();

      if(other.denominator != denominator)
      {
         newFrac.denominator = other.denominator * denominator;
         newFrac.numerator = (other.numerator * denominator) + (numerator * other.denominator);
         Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
         return finalFrac;
      }
      else
      {
         newFrac.denominator = denominator;
         newFrac.numerator = other.numerator + numerator;
         Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
         return finalFrac;
      }
   }
   public Fraction div(Fraction other)
   {
      Fraction newFrac = new Fraction();

      newFrac.numerator = other.denominator * numerator;
      newFrac.denominator = other.numerator * denominator;
      Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
      return finalFrac;
   }
   public boolean equals(Fraction other)
   {
      if(other.numerator == numerator && other.denominator == denominator)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   public int getDenominator()
   {
      return denominator;
   }
   public int getNumerator()
   {
      return numerator;
   }
   public Fraction mul(Fraction other)
   {
      Fraction newFrac = new Fraction();

      newFrac.numerator = other.numerator * numerator;
      newFrac.denominator = other.denominator * denominator;
      Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
      return finalFrac;
   }
   public Fraction sub(Fraction other)
   {
      Fraction newFrac = new Fraction();

      if(other.denominator != denominator)
      {
         newFrac.denominator = other.denominator * denominator;
         newFrac.numerator = (numerator * other.denominator) - (other.numerator * denominator);
         Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
         return finalFrac;
      }
      else
      {
         newFrac.denominator = denominator;
         newFrac.numerator =  numerator - other.numerator;
         Fraction finalFrac = new Fraction(newFrac.numerator, newFrac.denominator);
         return finalFrac;
      }
   }
   public java.lang.String toString()
   {
      if(denominator == 1)
      {
         return "" + numerator;
      }
      else
      {
         return numerator + "/" + denominator;
      }
   }
   public double value()
   {
      double value;

      value = (double)numerator / (double)denominator;
      return value;
   }
}