/**
 * Driver for Fraction Program
 *
 * @author Tyler Holland
 * @version Program 1
 * @version CPE102-5
 * @version Spring 2008
 */

class DriverTest
{
   public static void main(String[] args)
   {
      Fraction zero = new Fraction();
      System.out.println("" + zero);

      Fraction top = new Fraction(1);
      System.out.println("" + top);

      Fraction both = new Fraction(1,2);

      String bothString = both.toString();
      System.out.println(bothString);

      Fraction added = top.add(both);
      System.out.println(added);

      Fraction subbed = top.sub(both);
      System.out.println(subbed);

      Fraction multed = top.mul(both);
      System.out.println(multed);

      Fraction divd = top.div(both);
      System.out.println(divd);

      double ninetho = both.value();
      System.out.println(ninetho);
   }
}