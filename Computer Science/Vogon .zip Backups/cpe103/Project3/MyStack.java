/*
 * CPE 103 Section 07/08 - Project 1
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
public class MyStack <T>
{
   private class Node //Node class
   {
      T element;
      Node next;
   }
   
   public static class MyException extends RuntimeException
   {
      public MyException() //constructor
      {
         super();
      }
      
      public MyException(String message)//Constructor
      {
         super(message);
      }
   }
   
   private Node first; //First Node
   
   public MyStack() //Constructor
   {
      first = null;
   }
   /*
    * Pushes an item on to the stack
    * @param thing Item to add to the stack
    * Precondition: stack exists
    * Postcondition: the item is now on the top of the stack
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
    * Removes and returns the top item of the stack
    * @return the T type object that was on the top of stack
    * Precondition: stack exists and preferably has elements
    * Postcondition: the top element is returned and deleted from the stack
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
    * Looks at the top element on the stack
    * @return the T type object that is on top of the stack
    * Precondition: stack exists and preferably has elements
    * Postcondition: the top element is returned but stays in the stack
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
    * Analyzes the stack to see if it is empty
    * @return True if the stack is empty, false otherwise
    * Precondition: stack preferably exists
    * Postcondition: The emptiness of the stack is now known
    */
   public boolean isEmpty()
   {
      return first == null;
   }
}
