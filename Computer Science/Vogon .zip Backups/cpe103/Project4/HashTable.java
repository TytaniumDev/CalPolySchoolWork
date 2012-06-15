/*
 * CPE 103 Section 07/08 - Project 4
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable
{
   private HashEntry[] table;
   private int occupied;
   
   private class HashEntry //Nested class for HashTableEntries
   {
      public Object element;
      public boolean active;
      
      public HashEntry(Object x)
      {
         element = x;
         active = true;
      }
   }
   
   
   public HashTable(int size) //Constructor
   {
      table = new HashEntry[nextPrime(2*size)];
      occupied = 0;
   }
   
   //Assists other methods for hashing
   /*
    * Creates the HashCode for the given object
    * @param x The Object to make a hashCode out of
    * @return Returns the int value that is the hashCode
    * Precondition: x is a valid object
    * Postcondition: the hashCode is returned
    */
   private int hash(Object x)
   {
      return Math.abs(x.hashCode()) % table.length;
   }
   
   private class Iter implements Iterator //Nested iterator class
   {
      int cursor = 0;
      /*
       * Returns the true if the iterator has a next value
       * @return true if the iterator has a next element, false otherwise
       * Precondition: the iterator is called
       * Postcondition: It is now known if the iterator has a next element
       */
      public boolean hasNext()
      {
         if(cursor == 0)
         {
            boolean found = false;
            while(found == false && cursor < table.length)
            {
               if(table[cursor] == null)
               {
                  cursor++;
               }
               else if(table[cursor].active == false)
               {
                  cursor++;
               }
               else
               {
                  found = true;
               }
            }
         }
         return (cursor < table.length && table[cursor] != null && table[cursor].active);
      }

      /*
       * Returns the next element in the iterator
       * @return the element that is next in the iterator
       * Precondition: the iterator exists
       * Postcondition: the next element is returned, iterator is moved to the next element
       */
      public Object next()
      {
         if(hasNext() == false)
         {
            throw new NoSuchElementException();
         }
         Object temp = table[cursor].element;
         cursor++;
         boolean found = false;
         while(found == false && cursor < table.length)
         {
            if(table[cursor] == null)
            {
               cursor++;
            }
            else if(table[cursor].active == false)
            {
               cursor++;
            }
            else
            {
               found = true;
            }
         }
         return temp;
      }

      /*
       * An unsupported operation
       * Precondition: none
       * Postcondition: it is an UnsupportedOperation
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   //Assists the iterator
   /*
    * Returns the next prime number
    * @param size The number to find the next prime number of
    * @return The next prime number after the given number
    * Precondition: some type of rehashing method was called
    * Postcondition: the next prime number after the input is known
    */
   private int nextPrime(int size)
   {
      if(size < 2) //Because of implementation reasons
      {
         return 2; //2 is the first prime, anything less than 2's next prime is 2
      }
      int tempPrime;
      tempPrime = size;
      boolean found = false; 
      
      while(found == false)
      {
         for(int i = 2; i < tempPrime; i++) //Divide the tempPrime by every number starting from 2
         {
            if(tempPrime % i == 0) //If the number is divisible by something
            {
               i = 1; //Start the count over (account for i++ at the end of loop)
               tempPrime++; //Increase the size of the tempPrime
            }
            else if(i == tempPrime - 1) //If the number was never divided fully
            {
               found = true; //It's a prime!
            }
         }
      }
      return tempPrime;
   }
   
   //Assists find, insert, and delete
   /*
    * Finds the position of a given object based on hashing
    * @param x An object to find the position of
    * @return Returns an int which is the position in the table where the element is
    * Precondition: A method is called that needs to find the position of an element
    * Postcondition: The position of the object is known
    */
   private int findPosition(Object x)
   {
      int i = 0;
      int hashValue = hash(x);
      int index = hashValue;
      while(table[index] != null && !x.equals(table[index].element))
      {
         i++;
         index = (hashValue + i*i) % table.length; //Next position
      }
      return index;
   }
   
   /*
    * Finds an object in the table
    * @param item The object to be found in the table
    * @return The object that was found using the given item
    * Precondition: item is a valid Object type
    * Postcondition: The found object is returned or, if not found, null is returned
    */
   public Object find(Object item)
   {
      int index = findPosition(item);
      Object answer;
      if(table[index] != null && table[index].active == true)
      {
         answer = table[index].element;
      }
      else
      {
         answer = null;
      }
      return answer;
   }
   
   /*
    * Inserts an object into the table
    * @param x The object to insert
    * Precondition: The hashTable is initialized
    * Postcondition: x is now in the table
    */
   public void insert(Object x)
   {
      int index = findPosition(x);
      if(table[index] == null)
      {
         table[index] = new HashEntry(x);
         occupied++;
         if(occupied >= table.length / 2)
         {
            rehash();
         }
      }
      else
      {
         if(table[index].active == false)
         {
            table[index].active = true;
         }
      }
   }
   
   //Assists insert
   /*
    * Increases the size of the table and rehashes
    * Precondition: Insert is called, the table is more than half full
    * Postcondition: The table is increased to at least double the size and it is rehashed
    */
   private void rehash()
   {
      HashEntry[] temp = table;
      HashTable newTable = new HashTable(nextPrime(2 * table.length));
      occupied = 0;
      
      for(int i = 0; i < temp.length; i++)
      {
         if(table[i] != null && table[i].active == true)
         {
            newTable.insert(table[i].element);
         }
      }
      table = newTable.table;
   }
   
   /*
    * Deletes an object from the table
    * @param x The item to delete from the table
    * Precondition: the table exists
    * Postcondition: If the object exists it is made inactive, otherwise the object is already not in the table
    */
   public void delete(Object x)
   {
      int index = findPosition(x);
      if(table[index] != null && table[index].active == true)
      {
         table[index].active = false;
      }
   }
   
   /*
    * Counts the number of active elements in the table
    * @return The number of active elements in the table
    * Precondition: the table exists
    * Postcondition: The number of active elements is known
    */
   public int elementCount()
   {
      int count = 0;
      for(int i = 0; i < table.length; i++)
      {
         if(table[i] != null && table[i].active == true)
         {
            count++;
         }
      }
      return count;
   }
   
   /*
    * Finds if the table is empty or not
    * @return true if there are no active elements, false otherwise
    * Precondition: the table exists
    * Postcondition: elementCount is used to find the size of the table, if 0 isEmpty returns true
    */
   public boolean isEmpty()
   {
      return elementCount() == 0;
   }
   
   /*
    * Makes the table empty
    * Precondition: The table exists
    * Postcondition: A new Hash table is made with the same length as the current, and table is assigned to it
    */
   public void makeEmpty()
   {
      table = new HashEntry[table.length];
   }
   
   /*
    * Prints out the table
    * Precondition: the table exists
    * Postcondition: The complete table is printed, empty, inactive, and active cells are shown accordingly
    */
   public void printTable()
   {
      for(int i = 0; i < table.length; i++)
      {
         System.out.print("[" + i + "]: ");
         if(table[i] == null)
         {
            System.out.println("empty");
         }
         else
         {
            System.out.print("" + table[i].element + ", ");
            if(table[i].active == true)
            {
               System.out.println("active");
            }
            else if(table[i].active == false)
            {
               System.out.println("inactive");
            }
         }
      }
   }
   
   /*
    * Returns an iterator for this hash table
    * @return An iterator for the HashTable class
    * Precondition: the table exists, Iter is defined properly
    * Postcondition: An iterator for this hash table is created
    */
   public Iterator iterator()
   {
      return new Iter();
   }
}
