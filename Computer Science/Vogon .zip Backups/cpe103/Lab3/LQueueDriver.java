import java.util.Scanner;
public class LQueueDriver 
{
	public static void main(String[] args)
	{
		LQueue<Integer> object = new LQueue<Integer>();
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Choose one of the following operations");
		System.out.println(" -   enqueue/add (enter the letter a)");
		System.out.println(" -   dequeue/delete (enter the letter d)");
		System.out.println(" -   check if the list is empty (enter the letter e)");
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
					catch(LQueue.MyException e)
					{
						System.out.println("Invalid Operation: the queue is empty");
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
					
				case 'q':
					break;
					
				default:
					System.out.println("Invalid choice");
			}
		}
		while(!object.isEmpty())
		{
			System.out.print("" + object.dequeue() + " "); 
		}
		System.out.println("Quitting");
	}
}
