/*
 * CPE 103 Section 07/08 - Project 3
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Iterator;
import java.util.Scanner;

public class BSTDriver
{
   /*
    * Allows the user to enter multiple integer values and store them in a binary search tree
    * Also allows testing of all BST methods
    */
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      BST<Integer> tree = new BST<Integer>();
      
      System.out.println("Choose one of the following operations by entering provided letter:");
      System.out.println("       a- add the element");
      System.out.println("       d- delete the element");
      System.out.println("       f- find the element");
      System.out.println("       e- check if the tree is empty");
      System.out.println("       k- make the tree empty");
      System.out.println("       n- get the number of nodes (the size) of the tree");
      System.out.println("       m- find the minimal element");
      System.out.println("       x- find the maximal element");
      System.out.println("       p- print the tree in preorder");
      System.out.println("       i- print the tree in inorder");
      System.out.println("       l- print the tree in levelorder");
      System.out.println("       t- test print the content of the tree");
      System.out.println("       q- Quit the program");
      
      int temp; //Temporary storage of scanned input after choice
      char choice;
      choice = 'z';
      while(choice != 'q')
      {
         System.out.println("Enter a choice: ");
         choice = scan.next().charAt(0);
         scan.nextLine();
         switch (choice)
         {
            case 'a':
               System.out.println("Enter a value to be added: ");
               temp = scan.nextInt();
               tree.insert(temp);
               System.out.println("" + temp + " added");
               
               break;
               
            case 'd':
               System.out.println("Enter a value to be deleted: ");
               temp = scan.nextInt();
               tree.delete(temp);
               System.out.println("" + temp + " deleted");
               
               break;
               
            case 'f':
               System.out.println("Enter a value to find: ");
               temp = scan.nextInt();
               if(tree.find(temp))
               {
                  System.out.println("" + temp + " was found");
               }
               else
               {
                  System.out.println("" + temp + " was not found");
               }
               
               break;
               
            case 'e':
               if(tree.isEmpty())
               {
                  System.out.println("The tree is empty");
               }
               else
               {
                  System.out.println("The tree is not empty");
               }
               
               break;
               
            case 'k':
               tree.makeEmpty();
               System.out.println("The tree is now empty");
               
               break;
               
            case 'n':
               System.out.println("The size of the tree is: " + tree.size());
               
               break;
               
            case 'm':
               try
               {
                  temp = tree.findMinimum();
                  System.out.println("The minimal element is: " + temp);
               }
               catch(BST.MyException e)
               {
                  System.out.println("Error: the tree is empty");
               }
               
               break;
               
            case 'x':
               try
               {
                  temp = tree.findMaximum();
                  System.out.println("The maximal element is: " + temp);
               }
               catch(BST.MyException e)
               {
                  System.out.println("Error: the tree is empty");
               }
               break;
               
            case 'p':
               Iterator preorder = tree.iteratorPre();
               System.out.println("The tree in preorder traversal:");
               while(preorder.hasNext())
               {
                  System.out.print("" + preorder.next() + " ");
               }
               System.out.println();
               
               break;
               
            case 'i':
               Iterator inorder = tree.iteratorIn();
               System.out.println("The tree in inorder traversal:");
               while(inorder.hasNext())
               {
                  System.out.print("" + inorder.next() + " ");
               }
               System.out.println();
               
               break;
               
            case 'l':
               Iterator levelorder = tree.iteratorLevel();
               System.out.println("The tree in levelorder traversal:");
               while(levelorder.hasNext())
               {
                  System.out.print("" + levelorder.next() + " ");
               }
               System.out.println();
               
               break;
               
            case 't':
               tree.testPrint();
               break;
               
            case 'q':
               System.out.println("Quitting the program, farewell");
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
   }
}
