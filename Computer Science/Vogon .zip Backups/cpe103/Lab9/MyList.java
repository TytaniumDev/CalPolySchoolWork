
public class MyList
{
   private Node head;
   
   private class Node
   {
      public int element;
      public Node next;
      
      public Node(int thing)
      {
         element = thing;
         next = null;
      }
   }
   
   public MyList()
   {
      head = null;
   }
   
   public void add(int element)
   {
      Node temp = new Node(element);
      if(head != null)
      {
         temp.next = head;
      }
      head = temp;
   }
   
   public boolean find(int item)
   {
      return find(item, head);
   }
   private boolean find(int item, Node here)
   {
      if(here == null)
      {
         return false;
      }
      if(item == here.element)
      {
         return true;
      }
      return find(item, here.next);
   }
   
   public void print()
   {
      print(head);
      System.out.println();
   }
   private void print(Node here)
   {
      if(here != null)
      {
         print(here.next);
         System.out.print(here.element + " ");
      }
   }
   
   public int sum()
   {
      return sum(head);
   }
   private int sum(Node here)
   {
      if(here != null)
      {
         return here.element + sum(here.next);
      }
      return 0;
   }
}
