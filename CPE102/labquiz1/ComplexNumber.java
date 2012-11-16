/**
 * @author Tyler Holland
 * @version Lab Quiz 1
 */

public class ComplexNumber
{
   //Instance Variables
   private double real;
   private double imag;
   
   //Constructors
   public ComplexNumber()
   {
      this.real = 0;
      this.imag = 0;
   }
  
   public ComplexNumber(double realIn, double im)
   {
      this.real = realIn;
      this.imag = im;
   }   
   
   //Methods
   public ComplexNumber add(ComplexNumber input)
   {
      ComplexNumber result = new ComplexNumber();
    
      result.real = this.real + input.real;
      result.imag = this.imag + input.imag;
      
      return result;
   }

   public ComplexNumber sub(ComplexNumber input)
   {
      ComplexNumber result = new ComplexNumber();
      
      result.real = this.real - input.real;
      result.imag = this.imag - input.imag;
      
      return result;
   }

   public ComplexNumber mul(ComplexNumber input)
   {
      ComplexNumber result = new ComplexNumber();

      result.real = ((this.real * input.real) - (this.imag * input.imag));
      result.imag = ((this.imag * input.real) + (this.real * input.imag));

      return result;
   }

   public ComplexNumber div(ComplexNumber input)
   {
      ComplexNumber result = new ComplexNumber();

      result.real = ((this.real * input.real) + (this.imag * input.imag));
      result.real = (result.real) / (Math.pow(input.real, 2) + Math.pow(input.imag, 2));

      result.imag = ((this.imag * input.real) - (this.real * input.imag));
      result.imag = (result.imag) / (Math.pow(input.real, 2) + Math.pow(input.imag, 2));
   
      return result;
   }

   public double getReal()
   {
      return this.real;
   }

   public double getImaginary()
   {
      return this.imag;
   }

   public String toString()
   {
      String result;

      if(this.real >= 0)
      {
         if(this.imag >= 0)
         {
            result = "(" + this.real + "+" + this.imag + "i)";
         }
         else
         {
            result = "(" + this.real + "" + this.imag + "i)";
         }
      }
      else
      {
         if(this.imag >= 0)
         {
            result = "(" + this.real + "+" + this.imag + "i)";
         }
         else
         {
            result = "(" + this.real + "" + this.imag + "i)";
         }
      }
      return result;
   }
}