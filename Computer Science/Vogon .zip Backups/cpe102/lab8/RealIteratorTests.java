import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.*;

public class RealIteratorTests
{
   @Test
   public void testConstructor()
   {
      RealIterator test1 = new RealIterator(2);
      RealIterator test2 = new RealIterator(2,3);
      RealIterator test3 = new RealIterator(2,3,4);
      assertEquals(true, test1 != null);      
      assertEquals(true, test2 != null);     
      assertEquals(true, test3!= null);     
   }
   
   @Test
   public void testNexts()
   {
      RealIterator test1 = new RealIterator(2);
      RealIterator test2 = new RealIterator(2,1);
      RealIterator test3 = new RealIterator(2,1,15);
      
      //Test hasNext
      assertEquals(true, test1.hasNext());
      assertEquals(true, test2.hasNext());
      assertEquals(true, test3.hasNext());
      
      //Test next
      assertEquals(true, test1.next() == 1);
      assertEquals(true, test2.next() == 1);
      
      //Test Accuracy
      assertEquals(true, test2.next() == 1);
      assertEquals(true, test2.next() == 1);
      assertEquals(true, test2.next() == 1);
      
      assertEquals(true, test1.next() == 2);
      assertEquals(true, test1.next() == 4);
      assertEquals(true, test1.next() == 8);
   }
   
   @Test
   public void testLimit()
   {
      boolean pass = false;
      RealIterator test1 = new RealIterator(2);
      double answer = 0;
      while(answer < ((Double.MAX_VALUE) / 2) + 1)
      {
         assertEquals(true, test1.hasNext());
         answer = test1.next();
      }
      assertEquals(false, test1.hasNext());
      try
      {
         answer = test1.next();
      }
      catch(NoSuchElementException e)
      {
         pass = true;
      }
      
      assertEquals(true, pass);
   }
}
