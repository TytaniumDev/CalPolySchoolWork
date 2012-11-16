import java.util.Iterator;
import java.util.NoSuchElementException;


public class PowerSequence implements Iterator<Double>, Iterable<Double>
{
   private double base;
   private double exponent;
   
   public PowerSequence(double base)
   {
      this.base = base;
      this.exponent = 0;
   }
   
   public boolean hasNext()
   {
      if(Math.pow(base, exponent) > Double.MAX_VALUE)
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
      if(Math.pow(base, exponent) > Double.MAX_VALUE)
      {
         throw new NoSuchElementException();
      }
      else
      {
         exponent++;
         return Math.pow(base, exponent - 1);
      }
   }
   
   public void remove()
   {
      throw new UnsupportedOperationException();
   }
   
   public Iterator<Double> iterator()
   {
      return new PowerSequence(base);
   }

}
