
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
	
	public LQueue()
	{
		front = null;
		end = null;
	}
	
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
	
	public boolean isEmpty()
	{
		return front == null;
	}
}
