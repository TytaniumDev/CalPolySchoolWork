import java.util.Scanner;

/**
 * A Book on Tape Class that uses AbstractBook to store extra info on books on tape.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */
public class BookOnTape extends AbstractBook
{
   //Instance Variables
   public static int TAPE = 1;
   public static int CD = 2;
   public static int DVD = 3;
   private Name reader;
   private int length;
   private int format;
   
   //Constructors
   public BookOnTape()
   {
      super();
      this.reader = new Name();
      this.length = 0;
      this.format = 1;
   }

   public BookOnTape(int productID)
   {
      super(productID);
      this.reader = new Name();
      this.length = 0;
      this.format = 1;
   }
   //Methods
   public Name getReader()
   {
      return reader;
   }
   public void setReader(Name reader)
   {
      this.reader = reader;
   }
   public int getLength()
   {
      return length;
   }
   public void setLength(int length)
   {
      this.length = length;
   }
   public int getFormat()
   {
      return format;
   }
   public void setFormat(int format)
   {
      this.format = format;
   }
   public boolean equals(Object other)
   {
      if(!super.equals(other))
      {
         return false;
      }
      if(!(((BookOnTape)other).reader.getFirst() == null || 
          this.reader.getFirst().equals(((BookOnTape)other).reader.getFirst())))
      {
         return false;
      }
      if(!(((BookOnTape)other).reader.getMiddle() == null ||
         this.reader.getMiddle().equals(((BookOnTape)other).reader.getMiddle())))
      {
         return false;
      }
      if(!(((BookOnTape)other).reader.getLast() == null ||
         this.reader.getLast().equals(((BookOnTape)other).reader.getLast())))
      {
         return false;
      }
      if(this.length != ((BookOnTape)other).length)
      {
         return false;
      }
      if(this.format != ((BookOnTape)other).format)
      {
         return false;
      }
      return true;
   }
   
   public void toObject(Scanner scan2)
   {
      super.toObject(scan2);
      this.reader.toObject(scan2);
      this.length = Integer.parseInt(scan2.next().trim());
      this.format = Integer.parseInt(scan2.next().trim());
   }
   
   public String toText(char delimiter)
   {
      String result = new String();
      result = super.toText(delimiter);
      
      result = result.concat(reader.toText(delimiter) + " " + delimiter + " ");
      result = result.concat("" + length + " " + delimiter + " ");
      result = result.concat("" + format + " " + delimiter);

      return result;
   }
}
