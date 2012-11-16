public class testdriver
{
   public static void main(String args[])
   {
   //Make new number
   ComplexNumber test = new ComplexNumber();
   ComplexNumber testW = new ComplexNumber(10, 25);
   ComplexNumber result = new ComplexNumber();

   result = test.add(testW);
   System.out.println(result.toString());

   result = test.sub(testW);
   System.out.println(result.toString());


   result = test.mul(testW);
   System.out.println(result.toString());


   result = test.div(testW);
   System.out.println(result.toString());

   System.out.println(testW.getReal());

   System.out.println(testW.getImaginary());

// MORE
   System.out.println( );
   System.out.println( );
   System.out.println( );

   ComplexNumber testA = new ComplexNumber(100, 250);
   ComplexNumber testAW = new ComplexNumber(10, 25);
   ComplexNumber resultA = new ComplexNumber();

   resultA = testA.add(testAW);
   System.out.println(resultA.toString());

   resultA = testA.sub(testAW);
   System.out.println(resultA.toString());


   resultA = testA.mul(testAW);
   System.out.println(resultA.toString());


   resultA = testA.div(testAW);
   System.out.println(resultA.toString());

   System.out.println(testA.getReal());

   System.out.println(testA.getImaginary());
   }
}