/**
 * Threes.java - The dice game!
 *
 * @author kmammen
 */

import java.util.*;

public class Threes 
{
   private static final int NUMBER_OF_DIE = 5;
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      Roller roller;
      String name;
      String play = "y";
      String roll = "";
      String seed;
      int[] dice = new int[NUMBER_OF_DIE];
      int[] kept = new int[NUMBER_OF_DIE];
      long[] seeds = null;
      int count = 0;
      int sides = Die.DEFAULT_NUMBER_OF_SIDES;
      
      System.out.println("*");
      System.out.println("* Welcome to the game of Threes!");
      System.out.println("*");
      System.out.println("* This program supports a single player.");
      System.out.println("*");
      System.out.println("* To play Threes with mulitiple players simply start");
      System.out.println("* multiple instances of this program.\n");
      
      System.out.print("To begin, please enter your name: ");
      name = scanner.nextLine();
      
      // Seeded die?
      //      
      System.out.print("\nWelcome " + name + ", would you like to seed the die? (y/n): ");
      seed = scanner.nextLine();
      
      if (seed.equals("y"))   
      {
         seeds = new long[NUMBER_OF_DIE];

         for (int i = 0; i < NUMBER_OF_DIE; i++)
         {
            System.out.print("Enter seed for die #" + (i + 1) + ": ");
            seeds[i] = scanner.nextLong();
            scanner.nextLine();
         }
         
         roller = new Roller(NUMBER_OF_DIE, seeds);
      }
      else
      {
         roller = new Roller(NUMBER_OF_DIE);
      }
      
      // Use six-sided die?
      //
      System.out.print("\nWould you like to use six-sided dice? (y/n): ");
      seed = scanner.nextLine();
      
      if (!seed.equals("y"))
      {
         System.out.print("Enter the number of sides for each die: ");
         sides = scanner.nextInt();
         scanner.nextLine();
      }
      
      // Construct the Roller
      //
      if (seeds == null)
      {
         if (sides == Die.DEFAULT_NUMBER_OF_SIDES)
         {
            roller = new Roller(NUMBER_OF_DIE);
         }
         else
         {
            roller = new Roller(NUMBER_OF_DIE, sides);
         }
      }
      else
      {
         if (sides == Die.DEFAULT_NUMBER_OF_SIDES)
         {
            roller = new Roller(NUMBER_OF_DIE, seeds);
         }
         else
         {
            roller = new Roller(NUMBER_OF_DIE, sides, seeds);
         }
      }

      // Game loop...
      //
      while (play.equals("y"))
      {
         count = 0;
                
         // Turn loop...
         // 
         while (count < NUMBER_OF_DIE)
         {
            
            // Block until user wants to roll...
            //
            while (!roll.equals("r"))
            {
               System.out.print("\nYou have " + (NUMBER_OF_DIE - count));
               
               if (NUMBER_OF_DIE - count == 1)
               {
                  System.out.print(" die, ");
               }
               else
               {
                  System.out.print(" dice, ");
               }
               
               System.out.print("enter <r> to roll: ");
               
               roll = scanner.nextLine();
            }
            
            // Reset roll...
            roll = "";
            
            dice = roller.roll(NUMBER_OF_DIE - count);
            
            System.out.print("\nRolling " + (NUMBER_OF_DIE - count));
            
            if (count > 1)
            {
               System.out.print(" dice, ");
            }
            else
            {
               System.out.print(" die, ");
            }
            
            System.out.println("you rolled:");
            
            for (int i = 0; i < NUMBER_OF_DIE - count; i++)
            {
               System.out.println("  Die " + (i + 1) + ": " + dice[i]);   
            }
            
            // Handle the roll...
            //
            while (true)
            {
               boolean noneKeptThisRoll = true;
               
               if (count < NUMBER_OF_DIE - 1)
               {
               
                  System.out.print("\nEnter die #s to keep or <h> for help): ");
                  Scanner response = new Scanner(scanner.nextLine());
                  
                  if (!response.hasNextInt())
                  {
                     System.out.println("\nYou must keep one or more die each roll." );
                     System.out.println("Enter the number(s) of the die you wish");
                     System.out.println("to keep separated by spaces for example:\n");
                     System.out.print("Enter die #s to keep ('h' for help): ");
                     System.out.println("2 5\n");
                     System.out.println("This would keep the current values of the");
                     System.out.println("second and fifth die and remove them from" );
                     System.out.println("the next roll.\n");
                     
                     continue;
                  }
   
                  noneKeptThisRoll = false;
                  
                  while (response.hasNextInt())
                  {
                     kept[count++] = dice[response.nextInt() - 1];
                  }
               }
               else
               {
                  kept[count++] = dice[0];
               }

               int sum = 0;
               System.out.print("\nKept die values: ");
                  
               for(int i = 0; i < count; i++)
               {
                  System.out.print(kept[i] + " ");
                  
                  if ( kept[i] != 3)
                  {
                     sum += kept[i];
                  }
               }
            
               System.out.println();
            
               System.out.println("Score is: " + sum);
               break;
            } // End of roll loop
         } // End Turn loop...
         
         System.out.print("\nWould you like to play again? (y/n): ");
         play = scanner.nextLine();
      }
      
      System.out.println("\nThanks for playing " + name + " - bye...\n");
   }  
}
