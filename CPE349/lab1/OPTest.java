//Written by Tyler Holland and Spencer Ellsworth
import java.io.*;
import java.util.*;

public class OPTest
{
   public static void main(String args[]) throws NumberFormatException, IOException
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      Integer[] array = null;
      File file = new File(args[0]);
      BinaryTree tree = new BinaryTree();
      
      BufferedReader bufRdr = new BufferedReader(new FileReader(file));
      String line = null;
      
      //read in lines
      while((line = bufRdr.readLine()) != null)
      {
         StringTokenizer st = new StringTokenizer(line, ", ");
         while (st.hasMoreTokens())
         {
            list.add(Integer.parseInt(st.nextToken()));
         }
      }
      
      array = list.toArray(new Integer[]{});
      
      tree.sort(array);
      tree.findMax(array);
      tree.findSecondMax(array);
   }
}
