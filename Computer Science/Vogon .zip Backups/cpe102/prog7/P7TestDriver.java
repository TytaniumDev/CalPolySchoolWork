/**
 * Program 7 Test Driver - OrderedLinkedList.
 *
 * @author Kurt Mammen
 * @version CPE102
 */
import java.lang.reflect.*;
import java.util.*;

public class P7TestDriver
{
   private static final String RESULTS_FOR = "Results for Program 7";
   private static Comparator<Integer> comparator = new Descending();
   
   private static class Descending implements Comparator<Integer>
   {
      public int compare(Integer a, Integer b)
      {
         return b.compareTo(a);
      }
   }
   
   public static void main(String[] args) throws ClassNotFoundException
   {
      boolean pass = true;
      
      printHeader(args);

      pass &= testOrderedLinkedListArch();
      pass &= testListIteratorArch();
      
      System.out.println();
      
      pass &= testEmptyList();
      pass &= testListOfOne();
      pass &= testListOfTwo();
      pass &= testListOfThree();
      pass &= testConstructor2();
      pass &= testAddClearRemove();
      pass &= testIndexOf();
      
      System.out.println();
      
      pass &= testIterator();
      pass &= testListIterator();
      
      printResults(pass);
      
      if (!pass)
      {
         System.exit(-1);
      }
   }
   
   private static boolean testOrderedLinkedListArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int cnt;
      Class cl;
      Class[] temp;
      OrderedLinkedList<Integer> ref = new OrderedLinkedList<Integer>(comparator);

      System.out.println("OrderedLinkedList architecture tests...");

      cl = ref.getClass();
      
      pass &= test(cl.getSuperclass() == Class.forName("java.lang.Object"), "Class extends something other than Object");

      temp = cl.getInterfaces();
      pass &= test(temp.length == 1, "Incorrect number of implemented interfaces");
      pass &= test(temp[0].getName().equals("java.lang.Iterable"), "Not implementing specified interface");    
      pass &= test(cl.getConstructors().length == 2, "Incorrect number of constructors");

      String[] names = {"add", "get", "size", "clear", "indexOf", "remove",
                        "listIterator", "iterator"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, "Incorrect number of public methods");
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names),
                   "Above method(s) were not specified");
                 
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, "public instance fields declared");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, "Protected instance fields declared");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt <= 4, "Too many instance fields declared");
      
      // Count and test number of of PACKAGE fields
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 0, "package instance fields declared");

      return pass;
   }
   
   private static boolean testListIteratorArch() throws ClassNotFoundException
   {
      boolean pass = true;
      int cnt;
      Class cl;
      Class[] temp;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);

      System.out.println("ListIterator architecture tests...");

      cl = list.listIterator().getClass();
      
      pass &= test(cl.getSuperclass() == Class.forName("java.lang.Object"),
       "Class extends something other than Object");
      pass &= test(cl.getInterfaces().length == 1,
       "ListIterator implements incorrect number of interfaces");
      pass &= test(cl.getInterfaces()[0].getName().equals("ListIterator"),
       "listIterator() returns incorrect type");
      pass &= test(cl.getInterfaces()[0].getInterfaces().length == 1,
       "ListIterator extends incorrect number of interfaces");
      pass &= test(cl.getInterfaces()[0].getInterfaces()[0].getName().equals("java.util.Iterator"),
       "ListIterator extends incorrect interface");
      temp = cl.getInterfaces();
               
      pass &= test(cl.getConstructors().length <= 1, "Incorrect number of constructors");
      String[] names = {"hasNext", "next", "hasPrevious", "previous", "remove"};

      cnt = countModifiers(cl.getDeclaredMethods(), Modifier.PUBLIC);     
      pass &= test(cnt == names.length, "Incorrect number of public methods");
      pass &= test(verifyNames(cl.getDeclaredMethods(), Modifier.PUBLIC, names),
                   "Unspecified method name(s)");
      
      cnt = cl.getFields().length;
      pass &= test(cnt == 0, "public instance fields declared");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PROTECTED);
      pass &= test(cnt == 0, "Protected instance fields declared");
      
      cnt = countModifiers(cl.getDeclaredFields(), Modifier.PRIVATE);
      pass &= test(cnt <= 3, "Too many instance fields declared");
      
      // Count and test number of of PACKAGE fields
      // NOTE: "this" is a package variable for inner classes - so cnt == 1 expected.
      cnt = countPackage(cl.getDeclaredFields());
      pass &= test(cnt == 1, "package instance fields declared");

      return pass;
   }
   
   private static boolean testEmptyList()
   {
      System.out.println("Testing an empty OrderedLinkedList...");  

      boolean pass = true;
      boolean caught = false;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
    
      try
      {
         caught = false;
         list.get(0);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "get(0)");

      try
      {
         caught = false;
         list.get(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "get(-99)");
      pass &= test(list.size() == 0, "size()");
      
      try
      {
         caught = false;
         list.indexOf(new Integer(5));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "indexOf(new Integer(5))");

      try
      {
         caught = false;
         list.remove(0);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "remove(0)");

      try
      {
         caught = false;
         list.remove(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "remove(-99)");
      
      return pass;
   }
   
   private static boolean testListOfOne()
   {
      System.out.println("Testing an OrderedLinkedList of one element...");  

      boolean pass = true;
      boolean caught = false;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      
      list.add(new Integer(99));
      
      try
      {
         list.get(1);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "get(1)");

      try
      {
         list.get(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "get(-99)");
      
      pass &= test(list.get(0) == 99, "get(0)");
      pass &= test(list.size() == 1, "size()");
      
      try
      {
         caught = false;
         list.indexOf(new Integer(5));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "indexOf(new Integer(5)) (value not in list)");

      int index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(99));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(99)) (value in list)");
      pass &= test(index == 0, "indexOf(new Integer(99) (value in list)");
      
      try
      {
         caught = false;
         list.remove(1);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "remove(1)");

      try
      {
         caught = false;
         list.remove(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "remove(-99)");
      
      return pass;
   }

   private static boolean testListOfTwo()
   {
      System.out.println("Testing an OrderedLinkedList of two elements...");

      boolean pass = true;
      boolean caught = false;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      
      list.add(new Integer(99));
      list.add(new Integer(1111));
      
      try
      {
         list.get(2);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "get(2)");

      try
      {
         list.get(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "get(-99)");
      
      pass &= test(list.get(0) == 1111, "get(0)");
      pass &= test(list.get(1) == 99, "get(1)");
      pass &= test(list.size() == 2, "size()");
      
      try
      {
         caught = false;
         list.indexOf(new Integer(5));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "indexOf(new Integer(5)) (value not in list)");

      int index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(99));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(99)) (value in list)");
      pass &= test(index == 1, "indexOf(new Integer(99) (value in list)");

      index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(1111));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(1111)) (value in list)");
      pass &= test(index == 0, "indexOf(new Integer(1111) (value in list)");
      
      try
      {
         caught = false;
         list.remove(2);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "remove(2)");

      try
      {
         caught = false;
         list.remove(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "remove(-99)");
      
      return pass;
   }
   
   private static boolean testListOfThree()
   {
      System.out.println("Testing an OrderedLinkedList of three elements...");

      boolean pass = true;
      boolean caught = false;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      
      list.add(new Integer(99));
      list.add(new Integer(1111));
      list.add(new Integer(-777));
      
      try
      {
         list.get(3);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "get(3)");

      try
      {
         list.get(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "get(-99)");
      
      pass &= test(list.get(0) == 1111, "get(0)");
      pass &= test(list.get(1) == 99, "get(1)");
      pass &= test(list.get(2) == -777, "get(2)");
      pass &= test(list.size() == 3, "size()");
      
      try
      {
         caught = false;
         list.indexOf(new Integer(5));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "indexOf(new Integer(5)) (value not in list)");

      int index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(99));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(99)) (value in list)");
      pass &= test(index == 1, "indexOf(new Integer(99) (value in list)");

      index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(1111));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(1111)) (value in list)");
      pass &= test(index == 0, "indexOf(new Integer(1111) (value in list)");

      index = -1;
      try
      {
         caught = false;
         index = list.indexOf(new Integer(-777));
      }
      catch(java.util.NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "indexOf(new Integer(-777)) (value in list)");
      pass &= test(index == 2, "indexOf(new Integer(-777) (value in list)");

      try
      {
         caught = false;
         list.remove(3);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "remove(3)");

      try
      {
         caught = false;
         list.remove(-99);
      }
      catch(IndexOutOfBoundsException e)
      {
         caught = true;
      }

      pass &= test(caught, "remove(-99)");
      
      return pass;
   }
   
   private static boolean testConstructor2()
   {
      System.out.println("Testing OrderedLinkedList(java.util.List)...");
      boolean pass = true;
      int[] ints = new int[] {66, 77, 55, -11, 22, 70, 88, -22};
      int[] expected = new int[] {88, 77, 70, 66, 55, 22, -11, -22};
      LinkedList<Integer> in = new LinkedList<Integer>();
      
      for(Integer i : ints)
      {
         in.add(i);
      }
      
      try
      {
         OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(in, comparator);
         
         for(int i = 0; i < list.size(); i++)
         {
            if(list.get(i) != expected[i])
            {
               pass &= test(false, "OrderedLinkedList(java.util.List)");
               break;
            }
         }
      }
      catch (RuntimeException e)
      {
         pass &= test(false, "Exception in OrderedLinkedList(java.util.List)");
         throw e;
      }
      
      return pass;
   }
   
   private static boolean testAddClearRemove()
   {
      System.out.println("Testing add(int), clear(), and remove(int)...");
      boolean pass = true;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      
      pass &= test(list.size() == 0, "size()");
      
      list.clear();
      pass &= test(list.size() == 0, "size() after clear()");
      
      // Add some in order...
      int[] ints = new int[] {99, 88, 77, 66, 55};
      
      for (int i = 0; i < ints.length; i++)
      {
         list.add(ints[i]);
         pass &= test(list.size() == i + 1, "size() while adding elements");

         for(int j = 0; j < list.size(); j++)
         {
            pass &= test(list.get(j) == ints[j], "get(int)");
         }
      }
      
      list.clear();
      pass &= test(list.size() == 0, "size() after clear()");
      
      boolean caught = false;
      
      try
      {
         list.get(0);
      }
      catch (IndexOutOfBoundsException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "get(0) after clear()");

      // Add some in reverse order...
      for (int i = ints.length - 1; i > -1; i--)
      {
         list.add(ints[i]);
         
         pass &= test(list.size() == ints.length - i, "size() while adding elements");
         int k = ints.length - list.size();
         for(int j = 0; j < list.size(); j++)
         {
            pass &= test(list.get(j) == ints[k + j], "get(int)");
         }
      }
      
      // Remove last...
      pass &= test(list.remove(4) == 55, "remove(int) - last one");
      pass &= test(list.size() == 4, "size() - after remove");
      
      for (int i = 0; i < ints.length - 1; i++)
      {
         pass &= test(list.get(i) == ints[i], "get(int) after remove");
      }
      
      // Remove first...
      pass &= test(list.remove(0) == 99, "remove(int) - first one");
      pass &= test(list.size() == 3, "size() - after remove");
      
      for (int i = 0; i < ints.length - 2; i++)
      {
         pass &= test(list.get(i) == ints[i + 1], "get(int) after remove");
      }
      
      // Remove middle...
      pass &= test(list.remove(1) == 77, "remove(int) - middle value");
      pass &= test(list.size() == 2, "size() - after remove");
      pass &= test(list.get(0) == 88, "get(int) after remove");
      pass &= test(list.get(1) == 66, "get(int) after remove");
      
      // Add in middle...
      list.add(79);
      pass &= test(list.size() == 3, "size() - after add(E)");
      pass &= test(list.get(0) == 88, "get(int) after add(E)");
      pass &= test(list.get(1) == 79, "get(int) after add(E)");
      pass &= test(list.get(2) == 66, "get(int) after add(E)");
      
      // Add in middle...
      list.add(78);
      pass &= test(list.size() == 4, "size() - after add(E)");
      pass &= test(list.get(0) == 88, "get(int) after add(E)");
      pass &= test(list.get(1) == 79, "get(int) after add(E)");
      pass &= test(list.get(2) == 78, "get(int) after add(E)");
      pass &= test(list.get(3) == 66, "get(int) after add(E)");

      // Remove all
      pass &= test(list.remove(0) == 88, "remove(0) - non-empty list");
      pass &= test(list.size() == 3, "size() after remove()");

      pass &= test(list.remove(0) == 79, "remove(0) - non-empty list");
      pass &= test(list.size() == 2, "size() after remove()");

      pass &= test(list.remove(0) == 78, "remove(0) - non-empty list");
      pass &= test(list.size() == 1, "size() after remove()");

      pass &= test(list.remove(0) == 66, "remove(0) - non-empty list");
      pass &= test(list.size() == 0, "size() after remove()");

      list.add(9999);
      pass &= test(list.size() == 1, "size() after add(E)");
      pass &= test(list.get(0) == 9999, "get(int) after remove(int) all");
      
      return pass;
   }

   private static boolean testIndexOf()
   {
      System.out.println("Testing indexOf(E)...");
      boolean pass = true;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      
      // Add some in order...
      int[] ints = new int[] {99, 88, 77, 66, 55};
      
      for (int i = 0; i < ints.length; i++)
      {
         list.add(ints[i]);
         
         for (int j = 0; j < list.size(); j++)
         {
            pass &= test(list.indexOf(ints[j]) == j, "indexOf(E) - existing value");
         }
      }
      
      return pass;
   }

   private static boolean testIterator()
   {
      System.out.println("Testing Iterator...");
      boolean pass = true;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      int[] ints = new int[] {99, 88, 77, 66, 55};
      
      for (Integer i : list)
      {
         pass &= test(false, "Iterating on an empty OrderedLinkedList");
      }
      
      for (int i : ints)
      {
         list.add(i);
      }
      
      int ndx = 0;
      for (Integer i : list)
      {
         pass &= test(i == ints[ndx], "Iterating on a non-empty OrderedLinkedList");
         ndx++;
      }
     
      // ListIterator isA Iterator and should share same methods/data
      Iterator<Integer> iter = list.iterator();
      ListIterator<Integer> listIter = (ListIterator<Integer>)iter;
      
      pass &= test(iter.next() == 99, "Iterator.next() returned incorrect value");
      pass &= test(listIter.next() == 88, "ListIterator.next() returned incorrect value");
      
      return pass;
   }

   private static boolean testListIterator()
   {
      System.out.println("Testing ListIterator...");
      boolean pass = true;
      OrderedLinkedList<Integer> list = new OrderedLinkedList<Integer>(comparator);
      int[] ints = new int[] {99, 88, 77, 66, 55};
      
      ListIterator<Integer> iter;
      
      // Test empty list...
      iter = list.listIterator();
        
      pass &= test(!iter.hasNext(), "ListIterator.hasNext() on empty list");
      pass &= test(!iter.hasPrevious(), "ListIterator.hasPrevious() on empty list");
      
      boolean caught = false;
      try
      {
         iter.next();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.next() not throwing when it should");

      caught = false;
      try
      {
         iter.previous();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.previous() not throwing when it should");

      // Test list of one...
      list.add(ints[0]);
      iter = list.listIterator();

      pass &= test(iter.hasNext(), "ListIterator.hasNext() on empty list");
      pass &= test(!iter.hasPrevious(), "ListIterator.hasPrevious() on empty list");
      
      caught = false;
      try
      {
         pass &= test(iter.next() == ints[0], "ListIterator.hasNext() on non-empty list");
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "ListIterator.next() throwing when it should not");

      caught = false;
      try
      {
         pass &= test(iter.previous() == ints[0], "ListIterator.hasPrevious() on non-empty list");
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(!caught, "ListIterator.previous() throwing when it should not");

      caught = false;
      try
      {
         iter.next();
         iter.next();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.next() not throwing when it should");

      // Test list of two...
      list.add(ints[1]);
      iter = list.listIterator();
      
      int i = 0;
      while(iter.hasNext())
      {
         pass &= test(iter.next() == ints[i++], "ListIterator not working correctly");
      }
      
      caught = false;
      try
      {
         iter.next();
       }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.next() not throwing when it should");

      while(iter.hasPrevious())
      {
         pass &= test(iter.previous() == ints[--i], "ListIterator not working correctly");
      }

      caught = false;
      try
      {
         iter.previous();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.previous() not throwing when it should");

      // Test list of many...
      list.add(ints[4]);
      list.add(ints[2]);
      list.add(ints[3]);
      iter = list.listIterator();

      i = 0;
      while(iter.hasNext())
      {
         pass &= test(iter.next() == ints[i++], "ListIterator not working correctly");
      }
      
      caught = false;
      try
      {
         iter.next();
       }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.next() not throwing when it should");

      while(iter.hasPrevious())
      {
         pass &= test(iter.previous() == ints[--i], "ListIterator not working correctly");
      }

      caught = false;
      try
      {
         iter.previous();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.previous() not throwing when it should");
      
      // Remove some elements and iterate over remaining ones...
      pass &= test(list.remove(2) == ints[2], "remove(int) after iteration");
      pass &= test(list.remove(3) == ints[4], "remove(int) after iteration");
      pass &= test(list.remove(0) == ints[0], "remove(int) after iteration");
      
      iter = list.listIterator();
      
      pass &= test(iter.hasNext(), "hasNext() after remove(int)");
      pass &= test(iter.next() == ints[1], "next() after remove(int)");
      
      pass &= test(iter.hasNext(), "hasNext() after remove(int)");
      pass &= test(iter.next() == ints[3], "next() after remove(int)");

      // Add some elements and iterate over list...
      list.add(ints[2]);
      list.add(ints[4]);
      list.add(ints[0]);
      iter = list.listIterator();
      
      pass &= test(list.size() == 5,"size() after remove-add");
      
      iter = list.listIterator();
      i = 0;
      while(iter.hasNext())
      {
         pass &= test(iter.next() == ints[i++], "ListIterator not working correctly");
      }
      
      caught = false;
      try
      {
         iter.next();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.next() not throwing when it should");

      while(iter.hasPrevious())
      {
         pass &= test(iter.previous() == ints[--i], "ListIterator not working correctly");
      }

      caught = false;
      try
      {
         iter.previous();
      }
      catch (NoSuchElementException e)
      {
         caught = true;
      }
      
      pass &= test(caught, "ListIterator.previous() not throwing when it should");

      // Remove all and iterate...
      list.remove(4);
      list.remove(1);
      list.remove(2);
      list.remove(0);
      list.remove(0);
      
      pass &= test(list.size() == 0, "size() after remove(int)");
      
      iter = list.listIterator();
      
      pass &= test(!iter.hasNext(), "ListIterator.hasNext() after remove(int)");
      pass &= test(!iter.hasPrevious(), "ListIterator.hasPrevious() after remove(int)");
      
      // Add some and iterate...
      for (i = ints.length - 1; i > -1; i--)
      {
         list.add(ints[i]);
      }
      
      iter = list.listIterator();

      i = 0;
      while(iter.hasNext())
      {
         pass &= test(iter.next() == ints[i++], "ListIterator.next() after add(E)");
      }

      pass &= test(iter.hasPrevious(), "ListIterator.hasPrevious() after next()");

      // Clear and iterate...
      list.clear();

      iter = list.listIterator();
      
      pass &= test(!iter.hasNext(), "ListIterator.hasNext() after clear()");
      pass &= test(!iter.hasPrevious(), "ListIterator.hasPrevious() after clear()");
      
      return pass;
   }

   private static void printHeader(String[] args)
   {
      if (args.length == 1)
      {
         System.out.println(args[0]);
      }
      
      System.out.println(RESULTS_FOR + "\n");
   }
   
   private static void printResults(boolean pass)
   {
      String msg;
      
      if(pass)
      {
         msg = "\nCongratulations, you passed all the tests!\n\n"
            + "Your grade will be based on when you turn in your functionally\n"
            + "correct solution and any deductions for the quality of your\n"
            + "implementation.  Quality is based on, but not limited to,\n"
            + "coding style, documentation requirements, compiler warnings,\n"
            + "and the efficiency and elegance of your code.\n";
      }
      else
      {
         msg = "\nNot done yet - you failed one or more tests!\n";
      }
      
      System.out.print(msg);       
   }
   
   private static int countModifiers(Field[] fields, int modifier)
   {
      int count = 0;
      
      for (Field f : fields)
      {
         if (f.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }
   
   private static int countModifiers(Method[] methods, int modifier)
   {
      int count = 0;
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }
   
   private static boolean approx(double a, double b, double epsilon)
   {
      return Math.abs(a - b) < epsilon;
   }
   
   private static boolean verifyNames(Method[] methods, int modifier, String[] names)
   {
      boolean pass = true;
      Arrays.sort(names);
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            if (Arrays.binarySearch(names, m.getName()) < 0)
            {
               System.out.print("      Class contains unspecified public ");
               System.out.println("method: " + m.getName());
               pass &= false;
            }
         }
      }
      
      return pass;
   }
      
   private static boolean test(boolean pass, String msg)
   {
      if (!pass)
      {
         System.out.println("   Failed: " + msg);
      }
      
      return pass;
   }
   
   private static int countPackage(Field[] fields)
   {
      int cnt = fields.length
                - countModifiers(fields, Modifier.PRIVATE)
                - countModifiers(fields, Modifier.PROTECTED)
                - countModifiers(fields, Modifier.PUBLIC);

      // Adjust for students that have written assert statment(s) in their code
      // The package field specified below gets added to the .class file when
      // assert statements are present in the source.
      for (Field f : fields)
      {
         int mods = f.getModifiers();
         
         if (Modifier.isStatic(mods)
          && Modifier.isFinal(mods)
          && f.getName().equals("$assertionsDisabled"))
         {
            cnt--;
         }
      }
      
      return cnt;
   } 
}