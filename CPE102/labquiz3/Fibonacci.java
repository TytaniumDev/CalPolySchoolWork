/**
 * 
 * @author Tyler Holland
 * @version Lab Quiz 3
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;;

public class Fibonacci implements Iterator<Double>, Iterable<Double>
{
   private double minusOne;
   private double answer;
   
   //Default Constructor
   public Fibonacci()
   {
      this.answer = 0;
      this.minusOne = 0;
   }
   
   public boolean hasNext()
   {
      if((answer + minusOne) > Double.MAX_VALUE)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   public Double next()
   {
      if(!hasNext())
      {
         throw new NoSuchElementException();
      }
      if(answer == 0 && minusOne == 0)
      {
         answer = 1;
         minusOne = 0;
         return 0.0;
      }
      else if((answer + minusOne) < Double.MAX_VALUE)
      {
         double temp;
         temp = answer;
         answer = answer + minusOne;
         minusOne = temp;
         return answer;
      }
      else 
      {
         throw new NoSuchElementException();
      }
   }
   
   public void remove()
   {
      throw new UnsupportedOperationException();
   }
   
   //Iterable Methods
   public Iterator<Double> iterator()
   {
      return new Fibonacci();
   }
}
