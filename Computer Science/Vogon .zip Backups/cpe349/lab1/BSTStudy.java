//Written by Tyler Holland and Spencer Ellsworth
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BSTStudy
{
   public static void main(String args[]) throws IOException 
   {
      Random rando = new Random();
      BinaryTree tree = new BinaryTree();
      int[][] holdCounter = new int[13][3];
      Double[][] holdCount = new Double[13][3];
      File outFile = new File("output.csv");
      BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
      Integer[] numbers = new Integer[]{10,20,50,75,100,200,500,750,1000,2000,5000,7500,10000};
      
      //Study 2
      Integer[] array20best = null;
      Integer[] array20rando = null;
      Integer[] array20worst = null;
      int[][] holdCounter2 = new int[3][3];
      Double[][] holdCount2 = new Double[3][3];
      File outFile2 = new File("output2.csv");
      BufferedWriter writer2 = new BufferedWriter(new FileWriter(outFile2));
      String[] numbers2 = new String[]{"Best", "Average", "Worst"};
      //Best
      for(int i = 0; i < 1000; i++)
      {
         array20best = new Integer[]{50,30,100,20,40,90,110,10,25,35,45,85,95,105,120,92,102,107,115,130};
         tree.initialize(); //Plant a tree
         tree.sort(array20best);
         holdCounter2[0][0]+= tree.getCounter();
         tree.findMax(array20best);
         holdCounter2[0][1]+= tree.getCounter();
         tree.findSecondMax(array20best);
         holdCounter2[0][2]+= tree.getCounter();
      }
      //Average
      for(int i = 0; i < 1000; i++)
      {
         array20rando = new Integer[20];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 20; j++)
         {
            array20rando[j] = rando.nextInt();
         }
         tree.sort(array20rando);
         holdCounter2[1][0]+= tree.getCounter();
         tree.findMax(array20rando);
         holdCounter2[1][1]+= tree.getCounter();
         tree.findSecondMax(array20rando);
         holdCounter2[1][2]+= tree.getCounter();
      }
      //Worst
      for(int i = 0; i < 1000; i++)
      {
         array20worst = new Integer[20];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 20; j++)
         {
            array20worst[j] = j + 1;
         }
         tree.sort(array20worst);
         holdCounter2[2][0]+= tree.getCounter();
         tree.findMax(array20worst);
         holdCounter2[2][1]+= tree.getCounter();
         tree.findSecondMax(array20worst);
         holdCounter2[2][2]+= tree.getCounter();
      }
      
      
      Integer[] array10 = null;
      Integer[] array20 = null;
      Integer[] array50 = null;
      Integer[] array75 = null;
      Integer[] array100 = null;
      Integer[] array200 = null;
      Integer[] array500 = null;
      Integer[] array750 = null;
      Integer[] array1000 = null;
      Integer[] array2000 = null;
      Integer[] array5000 = null;
      Integer[] array7500 = null;
      Integer[] array10000 = null;
      for(int i = 0; i < 1000; i++)
      {
         array10 = new Integer[10];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 10; j++)
         {
            array10[j] = rando.nextInt();
         }
         tree.sort(array10);
         holdCounter[0][0]+= tree.getCounter();
         tree.findMax(array10);
         holdCounter[0][1]+= tree.getCounter();
         tree.findSecondMax(array10);
         holdCounter[0][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array20 = new Integer[20];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 20; j++)
         {
            array20[j] = rando.nextInt();
         }
         tree.sort(array20);
         holdCounter[1][0]+= tree.getCounter();
         tree.findMax(array20);
         holdCounter[1][1]+= tree.getCounter();
         tree.findSecondMax(array20);
         holdCounter[1][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array50 = new Integer[50];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 50; j++)
         {
            array50[j] = rando.nextInt();
         }
         tree.sort(array50);
         holdCounter[2][0]+= tree.getCounter();
         tree.findMax(array50);
         holdCounter[2][1]+= tree.getCounter();
         tree.findSecondMax(array50);
         holdCounter[2][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array75 = new Integer[75];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 75; j++)
         {
            array75[j] = rando.nextInt();
         }
         tree.sort(array75);
         holdCounter[3][0]+= tree.getCounter();
         tree.findMax(array75);
         holdCounter[3][1]+= tree.getCounter();
         tree.findSecondMax(array75);
         holdCounter[3][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array100 = new Integer[100];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 100; j++)
         {
            array100[j] = rando.nextInt();
         }
         tree.sort(array100);
         holdCounter[4][0]+= tree.getCounter();
         tree.findMax(array100);
         holdCounter[4][1]+= tree.getCounter();
         tree.findSecondMax(array100);
         holdCounter[4][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array200 = new Integer[200];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 200; j++)
         {
            array200[j] = rando.nextInt();
         }
         tree.sort(array200);
         holdCounter[5][0]+= tree.getCounter();
         tree.findMax(array200);
         holdCounter[5][1]+= tree.getCounter();
         tree.findSecondMax(array200);
         holdCounter[5][2]+= tree.getCounter();
      }
      for(int i = 0; i < 100; i++)
      {
         array500 = new Integer[500];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 500; j++)
         {
            array500[j] = rando.nextInt();
         }
         tree.sort(array500);
         holdCounter[6][0]+= tree.getCounter();
         tree.findMax(array500);
         holdCounter[6][1]+= tree.getCounter();
         tree.findSecondMax(array500);
         holdCounter[6][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array750 = new Integer[750];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 750; j++)
         {
            array750[j] = rando.nextInt();
         }
         tree.sort(array750);
         holdCounter[7][0]+= tree.getCounter();
         tree.findMax(array750);
         holdCounter[7][1]+= tree.getCounter();
         tree.findSecondMax(array750);
         holdCounter[7][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array1000 = new Integer[1000];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 1000; j++)
         {
            array1000[j] = rando.nextInt();
         }
         tree.sort(array1000);
         holdCounter[8][0]+= tree.getCounter();
         tree.findMax(array1000);
         holdCounter[8][1]+= tree.getCounter();
         tree.findSecondMax(array1000);
         holdCounter[8][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array2000 = new Integer[2000];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 2000; j++)
         {
            array2000[j] = rando.nextInt();
         }
         tree.sort(array2000);
         holdCounter[9][0]+= tree.getCounter();
         tree.findMax(array2000);
         holdCounter[9][1]+= tree.getCounter();
         tree.findSecondMax(array2000);
         holdCounter[9][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array5000 = new Integer[5000];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 5000; j++)
         {
            array5000[j] = rando.nextInt();
         }
         tree.sort(array5000);
         holdCounter[10][0]+= tree.getCounter();
         tree.findMax(array5000);
         holdCounter[10][1]+= tree.getCounter();
         tree.findSecondMax(array5000);
         holdCounter[10][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array7500 = new Integer[7500];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 7500; j++)
         {
            array7500[j] = rando.nextInt();
         }
         tree.sort(array7500);
         holdCounter[11][0]+= tree.getCounter();
         tree.findMax(array7500);
         holdCounter[11][1]+= tree.getCounter();
         tree.findSecondMax(array7500);
         holdCounter[11][2]+= tree.getCounter();
      }
      for(int i = 0; i < 1000; i++)
      {
         array10000 = new Integer[10000];
         tree.initialize(); //Plant a tree
         for(int j = 0; j < 10000; j++)
         {
            array10000[j] = rando.nextInt();
         }
         tree.sort(array10000);
         holdCounter[12][0]+= tree.getCounter();
         tree.findMax(array10000);
         holdCounter[12][1]+= tree.getCounter();
         tree.findSecondMax(array10000);
         holdCounter[12][2]+= tree.getCounter();
      }
      
      for(int k = 0; k<13; k++)
      {
         for(int l=0; l<3; l++)
         {
            holdCount[k][l] = holdCounter[k][l]/1000.0;
         }
      }
      writer.write(",Sort,Max,2nd Max,");
      writer.newLine();
      for(int k = 0; k<13; k++)
      {
         writer.write(numbers[k].toString());
         writer.write(",");
         for(int l=0; l<3; l++)
         {
            writer.write(holdCount[k][l].toString());
            writer.write(",");
         }
         writer.newLine();
      }
      writer.close();
   
      //Study 2
      for(int k = 0; k<3; k++)
      {
         for(int l=0; l<3; l++)
         {
            holdCount2[k][l] = holdCounter2[k][l]/1000.0;
         }
      }
      writer2.write(",Sort,Max,2nd Max,");
      writer2.newLine();
      for(int k = 0; k<3; k++)
      {
         writer2.write(numbers2[k]);
         writer2.write(",");
         for(int l=0; l<3; l++)
         {
            writer2.write(holdCount2[k][l].toString());
            writer2.write(",");
         }
         writer2.newLine();
      }
      writer2.close();
   }
}
