import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AStackClient 
{
	public static void main(String[] args)
	{
		AStack<Integer> ints = new AStack<Integer>(5);
		AStack<Float> floats = new AStack<Float>(5);
		AStack<String> strings = new AStack<String>(5);
		Scanner scan1 = new Scanner(System.in);
		String fileName;
		
		System.out.println("Enter a file name: ");
		fileName = scan1.nextLine();
		
		try
		{
			scan1 = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
		}
		
		while(scan1.hasNext())
		{
			if(scan1.hasNextInt())
			{
				ints.push(scan1.nextInt());
			}
			else if(scan1.hasNextFloat())
			{
				floats.push(scan1.nextFloat());
			}
			else
			{
				strings.push(scan1.next());
			}
		}
		
		System.out.print("Strings: ");
		while(!strings.isEmpty())
		{
			System.out.print("" + strings.pop() + " ");
		}
		System.out.println();
		System.out.print("Floats: ");
		while(!floats.isEmpty())
		{
			System.out.print("" + floats.pop() + " ");
		}
		System.out.println();
		System.out.print("Integers: ");
		while(!ints.isEmpty())
		{
			System.out.print("" + ints.pop() + " ");
		}
		System.out.println();
	}
}
