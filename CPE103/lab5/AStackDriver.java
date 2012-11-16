import java.util.Scanner;
import java.util.Scanner;
public class AStackDriver 
{
	public static void main(String[] args)
	{
		AStack<Integer> object = new AStack<Integer>(5);
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Choose one of the following operations");
		System.out.println(" -   push/add (enter the letter a)");
		System.out.println(" -   pop/delete (enter the letter d)");
		System.out.println(" -   check if the list is empty (enter the letter e)");
		System.out.println(" -   peek (enter the letter p)");
		System.out.println(" -   quit (enter the letter q)");
		
		int tempInt;
		char choice;
		choice = 'g';
		while(choice != 'q')
		{
			System.out.println("Enter a choice: ");
			choice = scan1.next().charAt(0);
			switch (choice)
			{
				case 'a':
					System.out.println("Enter an integer: ");
					if(scan1.hasNextInt())
					{
						tempInt = scan1.nextInt();
						object.push(tempInt);
						System.out.println("" + tempInt + " pushed");	
					}
					else
					{
						System.out.println("Invalid value entered");
						scan1.nextLine();
					}
					scan1.nextLine();
					break;
					
				case 'd':
					try
					{
						tempInt = object.pop();
						System.out.println("" + tempInt + " popped");
					}
					catch(AStack.MyException e)
					{
						System.out.println("Invalid Operation: the stack is empty");
					}
		
					break;
					
				case 'e':
					if(object.isEmpty())
					{
						System.out.println("empty");
					}
					else
					{
						System.out.println("not empty");
					}
					break;
					
				case 'p':
					try
					{
						tempInt = object.peek();
						System.out.println("" + tempInt + " peeked");
					}
					catch(AStack.MyException e)
					{
						System.out.println("Invalid Operation: the stack is empty");
					}
					
					break;
					
				case 'q':
					break;
					
				default:
					System.out.println("Invalid choice");
			}
		}
		while(!object.isEmpty())
		{
			System.out.print("" + object.pop() + " "); 
		}
		System.out.println("Quitting");
	}
}
