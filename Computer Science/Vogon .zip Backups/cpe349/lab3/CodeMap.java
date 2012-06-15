//Written by: Tyler Holland (tyhollan)

public class CodeMap
{
   public String[] codemap;
   
   public CodeMap()
   {
      codemap = new String[26];
      for(int i = 0; i < 26; i++)
      {
         codemap[i] = null;
      }
   }
   
   public void assignCode(char c, String code)
   {
      int aval = (int) 'a';
      int zval = (int) 'z';
      int theval = (int) c;
      if(theval >= aval)
      {
         if(theval <= zval)
         {
            codemap[theval - aval] = code;
         }
      }
   }
   
   public boolean isComplete()
   {
      for(int i = 0; i < 26; i++)
      {
         if(codemap[i] == null)
         {
            return false;
         }
      }
      return true;
   }
   
   public String convertChar(char c)
   {
      int aval = (int) 'a';
      int zval = (int) 'z';
      int theval = (int) c;
      if(theval >= aval)
      {
         if(theval <= zval)
         {
            return codemap[theval - aval];
         }
      }
      return "";
   }
   
   public String convertText(String s)
   {
      String temp = s.toLowerCase();
      String total = "";
      for(int i = 0; i < temp.length(); i++)
      {
         total = total.concat(convertChar(temp.charAt(i)));
      }
      return total;
   }
   
   public void print()
   {
      int aval = (int) 'a';
      
      System.out.println("Codemap:");
      for(int i = aval; i <  (aval + 26); i++)
      {
         //2 columns, 13 rows
         System.out.print((char) i + " = " + this.codemap[i - aval] + "   ");
         i++;
         System.out.println((char) i + " = " + this.codemap[i - aval]);
      }
   }
}
