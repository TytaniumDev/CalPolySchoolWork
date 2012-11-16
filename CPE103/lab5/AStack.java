
public class AStack<T> 
{
	private T[] arr;
	private int top;
	
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}
		public MyException(String error)
		{
			super(error);
		}
	}
	
	public AStack(int size)
	{
		arr = (T[])new Object[size];
		top = -1;
	}
	
	public void push(T thing)
	{
		top++;
		if(top == arr.length)
		{
			T[] temp = (T[]) new Object[arr.length *2];
			for(int i = 0; i < arr.length; i++)
			{
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[top] = thing;
	}
	
	public T pop()
	{
		if(top == -1)
		{
			throw new MyException();
		}
		top--;
		return arr[top + 1];
	}
	
	public T peek()
	{
		if(top == -1)
		{
			throw new MyException();
		}
		return arr[top];
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
}
