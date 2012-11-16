import java.util.Scanner;
import java.util.InputMismatchException;

public class ListWork<T>
{
	
	public static <T> boolean search(T[] arr, T target)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].equals(target))
			{
				return true;
			}
		}
		return false;
	}

	public static <T> void print (T[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("" + arr[i]);
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] test = new Integer[10];
		
		System.out.println("Enter 10 integers:");
		Scanner scan1 = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++)
		{
			try
			{
				test[i] = scan1.nextInt();
			}	
			catch(InputMismatchException e)
			{
				scan1.next();
				i--;
			}
		}
		
		scan1.nextLine();

		System.out.println("Do you want to search for an element?");
		String temp = scan1.next();
		while(temp.equals("y"))
		{
			System.out.println("Value to search for:");
			int number;
			try
			{
				number = scan1.nextInt();
				if(search(test, number))
				{
					System.out.println("Target found");
				}
				else
				{
					System.out.println("Target not found");
				}
			}
			catch(InputMismatchException e)
			{
				scan1.next();
				System.out.println("Invalid element");
			}
			System.out.println("Search for another element?");
			temp = scan1.next();
		}
		System.out.println("The array:");
		for(int i = 0; i < test.length; i++)
		{
			System.out.println("" + test[i]);
		}
	}
}
