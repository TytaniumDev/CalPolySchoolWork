import java.util.LinkedList;
import java.util.Iterator;

public class MyHashTable<T>
{
   LinkedList<T>[] arr;
   
   public MyHashTable(int param)
   {
      arr = (LinkedList<T>[])new LinkedList[param];
      for(int i = 0; i < arr.length; i++)
      {
         arr[i] = new LinkedList<T>();
      }
   }
   
   private int hash(T param)
   {
      return param.hashCode() % arr.length;
   }
   
   public void insert(T param)
   {
      int hash = hash(param);
      arr[hash].addFirst(param);
   }
   
   public void delete(T param)
   {
      int hash = hash(param);
      arr[hash].remove(param);
   }
   
   public boolean find(T param)
   {
      int hash = hash(param);
      return arr[hash].contains(param);
   }
   
   public boolean isEmpty()
   {
      for(int i = 0; i < arr.length; i++)
      {
         if(arr[i].size() != 0)
         {
            return false;
         }
      }
      return true;
   }
   
   public void print()
   {
      for(int i = 0; i < arr.length; i++)
      {
         System.out.print("" + i + ":");
         for(int j = 0; j < arr[i].size(); j++)
         {
            System.out.print(" " + arr[i].get(j));
         }
         System.out.println();
      }
   }
   
   public void makeEmpty()
   {
      for(int i = 0; i < arr.length; i++)
      {
         arr[i].clear();
      }
   }
   
   public int size()
   {
      int combined = 0;
      for(int i = 0; i < arr.length; i++)
      {
         combined = combined + arr[i].size();
      }
      return combined;
   }
   
   private class Iter implements Iterator<T>
   {
      private int i;
      private int j;
      
      public Iter()
      {
         i = 0;
         while(i < arr.length && arr[i].size() <= 0)
         {
            i++;
         }
         j = 0;
      }
      
      public boolean hasNext()
      {
         return i != arr.length;
      }
      
      public T next()
      {
         T temp = arr[i].get(j);
         j++;
         if (j >= arr[i].size())
         {
            i++;
            j=0;
            while(i < arr.length && arr[i].size() <= 0)
            {
               i++;
            }
         }
         return temp;
      }
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   public Iter iterator()
   {
      return new Iter();
   }
}
