public class MyAVL
{
   private class AVLNode
   {
      int element;
      int height;
      AVLNode left;
      AVLNode right;
   }
   
   private AVLNode root;
   
   public MyAVL()
   {
      root = null;
   }
   
   public void insert(int item)
   {
      root = insert(item,root);
   }
   
   //Methods for insert
   private int height(AVLNode x)
   {
      int answer;
      if(x != null)
      {
         answer = x.height;
      }
      else
      {
         answer = -1;
      }
      return answer;
   }
   
   private AVLNode rotateWithLeft(AVLNode x)
   {
      AVLNode y;
      y = x.left;
      x.left = y.right;
      y.right = x;
      x.height = Math.max(height(x.left), height(x.right)) + 1;
      y.height = Math.max(height(y.left), height(y.right)) + 1;
      return y;
   }
   
   private AVLNode rotateWithRight(AVLNode x)
   {
      AVLNode y;
      y = x.right;
      x.right = y.left;
      y.left = x;
      x.height = Math.max(height(x.left), height(x.right)) + 1;
      y.height = Math.max(height(y.left), height(y.right)) + 1;
      return y;
   }
   
   private AVLNode doubleLeftRight(AVLNode x)
   {
      x.left = rotateWithRight(x.left);
      return rotateWithLeft(x);
   }
   
   private AVLNode doubleRightLeft(AVLNode x)
   {
      x.right = rotateWithLeft(x.right);
      return rotateWithRight(x);
   }
   
   private AVLNode insert(int item, AVLNode treeroot)
   {
      if(treeroot == null)
      {
         treeroot = new AVLNode();
         treeroot.element = item;
      }
      else
      {
         if(item < treeroot.element)
         {
            treeroot.left = insert(item, treeroot.left);
            if(treeroot.left.height - height(treeroot.right) == 2)
            {
               if(item < treeroot.left.element)
               {
                  treeroot = rotateWithLeft(treeroot);
               }
               else
               {
                  treeroot = doubleLeftRight(treeroot);
               }
            }
         }
         else if(item > treeroot.element)
         {
            treeroot.right = insert(item, treeroot.right);
            if(treeroot.right.height - height(treeroot.left) == 2)
            {
               if(item >= treeroot.right.element)
               {
                  treeroot = rotateWithRight(treeroot);
               }
               else
               {
                  treeroot = doubleRightLeft(treeroot);
               }
            }
         }
      }
      treeroot.height = Math.max(height(treeroot.left), height(treeroot.right)) + 1;
      return treeroot;
   }
   
   public void print()
   {
       print(root, 0);
   }
   
   private void print(AVLNode index, int level)
   {
       if(index != null)
       {
           for(int i = 0; i < level; i++)
           {
               System.out.print("\t");
           }
           System.out.println("" + index.element);
           print(index.left, level+1);
           print(index.right, level+1);
       }
   }
   
   public int countOdds()
   {
      return countOdds(root);
   }
   
   private int countOdds(AVLNode node)
   {
      if(node == null)
      {
         return 0;
      }
      if(node.element % 2 == 0)
      {
         return countOdds(node.left) + countOdds(node.right);
      }
      return 1 + countOdds(node.left) + countOdds(node.right);
   }
   
   public int sum()
   {
      return sum(root);
   }
   
   private int sum(AVLNode node)
   {
      if(node == null)
      {
         return 0;
      }
      return node.element + sum(node.left) + sum(node.right);
   }
   
   public int countLeaves()
   {
      return countLeaves(root);
   }
   
   private int countLeaves(AVLNode node)
   {
      if(node == null)
      {
         return 0;
      }
      if(node.left == null && node.right == null)
      {
         return 1;
      }
      return countLeaves(node.left) + countLeaves(node.right);
   }
   
   public int countOneChildParents()
   {
      return countOneChildParents(root);
   }
   
   private int countOneChildParents(AVLNode node)
   {
      if(node == null)
      {
         return 0;
      }
      if(node.left == null && node.right != null)
      {
         return 1 + countOneChildParents(node.right);
      }
      if(node.left != null && node.right == null)
      {
         return 1 + countOneChildParents(node.left);
      }
      return countOneChildParents(node.left) + countOneChildParents(node.right);
   }
}
