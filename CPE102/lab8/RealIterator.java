import java.util.Iterator;
import java.util.NoSuchElementException;


public class RealIterator implements Iterator<Double>, Iterable<Double>
{
   private double increment;
   private double start;
   private double limit;
   
   public RealIterator(double param)
   {
      this.increment = param;
      this.start = 0;
      this.limit = Double.MAX_VALUE;
   }
   public RealIterator(double inc, double begin)
   {
      this.increment = inc;
      this.start = begin;
      this.limit = Double.MAX_VALUE;
   }
   public RealIterator(double inc, double begin, double stop)
   {
      this.increment = inc;
      this.start = begin;
      this.limit = stop;
   }
   
   public boolean hasNext()
   {
      if((start + increment) < limit)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public Double next()
   {
      if((start + increment) >= limit)
      {
         throw new NoSuchElementException();
      }
      else
      {
         return (start + increment);
      }
   }
   
   public void remove()
   {
      throw new UnsupportedOperationException();      
   }
   
   public Iterator<Double> iterator()
   {
      return new RealIterator(increment, start, limit);
   }
}
