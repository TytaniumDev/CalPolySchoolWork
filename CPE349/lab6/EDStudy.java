/* Written by Tyler Holland and Spencer Ellsworth */
public class EDStudy
{
   public static void main(String args[])
   {
      RandomText[][] part1 = new RandomText[10][10];
      RandomText[][] part2 = new RandomText[30][20];
      int counter = 25;
      long start, end;
      long p1total[] = new long[10];
      long p1avg[] = new long[10];
      long p2total[] = new long[30];
      long p2avg[] = new long[30];
      int p2distotal[] = new int[30];
      int p2disavg[] = new int[30];
      EditDistance test = new EditDistance();
      
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            part1[i][j] = new RandomText(counter);
            part2[i][j] = new RandomText(counter);
            part2[i][j+10] = new RandomText(counter);
            part2[i+10][j] = new RandomText(counter);
            part2[i+10][j+10] = new RandomText(counter);
            part2[i+20][j] = new RandomText(counter);
            part2[i+20][j+10] = new RandomText(counter);
         }
         counter = counter * 2;
      }
      //Part 1
      for(int i = 0; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            start = System.nanoTime();
            test.findEditDistance(part1[i][j].text, part1[i][j].text);
            end = System.nanoTime();
            p1total[i] += end - start;
            start = System.nanoTime();
            p2distotal[i] = test.findEditDistance(part2[i][j].text, part2[i][j+10].text);
            end = System.nanoTime();
            p2total[i] += end - start;
            start = System.nanoTime();
            p2distotal[i+10] = test.findEditDistance(part2[i+10][j].text, part2[i+10][j+10].text);
            end = System.nanoTime();
            p2total[i+10] += end - start;
            start = System.nanoTime();
            p2distotal[i+20] = test.findEditDistance(part2[i+20][j].text, part2[i+20][j+10].text);
            end = System.nanoTime();
            p2total[i+20] += end - start;
         }
      }
      
      for(int i = 0; i < 10; i++)
      {
         p1avg[i] = p1total[i] / 10;
         p2avg[i] = p2total[i] / 10;
         p2avg[i+10] = p2total[i+10] / 10;
         p2avg[i+20] = p2total[i+20] / 10;
         p2disavg[i] = p2distotal[i] / 10;
         p2disavg[i+10] = p2distotal[i+10] / 10;
         p2disavg[i+20] = p2distotal[i+20] / 10;
      }
      
      System.out.println("Size, p1 Avg, p2 Avg 1, p2 Avg 2, p2 Avg 3, " +
      		"p2 disAvg 1, p2 disAvg 2, p2 disAvg 3");
      counter = 25;
      for(int i = 0; i < 10; i++)
      {
         System.out.println(counter + "," + p1avg[i] + "," + p2avg[i] + ","
               + p2avg[i+10] + "," + p2avg[i+20] + "," + p2disavg[i] +
               "," + p2disavg[i+10] + "," + p2disavg[i+20] + ",");
         counter = counter * 2;
      }
   }

}
