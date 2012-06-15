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

public class OrderedLinkedList<E> implements java.lang.Iterable<E>
{
   //Instance Variables
   private Node first;
   private int size = 0;
   private java.util.Comparator<E> comp;
   
   //Constructors 
   public OrderedLinkedList(Comparator<E> comparator)
   {
      this.comp = comparator;
      this.size = 0;
      this.first = null;
   }
   
   public OrderedLinkedList(java.util.List<E> list, java.util.Comparator<E> comparator)
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

   private class MyListIterator implements ListIterator<E>
   {
      private Node prevNode = null; //The node behind the "cursor"
      private Node nextNode = first; //The node in front of the "cursor"

      public void remove()
      {
         throw new UnsupportedOperationException();
      }

      public boolean hasNext()
      {
         if(nextNode == null)
         {
            return false;
         }
         else
         {
            return true;
         }
      }

      public E next()
      {
         if(!hasNext())
         {
            throw new NoSuchElementException();
         }
         else
         {
            //Move up, staying one step ahead with nextNode
            prevNode = nextNode;
            nextNode = prevNode.next; //prevNode is now really nextNode
         }
         return prevNode.data;
      }

      public boolean hasPrevious()
      {
         //prevNode will be the previous
         if(prevNode == null)
         {
            return false;
         }
         else
         {
            return true;
         }
      }

      public E previous()
      {
         if(!hasPrevious())
         {
            throw new NoSuchElementException();
         }
         else
         {
            nextNode = prevNode;
            prevNode = nextNode.previous; //nextNode is now really prevNode
         }
         return nextNode.data;
      }
   }
   
   //Methods
   public void add(E data)
   {
      Node temp = new Node(data);

      if(first == null) //Empty list
      {
         first = temp;
      }
      else if(comp.compare(temp.data, first.data) <= 0) //Less than first
      {
         first.previous = temp;
         temp.next = first;
         first = temp;
      }
      else
      {
         //Putting temps that are equal to walker after the walker node
         Node walker = first;
         while(walker.next !=  null && (comp.compare(temp.data, walker.data) >= 0))
         {
            walker = walker.next;
         }
         if(comp.compare(temp.data, walker.data) >= 0) //Out of loop, if temp is bigger
         {
            if(walker.next == null && walker.previous == null) //List with 0-1 nodes
            {
               temp.next = null;
               temp.previous = walker;
               walker.next = temp;
            }
            else if(walker.previous == null) //First node on list
            {
               temp.previous = walker;
               temp.next = walker.next;
               (walker.next).previous = temp;
               walker.next = temp;
            }
            else if(walker.next == null) //Last node on list
            {
               temp.previous = walker;
               temp.next = null;
               walker.next = temp;
            }
            else //Nodes on either side
            {
               temp.previous = walker;
               temp.next = walker.next;
               (walker.next).previous = temp;
               walker.next = temp;
            }
         }
         else if(comp.compare(temp.data, walker.data) < 0)
         {
            if(walker.previous == null) //First node on list
            {
               temp.previous = null;
               temp.next = walker;
               walker.previous = temp;
               first = temp;
            }
            else //Nodes on either side
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
