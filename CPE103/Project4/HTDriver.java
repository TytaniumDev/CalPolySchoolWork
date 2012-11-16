/*
 * CPE 103 Section 07/08 - Project 4
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;


public class HTDriver
{
   /*
    * Allows the user to enter multiple Student values and store them in a Hash Table
    * Also allows testing of all HashTable methods
    * Precondition: There is a valid text file with table size followed by student ID's and last names
    *               on the following lines.
    */
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the name of the input file: ");
      File inFile = new File(scan.nextLine());
      Scanner fileScan = new Scanner(inFile);
      int size;
      if(fileScan.hasNextInt())
      {
         size = fileScan.nextInt();
      }
      else
      {
         System.out.println("Warning: input file did not contain a valid size parameter, setting table size to 0");
         size = 0;
      }

      HashTable table = new HashTable(size);
      long idTemp;
      String tempName;
      Scanner lineScan;
      for(int i = 0; i < size; i++)
      {
         lineScan = new Scanner(fileScan.nextLine());
         if(lineScan.hasNextLong()) //Long type value check
         {
            idTemp = lineScan.nextLong();
            if(lineScan.hasNext() && idTemp > 0) //Positive value ID Check
            {
               tempName = lineScan.next();
               if(lineScan.hasNext())
               {
                  //Additional values, invalid record
               }
               else //Missing values check
               {
                  Student tempStudent = new Student(idTemp, tempName);
                  table.insert(tempStudent);
               }
            }
         }
      }
      
      System.out.println("Choose one of the following operations by entering the provided letter:");
      System.out.println("      a - add the element");
      System.out.println("      d - delete the element");
      System.out.println("      f - find and retrieve the element");
      System.out.println("      n - get the number of elements in the collection");
      System.out.println("      e - check if the collection is empty");
      System.out.println("      k - make the hash table empty");
      System.out.println("      p - print the content of the hash table");
      System.out.println("      o - output the elements of the collection");
      System.out.println("      q - add the element");
      
      long tempID;
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
               System.out.println("Enter the Student ID and last name, seperated by spaces: ");
               lineScan = new Scanner(scan.nextLine());
               if(lineScan.hasNextLong()) //Long type value check
               {
                  idTemp = lineScan.nextLong();
                  if(lineScan.hasNext() && idTemp > 0) //Positive value ID Check
                  {
                     tempName = lineScan.next();
                     if(lineScan.hasNext())
                     {
                        System.out.println("Invalid input"); //Additional values, invalid record
                     }
                     else //Missing values check
                     {
                        Student tempStudent = new Student(idTemp, tempName);
                        table.insert(tempStudent);
                        System.out.println("" + tempStudent.toString() + " inserted");
                     }
                  }
                  else
                  {
                     System.out.println("Invalid input");
                  }
               }
               else
               {
                  System.out.println("Invalid input");
               }

               break;

            case'd':
               System.out.println("Enter a Student's ID number to be deleted");
               if(scan.hasNextLong())
               {
                  tempID = scan.nextLong();
                  if(tempID > 0)
                  {
                     Student dummy = new Student(tempID, "dummy");
                     table.delete(dummy);
                     System.out.println("Student with ID # " + tempID + " deleted");
                  }
                  else
                  {
                     System.out.println("Invalid input");
                  }
               }
               else
               {
                  System.out.println("Invalid input");
               }
               
               break;
               
               
            case 'f':
               System.out.println("Enter a Student's ID number to be found");
               if(scan.hasNextLong())
               {
                  tempID = scan.nextLong();
                  if(tempID > 0)
                  {
                     Student dummy = new Student(tempID, "dummy");
                     Student tempStudent = (Student) table.find(dummy);
                     if(tempStudent != null)
                     {
                        System.out.println("" + tempStudent.toString() + " found");
                     }
                     else
                     {
                        System.out.println("ID number " + tempID + " was not found");
                     }
                  }
                  else
                  {
                     System.out.println("Invalid input");
                  }
               }
               else
               {
                  System.out.println("Invalid input");
               }
               
               break;
            
            case 'n':
               System.out.println("Number of elements in the collection: " + table.elementCount());
               
               break;
               
            case 'e':
               if(table.isEmpty())
               {
                  System.out.println("The HashTable is empty");
               }
               else
               {
                  System.out.println("The HashTable is not empty");
               }
               
               break;
               
            case 'k':
               table.makeEmpty();
               System.out.println("The HashTable is now empty");
               
               break;
             
            case 'p':
               table.printTable();
               
               break;
             
            case 'o':
               Iterator iter = table.iterator();
               System.out.println("Elements of the collection:");
               while(iter.hasNext())
               {
                  System.out.println("" + iter.next().toString());
               }
               
               break;
             
            case 'q':
               System.out.println("Quitting the program, Farewell");
               break;
               
            default:
               System.out.println("Invalid choice");
         }
      }
   }
}
