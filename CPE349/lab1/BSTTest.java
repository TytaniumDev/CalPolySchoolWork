//Written by Tyler Holland and Spencer Ellsworth
import java.io.*;
import java.util.*;

public class BSTTest 
{
   public static void main(String args[]) throws NumberFormatException, IOException
   {
      File file = new File(args[0]);
      File file2 = new File(args[1]);
      String temp = new String();
      String result = new String();
      Scanner scan = new Scanner(file2).useDelimiter(";\n");
      BinaryTree tree = new BinaryTree();
      
      BufferedReader bufRdr = new BufferedReader(new FileReader(file));
      String line = null;
      
      //read in lines
      while((line = bufRdr.readLine()) != null)
      {
         StringTokenizer st = new StringTokenizer(line, ", ");
         while (st.hasMoreTokens())
         {
            tree.insert(Integer.parseInt(st.nextToken()));
         }
      }
      
      while(scan.hasNext())
      {
         temp = scan.next();
         if(temp.contains("find"))
         {
            result = temp.substring(5, (temp.length() - 1));
            if(tree.find(Integer.parseInt(result)) == 1)
            {
               System.out.println(temp + ": success;");
            }
            else
            {
               System.out.println(temp + ": not found;");
            }  
         }
         else if(temp.contains("insert"))
         {
            result = temp.substring(7, (temp.length() - 1));
            if(tree.insert(Integer.parseInt(result)) == 1)
            {
               System.out.println(temp + ": success;");
            }
            else
            {
               System.out.println(temp + ": not found;");
            }  
         }
         else if(temp.contains("delete"))
         {
            result = temp.substring(7, (temp.length() - 1));
            if(tree.delete(Integer.parseInt(result)) == 1)
            {
               System.out.println(temp + ": success;");
            }
            else
            {
               System.out.println(temp + ": not found;");
            }  
         }
      }
   }
}
