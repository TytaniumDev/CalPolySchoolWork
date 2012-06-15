/*
 * CPE 103 Section 07/08 - Project 1
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Scanner;

public class Converter
{
   /*
    * @pre Input string is a valid infix expression
    * @post Postfix expression from the input
    */
   public static String infixToPostfix(String expression)
   {
      MyStack<String> stack = new MyStack<String>(); //The stack
      String output = new String(); //The final Postfix output
      String current; //The current string being evaluated
      Scanner input = new Scanner(expression); //Input scanner
      
      while(input.hasNext())
      {
         current = input.next();
         
         if(current.equals("+") || current.equals("-"))
         {
            while(!stack.isEmpty() && !stack.peek().equals("("))
            {
               output = output.concat(stack.pop() + " ");
            }
            stack.push(current);
         }
         else if(current.equals("*") || current.equals("/"))
         {
            while(!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("+") && !stack.peek().equals("-"))
            {
               output = output.concat(stack.pop() + " ");
            }
            stack.push(current);
         }
         else if(current.equals("("))
         {
            stack.push(current);
         }
         else if(current.equals(")"))
         {
            while(!stack.isEmpty() && !stack.peek().equals("("))
            {
               output = output.concat(stack.pop() + " ");
            }
            if(!stack.isEmpty())
            {
               stack.pop();
            }
         }
         else
         {
            output = output.concat(current + " ");
         }
      }
      return output;
   }
   
   /*
    * @pre Input is a valid postfix expression
    * @post Value of input
    */
   public static double postfixValue(String expression)
   {
      MyStack<Double> stack = new MyStack<Double>(); //The stack
      Scanner input = new Scanner(expression); //Input scanner
      
      while(input.hasNext())
      {
         if(input.hasNextDouble())
         {
            stack.push(input.nextDouble());
         }
         else
         {
            String value = input.next();
            if(value.equals("+"))
            {
               double temp;
               temp = stack.pop() + stack.pop();
               stack.push(temp);
            }
            else if(value.equals("-"))
            {
               double temp;
               temp = stack.pop() - stack.pop();
               stack.push(temp);
            }
            else if(value.equals("*"))
            {
               double temp;
               temp = stack.pop() * stack.pop();
               stack.push(temp);
            }
            else if(value.equals("/"))
            {
               double temp;
               temp = stack.pop() / stack.pop();
               stack.push(temp);
            }
         }
      }
      return stack.pop();
   }
}
