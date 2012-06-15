//Written by Tyler Holland and Spencer Ellsworth
public class BinaryTree 
{
   BinaryNode<Integer> root;
   public int counter;
   
   public BinaryTree()
   {
      counter = 0;
      root = null;
   }
   
   public void initialize()
   {
       counter = 0;
       root = null;
   }
   
   public int insert(int value)
   {
      BinaryNode<Integer> temp = new BinaryNode<Integer>(value);
      
      if(root == null)
      {
         root = temp;
      }
      else
      {
         return (insertBinaryNode(root, temp));
      }
      return 0;
   }
   
   private int insertBinaryNode(BinaryNode<Integer> curr, BinaryNode<Integer> temp)
   {
      if(curr == null)
      {
         curr = new BinaryNode<Integer>(temp.nodeData);
         return 1;
      }
      else
      {
         if(temp.nodeData.compareTo(curr.nodeData) < 0)
         {
            this.counter++;
            if(curr.left == null)
            {
               curr.left = new BinaryNode<Integer>(temp.nodeData);
               return 1;
            }
            else
            {
               insertBinaryNode(curr.left, temp);
            }
            
         }
         else if(temp.nodeData.compareTo(curr.nodeData) > 0)
         {
            this.counter++;
            if(curr.right == null)
            {
               curr.right = new BinaryNode<Integer>(temp.nodeData);
               return 1;
            }
            else
            {
               insertBinaryNode(curr.right, temp);
            }
         }
         else
         {
            // Already exists
            return 0;
         }
      }
      return 0;
   }
   
   public int find(int value)
   {
      return search(root, value);
   }
   
   public int search(BinaryNode<Integer> curr, Integer target)
   {
      if (target.compareTo(curr.nodeData) == 0)
      {
         this.counter++;
         return 1;
      }
      else if(target.compareTo(curr.nodeData) > 0 && curr.right != null)
      {
         this.counter++;
         return search(curr.right, target);
      }
      else if(target.compareTo(curr.nodeData) < 0 && curr.left != null)
      {
         this.counter++;
         return search(curr.left, target);
      }
      else
      {
         return 0;
      }
   }
   
   public int delete(int value)
   {
      return remove(root, value);
   }
   
   public int remove(BinaryNode<Integer> curr, Integer target)
   {
      if(target.compareTo(curr.nodeData) == 0)
      {
         this.counter++;
         if(curr.left != null && curr.right != null) //Two children
         {
            curr.nodeData = findMin(curr.right).nodeData;
            remove (curr.right, curr.nodeData);
         }
         else
         {
            curr = (curr.left != null) ? curr.left : curr.right;
         }
         return 1;
      }
      else if(target.compareTo(curr.nodeData) > 0 && curr.right != null)
      {
         this.counter++;
         return remove(curr.right, target);
      }
      else if(target.compareTo(curr.nodeData) < 0 && curr.left != null)
      {
         this.counter++;
         return remove(curr.left, target);
      }
      else
      {
         return 0;
      }
   }
   
   public BinaryNode<Integer> findMin(BinaryNode<Integer> curr)
   {
      if(curr == null)
      {
         return null;
      }
      else if(curr.left == null)
      {
         return curr;
      }
      return findMin(curr.left);
   }
   
   public void sort(Integer[] A)
   {
      BinaryTree fun = new BinaryTree();
      for(int i = 0;i < A.length; i++)
      {
         fun.insert(A[i]);
      }
      this.counter = fun.counter;
      //traverse(fun.root); Don't need to print
   }
   
   /*public void traverse(BinaryNode<Integer> curr)
   {
      if(curr != null)
      {
         traverse(curr.left);
         System.out.println(curr.nodeData);
         traverse(curr.right);
      }
   }*/
   
   public int findMax(Integer[] array)
   {
      BinaryTree fun = new BinaryTree();
      for(int i = 0; i < array.length; i++)
      {
         fun.insert(array[i]);
      }
      this.counter = fun.counter;
      return (fun.findTheMax(fun.root));
   }
   
   public int findTheMax(BinaryNode<Integer> curr)
   {
      if(curr != null)
      {
         while(curr.right != null)
         {
            curr = curr.right;
         }
      }
      return curr.nodeData;
   }
   
   public int findSecondMax(Integer[] array)
   {
      BinaryTree fun = new BinaryTree();
      Integer tempData, tempData2;
      for(int i = 0;i < array.length; i++)
      {
         fun.insert(array[i]);
      }
      tempData = (fun.findTheMax(fun.root));
      fun.delete(tempData);
      tempData2 = (fun.findTheMax(fun.root));
      fun.insert(tempData);
      this.counter = fun.counter;
      return tempData2;
   }
   
   public int getCounter()
   {
      return this.counter;
   }
}
