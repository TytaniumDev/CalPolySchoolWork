/**
 * Shape interface for area, color, filling, and moving
 *
 * @author Tyler Holland
 * @version Lab 5
 * @version CPE102-5
 * @version Winter 2009
 */

public interface Shape extends Drawable
{
   /**
    * Calculates and returns the area of the object.
    *
    * @return Returns the area of the shape as a double.
    */
   double getArea();

   /**
    * Returns the java.awt.Color of the object.
    *
    * @return Returns the color of the object.
    */
   java.awt.Color getColor();

   /**
    * Sets the java.awt.Color of the object.
    *
    * @param color The color the object is being set to.
    */
   void setColor(java.awt.Color color);

   /**
    * Checks if the object is filled with color.
    *
    * @return Returns true if the object is filled with color, otherwise false.
    */
   boolean getFilled();

   /**
    * Sets the filled state of the object.
    *
    * @param filled The filled state of the object.
    */
   void setFilled(boolean filled);

   /**
    * Moves the shape by the x and y amounts specified in the Point given.
    *
    * @param point Point the shape is to be moved to.
    */
   void move(java.awt.Point point);
}