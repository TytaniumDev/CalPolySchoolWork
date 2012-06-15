
public class LQueue<T>
{
	private class Node
	{
		public T element;
		public Node next;
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
	
	private Node front;
	private Node end;
	
	public LQueue() //Constructor
	{
		front = null;
		end = null;
	}
	
   /*
    * Puts an item into the Queue
    * @param thing the item to be entered into the queue
    * Precondition: preferably the queue exists
    * Postcondition: the item is now in the queue
    */
	public void enqueue(T thing)
	{
		Node temp = new Node();
		temp.element = thing;
		if(front == null)
		{
			front = temp;
			end = front;
		}
		else
		{
			end.next = temp;
			end = temp;
		}
	}
	
   /*
    * removes the first item in the queue
    * @return the T type object that was removed from the queue
    * Precondition: preferably the queue exists
    * Postcondition: the first item is no longer in the queue
    */
	public T dequeue()
	{
		if(front == null)
		{
			throw new MyException();
		}
		T temp = front.element;
		front = front.next;
		return temp;
	}
	
   /*
    * Analyzes the queue to see if it is empty
    * @return True if the queue is empty, false otherwise
    * Precondition: queue preferably exists
    * Postcondition: The emptiness of the queue is now known
    */
	public boolean isEmpty()
	{
		return front == null;
	}
}
