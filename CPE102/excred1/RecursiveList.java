/** 
 * RecursiveList - A modification of Problem 20.10 from Nino and Horch's
 * "An Introduction to Programming and Object Oriented Design Using Java Version 5.0"
 *
 * @author Tyler Holland
 * @version Winter 2009
 */
 
public class RecursiveList<E>
{
   /////////////////////////////////////////////////////////////////////////////
   // A private internal interface.
   //
   // Do not modify this interface in any way!
   //
   // You will need to complete the implementation for two private inner classes
   // below that implement the methods of this interface.
   //
   // Be sure to read the javadocs for the RecursiveList methods below to
   // learn how these methods should behave from the perspective of the 
   // user of the RecursiveList class.
   //
   private interface ListState<E>
   {
      boolean isEmpty();
      int size();
      ListState<E> add(int index, E element);
      E get(int index);
      E set (int index, E element);
      int indexOf(E element);
      ListState<E> remove (int index);
   }
   
   /////////////////////////////////////////////////////////////////////////////
   // TODO: Implement this class as follows:
   //
   //   * With no instance variables
   //   * With no explicit constructors.
   //   * Only the methods of the ListState interface.
   //
   private class EmptyList<E> implements ListState<E>
   {
      // Your code here...
      public ListState<E> add(int index, E element)
      {
         if(index == 0)
         {
            NonEmptyList temp = new NonEmptyList();
            temp.add(index, element);
            return temp;
         }
         throw new IndexOutOfBoundsException();
      }

      public E get(int index)
      {
         stackTrace = new Throwable(); 
         throw new IndexOutOfBoundsException();
      }

      public int indexOf(E element)
      {
         stackTrace = new Throwable(); 
         throw new java.util.NoSuchElementException();
      }

      public boolean isEmpty()
      {
         stackTrace = new Throwable(); 
         return true;
      }

      
      public ListState<E> remove(int index)
      {
         stackTrace = new Throwable(); 
         throw new IndexOutOfBoundsException();
      }

      
      public E set(int index, E element)
      {
         stackTrace = new Throwable(); 
         throw new IndexOutOfBoundsException();
      }

      
      public int size()
      {
         stackTrace = new Throwable(); 
         return 0;
      }
   }
   
   /////////////////////////////////////////////////////////////////////////////
   // TODO: Implement this class as follows:
   //
   //    * With only the instance variables already specified.
   //    * With no explicit constructors.
   //    * Only the methods of the ListState<E> interface.
   //
   private class NonEmptyList<E> implements ListState<E>
   {
      public E element;
      public ListState<E> list; //next
      // Your code here...
      
      public ListState<E> add(int index, E element)
      {
         if(index == 0)
         {
            stackTrace = new Throwable(); 
            NonEmptyList temp = new NonEmptyList();
            temp.element = element;
            return temp;
         }
         if(index > 0)
         {
            return list.add(index - 1, element);
         }
         else if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         return list;
      }
      
      public E get(int index)
      {
         if(index > 0)
         {
            return list.get(index - 1);
         }
         else if(index < 0)
         {
            throw new IndexOutOfBoundsException();
         }
         stackTrace = new Throwable(); 
         return element;
      }
      
      public int indexOf(E element)
      {
         int count = 0;
         if(this.element == element)
         {
            return count;
         }
         else
         {
            count = 1;
            return count + list.indexOf(element);
         }
      }
      
      public boolean isEmpty()
      {
         return false;
      }
      
      public ListState<E> remove(int index)
      {
         
         return null;
      }
      
      public E set(int index, E element)
      {
         return null;
      }
      
      public int size()
      {
         int temp = 1;
         return temp + list.size();
      }
   }
   
   /****************************************************************************
    * The RecursiveList<E> implementation.
    *
    * DO NOT MODIFY CODE BELOW IN ANY WAY!
    * 
    * But, rather, implement the private inner classes EmptyList and 
    * NonEmptyList, above, so that these methods work as described below.
    */

   // The only two instance variable for RecursiveList<E>
   // Do not add any others!
   private ListState<E> listState = new EmptyList<E>();
   
   // This should be a Throwable object constructed in the base-case of all
   // ListState methods (EmptyList and NonEmptyList).
   //
   // YOU MUST UPDATE THIS FIELD AS SPECIFIED IN THE ASSIGNMENT!!!
   // ^^^ ^^^^ ^^^^^^ ^^^^ ^^^^^
   private Throwable stackTrace;

   /** DO NOT MODIFY!
    * Used to determine if the list is empty or not
    * @return true if empty, otherwise false
    */
   public boolean isEmpty()
   {
      return listState.isEmpty();
   }
   
   /** DO NOT MODIFY!
    * Used to access the number of elements in the list.  Please note that
    * this is, in fact, an O(n) operation as specified in this
    * assignment.
    * @return The number of elements in the list.
    */
   public int size()
   {
      return listState.size();
   }
   
   /** DO NOT MODIFY!
    * Adds the specified element to list in the specified location.  The element
    * at that position, if any, is not overwritten.  This method may be used to
    * add elements to the end of the list by specifying an index equal to the
    * list's current size.
    * @param index The zero-based index of the position to add the element.
    * @param element The element to add to the list.
    * @throws IndexOutOfBoundsException if the index is not valid.
    */
   public void add(int index, E element)
   {
      listState = listState.add(index, element);
   }

   /** DO NOT MODIFY!
    * Used to access the specified element of the list.
    * @param index The zero-based index of the desired element.
    * @throws IndexOutOfBoundsException if the index is not valid.
    * @return The requested element
    */
   public E get(int index)
   {
      return listState.get(index);
   }
   
   /** DO NOT MODIFY!
    * Used to modify the element at the specified index.
    * @param index The zero-based index of the element to modify.
    * @param element The new element
    * @throws IndexOutOfBoundsException if the index is not valid.
    * @return The old element at the specified index.
    */
   public E set (int index, E element)
   {
      return listState.set(index, element);
   }

   /** DO NOT MODIFY!
    * Used to obtain the zero-based index of the first element that is equal
    * to the specified element using its equals(Object) method.
    * @param element The element to search for in the list.
    * @throws java.util.NoSuchElementException() if there is not element in
    * the list that is equal to the specified element.
    * @return The zero-based index of the first element equal to the
    * specfied element using its equals(Object) method.
    */
   public int indexOf(E element)
   {
      return listState.indexOf(element);
   }

   /** DO NOT MODIFY!
    * Used to remove the element at the specified postion in the list.
    * @param index The zero-based index of the element to remove from the
    * list.
    * @throws IndexOutOfBoundsException if the index is not valid.
    */   
   public void remove (int index)
   {
      listState = listState.remove(index);
   }
   
   /** DO NOT MODIFY!
    * Used retrieve a stack trace at the bottom of the previous recursive call.
    * @return A reference to the Throwable object constructed during the last
    * recursive method call at the bottom of the recursion (base-case of NonEmptyList
    * or any EmptyList method).
    */
   public Throwable getStackTraceOfLastRecursion()
   {
      return stackTrace;
   }
}
