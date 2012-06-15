//Written by Tyler Holland (tyhollan)

public class Multiplier
{
   private char matrix[][];
   
   public void setMatrix(char[][] m, int n)
   {
      matrix = m;
   }
   
   public boolean parenthesize(String s)
   {
      String answer = new String("");
      answer = recursive(s);
      
      return answer.contains("a");
   }
   private String recursive(String s)
   {
      String result = new String("");
      if(s.length() == 1)
      {
         result += "" + s.charAt(0);
         return result;
      }
      else if(s.length() == 2)
      {
         result += "" + getval(s.charAt(0), s.charAt(1));
         return result;
      }
      else
      {
         char sub;
         for(int i = 0; i < s.length() - 1; i++)
         {
            String keep = new String("");
            if(i != 0)
            {
               if(i == 1)
               {
                  keep += "" + s.charAt(0);
               }
               else
               {
                  keep += "" + s.substring(0, i - 1);
               }
            }
            sub = getval(s.charAt(i), s.charAt(i+1));
            keep += "" + sub;
            if(i != s.length() - 2)
            {
               if(i+2 == s.length() - 1)
               {
                  keep += "" + s.charAt(i+2);
               }
               else
               {
                  keep += "" + s.substring(i+2, s.length());
               }
            }
            result += recursive(keep);
         }
      }
      return result;
   }
   
   private char getval(char one, char two)
   {
      return matrix[((int)one) - 97][((int)two) -97];
   }
   
   public void recover(String s)
   {
      if(this.parenthesize(s))
      {
         if(s.length() <= 2)
         {
            System.out.println("(" + s + ")");
         }
         else
         {
            System.out.println("Not yet implemented.");
         }
      }
      else
      {
         System.out.println("Result is false, unrecoverable");
      }
   }
}
