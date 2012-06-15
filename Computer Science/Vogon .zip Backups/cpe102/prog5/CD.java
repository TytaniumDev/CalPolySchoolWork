import java.util.Scanner;

/**
 * A CD Class that uses Product to store extra info about CDs.
 *
 * @author Tyler Holland
 * @version Program 5
 * @version CPE102-5
 * @version Winter 2009
 */

public class CD extends Product
{
   //Instance Variables
   private String title = new String();
   private Name artist;
   
   //Constructors
   public CD()
   {
      super();
      this.artist = new Name();
      this.title = "";
   }

   public CD(int productID)
   {
      super(productID);
      this.artist = new Name();
      this.title = "";
   }
   
   //Methods
   public String getTitle()
   {
      return title;
   }
   public void setTitle(String title)
   {
      if(title == null)
      {
         this.title = "";
      }
      else
      {
         this.title = new String(title);
      }
   }
   public Name getArtist()
   {
      return artist;
   }
   public void setArtist(Name artist)
   {
      this.artist = artist;
   }
   public boolean equals(Object other)
   {
      if(other == null)
      {
         return false;
      }
      if(!super.equals(other))
      {
         return false;
      }
      if(!this.title.equals(((CD)other).title))
      {
         return false;
      }
      if(!this.artist.getFirst().equals(((CD)other).artist.getFirst()))
      {
         return false;
      }
      if(!this.artist.getMiddle().equals(((CD)other).artist.getMiddle()))
      {
         return false;
      }
      if(!this.artist.getLast().equals(((CD)other).artist.getLast()))
      {
         return false;
      }
   return true;
   }
   
   public void toObject(Scanner scan2)
   {
      super.toObject(scan2);
      this.title = scan2.next().trim();
      this.artist.toObject(scan2);
   }
   
   public String toText(char delimiter)
   {
      String result = new String();
      result = super.toText(delimiter);
      
      result = result.concat("" + title + " " + delimiter + " ");
      result = result.concat(artist.toText(delimiter) + " " + delimiter);

      return result;
   }
}
