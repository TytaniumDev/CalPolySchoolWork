/*
 * CPE 103 Section 07/08 - Project 2
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
public class BinHeap <T extends Comparable<?super T>>
{
   public static class MyException extends RuntimeException
   {
      public MyException()
      {
         super();
      }
      
      public MyException(String message)
      {
         super(message);
      }
   }
   
   //Instance Variables
   private T[] arr;
   private int size;
   
   //Constructors
   /*
    * Precondition: none
    * Postcondition: An empty BinHeap is created of size 100
    */
   public BinHeap()
   {
      arr = (T[]) new Comparable[100];
      size = 0;
   }
   /*
    * Precondition: sizeOfArray is a positive integer
    * Postcondition: An empty BinHeap is created of a given size
    */
   public BinHeap(int sizeOfArray)
   {
      arr = (T[]) new Comparable[sizeOfArray + 1];
      size = 0;
   }
   
   //Methods
   /*
    * Precondition: item is a valid element of T type
    * Postcondition: item is inserted into the array in a binary heap type fashion
    */
   public void insert(T item)//based on pseudo-code given
   {
      if(size == arr.length)
      {
         T[] tempArr = (T[]) new Comparable[size*2];
         for(int i = 0; i < arr.length; i++)
         {
            tempArr[i] = arr[i];
         }
         arr = tempArr;
      }
      int hole = size; //The hole node location
      while(hole > 0 && (item.compareTo(arr[(hole - 1) / 2]) < 0)) //hole has a parent and parent's value is > item
      {
         arr[hole] = arr[(hole - 1) / 2]; //Set hole node's value to be its parent's value
         hole = (hole - 1) / 2; //Set hole to be the parent node
      }
      arr[hole] = item; //Set hole node's value to be the inserted value
      size++; //Size increase
   }
   
   /*
    * Precondition: none
    * Postcondition: returns the smallest element in the binary heap and it is removed from the heap
    */
   public T deleteMin() //based on pseudo-code given
   {
      if(size == 0)
      {
         throw new MyException();
      }
      else
      {
         T returnValue = arr[0];
         T item = arr[size - 1];
         size = size - 1;
         int hole = 0;
         int newhole = newHole(hole, item);
         
         while(newhole >= 0 && newhole < size)
         {
            arr[hole] = arr[newhole];
            hole = newhole;
            newhole = newHole(hole, item);
         }
         arr[hole] = item;
         return returnValue;
      }
   }
   
   /*
    * Precondition: item is a valid element of T type, hole is greater than 0
    * Postcondition: returns a new hole value for deleteMin in order to safely delete elements
    */
   private int newHole(int hole, T item) //private class for deleteMin
   {
      int  newhole = -1;
      if(((2*hole) + 1) < size) //if hole has children
      {
         if(!(((2*hole) + 2) < size)) //if hole does not have a right child 
         {
            newhole = (2*hole) + 1; //newhole is left child
         }
         else
         {
            if(arr[2*hole + 1].compareTo(arr[2*hole + 2]) < 0) //if left child is smaller than right child
            {
               if(arr[2*hole + 1].compareTo(item) < 0) //if left child is smaller than item
               {
                  newhole = 2*hole + 1;
               }
            }
            else //right child is smaller than left child
            {
               if(arr[2*hole + 2].compareTo(item) < 0) //if right child is smaller than item
               {
                  newhole = 2*hole + 2;
               }
            }
         }
      }
      return newhole;
   }
   
   /*
    * Precondition: none
    * Postcondition: returns if the heap is empty or not
    */
   public boolean isEmpty()
   {
      if(size == 0)
      {
         return true;
      }
      return false;
   }
   
   /*
    * Precondition: none
    * Postcondition: returns the size of the heap
    */
   public int size()
   {
      return size;
   }
   
   /*
    * Precondition: none
    * Postcondition: prints out the heap in the order it is in the array
    */
   public void print()
   {
      for(int i = 0; i < size; i++)
      {
         System.out.print("" + arr[i] + " ");
      }
      System.out.println();
   }
}
