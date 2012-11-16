import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Written by Tyler Holland (tyhollan)

public class RandomStudy
{
   public static void main(String args[]) throws IOException
   {
      
      File outFile = new File("Randomoutput.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
      Integer[] numbers = new Integer[]{128,256,512,1024,2048,3000,4096,5000,
            7000,8192};
      Integer[] numbers2 = new Integer[10];
      for(int i = 0; i < 10; i++)
      {
         numbers2[i] = numbers[i] * 16;
      }
      
      RandomText[] s128 = new RandomText[32];
      RandomText[] s256 = new RandomText[32];
      RandomText[] s512 = new RandomText[32];
      RandomText[] s1024 = new RandomText[32];
      RandomText[] s2048 = new RandomText[32];
      RandomText[] s3000 = new RandomText[32];
      RandomText[] s4096 = new RandomText[32];
      RandomText[] s5000 = new RandomText[32];
      RandomText[] s7000 = new RandomText[32];
      RandomText[] s8192 = new RandomText[32];
      
      for(int i = 0; i < 32; i++)
      {
         s128[i] = new RandomText(128);
         s256[i] = new RandomText(256);
         s512[i] = new RandomText(512);
         s1024[i] = new RandomText(1024);
         s2048[i] = new RandomText(2048);
         s3000[i] = new RandomText(3000);
         s4096[i] = new RandomText(4096);
         s5000[i] = new RandomText(5000);
         s7000[i] = new RandomText(7000);
         s8192[i] = new RandomText(8192);
      }
      
      HuffmanCode[] h128 = new HuffmanCode[32];
      HuffmanCode[] h256 = new HuffmanCode[32];
      HuffmanCode[] h512 = new HuffmanCode[32];
      HuffmanCode[] h1024 = new HuffmanCode[32];
      HuffmanCode[] h2048 = new HuffmanCode[32];
      HuffmanCode[] h3000 = new HuffmanCode[32];
      HuffmanCode[] h4096 = new HuffmanCode[32];
      HuffmanCode[] h5000 = new HuffmanCode[32];
      HuffmanCode[] h7000 = new HuffmanCode[32];
      HuffmanCode[] h8192 = new HuffmanCode[32];
      
      for(int i = 0; i < 32; i++)
      {
         h128[i] = new HuffmanCode(s128[i].text, 0);
         h256[i] = new HuffmanCode(s256[i].text, 0);
         h512[i] = new HuffmanCode(s512[i].text, 0);
         h1024[i] = new HuffmanCode(s1024[i].text, 0);
         h2048[i] = new HuffmanCode(s2048[i].text, 0);
         h3000[i] = new HuffmanCode(s3000[i].text, 0);
         h4096[i] = new HuffmanCode(s4096[i].text, 0);
         h5000[i] = new HuffmanCode(s5000[i].text, 0);
         h7000[i] = new HuffmanCode(s7000[i].text, 0);
         h8192[i] = new HuffmanCode(s8192[i].text, 0);
      }
      
      CodeMap[] c128 = new CodeMap[32];
      CodeMap[] c256 = new CodeMap[32];
      CodeMap[] c512 = new CodeMap[32];
      CodeMap[] c1024 = new CodeMap[32];
      CodeMap[] c2048 = new CodeMap[32];
      CodeMap[] c3000 = new CodeMap[32];
      CodeMap[] c4096 = new CodeMap[32];
      CodeMap[] c5000 = new CodeMap[32];
      CodeMap[] c7000 = new CodeMap[32];
      CodeMap[] c8192 = new CodeMap[32];
      
      for(int i = 0; i < 32; i++)
      {
         c128[i] = h128[i].getHuffmanCodeMap();
         c256[i] = h256[i].getHuffmanCodeMap();
         c512[i] = h512[i].getHuffmanCodeMap();
         c1024[i] = h1024[i].getHuffmanCodeMap();
         c2048[i] = h2048[i].getHuffmanCodeMap();
         c3000[i] = h3000[i].getHuffmanCodeMap();
         c4096[i] = h4096[i].getHuffmanCodeMap();
         c5000[i] = h5000[i].getHuffmanCodeMap();
         c7000[i] = h7000[i].getHuffmanCodeMap();
         c8192[i] = h8192[i].getHuffmanCodeMap();
      }
      
      String[] t128 = new String[32];
      String[] t256 = new String[32];
      String[] t512 = new String[32];
      String[] t1024 = new String[32];
      String[] t2048 = new String[32];
      String[] t3000 = new String[32];
      String[] t4096 = new String[32];
      String[] t5000 = new String[32];
      String[] t7000 = new String[32];
      String[] t8192 = new String[32];
      
      for(int i = 0; i < 32; i++)
      {
         t128[i] = c128[i].convertText(s128[i].text);
         t256[i] = c256[i].convertText(s256[i].text);
         t512[i] = c512[i].convertText(s512[i].text);
         t1024[i] = c1024[i].convertText(s1024[i].text);
         t2048[i] = c2048[i].convertText(s2048[i].text);
         t3000[i] = c3000[i].convertText(s3000[i].text);
         t4096[i] = c4096[i].convertText(s4096[i].text);
         t5000[i] = c5000[i].convertText(s5000[i].text);
         t7000[i] = c7000[i].convertText(s7000[i].text);
         t8192[i] = c8192[i].convertText(s8192[i].text);
      }
      
      Integer[] averages = new Integer[10];
      for(int i = 0; i < 10; i++)
      {
         averages[i] = 0;
      }
      for(int i = 0; i < 32; i++)
      {
         averages[0] = t128[i].length() + averages[0];
         averages[1] = t256[i].length() + averages[1];
         averages[2] = t512[i].length() + averages[2];
         averages[3] = t1024[i].length() + averages[3];
         averages[4] = t2048[i].length() + averages[4];
         averages[5] = t3000[i].length() + averages[5];
         averages[6] = t4096[i].length() + averages[6];
         averages[7] = t5000[i].length() + averages[7];
         averages[8] = t7000[i].length() + averages[8];
         averages[9] = t8192[i].length() + averages[9];
      }
      averages[0] = (averages[0] / 32);
      averages[1] = (averages[1] / 32);
      averages[2] = (averages[2] / 32);
      averages[3] = (averages[3] / 32);
      averages[4] = (averages[4] / 32);
      averages[5] = (averages[5] / 32);
      averages[6] = (averages[6] / 32);
      averages[7] = (averages[7] / 32);
      averages[8] = (averages[8] / 32);
      averages[9] = (averages[9] / 32);
      
      writer.write("Size,Average Length of Huffman,Reduction Ratio of Huffman,");
      writer.newLine();
      for(int k = 0; k<10; k++)
      {
         writer.write(numbers[k].toString());
         writer.write(",");
         writer.write(averages[k].toString());
         writer.write(",");
         writer.write(averages[k].toString() + " / " + numbers2[k].toString());
         writer.newLine();
      }
      writer.close();
   }
}
