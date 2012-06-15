//Written by Tyler Holland and Spencer Ellsworth
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaxValidate
{
   public static void main(String args[]) throws NumberFormatException, IOException
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      Integer[] array = null;
      File file = new File(args[0]);
      Finds thing = new Finds();
      
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
      
      System.out.println("Max Value is: " + thing.findMax(array.length, array));
      System.out.println("# of comparisons: " + thing.counter);
      thing = new Finds();
      System.out.println("Second Max Value is: " + thing.findSecondMax(array.length, array));
      System.out.println("# of comparisons: " + thing.counter);
   }
}
