import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.Assert.*;

public class PowerSequenceTests
{
   @Test
   public void testConstructor()
   {
      PowerSequence test1 = new PowerSequence(2);
      assertEquals(true, test1 != null);      
   }
   
   @Test
   public void testNexts()
   {
      PowerSequence test1 = new PowerSequence(2);
      PowerSequence test2 = new PowerSequence(1);
      
      //Test hasNext
      assertEquals(true, test1.hasNext());
      assertEquals(true, test2.hasNext());
      
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
      PowerSequence test1 = new PowerSequence(2);
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
