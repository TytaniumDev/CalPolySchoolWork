/**
 * A Canvas object to control the Shapes
 *
 * @author Tyler Holland
 * @version Lab 5
 * @version CPE102-5
 * @version Winter 2009
 */
import java.util.ArrayList;

public class Canvas implements Drawable
{
   //Instance variables
   private ArrayList<Shape> array = new ArrayList<Shape>();

   //Constructors
   public Canvas()
   {
   }
   //Methods
   public void add(Shape shape)
   {
      this.array.add(shape);
   }

   public Shape remove(int index)
   {
      return this.array.remove(index);
   }

   public Shape get(int index)
   {
      return this.array.get(index);
   }

   public int size()
   {
      return this.array.size();
   }

   public ArrayList<Circle> getCircles()
   {
      ArrayList<Circle> result = new ArrayList<Circle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Circle)
         {
            result.add((Circle)array.get(i));
         }
      }

      return result;
   }

   public ArrayList<Rectangle> getRectangles()
   {
      ArrayList<Rectangle> result = new ArrayList<Rectangle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Rectangle)
         {
            result.add((Rectangle)array.get(i));
         }
      }

      return result;
   }

   public ArrayList<Triangle> getTriangles()
   {
      ArrayList<Triangle> result = new ArrayList<Triangle>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof Triangle)
         {
            result.add((Triangle)array.get(i));
         }
      }

      return result;
   }

   public ArrayList<ConvexPolygon> getConvexPolygons()
   {
      ArrayList<ConvexPolygon> result = new ArrayList<ConvexPolygon>();

      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i) instanceof ConvexPolygon)
         {
            result.add((ConvexPolygon)array.get(i));
         }
      }

      return result;
   }

   public ArrayList<Shape> getShapesByColor(java.awt.Color color)
   {
      ArrayList<Shape> result = new ArrayList<Shape>();
      Shape temp;

      for(int i = 0; i < array.size(); i++)
      {
         temp = array.get(i);
         if(temp.getColor() == color)
         {
            result.add(array.get(i));
         }
      }

      return result;
   }

   public double getAreaOfAllShapes()
   {
      double result = 0;
      Shape temp;

      for(int i = 0; i < array.size(); i++)
      {
         temp = array.get(i);
         result = result + temp.getArea();
      }

      return result;
   }
   
   //Method from interface
   public void draw(java.awt.Graphics graphic)
   {
      for(int i = 0; i < array.size(); i++)
      {
         array.get(i).draw(graphic);
      }
   }
}