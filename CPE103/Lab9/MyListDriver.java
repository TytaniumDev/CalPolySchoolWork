import java.util.Scanner;


public class MyListDriver
{
   public static void main(String[] args)
   {
      MyList object = new MyList();
      Scanner scan1 = new Scanner(System.in);
      
      System.out.println("Choose one of the following operations");
      System.out.println(" -   add (enter the letter a)");
      System.out.println(" -   find (enter the letter f)");
      System.out.println(" -   print (enter the letter p)");
      System.out.println(" -   sum (enter the letter s)");
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
               System.out.println("Enter an integer to add: ");
               tempInt = scan1.nextInt();
               object.add(tempInt);
               System.out.println("" + tempInt + " added");   
               
               scan1.nextLine();
               break;
               
            case 'f':
               System.out.println("Enter an integer to find: ");
               tempInt = scan1.nextInt();
               if(object.find(tempInt))
               {
                  System.out.println("" + tempInt + " found");    
               } 
               else
               {
                  System.out.println("" + tempInt + " not found");  
               }
               break;
               
            case 'p':
               object.print();
               
               break;
               
            case 's':
               System.out.println("Sum: " + object.sum());
               
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
