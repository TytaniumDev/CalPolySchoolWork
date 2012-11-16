//Written by Tyler Holland and Spencer Ellsworth
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MaxStudy
{
   public static void main(String args[]) throws IOException 
   {
      Random rando = new Random();
      Finds things = new Finds();
      int[][] holdCounter = new int[15][2];
      Double[][] holdCount = new Double[15][2];
      File outFile = new File("output3.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
      Integer[] numbers = new Integer[]{8,16,32,64,100,128,256,512,1024,2048,4096,5000,8192,10000,16384};
           
      Integer[] array8 = null;
      Integer[] array16 = null;
      Integer[] array32 = null;
      Integer[] array64 = null;
      Integer[] array100 = null;
      Integer[] array128 = null;
      Integer[] array256 = null;
      Integer[] array512 = null;
      Integer[] array1024 = null;
      Integer[] array2048 = null;
      Integer[] array4096 = null;
      Integer[] array5000 = null;
      Integer[] array8192 = null;
      Integer[] array10000 = null;
      Integer[] array16384 = null;
      
      for(int i = 0; i < 100; i++)
      {
         array8 = new Integer[8];
         things = new Finds();
         for(int j = 0; j < 8; j++)
         {
            array8[j] = rando.nextInt();
         }
         things.findMax(array8.length, array8);
         holdCounter[0][0]+= things.counter;
         things.findSecondMax(array8.length, array8);
         holdCounter[0][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array16 = new Integer[16];
         things = new Finds();
         for(int j = 0; j < 16; j++)
         {
            array16[j] = rando.nextInt();
         }
         things.findMax(array16.length, array16);
         holdCounter[1][0]+= things.counter;
         things.findSecondMax(array16.length, array16);
         holdCounter[1][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array32 = new Integer[32];
         things = new Finds();
         for(int j = 0; j < 32; j++)
         {
            array32[j] = rando.nextInt();
         }
         things.findMax(array32.length, array32);
         holdCounter[2][0]+= things.counter;
         things.findSecondMax(array32.length, array32);
         holdCounter[2][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array64 = new Integer[64];
         things = new Finds();
         for(int j = 0; j < 64; j++)
         {
            array64[j] = rando.nextInt();
         }
         things.findMax(array64.length, array64);
         holdCounter[3][0]+= things.counter;
         things.findSecondMax(array64.length, array64);
         holdCounter[3][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array100 = new Integer[100];
         things = new Finds();
         for(int j = 0; j < 100; j++)
         {
            array100[j] = rando.nextInt();
         }
         things.findMax(array100.length, array100);
         holdCounter[4][0]+= things.counter;
         things.findSecondMax(array100.length, array100);
         holdCounter[4][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array128 = new Integer[128];
         things = new Finds();
         for(int j = 0; j < 128; j++)
         {
            array128[j] = rando.nextInt();
         }
         things.findMax(array128.length, array128);
         holdCounter[5][0]+= things.counter;
         things.findSecondMax(array128.length, array128);
         holdCounter[5][1]+= things.counter;
      }
      System.out.println("Here");
      /*for(int i = 0; i < 100; i++)
      {
         array256 = new Integer[256];
         things = new Finds();
         for(int j = 0; j < 256; j++)
         {
            array256[j] = rando.nextInt();
         }
         things.findMax(array256.length, array256);
         holdCounter[6][0]+= things.counter;
         things.findSecondMax(array256.length, array256);
         holdCounter[6][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array512 = new Integer[512];
         things = new Finds();
         for(int j = 0; j < 512; j++)
         {
            array512[j] = rando.nextInt();
         }
         things.findMax(array512.length, array512);
         holdCounter[7][0]+= things.counter;
         things.findSecondMax(array512.length, array512);
         holdCounter[7][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array1024 = new Integer[1024];
         things = new Finds();
         for(int j = 0; j < 1024; j++)
         {
            array1024[j] = rando.nextInt();
         }
         things.findMax(array1024.length, array1024);
         holdCounter[8][0]+= things.counter;
         things.findSecondMax(array1024.length, array1024);
         holdCounter[8][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array2048 = new Integer[2048];
         things = new Finds();
         for(int j = 0; j < 2048; j++)
         {
            array2048[j] = rando.nextInt();
         }
         things.findMax(array2048.length, array2048);
         holdCounter[9][0]+= things.counter;
         things.findSecondMax(array2048.length, array2048);
         holdCounter[9][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array4096 = new Integer[4096];
         things = new Finds();
         for(int j = 0; j < 4096; j++)
         {
            array4096[j] = rando.nextInt();
         }
         things.findMax(array4096.length, array4096);
         holdCounter[10][0]+= things.counter;
         things.findSecondMax(array4096.length, array4096);
         holdCounter[10][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array5000 = new Integer[5000];
         things = new Finds();
         for(int j = 0; j < 5000; j++)
         {
            array5000[j] = rando.nextInt();
         }
         things.findMax(array5000.length, array5000);
         holdCounter[11][0]+= things.counter;
         things.findSecondMax(array5000.length, array5000);
         holdCounter[11][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array8192 = new Integer[8192];
         things = new Finds();
         for(int j = 0; j < 8192; j++)
         {
            array8192[j] = rando.nextInt();
         }
         things.findMax(array8192.length, array8192);
         holdCounter[12][0]+= things.counter;
         things.findSecondMax(array8192.length, array8192);
         holdCounter[12][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array10000 = new Integer[10000];
         things = new Finds();
         for(int j = 0; j < 10000; j++)
         {
            array10000[j] = rando.nextInt();
         }
         things.findMax(array10000.length, array10000);
         holdCounter[13][0]+= things.counter;
         things.findSecondMax(array10000.length, array10000);
         holdCounter[13][1]+= things.counter;
      }
      System.out.println("Here");
      for(int i = 0; i < 100; i++)
      {
         array16384 = new Integer[16384];
         things = new Finds();
         for(int j = 0; j < 16384; j++)
         {
            array16384[j] = rando.nextInt();
         }
         things.findMax(array16384.length, array16384);
         holdCounter[14][0]+= things.counter;
         things.findSecondMax(array16384.length, array16384);
         holdCounter[14][1]+= things.counter;
      }
      System.out.println("Here");*/
      
      for(int k = 0; k<15; k++)
      {
         for(int l=0; l<2; l++)
         {
            holdCount[k][l] = holdCounter[k][l]/100.0;
         }
      }
      writer.write(",Sort,Max,2nd Max,");
      writer.newLine();
      for(int k = 0; k<15; k++)
      {
         writer.write(numbers[k].toString());
         writer.write(",");
         for(int l=0; l<2; l++)
         {
            writer.write(holdCount[k][l].toString());
            writer.write(",");
         }
         writer.newLine();
      }
      writer.close();
   }
}
