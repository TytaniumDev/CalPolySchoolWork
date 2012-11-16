//Written by Tyler Holland (tyhollan)
public class TestMultiplier
{
   public static void main(String[] args)
   {
      char matrix[][] = new char[][]{{'b','b','a'},{'c','b','a'},{'a','c','c'}};
      Multiplier test = new Multiplier();
      String set[] = new String[]{
                                "a",
                                "ab",
                                "ca",
                                "cab",
                                "abc",
                                "cba",
                                "aabb",
                                "ccab",
                                "aabbcc",
                                "ababab",
                                "bababa",
                                "abcabcabc",
                                "cabbaccabbac",
                                "acacacacaabcb" //Was acacacacaabcd
                                };
      
      test.setMatrix(matrix, matrix.length);
      
      System.out.println("Parenthesize test:");
      for(int i = 0; i < set.length; i++)
      {
         if(test.parenthesize(set[i]))
         {
            System.out.println(set[i] + ": True");
         }
         else
         {
            System.out.println(set[i] + ": False");
         }
      }
      
      System.out.println("\nRecover test:");
      for(int i = 0; i < set.length; i++)
      {
         System.out.print(set[i] + ": ");
         test.recover(set[i]);
      }
   }
}
