import java.util.Scanner;
public class GCDCalculator
{
   public static int gcd(int first, int second)
   {
      if(first == second)
      {
         return first;
      }
      else
      {
         if(first > second)
         {
            return gcd(first - second, second);
         }
         else
         {
            return gcd(first, second - first);
         }
      }
   }
   
   public static void main(String[] args)
   {
      int first;
      int second;
      Scanner scan = new Scanner(System.in);
      char cont = 'y';
      do
      {
         System.out.println("Enter two integers: ");
         first = scan.nextInt();
         second = scan.nextInt();
         System.out.println("The GCD is: " + gcd(first,second));
         System.out.println("Continue? (y/n)");
         cont = scan.next().charAt(0);
      } while(cont == 'y');
   }
}
