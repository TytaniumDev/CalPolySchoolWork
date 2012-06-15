import java.util.Iterator;
import java.util.Scanner;


public class AVLTest
{
   public static void main(String[] args)
   {
      BasicAVL tree = new BasicAVL();
      
      Scanner scan = new Scanner(System.in);

      System.out.println("Choose one of the following operations");
      System.out.println(" -   add/insert (enter the letter a)");
      System.out.println(" -   print (enter the letter p)");
      System.out.println(" -   quit (enter the letter q)");
      
      int tempInt;
      char choice;
      choice = 'g';
      while(choice != 'q')
      {
         System.out.println("Enter a choice: ");
         choice = scan.next().charAt(0);
         switch (choice)
         {
            case 'a':
               System.out.println("Enter an integer to add: ");
               tempInt = scan.nextInt();
               tree.insert(tempInt);
               System.out.println("" + tempInt + " added");   
               
               scan.nextLine();
               break;
               
            case 'p':
               tree.print();
               
               break;
               
            case 'q':
               System.out.println("quitting");
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
   }
}
