package edu.calpoly.testtool.QuestionDB;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class AddQuestionGeneric extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel = null;
	private JComboBox TypeofQuestion = null;
	private JButton Done = null;
	private JButton Cancel = null;
	/**
	 * This method initializes mainPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(1, 1, 1, 1);
			c.weighty = 1.0;
			c.weightx = 1.0;
			c.gridx = 2;
			c.gridy = 0;
			c.anchor = GridBagConstraints.NORTHEAST;
			mainPanel.add(getTypeofQuestion(), c);
			c.weightx = 0;
			c.gridx = 2;
			c.gridy = 1;
			c.gridwidth = 1;
			c.anchor = GridBagConstraints.SOUTHEAST;
			mainPanel.add(getCancel(), c);
			c.gridx = 3;
			mainPanel.add(getDone(), c);
		}
		return mainPanel;
	}

	/**
	 * This method initializes TypeofQuestion	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getTypeofQuestion() {
		if (TypeofQuestion == null) {
			TypeofQuestion = new JComboBox();
			TypeofQuestion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Check Boxes", "Drawn Answer", "Essay", "Fill in the Blank", "Matching",
					"Multiple Choice", "Point and Click", "Programming", "Short Answer", "True/False"}));
			TypeofQuestion.setName("jComboBox1");
		}
		return TypeofQuestion;
	}

	/**
	 * This method initializes Done	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getDone() {
		if (Done == null) {
			Done = new JButton("Done");
		}
		return Done;
	}

	/**
	 * This method initializes Cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancel() {
		if (Cancel == null) {
			Cancel = new JButton("Cancel");
		}
		return Cancel;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddQuestionGeneric thisClass = new AddQuestionGeneric();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public AddQuestionGeneric() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1280, 720);
	    this.setLayout(new FlowLayout());
	    this.getContentPane().setBackground(Color.WHITE);
	    this.setForeground(Color.BLACK);
	    this.setContentPane(getMainPanel());
		this.setTitle("Add Question");
	}

}
