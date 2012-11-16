package edu.calpoly.testtool;

import java.awt.*;

import javax.swing.*;

public class TeacherHome
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("TeacherHome");
    frame.setSize(1280, 720);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setForeground(Color.BLACK);
    
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu database = new JMenu("Database");
    JMenu tests = new JMenu("Tests");
    JMenu options = new JMenu("Options");
    JMenu help = new JMenu("Help");
    file.insert(new JMenuItem("Exit"), 0);
    menuBar.add(file);
    menuBar.add(edit);
    menuBar.add(database);
    menuBar.add(tests);
    menuBar.add(options);
    menuBar.add(help);
    
    JLabel welcomeLabel = new JLabel("<html><h1>Welcome, Professor Fisher</h1></html>");
    frame.getContentPane().add(welcomeLabel);
    
    frame.setJMenuBar(menuBar);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }
}
