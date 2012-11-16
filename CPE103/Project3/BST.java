/*
 * CPE 103 Section 07/08 - Project 3
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>>
{
   private class BSTNode //Node class
   {
      private T element;
      private BSTNode left;
      private BSTNode right;
   }
   
   private BSTNode root; //The top of the tree
   
   private class PreIter implements Iterator<T> //Pre-order iterator
   {
      private MyStack<BSTNode> stack;
      
      public PreIter() //Pre-order iterator constructor
      {
         stack = new MyStack<BSTNode>();
         if(root != null)
         {
            stack.push(root);
         }
      }
      /*
       * Checks to see if there is another value
       * @return true if there is another value, false otherwise
       * Precondition: stack exists
       * Postcondition: none
       */
      public boolean hasNext()
      {
         return !(stack.isEmpty());
      }

      /*
       * Returns the next value in the tree in pre-order
       * @return The next value in the tree
       * Precondition: stack exists
       * Postcondition: none
       */
      public T next()
      {
         if(stack.isEmpty())
         {
            throw new NoSuchElementException();
         }
         BSTNode temp = new BSTNode();
         
         temp = stack.pop();
         if(temp.right != null)
         {
            stack.push(temp.right);
         }
         if(temp.left != null)
         {
            stack.push(temp.left);
         }
         return temp.element;
      }

      /*
       * An unsupported operation
       * @throws UnsupportedOperationException()
       * Precondition: none
       * Postcondition: none
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   private class InIter implements Iterator<T>
   {
      private MyStack<BSTNode> stack;
      
      /*
       * Used to navigate down the left side of the tree for inorder traversal
       * @param root the root to travel down the left side of
       * Precondition: node has not been visited before, to avoid infinite loop
       * Postcondition: the left side of the root is in the stack
       */
      private void stackUpLefts(BSTNode root)
      {
         BSTNode currentNode = root;
         while(currentNode != null)
         {
            stack.push(currentNode);
            currentNode = currentNode.left;
         }
      }
      
      public InIter() //Constructor
      {
         stack = new MyStack<BSTNode>();
         if(root != null)
         {
            stackUpLefts(root);
         }
      }
      /*
       * Checks to see if there is another value
       * @return true if there is another value, false otherwise
       * Precondition: stack exists
       * Postcondition: none
       */
      public boolean hasNext()
      {
         return !(stack.isEmpty());
      }

      /*
       * Returns the next value in the tree in in-order
       * @return The next value in the tree
       * Precondition: stack exists
       * Postcondition: none
       */
      public T next()
      {
         if(stack.isEmpty())
         {
            throw new NoSuchElementException();
         }
         BSTNode temp = new BSTNode();
         
         temp = stack.pop();
         if(temp.right != null) //If temp has a right child
         {
            stackUpLefts(temp.right);
         }
         return temp.element;
      }

      /*
       * An unsupported operation
       * @throws UnsupportedOperationException()
       * Precondition: none
       * Postcondition: none
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   private class LevelIter implements Iterator<T>
   {
      private LQueue<BSTNode> queue;
      
      public LevelIter() //Constructor
      {
         queue = new LQueue<BSTNode>();
         if(root != null)
         {
            queue.enqueue(root);  
         }
      }
      /*
       * Checks to see if there is another value
       * @return true if there is another value, false otherwise
       * Precondition: queue exists
       * Postcondition: none
       */
      public boolean hasNext()
      {
         return !(queue.isEmpty());
      }

      /*
       * Returns the next value in the tree in level-order
       * @return The next value in the tree
       * Precondition: queue exists
       * Postcondition: none
       */
      public T next()
      {
         if(queue.isEmpty())
         {
            throw new NoSuchElementException();
         }
         BSTNode temp = new BSTNode();
         
         temp = queue.dequeue();
         if(temp.left != null)
         {
            queue.enqueue(temp.left);
         }
         if(temp.right != null)
         {
            queue.enqueue(temp.right);
         }
         return temp.element;
      }

      /*
       * An unsupported operation
       * @throws UnsupportedOperationException()
       * Precondition: none
       * Postcondition: none
       */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   public static class MyException extends RuntimeException
   {
      public MyException() //Constructor
      {
         super();
      }
      
      public MyException(String message) //Constructor
      {
         super(message);
      }
   }
   
   
   public BST() //Constructor
   {
      root = null;
   }
   
   /*
    * Adds an item into the tree
    * @param item the item to be added, of T type
    * Precondition: item is a valid T type object
    * Postcondition: The tree now contains the item
    */
   public void insert(T item)
   {
      root = insert(item, root);
   }
   
   // Linked to insert
   /*
    * A recursive method to assist insert(T item)
    * @param item the item to be inserted, of T type
    * @param treeroot A BSTNode of the root to be looked at
    * @return A BSTNode for use in recursive calls
    * Precondition: insert(T item) was invoked
    * Postcondition: The tree now contains the item
    */
   private BSTNode insert(T item, BSTNode treeroot)
   {
      if(treeroot == null)
      {
         treeroot = new BSTNode();
         treeroot.element = item;
      }
      else
      {
         if(item.compareTo(treeroot.element) < 0)
         {
            treeroot.left = insert(item, treeroot.left);
         }
         else
         {
            treeroot.right = insert(item, treeroot.right);
         }
      }
      return treeroot;
   }
   
   /*
    * Deletes a value from the tree
    * @param item Item to be deleted
    * Precondition: Item is a valid T type object
    * Postcondition: first instance of item is no longer in the tree
    */
   public void delete(T item)
   {
      root = delete (item, root);
   }
   /*
    * Helps delete(T item) delete a value from the tree
    * @param item Item to be deleted
    * @param treeroot the root for recursion
    * @return BSTNode for recursive calls
    * Precondition: delete(T item) was called, item is a valid T type object
    * Postcondition: first instance of item is no longer in the tree
    */
   //Linked to delete
   private BSTNode delete(T item, BSTNode treeroot)
   {
      if(treeroot != null)
      {
         if(item.compareTo(treeroot.element) < 0)
         {
            treeroot.left = delete(item, treeroot.left);
         }
         else if(item.compareTo(treeroot.element) > 0)
         {
            treeroot.right = delete(item, treeroot.right);
         }
         else if(item.equals(treeroot.element))
         {
            treeroot = deleteNode(treeroot);
         }
      }
      return treeroot;
   }
   /*
    * Helps the above delete method by ordering the tree while deleting
    * @param root Node to be deleted
    * @return BSTNode for recursive calls
    * Precondition: delete(T item, BSTNode treeroot) was called
    * Postcondition: first instance of item is no longer in the tree and the tree is ordered properly
    */
   //Linked to delete directly above
   private BSTNode deleteNode(BSTNode root)
   {
      BSTNode answer;
      if(root.left != null && root.right != null)
      {
         T nextValue = successor(root);
         root.element = nextValue;
         root.right = delete(nextValue, root.right);
         answer = root;
      }
      else
      {
         if(root.left != null)
         {
            answer = root.left;
         }
         else
         {
            if(root.right != null)
            {
               answer = root.right;
            }
            else
            {
               answer = null;
            }
         }
      }
      return answer;
   }
   //Linked to deleteNode
   /*
    * Helps deleteNode delete item properly
    * @param root BSTNode to find the successor of
    * @return the T type object that was root's successor
    * Precondition: root != null and root has a right child
    * Postcondition: none
    */
   private T successor(BSTNode root)
   {
      BSTNode temp = root.right;
      while(temp.left != null)
      {
         temp = temp.left;
      }
      return temp.element;
   }
   
   /*
    * Finds an item in the tree
    * @param item A T type item to be found
    * @return true if item was found, false otherwise
    * Precondition: item is a valid T type object
    * Postcondition: none
    */
   public boolean find(T item)
   {
      return find(item, root);
   }
   /*
    * Helps find through recursion
    * @param item A T type item to be found
    * @param root A BSTNode for recursion
    * @return true if item was found, false otherwise
    * Precondition: find(T item) was called
    * Postcondition: none
    */
   //Linked to find
   private boolean find(T item, BSTNode root)
   {
      boolean answer;
      if(root == null)
      {
         answer = false;
      }
      else
      {
         if(item.equals(root.element))
         {
            answer = true;
         }
         else
         {
            if(item.compareTo(root.element) < 0)
            {
               answer = find(item, root.left);
            }
            else
            {
               answer = find(item, root.right);
            }
         }
      }
      return answer;
   }
   
   /*
    * Returns if the tree is empty or not
    * @return true if the tree is empty, false if it isn't
    * Precondition: none
    * Postcondition: Emptiness of tree is now known
    */
   public boolean isEmpty()
   {
      return root == null;
   }
   
   /*
    * Makes the tree empty
    * Precondition: none
    * Postcondition: The tree is now empty and root = null
    */
   public void makeEmpty()
   {
      root = null;
   }
   
   /*
    * Returns the size of the tree
    * @return size of the tree as an int
    * Precondition: none
    * Postcondition: size of the tree is now known
    */
   public int size()
   {
       return size(root);
   }
   /*
    * Helps size work recursively
    * @param root A BSTNode for recursive calls
    * @return an int with the current size, used for recursion
    * Precondition: size() was called
    * Postcondition: size() can return the correct value
    */
   //Linked to size
   private int size(BSTNode root)
   {
      if(root == null)
      {
         return 0;
      }
      else
      {
         return (size(root.left) + 1 + size(root.right));
      }
   }
   
   /*
    * Finds the smallest element in the tree
    * @return T the smallest item
    * Precondition: the tree has a minimum element
    * Postcondition: the smallest element in the tree is now known
    */
   public T findMinimum()
   {
      if(root == null)
      {
         throw new MyException();
      }
      BSTNode temp = root;
      while(temp.left != null)
      {
         temp = temp.left;
      }
      return temp.element;
   }
   
   /*
    * finds the largest element in the tree
    * @return T the largest item
    * Precondition: the tree has a maximum element
    * Postcondition: the largest element in the tree is now known
    */
   public T findMaximum()
   {
      if(root == null)
      {
         throw new MyException();
      }
      BSTNode temp = root;
      while(temp.right != null)
      {
         temp = temp.right;
      }
      return temp.element;
   }
   
   /*
    * Returns a pre-order iterator
    * @return a pre-order iterator
    * Precondition: the private method PreIter() is correct
    * Postcondition: the iterator will traverse the tree in pre-order fashion
    */
   public Iterator<T> iteratorPre()
   {
      return new PreIter();
   }
   
   /*
    * Returns an in-order iterator
    * @return an in-order iterator
    * Precondition: the private method InIter() is correct
    * Postcondition: the iterator will traverse the tree in in-order fashion
    */
   public Iterator<T> iteratorIn()
   {
      return new InIter();
   }
   
   /*
    * Returns a level-order iterator
    * @return a level-order iterator
    * Precondition: the private method LevelIter() is correct
    * Postcondition: the iterator will traverse the tree in level-order fashion
    */
   public Iterator<T> iteratorLevel()
   {
      return new LevelIter();
   }
   
   /*
    * prints out the tree with tabs representing each level
    * Precondition: none
    * Postcondition: Prints the tree, with the root indented 0 tabs and its child indented 1 tab, etc
    */
   public void testPrint()
   {
      testPrint(root, 0);
   }
   //Linked to testPrint
   /*
    * Helps testPrint print using recursion
    * @param root A BSTNode for recursion
    * @param level an int for what level of children the method is on
    * Precondition: testPrint was called
    * Postcondition: prints the tree using recursion and tabs for spacing
    */
   private void testPrint(BSTNode root, int level)
   {
      if(root == null)
      {
         System.out.println();
      }
      else
      {
         for(int i = 0; i < level; i++)
         {
            System.out.print("\t");
         }
         System.out.println("" + root.element);
         if(root.left != null)
         {
            testPrint(root.left, level + 1);
         }
         if(root.right != null)
         {
            testPrint(root.right, level + 1);
         }
      }
   }
}
