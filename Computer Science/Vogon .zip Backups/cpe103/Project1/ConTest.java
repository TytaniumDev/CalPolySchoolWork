/*
 * CPE 103 Section 07/08 - Project 1
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Scanner;

public class ConTest
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in); //Input scanner
      
      System.out.println("Choose one of the following operations");
      System.out.println(" -   Infix to postfix conversion (enter the letter i)");
      System.out.println(" -   Postfix expression evaluation (enter the letter p)");
      System.out.println(" -   Arithmetic expression evaluation (enter the letter a)");
      System.out.println(" -   Quit the program (enter the letter q)");
      
      String temp; //Storage for input
      char choice; //User's menu choice
      choice = 'g'; //Initialization
      while(choice != 'q')
      {
         System.out.println("Enter a choice: ");
         choice = scan.next().charAt(0);
         scan.nextLine();
         switch (choice)
         {
            case 'i':
               System.out.println("Enter an infix operation: ");
               temp = scan.nextLine();
               System.out.println("the postfix expression is: " + Converter.infixToPostfix(temp));

               break;
               
            case 'p':
               System.out.println("Enter a postfix expression: ");
               temp = scan.nextLine();
               System.out.println("the value of the postfix expression is: " + Converter.postfixValue(temp));

               break;
               
            case 'a':
               System.out.println("Enter an arithmetic expression: ");
               temp = scan.nextLine();
               System.out.println("the value of the arithmetic expression is: " + Converter.postfixValue(Converter.infixToPostfix(temp)));
               
               break;

            case 'q':
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
   }
}
