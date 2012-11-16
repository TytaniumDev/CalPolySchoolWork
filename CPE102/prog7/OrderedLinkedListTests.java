/**
 * A Test for OrderedLinkedList.
 *
 * @author Tyler Holland
 * @version Program 7
 * @version CPE102-5
 * @version Winter 2009
 */

import java.util.Comparator;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderedLinkedListTests
{
   private class testClass implements Comparator<Integer>
   {
      public testClass()
      {
      }
      
      public int compare(Integer o1, Integer o2)
      {
         if(o1 > o2)
         {
            return 1;
         }
         else if(o1 < o2)
         {
            return -1;
         }
         else if(o1 == o2)
         {
            return 0;
         }
         return 0;
      }
   }
   
   //Constructor Tests
   @Test
   public void testConstructor()
   {
      testClass testComp = new testClass();
      
      OrderedLinkedList<Integer> test1 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test2 = new OrderedLinkedList<Integer>(testComp);

      //Basic constructor test
      assertEquals(true, test1.size() == test2.size());
   }
   
   //Add tests
   @Test
   public void testAdd()
   {
      //Order should be 1-2-3-4-5
      testClass testComp = new testClass();
      OrderedLinkedList<Integer> test1 = new OrderedLinkedList<Integer>(testComp);
      
      //Add in order
      test1.add(1);
      test1.add(2);
      test1.add(3);
      test1.add(4);
      test1.add(5);
      test1.add(5);
      
      OrderedLinkedList<Integer> test2 = new OrderedLinkedList<Integer>(testComp);
      
      //Add out of order
      test2.add(4);
      test2.add(1);
      test2.add(2);
      test2.add(5);
      test2.add(3);
      test2.add(5);
      
      assertEquals(true, test1.size() == test2.size());
      assertEquals(true, test1.get(0).equals(test2.get(0)));
      assertEquals(true, test1.get(1).equals(test2.get(1)));
      assertEquals(true, test1.get(2).equals(test2.get(2)));
      assertEquals(true, test1.get(3).equals(test2.get(3)));
      assertEquals(true, test1.get(4).equals(test2.get(4)));
      assertEquals(true, test1.get(5).equals(test2.get(5)));
      
      //Test a false case
      OrderedLinkedList<Integer> test3 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test4 = new OrderedLinkedList<Integer>(testComp);
      
      test3.add(100);
      test3.add(102);
      test3.add(104);
      test3.add(105);
      
      test4.add(100);
      test4.add(102);
      test4.add(104);
      test4.add(105);
      test4.add(103);
      
      assertEquals(false, test3.size() == test4.size());
      assertEquals(false, test3.get(2).equals(test4.get(2)));
   }
   
   //Size tests
   @Test
   public void testSize()
   {
      testClass testComp = new testClass();
      OrderedLinkedList<Integer> test1 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test2 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test3 = new OrderedLinkedList<Integer>(testComp);
      
      //Add in order
      test1.add(1);
      test1.add(2);
      test1.add(3);
      test1.add(4);
      test1.add(5);
      
      assertEquals(true, test1.size() == 5);
      
      //Add a bunch of duplicates
      test2.add(6);
      test2.add(6);
      test2.add(6);
      test2.add(6);
      test2.add(6);
      test2.add(6);
      
      assertEquals(true, test2.size() == 6);
      
      //Add nothing
      assertEquals(true, test3.size() == 0);
   }
   
   //Get tests
   @Test
   public void testGet()
   {
      testClass testComp = new testClass();
      OrderedLinkedList<Integer> test1 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test2 = new OrderedLinkedList<Integer>(testComp);
      OrderedLinkedList<Integer> test3 = new OrderedLinkedList<Integer>(testComp);
      
      //Add in order
      test1.add(1);
      test1.add(2);
      test1.add(3);
      test1.add(4);
      test1.add(5);
      
      assertEquals(true, test1.get(0) == 1);
      assertEquals(true, test1.get(1) == 2);
      assertEquals(true, test1.get(2) == 3);
      assertEquals(true, test1.get(3) == 4);
      assertEquals(true, test1.get(4) == 5);
      
      //Add out of order
      test2.add(1);
      test2.add(4);
      test2.add(2);
      test2.add(5);
      test2.add(3);
      test2.add(5);
      
      assertEquals(true, test2.get(0) == 1);
      assertEquals(true, test2.get(1) == 2);
      assertEquals(true, test2.get(2) == 3);
      assertEquals(true, test2.get(3) == 4);
      assertEquals(true, test2.get(4) == 5);
      assertEquals(true, test2.get(5) == 5);
      
      //Add a bunch of duplicates
      test3.add(6);
      test3.add(6);
      test3.add(6);
      test3.add(6);
      test3.add(6);
      
      assertEquals(true, test3.get(0) == 6);
      assertEquals(true, test3.get(1) == 6);
      assertEquals(true, test3.get(2) == 6);
      assertEquals(true, test3.get(3) == 6);
      assertEquals(true, test3.get(4) == 6);
   }
}
