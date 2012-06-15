import java.util.Scanner;
public class StringChecker 
{
	public static boolean isBalanced(String item)
	{
		AStack<Character> stack = new AStack<Character>(6);
		
		for(int i = 0; i < item.length(); i++)
		{
			if(item.charAt(i) == '[' || item.charAt(i) == '{' || item.charAt(i) == '(')
			{
				stack.push(item.charAt(i));
			}
			if(item.charAt(i) == ']' || item.charAt(i) == '}' || item.charAt(i) == ')')
			{
				if(stack.isEmpty())
				{
					return false;
				}
				else
				{
					char compare;
					compare = stack.pop();
					if(compare == '[')
					{
						if(item.charAt(i) != ']')
						{
							return false;
						}
					}
					if(compare == '{')
					{
						if(item.charAt(i) != '}')
						{
							return false;
						}
					}
					if(compare == '(')
					{
						if(item.charAt(i) != ')')
						{
							return false;
						}
					}
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String loop = "yes";
		String temp;
		while(loop.equals("yes"))
		{
			System.out.println("Enter a String to be checked: ");
			temp = scan.nextLine();
			if(isBalanced(temp))
			{
				System.out.println("" + temp + " is balanced");
			}
			else
			{
				System.out.println("" + temp + " is not balanced");
			}
			
			System.out.println("Continue? (yes/no)");
			loop = scan.nextLine();
			System.out.println();
		}
	}
}
