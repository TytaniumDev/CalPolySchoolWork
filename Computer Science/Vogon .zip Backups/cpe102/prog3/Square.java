/**
 * A Square object that extends Rectangle
 *
 * @author Tyler Holland
 * @version Program 3
 * @version CPE102-5
 * @version Winter 2009
 */
import java.awt.*;

public class Square extends Rectangle
{
   //Constructor
   public Square(double size, java.awt.Point position, Color color, boolean filled)
   {
      super(size, size, position, color, filled);
   }
   
   //Methods
   /**
    * Sets the height of the Square.
    * This will also set the width of the Square, because
    * squares are even on all sides.
    *
    * @param height Height the square is being set to.
    */
   public void setHeight(double height)
   {
      super.setHeight(height);
      super.setWidth(height);
   }
   
   /**
    * Sets the width of the Square.
    * This will also set the height of the Square, because
    * squares are even on all sides.
    *
    * @param width Width the square is being set to.
    */
   public void setWidth(double width)
   {
      super.setWidth(width);
      super.setHeight(width);
   }
}
