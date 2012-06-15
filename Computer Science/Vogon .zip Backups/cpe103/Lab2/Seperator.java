import java.util.Scanner;

public class Seperator 
{
	public static void main(String[] args)
	{
		int N = 5;
		int[] intArray = new int[N];
		float[] floatArray = new float[N];
		int numInts = 0;
		int numFloats = 0;
		Scanner scan = new Scanner(System.in);
		boolean cont = true;
		
		while((scan.hasNextInt() || scan.hasNextFloat()) && cont)
		{
			if(scan.hasNextInt())
			{
				if(numInts == N)
				{
					cont = false;
				}
				else
				{
					intArray[numInts] = scan.nextInt();
					numInts++;	
				}
			}
			else if(scan.hasNextFloat())
			{
				if(numFloats == N)
				{
					cont = false;
				}
				else
				{
					floatArray[numFloats] = scan.nextFloat();
					numFloats++;
				}
			}
		}
		System.out.print("Integers: ");
		for(int i = 0; i < numInts; i++)
		{
			System.out.print("" + intArray[i] + " ");
		}
		System.out.println("");
		System.out.print("Floats: ");
		for(int i = 0; i < numFloats; i++)
		{
			System.out.print("" + floatArray[i] + " ");
		}
		System.out.println("");
	}
}
