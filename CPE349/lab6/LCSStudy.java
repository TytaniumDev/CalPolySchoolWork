/* Written by Tyler Holland and Spencer Ellsworth */
/* Increase heap size to 1.5gb */
public class LCSStudy
{
   public static void main(String args[])
   {
      RandomText[][] part1 = new RandomText[10][10];
      RandomText[][] part2 = new RandomText[10][20];
      int counter = 25;
      long start, end;
      long p1total[] = new long[10];
      long p1avg[] = new long[10];
      long p2total[] = new long[10];
      long p2avg[] = new long[10];
      LCS test = new LCS();
      
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            part1[i][j] = new RandomText(counter);
            part2[i][j] = new RandomText(counter);
            part2[i][j+10] = new RandomText(counter);
         }
         counter = counter * 2;
      }
      //Part 1
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            start = System.nanoTime();
            test.findLCS(part1[i][j].text, part1[i][j].text);
            end = System.nanoTime();
            p1total[i] += end - start;
            start = System.nanoTime();
            test.findLCS(part2[i][j].text, part2[i][j+10].text);
            end = System.nanoTime();
            p2total[i] += end - start;
         }
      }
      
      for(int i = 0; i < 10; i++)
      {
         p1avg[i] = p1total[i] / 10;
         p2avg[i] = p2total[i] / 10;
      }
      
      System.out.println("Size, p1 Avg, p2 Avg,");
      counter = 25;
      for(int i = 0; i < 10; i++)
      {
         System.out.println(counter + "," + p1avg[i] + "," + p2avg[i] + ",");
         counter = counter * 2;
      }
   }
}
