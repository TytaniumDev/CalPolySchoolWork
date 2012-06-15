/*
 * CPE 103 Section 07/08 - Project 5
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */

import java.util.Random;

public class SortTimes
{
   /*
    * Runs timed tests on each of the sorting algorithms
    * from 5000 to 80000 integer arrays, starting at 5000 and doubling each time
    * Precondition: none
    * Postcondition: A printout with the timing results is shown
    */
   public static void main(String[] args)
   {
      //Initial arrays
      Integer[] selection = new Integer[80000];
      Integer[] bubble = new Integer[80000];
      Integer[] insertion = new Integer[80000];
      Integer[] quick = new Integer[80000];
      Integer[] merge = new Integer[80000];
      
      //Segment 1
      System.out.println("TEST1: presorted list.");
      for(int N = 5000; N <= 80000; N = N*2)
      {
         for(int i = 0; i < N; i++)
         {
            selection[i] = i;
            bubble[i] = i;
            insertion[i] = i;
            quick[i] = i;
            merge[i] = i;
         }
         System.out.print("N=" + N + ": ");
         long startTime = System.nanoTime();
         Sorts.selectionSort(selection, N);
         long endTime = System.nanoTime();
         System.out.print("T_ss=" + ((endTime - startTime)/ 1000000) + ", ");

         startTime = System.nanoTime();
         Sorts.bubbleSort(bubble, N);
         endTime = System.nanoTime();
         System.out.print("T_bs=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.insertionSort(insertion, N);
         endTime = System.nanoTime();
         System.out.print("T_is=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.mergeSort(merge, N);
         endTime = System.nanoTime();
         System.out.print("T_ms=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.quickSort(quick, N);
         endTime = System.nanoTime();
         System.out.print("T_qs=" + ((endTime - startTime)/ 1000000));
         System.out.println();
      }
      
      //Segment 2
      System.out.println();
      System.out.println("TEST2: reverse sorted list.");
      for(int N = 5000; N <= 80000; N = N*2)
      {
         for(int i = 0; i < N; i++)
         {
            selection[i] = N-1-i;
            bubble[i] = N-1-i;
            insertion[i] = N-1-i;
            quick[i] = N-1-i;
            merge[i] = N-1-i;
         }
         System.out.print("N=" + N + ": ");
         long startTime = System.nanoTime();
         Sorts.selectionSort(selection, N);
         long endTime = System.nanoTime();
         System.out.print("T_ss=" + ((endTime - startTime)/ 1000000) + ", ");

         startTime = System.nanoTime();
         Sorts.bubbleSort(bubble, N);
         endTime = System.nanoTime();
         System.out.print("T_bs=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.insertionSort(insertion, N);
         endTime = System.nanoTime();
         System.out.print("T_is=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.mergeSort(merge, N);
         endTime = System.nanoTime();
         System.out.print("T_ms=" + ((endTime - startTime)/ 1000000) + ", ");
         
         startTime = System.nanoTime();
         Sorts.quickSort(quick, N);
         endTime = System.nanoTime();
         System.out.print("T_qs=" + ((endTime - startTime)/ 1000000));
         System.out.println();
      }
      
      //Segment 3
      System.out.println();
      System.out.println("TEST3: random list.");
      int randomInt;
      Random generator = new Random();
      for(int N = 5000; N <= 80000; N = N*2)
      {
         for(int j = 0; j < 3; j++)
         {
            for(int i = 0; i < N; i++)
            {
               randomInt = generator.nextInt(N);
               selection[i] = randomInt;
               bubble[i] = randomInt;
               insertion[i] = randomInt;
               quick[i] = randomInt;
               merge[i] = randomInt;
            }
            System.out.print("N=" + N + ": ");
            long startTime = System.nanoTime();
            Sorts.selectionSort(selection, N);
            long endTime = System.nanoTime();
            System.out.print("T_ss=" + ((endTime - startTime)/ 1000000) + ", ");
   
            startTime = System.nanoTime();
            Sorts.bubbleSort(bubble, N);
            endTime = System.nanoTime();
            System.out.print("T_bs=" + ((endTime - startTime)/ 1000000) + ", ");
            
            startTime = System.nanoTime();
            Sorts.insertionSort(insertion, N);
            endTime = System.nanoTime();
            System.out.print("T_is=" + ((endTime - startTime)/ 1000000) + ", ");
            
            startTime = System.nanoTime();
            Sorts.mergeSort(merge, N);
            endTime = System.nanoTime();
            System.out.print("T_ms=" + ((endTime - startTime)/ 1000000) + ", ");
            
            startTime = System.nanoTime();
            Sorts.quickSort(quick, N);
            endTime = System.nanoTime();
            System.out.print("T_qs=" + ((endTime - startTime)/ 1000000));
            System.out.println();
         }
         System.out.println();
      }
      
      System.out.println();
      System.out.println("Program ending, goodbye");
   }
}
