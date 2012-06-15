import java.util.Scanner;


public class AQueueDriver
{
	public static void main(String[] args)
	{
		AQueue<Integer> object = new AQueue<Integer>(5);
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Choose one of the following operations");
		System.out.println(" -   enqueue/add (enter the letter a)");
		System.out.println(" -   dequeue/delete (enter the letter d)");
		System.out.println(" -   check if the list is empty (enter the letter e)");
		System.out.println(" -   print array (enter the letter p)");
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
						object.enqueue(tempInt);
						System.out.println("" + tempInt + " enqueued");	
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
						tempInt = object.dequeue();
						System.out.println("" + tempInt + " dequeued");
					}
					catch(AQueue.MyException e)
					{
						System.out.println("Invalid Operation: the queue is empty");
					}
		
					break;
					
				case 'e':
					if(object.empty())
					{
						System.out.println("empty");
					}
					else
					{
						System.out.println("not empty");
					}
					break;
					
				case 'p':
					object.printArray();
					break;
					
				case 'q':
					break;
					
				default:
					System.out.println("Invalid choice");
			}
		}
		while(!object.empty())
		{
			System.out.print("" + object.dequeue() + " "); 
		}
		System.out.println("Quitting");
	}
}
