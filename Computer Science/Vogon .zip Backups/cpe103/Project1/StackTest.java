/*
 * CPE 103 Section 07/08 - Project 1
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Scanner;

public class StackTest
{
   public static void main(String[] args)
   {
      MyStack<String> stack = new MyStack<String>(); //The stack
      
      Scanner scan = new Scanner(System.in); //Input scanner
      
      System.out.println("Choose one of the following operations");
      System.out.println(" -   push/add (enter the letter a)");
      System.out.println(" -   pop/delete (enter the letter d)");
      System.out.println(" -   peek (enter the letter p)");
      System.out.println(" -   check if the list is empty (enter the letter e)");
      System.out.println(" -   quit (enter the letter q)");
      
      String tempString; //Temporary storage string
      char choice; //User's menu choice
      choice = 'g'; //Initialization
      while(choice != 'q')
      {
         System.out.print("Enter a choice: ");
         choice = scan.nextLine().charAt(0);
         switch (choice)
         {
            case 'a':
               System.out.print("Enter an input value: ");
               if(scan.hasNext())
               {
                  tempString = scan.nextLine();
                  stack.push(tempString);
                  System.out.println("" + tempString + " pushed in");   
               }
               else
               {
                  System.out.println("Invalid value entered");
                  scan.nextLine();
               }
               break;
               
            case 'd':
               try
               {
                  tempString = stack.pop();
                  System.out.println("" + tempString + " popped out");
               }
               catch(MyStack.MyException e)
               {
                  System.out.println("Invalid Operation: the stack is empty");
               }
      
               break;
               
            case 'e':
               if(stack.isEmpty())
               {
                  System.out.println("empty");
               }
               else
               {
                  System.out.println("not empty");
               }
               break;
               
            case 'p':
               try
               {
                  tempString = stack.peek();
                  System.out.println("" + tempString + " on the top");
               }
               catch(MyStack.MyException e)
               {
                  System.out.println("Invalid Operation: the stack is empty");
               }
               
               break;
               
            case 'q':
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
      System.out.println("quitting ");
      while(!stack.isEmpty())
      {
         System.out.print("" + stack.pop() + " "); 
      }
   }
}
