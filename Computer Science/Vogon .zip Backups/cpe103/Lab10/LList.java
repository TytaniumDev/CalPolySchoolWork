import java.util.NoSuchElementException;
import java.util.Iterator;
public class LList<T>
{
   private Node head;
   
   private class Node
   {
      T element;
      Node next;
      
      public Node(T item)
      {
         element = item;
         next = null;
      }
   }
   
   private class Iter implements Iterator<T>
   {
      private Node cursor;
      
      public Iter()
      {
         cursor = head;
      }
      
      public boolean hasNext()
      {
         return cursor != null;
      }
      
      public T next()
      {
         if(cursor == null)
         {
            throw new NoSuchElementException();
         }
         else
         {
            T temp = cursor.element;
            cursor = cursor.next;
            return temp;
         }
      }
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   public LList()
   {
      head = null;
   }
   
   public Iter iterator()
   {
      return new Iter();
   }
   
   public void add(T item)
   {
      Node temp = new Node(item);
      if(head == null)
      {
         head =temp;
      }
      else
      {
         Node pointer = head;
         while(pointer.next != null)
         {
            pointer = pointer.next;
         }
         pointer.next = temp;
      }
   }
}
