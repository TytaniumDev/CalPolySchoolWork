import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Written by Tyler Holland (tyhollan)

public class ClassicsStudy
{
   public static void main(String args[]) throws IOException
   {
      File outFile = new File("Classicsoutput.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
      String[] names = new String[]{"Alice", "Grimm", "Gulliver", "Holmes", 
            "Pride","TomSawyer", "Ulysses"};
      
      File alice = new File("alice.txt");
      File grimm = new File("grimm.txt");
      File gulliver = new File("gulliver.txt");
      File holmes = new File("holmes.txt");
      File pride = new File("pride.txt");
      File tomsawyer = new File("tomsawyer.txt");
      File ulysses = new File("ulysses.txt");
      
      Scanner alices = new Scanner(alice);
      Scanner grimms = new Scanner(grimm);
      Scanner gullivers = new Scanner(gulliver);
      Scanner holmess = new Scanner(holmes);
      Scanner prides = new Scanner(pride);
      Scanner tomsawyers = new Scanner(tomsawyer);
      Scanner ulyssess = new Scanner(ulysses);
      
      HuffmanCode halice = new HuffmanCode("alice.txt");
      HuffmanCode hgrimm = new HuffmanCode("grimm.txt");
      HuffmanCode hgulliver = new HuffmanCode("gulliver.txt");
      HuffmanCode hholmes = new HuffmanCode("holmes.txt");
      HuffmanCode hpride = new HuffmanCode("pride.txt");
      HuffmanCode htomsawyer = new HuffmanCode("tomsawyer.txt");
      HuffmanCode hulysses = new HuffmanCode("ulysses.txt");
      
      CodeMap calice = halice.getHuffmanCodeMap();
      CodeMap cgrimm = hgrimm.getHuffmanCodeMap();
      CodeMap cgulliver = hgulliver.getHuffmanCodeMap();
      CodeMap cholmes = hholmes.getHuffmanCodeMap();
      CodeMap cpride = hpride.getHuffmanCodeMap();
      CodeMap ctomsawyer = htomsawyer.getHuffmanCodeMap();
      CodeMap culysses = hulysses.getHuffmanCodeMap();
      
      String salice = new String();
      String sgrimm = new String();
      String sgulliver = new String();
      String sholmes = new String();
      String spride = new String();
      String stomsawyer = new String();
      String sulysses = new String();
      
      String tempalice = "";
      String tempgrimm = "";
      String tempgulliver = "";
      String tempholmes = "";
      String temppride = "";
      String temptomsawyer = "";
      String tempulysses = "";
      
      while(alices.hasNext())
      {
         tempalice = tempalice.concat(alices.next());
      }
      while(grimms.hasNext())
      {
         tempgrimm = tempgrimm.concat(grimms.next());
      }
      while(gullivers.hasNext())
      {
         tempgulliver = tempgulliver.concat(gullivers.next());
      }
      while(holmess.hasNext())
      {
         tempholmes = tempholmes.concat(holmess.next());
      }
      while(prides.hasNext())
      {
         temppride = temppride.concat(prides.next());
      }
      while(tomsawyers.hasNext())
      {
         temptomsawyer = temptomsawyer.concat(tomsawyers.next());
      }
      while(ulyssess.hasNext())
      {
         tempulysses = tempulysses.concat(ulyssess.next());
      }
      
      salice = calice.convertText(tempalice);
      sgrimm = cgrimm.convertText(tempgrimm);
      sgulliver = cgulliver.convertText(tempgulliver);
      sholmes = cholmes.convertText(tempholmes);
      spride = cpride.convertText(temppride);
      stomsawyer = ctomsawyer.convertText(temptomsawyer);
      sulysses = culysses.convertText(tempulysses);
      
      Integer[] lengths = new Integer[7];
      lengths[0] = salice.length();
      lengths[1] = sgrimm.length();
      lengths[2] = sgulliver.length();
      lengths[3] = sholmes.length();
      lengths[4] = spride.length();
      lengths[5] = stomsawyer.length();
      lengths[6] = sulysses.length();
      
      Integer[] olengths = new Integer[7];
      olengths[0] = tempalice.length();
      olengths[1] = tempgrimm.length();
      olengths[2] = tempgulliver.length();
      olengths[3] = tempholmes.length();
      olengths[4] = temppride.length();
      olengths[5] = temptomsawyer.length();
      olengths[6] = tempulysses.length();

      writer.write("Author,Size,Length of Huffman,Reduction Ratio of Huffman,");
      writer.newLine();
      for(int k = 0; k<7; k++)
      {
         writer.write(names[k]);
         writer.write(",");
         writer.write("Full Size");
         writer.write(",");
         writer.write(lengths[k].toString());
         writer.write(",");
         writer.write(olengths[k].toString());
         writer.newLine();
      }
      writer.close();
      alices.close();
      grimms.close();
      gullivers.close();
      holmess.close();
      prides.close();
      tomsawyers.close();
      ulyssess.close();
   }
}
