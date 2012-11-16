import java.util.Scanner;
public class AQueueClient 
{
	public static void main(String[] args)
	{
		AQueue<Float> object = new AQueue<Float>(5);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter floats for queue: ");
		
		while(scan.hasNext())
		{
			if(scan.hasNextFloat())
			{
				object.enqueue(scan.nextFloat());
			}
			else
			{
				scan.next();
			}
		}
		
		System.out.println("Queue: ");
		while(!object.empty())
		{
			System.out.print("" + object.dequeue() + " ");
		}
		System.out.println("");
	}	
}
