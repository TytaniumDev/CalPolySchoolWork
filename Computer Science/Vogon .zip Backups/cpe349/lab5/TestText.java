//Written by Tyler Holland and Spencer Ellsworth
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TestText
{
   public static void main(String[] args) throws FileNotFoundException
   {
      File infile1 = null;
      File infile2 = null;
      Scanner scan1 = null;
      Scanner scan2 = null;
      if(args.length >= 1)
      {
         //One file
         infile1 = new File(args[0]);
         scan1 = new Scanner(infile1);
         
      }
      if(args.length == 2)
      {
         //Text and dictionary files
         infile2 = new File(args[1]);
         scan2 = new Scanner(infile2);
      }
      
      String[] dict = new String[]{"i", "item", "am", "sam", "ma", "red",
                      "dare", "rare", "re", "in", "into", "to", "a", "the",
                      "main", "and", "an"};
      
      String[] input = new String[]
                       //True
                      {"samiam", "iamsam", "iamiamiam", "maiamsam",
                       "iteminred", "themainitemandtherarereddare",
                       "itemandtheraredare", "maintothered", "redare",
                       "reddare", "rareanddare", "redandrareinmain",
                       "themaindare",
                       //False
                       "aandb","intotooandthe","themainsambutnotthelastone",
                       "stop", "iamtired", "redraredareinannitem"};
      
      int counter = 1;
      //Figure out which file is which
      String temp = new String();
      if(scan1 != null)
      {
         temp = scan1.next();
         if(scan1.hasNext())
         {
            //Dictionary file
            dict = new String[(int) infile1.length()];
            dict[0] = temp;
            while(scan1.hasNext())
            {
               dict[counter] = scan1.next();
               counter++;
            }
            String[] temp2 = new String[counter];
            for(int i = 0; i < temp2.length; i++)
            {
               temp2[i] = dict[i];
            }
            dict = temp2;
         }
         else
         {
            //Text input
            input = new String[1];
            input[0] = temp;
         }
      }
      counter = 1;
      if(scan2 != null)
      {
         temp = scan2.next();
         if(scan2.hasNext())
         {
            //Dictionary file
            dict = new String[(int) infile2.length()];
            dict[0] = temp;
            while(scan2.hasNext())
            {
               dict[counter] = scan2.next();
               counter++;
            }
            String[] temp2 = new String[counter];
            for(int i = 0; i < temp2.length; i++)
            {
               temp2[i] = dict[i];
            }
            dict = temp2;
         }
         else
         {
            //Text input
            input = new String[1];
            input[0] = temp;
         }
      }
      
      
      TextChecker thing = new TextChecker();
      thing.setDictionary(dict);
      
      for(int i = 0; i < input.length; i++)
      {
         System.out.print(input[i] + ": ");
         thing.setString(input[i]);
         if(thing.isText() == true)
         {
            thing.split();
            System.out.println("True");
         }
         else
         {
            System.out.println("False");
         }
      }
   }
}