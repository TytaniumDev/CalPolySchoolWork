import java.util.Scanner;
public class HashTest
{
   public static void main(String[] args)
   {
      int size;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the size of the table");
      size = scan.nextInt();
      HashTableSC<Integer> table = new HashTableSC<Integer>(size);

      System.out.println("Choose one of the following operations");
      System.out.println(" -   add/insert (enter the letter a)");
      System.out.println(" -   find (enter the letter f)");
      System.out.println(" -   delete (enter the letter d)");
      System.out.println(" -   is empty (enter the letter e)");
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
               table.insert(tempInt);
               System.out.println("" + tempInt + " added");   
               
               scan.nextLine();
               break;
               
            case 'f':
               System.out.println("Enter an integer to find: ");
               tempInt = scan.nextInt();
               if(table.find(tempInt))
               {
                  System.out.println("" + tempInt + " found");    
               } 
               else
               {
                  System.out.println("" + tempInt + " not found");  
               }
               break;
               
            case 'p':
               table.print();
               
               break;
               
            case 'e':
               if(table.isEmpty())
               {
                  System.out.println("The table is empty");
               }
               else
               {
                  System.out.println("The table is not empty");
               }
               
               break;
               
            case 'd':
               System.out.println("Enter an integer to delete");
               tempInt = scan.nextInt();
               table.delete(tempInt);
               System.out.println(""+ tempInt + "deleted");
               scan.nextLine();
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
