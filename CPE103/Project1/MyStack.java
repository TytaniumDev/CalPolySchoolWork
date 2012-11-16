/*
 * CPE 103 Section 07/08 - Project 1
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
public class MyStack <T>
{
   private class Node
   {
      T element;
      Node next;
   }
   
   public static class MyException extends RuntimeException
   {
      public MyException()
      {
         super();
      }
      
      public MyException(String message)
      {
         super(message);
      }
   }
   
   private Node first; //First Node
   
   public MyStack()
   {
      first = null;
   }
   /*
    * @pre thing exists
    * @post isEmpty == false
    */
   public void push(T thing)
   {
      Node temp = new Node();
      temp.element = thing;
      if(first == null)
      {
         first = temp;
      }
      else
      {
         temp.next = first;
         first = temp;
      }
   }
   
   /*
    * @pre stack isn't empty
    * @post top element
    */
   public T pop()
   {
      if(first == null)
      {
         throw new MyException();
      }
      T temp = first.element;
      first = first.next;
      return temp;
   }
   
   /*
    * @pre stack isn't empty
    * @post the top element
    */
   public T peek()
   {
      if(first == null)
      {
         throw new MyException();
      }
      else
      {
         return first.element;
      }
   }
   
   /*
    * @pre stack exists
    * @post emptiness of stack
    */
   public boolean isEmpty()
   {
      return first == null;
   }
}
