import java.util.*;
public class HashTableSC<T>
{
   LinkedList<T>[] arr;
   
   public HashTableSC(int param)
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
}
