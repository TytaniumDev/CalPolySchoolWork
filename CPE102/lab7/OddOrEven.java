
public class OddOrEven
{
   private int value;

   public OddOrEven(int input)
   {
      value = input;
   }

   public String oddOrEven()
   {
      if (value % 2 == 0)
      {
         return "EVEN";
      }
      else
      {
         return "ODD";
      }
   }
}