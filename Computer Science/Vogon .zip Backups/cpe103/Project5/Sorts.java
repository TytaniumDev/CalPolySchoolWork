/*
 * CPE 103 Section 07/08 - Project 5
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */

public class Sorts
{
   //O(N^2) algorithms
   /*
    * Uses selection sorting technique to sort the values
    * @param arr The array to sort
    * @param size The size of the array (can also be used to sort part of an array)
    * Precondition: Array is made up of comparable types
    * Postcondition: The array is sorted using selection sort
    */
   public static <Type extends Comparable<? super Type>> void selectionSort(Type[] arr, int size)
   {
      int minIndex;
      Type holder;
      for(int i = 0; i <= size - 2; i++)
      {
         minIndex = i;
         for(int j = i+1; j <= size - 1; j++)
         {
            if(arr[j].compareTo(arr[minIndex]) < 0)
            {
               minIndex = j;
            }
         }
         holder = arr[minIndex];
         arr[minIndex] = arr[i];
         arr[i] = holder;
      }
   }
   
   /*
    * Uses bubble sorting technique to sort the values
    * @param arr The array to sort
    * @param size The size of the array (can also be used to sort part of an array)
    * Precondition: Array is made up of comparable types
    * Postcondition: The array is sorted using bubble sort
    */
   public static <Type extends Comparable<? super Type>> void bubbleSort(Type[] arr, int size)
   {
      boolean done = false;
      Type holder;
      while(done == false)
      {
         done = true;
         for(int i = 0; i <= size - 2; i++)
         {
            if(arr[i].compareTo(arr[i+1]) > 0)
            {
               holder = arr[i];
               arr[i] = arr[i + 1];
               arr[i + 1] = holder;
               done = false;
            }
         }
      }
   }
   
   /*
    * Uses insertion sorting technique to sort the values
    * @param arr The array to sort
    * @param size The size of the array (can also be used to sort part of an array)
    * Precondition: Array is made up of comparable types
    * Postcondition: The array is sorted using insertion sort
    */
   public static <Type extends Comparable<? super Type>> void insertionSort(Type[] arr, int size)
   {
      Type temp;
      int j;
      for(int i = 0; i <= size - 1; i++)
      {
         temp = arr[i];
         j = i;
         while(j != 0 && arr[j-1].compareTo(temp) > 0)
         {
            arr[j] = arr[j-1];
            j--;
         }
         arr[j] = temp;
      }
   }
   
   //O(N) algorithms
   /*
    * Uses merge sorting technique to sort the values
    * @param arr The array to sort
    * @param size The size of the array (can also be used to sort part of an array)
    * Precondition: Array is made up of comparable types
    * Postcondition: The array is sorted using merge sort
    */
   public static <Type extends Comparable<? super Type>> void mergeSort(Type[] arr, int size)
   {
      mergeSort(arr, 0, size - 1);
   }
   //Tied in with mergeSort above
   /*
    * The recursive part of merge sort
    * @param list The array to sort
    * @param first The first index to sort from
    * @param last The last index to sort to
    * Precondition: first is a valid index and last is a valid index
    * Postcondition: The array is sorted using merge sort
    */
   private static <Type extends Comparable<? super Type>> void mergeSort(Type[] list, int first, int last)
   {
      if(first < last)
      {
         int middle = (first + last) / 2;
         mergeSort(list, first, middle);
         mergeSort(list, middle + 1, last);
         mergeSortedHalves(list, first, middle, last);
      }
   }
   //Tied in with mergeSort above
   /*
    * @param arr The array to sort
    * @param left The leftmost index
    * @param middle The middle index (used for splitting the array)
    * @param right The last index to sort to
    * Precondition: arr[left..middle] is sorted; arr[middle+1, right] is sorted
    * Postcondition: arr[left..right] is sorted;
    */
   private static <Type extends Comparable<? super Type>> void mergeSortedHalves (Type[] arr, int left, int middle, int right)
   {
      Type[] temp = (Type[]) new Comparable[(right-left)+1];
      int index1 = left;
      int index2 = middle + 1;
      int index = 0;
       
      while(index1 <= middle && index2 <= right)
      {
         if(arr[index1].compareTo(arr[index2]) < 0)
         {
            temp[index] = arr[index1];
            index1++;
         }
         else
         {
            temp[index] = arr[index2];
            index2++;
         }
         index++;
      }  
      if(index1 <= middle)
      {
         for(int i = index1; i <= middle; i++)
         {
            temp[index] = arr[i];
            index++;
         }
      }
      else if(index2 <= right)
      {
         for(int i = index2; i <= right; i++)
         {
            temp[index] = arr[i];
            index++;
         }
      }
      for(int i = 0; i < temp.length; i++)
      {
         arr[left] = temp[i];
         left++;
      }
   }
   
   /*
    * Uses quick sorting technique to sort the values
    * @param arr The array to sort
    * @param size The size of the array (can also be used to sort part of an array)
    * Precondition: Array is made up of comparable types
    * Postcondition: The array is sorted using quick sort
    */
   public static <Type extends Comparable<? super Type>> void quickSort(Type[] arr, int size)
   {
      quickSort(arr, 0, size-1);
   }
   //Tied in with quickSort above
   /*
    * The recursive part of quick sort
    * @param list The array to sort
    * @param first The first index to sort from
    * @param last The last index to sort to
    * Precondition: first is a valid index and last is a valid index
    * Postcondition: The array is sorted using quick sort
    */
   private static <Type extends Comparable<? super Type>> void quickSort(Type[] list, int first, int last)
   {
      if(first < last)
      {
         setPivotToEnd(list, first, last);
         int pivotIndex = splitList(list, first, last);
         quickSort(list, first, pivotIndex-1);
         quickSort(list, pivotIndex+1, last);
      }
   }
   //Tied in with quickSort above
   /*
    * Chooses a pivot in arr[left..right], and moves it to the end of the segment
    * @param arr The array to be sorted
    * @param left The left most index to be considered
    * @param right The right most index to be considered
    * Precondition: none
    * Postcondition: arr[right] is the pivot
    */
   private static <Type extends Comparable<? super Type>> void setPivotToEnd(Type[] arr, int left, int right)
   {
      int center = (left+right)/2;
      Type holder;
      if(arr[center].compareTo(arr[left]) < 0)
      {
         holder = arr[center];
         arr[center] = arr[left];
         arr[left] = holder;
      }
      if(arr[right].compareTo(arr[left]) < 0)
      {
         holder = arr[right];
         arr[right] = arr[left];
         arr[left] = holder;
      }
      if(arr[center].compareTo(arr[right]) < 0)
      {
         holder = arr[center];
         arr[center] = arr[right];
         arr[right] = holder;
      }
   }
   //Tied in with quickSort above
   /*
    * Rearranges the list by placing the pivot so that it is preceded by smaller values and followed by greater values
    * Returns pivot's index
    * @return An int with the pivot's index
    * @param left The leftmost index to be considered
    * @param right The rightmost index to be considered
    * Precondition: arr[right] contains the pivot
    * Postcondition: the pivot is placed in the list and its index is returned
    */
   private static <Type extends Comparable<? super Type>> int splitList(Type[] arr, int left, int right)
   {
      int indexL = left;
      int indexR = right-1;
      Type pivot = arr[right];
      Type holder;
      while(!(indexL>indexR))
      {
         while(arr[indexL].compareTo(pivot) < 0)
         {
            indexL++;
         }
         while((!(indexL>indexR)) && (arr[indexR].compareTo(pivot) > 0))
         {
            indexR--;
         }
         if(!(indexL>indexR))
         {
            holder = arr[indexL];
            arr[indexL] = arr[indexR];
            arr[indexR] = holder;
            indexL++;
            indexR--;
         }
      }
      if(indexL != right)
      {
         holder = arr[indexL];
         arr[indexL] = arr[right];
         arr[right] = holder;
      }
      return indexL;
   }
}
