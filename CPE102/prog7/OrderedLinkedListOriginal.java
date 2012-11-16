/**
 * A Generic Ordered Link List for storage of multiple items.
 *
 * @author Tyler Holland
 * @version Program 7
 * @version CPE102-5
 * @version Winter 2009
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedLinkedListOriginal<E> implements java.lang.Iterable<E>
{
   //Instance Variables
   private Node first;
   private int size = 0;
   private java.util.Comparator<E> comp;
   
   //Constructors 
   public OrderedLinkedListOriginal(Comparator<E> comparator)
   {
      this.comp = comparator;
      this.size = 0;
      this.first = null;
   }
   
   public OrderedLinkedListOriginal(java.util.List<E> list, java.util.Comparator<E> comparator)
   {
      this.comp = comparator;
      this.size = 0;
      for(int i = 0; i < list.size(); i++)
      {
         add(list.get(i));
      }
   }
   
   //Node class
   private class Node
   {
      public E data;
      public Node next;
      public Node previous;
      
      public Node(E data)
      {
         this.data = data;
         this.next = null;
         this.previous = null;
      }
   }
   
   //MyListIterator Class
   private class MyListIterator implements ListIterator<E>
   {
      private Node cursor;

      public void remove()
      {
         throw new UnsupportedOperationException();
      }

      public boolean hasNext()
      {
         if(cursor == null)
         {
            return first != null;
         }
         else
         {
            return cursor.next != null;
         }
      }

      public E next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }
         if(cursor == null)
         {
            cursor = first;
         }
         else
         {
            cursor = cursor.next;
         }

         return cursor.data;
      }

      public boolean hasPrevious()
      {
         if(cursor == null)
         {
            return false;
         }
         else
         {
            return cursor.previous != null;
         }
      }

      public E previous()
      {
         if(hasPrevious() == false)
         {
            throw new NoSuchElementException();
         }
         if(cursor == null)
         {
            cursor = first;
         }
         else
         {
            cursor = cursor.previous;
         }

         return cursor.data;
      }
   }
   
   //Methods
   public void add(E data)
   {
      Node temp = new Node(data);

      if(first == null)
      {
         first = temp;
      }
      else
      {
         Node walker = first;
         while(walker.next !=  null && (comp.compare(temp.data, walker.data) >= 0))
         {
            walker = walker.next;
         }
         if(comp.compare(temp.data, walker.data) >= 0)
         {
            if(walker.next == null && walker.previous == null)
            {
               temp.next = null;
               temp.previous = walker;
               walker.next = temp;
            }
            else if(walker.previous == null)
            {
               temp.previous = walker;
               temp.next = walker.next;
               (walker.next).previous = temp;
               walker.next = temp;
            }
            else if(walker.next == null)
            {
               temp.previous = walker;
               temp.next = null;
               walker.next = temp;
            }
            else
            {
               temp.previous = walker;
               temp.next = walker.next;
               (walker.next).previous = temp;
               walker.next = temp;
            }
         }
         else if(comp.compare(temp.data, walker.data) < 0)
         {
            if(walker.previous == null)
            {
               temp.previous = null;
               temp.next = walker;
               walker.previous = temp;
               first = temp;
            }
            else
            {
               temp.previous = walker.previous;
               temp.next = walker;
               (temp.previous).next = temp;
               walker.previous = temp;
            }
         }
      }
      size++;
   }
   
   public void clear()
   {
      first = null;
      size = 0;
   }
   
   public E get(int index)
   {
      Node answer = first; 
      if(first == null || index < 0 || index > size)
      {
         throw new java.lang.IndexOutOfBoundsException();
      }
      for(int i = 0; i < index; i++)
      {
         if(answer.next == null)
         {
            throw new java.lang.IndexOutOfBoundsException();
         }
         else
         {
            answer = answer.next;
         }
      }
      return answer.data;
   }
   
   public int indexOf(E element)
   {
      Node walker = first;
      if(first == null)
      {
         throw new java.util.NoSuchElementException();
      }
      int index = 0;
      while(walker != null)
      {
         if((walker.data).equals(element))
         {
            return index;
         }
         else
         {
            walker = walker.next;
            index++;
         }
      }
      throw new java.util.NoSuchElementException();
   }
   
   public Iterator<E> iterator()
   {
      return new MyListIterator();
   }

   public ListIterator<E> listIterator()
   {
      return new MyListIterator();
   }
   
   public E remove(int index)
   {
      Node walker = first;
      if(index < 0 || index > size || first == null)
      {
         throw new java.lang.IndexOutOfBoundsException();
      }
      for(int i = 0; i < index; i++)
      {
         if(walker.next != null)
         {
            walker = walker.next;
         }
         else
         {
            throw new java.lang.IndexOutOfBoundsException();
         }
      }
      //Make previous point to next and vice-versa
      if(walker.next == null && walker.previous == null)
      {
         clear();
         size = 1;
      }
      else if(walker.next == null)
      {
         (walker.previous).next = null;         
      }
      else if(walker.previous == null)
      {
         (walker.next).previous = null;
         first = walker.next;
      }
      else
      {
         (walker.previous).next = walker.next;
         (walker.next).previous = walker.previous;
      } 
      size--;
      return walker.data;
   }
   
   public int size()
   {
      return this.size;
   }
}
