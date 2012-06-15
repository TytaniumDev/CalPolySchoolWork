//Written by Tyler Holland (tyhollan)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HuffmanCode
{
   private class HuffmanNode implements Comparable<HuffmanNode>
   {
      public int freq;
      public HuffmanNode right;
      public HuffmanNode left;
      public char letter;
      public String code;
      public HuffmanNode(int frequency)
      {
         freq = frequency;
         right = null;
         left = null;
         letter = ' ';
      }
      
      public void setLetter(char name)
      {
         letter = name;
      }
      public void setLeft(HuffmanNode node)
      {
         left = node;
      }
      public void setRight(HuffmanNode node)
      {
         right = node;
      }

      @Override
      public int compareTo(HuffmanNode arg0)
      {
         if(this.freq == -64)
         {
            return 1;
         }
         if(arg0.freq == -64)
         {
            return -1; //For this implementation, push already sorted to the top
         }
         if(this.freq == arg0.freq)
         {
            return 0;
         }
         else if(this.freq < arg0.freq)
         {
            return -1;
         }
         else
         {
            return 1;
         }
      }
   }
   public int[] freq = new int[26];
   CodeMap codemap;
   
   public HuffmanCode(String filename) throws FileNotFoundException
   {
      for(int i = 0; i < 26; i++)
      {
         freq[i] = 0;
      }
      codemap = new CodeMap();
      File infile = new File(filename);
      Scanner scan = new Scanner(infile);
      String temp = null;
      int aval = (int) 'a';
      int zval = (int) 'z';
      int theval = -1;
      while(scan.hasNext())
      {
         temp = scan.next();
         temp = temp.toLowerCase();
         for(int i = 0; i < temp.length(); i++)
         {
            theval = (int) temp.charAt(i);
            if(theval >= aval)
            {
               if(theval <= zval)
               {
                  freq[theval - aval]++;
               }
            }
         }
      }
      scan.close();
   }
   
   public HuffmanCode(String text, int set) //set does nothing
   {
      for(int i = 0; i < 26; i++)
      {
         freq[i] = 0;
      }
      codemap = new CodeMap();
      Scanner scan = new Scanner(text);
      String temp = null;
      int aval = (int) 'a';
      int zval = (int) 'z';
      int theval = -1;
      while(scan.hasNext())
      {
         temp = scan.next();
         temp = temp.toLowerCase();
         for(int i = 0; i < temp.length(); i++)
         {
            theval = (int) temp.charAt(i);
            if(theval >= aval)
            {
               if(theval <= zval)
               {
                  freq[theval - aval]++;
               }
            }
         }
      }
      scan.close();
   }
   
   public CodeMap getHuffmanCodeMap()
   {
      HuffmanNode[] array = new HuffmanNode[26];
      HuffmanNode tempnode = null;
      int aval = (int) 'a';
      for(int i = 0; i < 26; i++)
      {
         array[i] = new HuffmanNode(freq[i]);
         array[i].setLetter((char)(aval + i));
      }
      Arrays.sort(array); //array is in ascending order based on frequency
      while(array[1].freq != -64) //Want to get down to one node in array
      {
         tempnode = new HuffmanNode((array[0].freq + array[1].freq));
         tempnode.setLeft(array[0]);
         tempnode.setRight(array[1]);
         array[0] = tempnode;
         array[1].freq = -64;
         Arrays.sort(array);
      }
      CodeMap map = new CodeMap();
      return getCode(array[0], "", map);
   }
   
   private CodeMap getCode(HuffmanNode node, String code, CodeMap map)
   {
      node.code = code;
      String temp;
      if(node.left != null)
      {
         //Put in a 0
         temp = code.concat("0");
         getCode(node.left, temp, map);
      }
      if(node.right != null)
      {
         //Put in a 1
         temp = code.concat("1");
         getCode(node.right, temp, map);
      }
      if(node.right == null && node.left == null)
      {
         //Create the CodeMap
         map.assignCode(node.letter, node.code);
      }
      return map; //Shouldn't happen
   }
}
