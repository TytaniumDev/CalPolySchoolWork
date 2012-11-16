/**
 * Basic Greeter program
 *
 * @author Tyler Holland
 * @version Lab 1
 * @version CPE102-5
 * @version Spring 2008
 */
 
class Greeter
{
   private String name;

   public Greeter(String name)
   {
	   this.name = name;
   }

	public String greet()
   {
	   return "Hello " + name;
   }
}