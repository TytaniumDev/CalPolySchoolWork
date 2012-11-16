/*
 * CPE 103 Section 07/08 - Project 2
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Scanner;
public class HeapTest
{
   /*
    * Allows the user to enter multiple string values and store them in a binary heap
    * Also allows testing of all BinHeap methods
    */
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the initial heap size: ");
      int sizeHolder = scan.nextInt();
      BinHeap<String> heap = new BinHeap<String>(sizeHolder);
      
      System.out.println("Choose one of the following operations:");
      System.out.println("     - add an element (enter the letter a)");
      System.out.println("     - delete the smallest element (enter the letter d)");
      System.out.println("     - is the heap empty (enter the letter e)");
      System.out.println("     - size of the collection (enter the letter s)");
      System.out.println("     - print the collection (enter the letter p)");
      System.out.println("     - Quit (enter the letter q)");
      
      String temp; //Temp storage of scanned line
      char choice;
      choice = 'g';
      while(choice != 'q')
      {
         System.out.println("Enter a choice: ");
         choice = scan.next().charAt(0);
         scan.nextLine();
         switch (choice)
         {
            case 'a':
               System.out.println("Enter a value to be inserted: ");
               temp = scan.nextLine();
               heap.insert(temp);
               System.out.println("" + temp + " inserted");

               break;
               
            case 'd':
               try
               {
                  temp = heap.deleteMin();  
                  System.out.println("" + temp + " deleted");
               }
               catch(BinHeap.MyException e)
               {
                  System.out.println("Error: the heap is empty");
               }

               break;
               
            case 'e':
               if(heap.isEmpty())
               {
                  System.out.println("heap is empty");
               }
               else
               {
                  System.out.println("heap is not empty");
               }
               
               break;
               
            case 's':
               System.out.println("the size is " + heap.size());
               
               break;
               
            case 'p':
               heap.print();
               
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
