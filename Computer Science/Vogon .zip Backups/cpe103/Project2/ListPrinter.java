/*
 * CPE 103 Section 07/08 - Project 2
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Scanner;
import java.io.*;
public class ListPrinter
{
   /*
    * Allows the user to enter a text file containing student records 
    * and have them be sorted in a binary heap based on ID number.
    * Also allows testing of all BinHeap methods and Student methods
    */
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);
      BinHeap<Student> heap = new BinHeap<Student>();
      
      System.out.println("Enter the student records file name:");
      File inFile = new File(scan.nextLine());
      Scanner fileScan = new Scanner(inFile);
      
      long tempID = -1;
      String tempLast = "";
      Scanner lineScan;
      while(fileScan.hasNext())
      {
         lineScan = new Scanner(fileScan.nextLine());
         if(lineScan.hasNextLong()) //Long type value check
         {
            tempID = lineScan.nextLong();
            if(lineScan.hasNext() && tempID > 0) //Positive value ID Check
            {
               tempLast = lineScan.next();
               if(lineScan.hasNext())
               {
                  //Additional values, invalid record
               }
               else //Missing values check
               {
                  Student tempStudent = new Student(tempID, tempLast);
                  heap.insert(tempStudent);
               }
            }
         }
      }
      fileScan.close();
      
      System.out.println();
      System.out.println("Student List:");
      int count = 1;
      while(!heap.isEmpty())
      {
         System.out.print("" + count + ". ");
         System.out.print("" + heap.deleteMin().toString());
         System.out.println();
         count++;
      }
   }
}
