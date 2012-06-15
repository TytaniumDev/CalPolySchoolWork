import java.util.Scanner;


public class MyAVLTest
{
   public static void main(String[] args)
   {
      MyAVL tree = new MyAVL();
      
      Scanner scan = new Scanner(System.in);

      System.out.println("Choose one of the following operations");
      System.out.println(" -   add/insert (enter the letter a)");
      System.out.println(" -   print (enter the letter p)");
      System.out.println(" -   count odds (enter the letter o)");
      System.out.println(" -   sum (enter the letter s)");
      System.out.println(" -   count leaves (enter the letter l)");
      System.out.println(" -   count 1-child parents (enter the letter c)");
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
               
            case 'o':
               System.out.println("Number of odds: " + tree.countOdds());
               
               break;
               
            case 's':
               System.out.println("Sum: " + tree.sum());
               
               break;
               
            case 'l':
               System.out.println("Number of leaves: " + tree.countLeaves());
               
               break;
               
            case 'c':
               System.out.println("Number of one-child parents: " + tree.countOneChildParents());
               
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
