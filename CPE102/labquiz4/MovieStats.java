/**
 * 
 * @author Tyler Holland
 * @version Lab Quiz 4
 *
 */

import java.util.Scanner;
import java.io.*;

public class MovieStats
{
   //Instance Variables
   private double totalGross = 0;
   private int bestDay;
   private double bestDayGross = 0;
   private String bestTheater;
   private double bestTheaterGross = 0;
   private String bestMovie;
   private double bestMovieGross = 0;
   private boolean DNE = false;
   private boolean empty = false;
   
   //Constructor
   public MovieStats(String filename)
   {
      reader(filename);
      writer(filename);
   }
   
   //Methods
   public void reader(String filename)
   {
      Scanner scan1 = null;
      
      File file = new File(filename);
      try
      {
         scan1 = new Scanner(file);
         if(!scan1.hasNextLine())
         {
            empty = true;
         }
         
         while(scan1.hasNextLine())
         {
            int tempDate = 0;
            String tempTheater = "";
            String tempMovie = "";
            double tempGross = 0;
            
            String temp = scan1.nextLine();
            Scanner scan2 = new Scanner(temp);
            scan2.useDelimiter("[" + "," + "]");
            
            if(scan2.hasNextInt())
            {
               tempDate = scan2.nextInt();
            }
            if(scan2.hasNext())
            {
               tempTheater = scan2.next();
            }
            if(scan2.hasNext())
            {
               tempMovie = scan2.next();
            }
            if(scan2.hasNextDouble())
            {
               tempGross = scan2.nextDouble();
            }
            totalGross = totalGross + tempGross;   
         }
      }
      catch (FileNotFoundException e)
      {
         DNE = true;
      }
   }
   
   public void writer(String filename)
   {
      File file = new File("movieStats.txt");
      file.setWritable(true);
      try
      {
         FileWriter writer = new FileWriter(file);
         if(DNE)
         {
            writer.write("Input file" + filename + "does not exist");
         }
         else if(empty)
         {
            writer.write("Input file" + filename + "is empty");
         }
         else
         {
            writer.write("Total gross of all days, theaters, and movies is $" + totalGross);
         }
         writer.close();
      }
      catch(IOException e)
      {
      }


   }
   
}
