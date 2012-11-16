import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.*;

public class PlayThrees extends JFrame
{
   public static void main(String[] args)
   {
      PlayThrees frame = new PlayThrees();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(200,200));
      
      frame.makeGrid();
      
      frame.pack();
      frame.setVisible(true);
   }
   
   private int[] dice;
   private int[] kept;
   private Roller roller = new Roller(5);
   
   public void makeGrid()
   {
      class RollListener implements MouseListener
      {
         public void stateChanged(ChangeEvent event)
         {
            dice = roller.roll(5 - kept.length);
         }
      }
      
      ChangeListener rollListen = new RollListener();
      
      JPanel backPanel = new JPanel();
      JPanel playPanel = new JPanel();
      JPanel rollPanel = new JPanel();
      JPanel dicePanel = new JPanel();
      JPanel keepPanel = new JPanel();
      JPanel keptPanel = new JPanel();
      JPanel scorePanel = new JPanel();
      
      backPanel.setLayout(new GridLayout(6,1));
      playPanel.setLayout(new GridLayout(1,1));
      rollPanel.setLayout(new GridLayout(1,1));
      dicePanel.setLayout(new GridLayout(1,5));
      keepPanel.setLayout(new GridLayout(1,5));
      keptPanel.setLayout(new GridLayout(1,5));
      scorePanel.setLayout(new GridLayout(1,1));
      
      JButton rollButton = new JButton("Roll");
      rollButton.addChangeListener(BasicButtonListener);
      
      rollPanel.add(rollButton);
      
      backPanel.add(playPanel);
      backPanel.add(rollPanel);
      backPanel.add(dicePanel);
      backPanel.add(keepPanel);
      backPanel.add(keptPanel);
      backPanel.add(scorePanel);
      
      setContentPane(backPanel);
   }
}
