//Written by Tyler Holland and Spencer Ellsworth
import java.util.ArrayList;
public class TextChecker
{
   String text;
   String[] dictionary;
   String lastWord;
   
   public TextChecker()
   {
      text = null;
      dictionary = null;
   }
   
   public boolean dict(int i, int j)
   {
      lastWord = new String("");
      for(int k = i; k <= j; k++)
      {
         lastWord += text.charAt(k);
      }
      for(int l = 0; l < dictionary.length; l++)
      {
         if(lastWord.compareTo(dictionary[l]) == 0)
         {
            return true;
         }
      }
      return false;
   }
   
   public void setDictionary(String[] dict)
   {
      dictionary = dict;
   }
   
   public void setString(String s)
   {
      text = s;
   }
   
   public boolean isText()
   {
      ArrayList<Integer> start = new ArrayList<Integer>(0);
      ArrayList<Integer> end = new ArrayList<Integer>(0);
      Integer[] startf = new Integer[0];
      Integer[] endf = new Integer[0];
      
      int counter = 0;
      for(int i = 0; i < text.length(); i++)
      {
         for(int j = i; j < text.length(); j++)
         {
            if(dict(i,j))
            {
               start.add(counter, i);
               end.add(counter, j);
               counter++;
            }
         }
      }
      //Modified Scheduling Algorithm 
      //Sort jobs by finish times
      startf = (Integer[]) start.toArray(startf);
      endf = (Integer[]) end.toArray(endf);
      //Bubble sort end times
      int temp, count, index;
      for(count = 0; count < endf.length-1; count++)
      {
         for(index = 0; index < endf.length-1-count; index++)
         {
            if(endf[index] > endf[index+1])
            {
               temp = endf[index];
               endf[index] = endf[index+1];
               endf[index+1] = temp;
               temp = startf[index];
               startf[index] = startf[index+1];
               startf[index+1] = temp;
            }
         }
      }
      
      return TestIt(startf, endf, 0);
   }
   
   public boolean TestIt(Integer[] start, Integer[] end, int i)
   {
      if(i == 0)
      {
         for(int j = 0; j < start.length; j++)
         {
            if(start[j] == 0)
            {
               if(TestIt(start, end, end[j] + 1))
               {
                  return true;
               }
            }
         }
         return false;
      }
      else if(i == text.length())
      {
         return true;
      }
      else
      {
         for(int j = 0; j < start.length; j++)
         {
            if(start[j] == i)
            {
               if(TestIt(start,end,end[j] + 1))
               {
                  return true;
               }
            }
         }
         return false;
      }
   }
   
   public void split()
   {
      for(int i = 0; i < text.length(); i++)
      {
         for(int j = i; j < text.length(); j++)
         {
            if(this.dict(i, j) == true)
            {
               System.out.println(lastWord);
            }
         }
      }
   }
}
