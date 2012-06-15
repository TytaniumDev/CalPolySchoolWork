
public class AQueue<T>
{
	private T[] arr;
	private int front;
	private int end;
	private int count;
	
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
	
	public AQueue(int size)
	{
		arr = (T[]) new Object[size];
		end = -1;
		count = 0;
		front = 0;
	}
	
	public void enqueue(T thing)
	{
		if(count == 0)
		{
			end = front;
			arr[front] = thing;
		}
		else
		{
			if(count == arr.length)
			{
				int tempFront = front;
				T[] temp = (T[]) new Object[arr.length *2];
				for(int i = 0; i < arr.length; i++)
				{
					temp[i] = arr[tempFront];
					tempFront++;
					if(tempFront == arr.length)
					{
						tempFront = 0;
					}
				}
				end = arr.length - 1;
				arr = temp;
				front = 0;
			}
			end++;
			if(end == arr.length)
			{
				end = 0;
			}
			arr[end] = thing;
		}
		count++;
	}
	
	public T dequeue()
	{
		if(count == 0)
		{
			throw new MyException();
		}
		T temp = arr[front];
		arr[front] = null;
		front++;
		if(front == arr.length)
		{
			front = 0;
		}
		count--;
		return temp;
	}
	
	public boolean empty()
	{
		return count == 0;
	}
	
	public void printArray()
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print("" + arr[i] + " ");
		}
		System.out.println("");
	}
}
