package edu.calpoly.testtool.QuestionDB;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class QuestionDB extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar Menu;
	private JMenu File;
	private JMenu Edit;
	private JMenu Database;
	private JMenu Tests;
	private JMenu Options;
	private JMenu Help;
	private JMenu Exit;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	/**
	 * This method initializes Menu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenu() {
		if (Menu == null) {
			Menu = new JMenuBar();
			Menu.add(getFile());
			Menu.add(getEdit());
			Menu.add(getDatabase());
			Menu.add(getTests());
			Menu.add(getOptions());
			Menu.add(getHelp());
			Menu.add(getExit());
		}
		return Menu;
	}

	/**
	 * This method initializes File	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFile() {
		if (File == null) {
			File = new JMenu("File");
		}
		return File;
	}

	/**
	 * This method initializes Edit	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEdit() {
		if (Edit == null) {
			Edit = new JMenu("Edit");
		}
		return Edit;
	}

	/**
	 * This method initializes Database	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getDatabase() {
		if (Database == null) {
			Database = new JMenu("Database");
		}
		return Database;
	}

	/**
	 * This method initializes Tests	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getTests() {
		if (Tests == null) {
			Tests = new JMenu("Tests");
		}
		return Tests;
	}

	/**
	 * This method initializes Options	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getOptions() {
		if (Options == null) {
			Options = new JMenu("Options");
		}
		return Options;
	}

	/**
	 * This method initializes Help	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelp() {
		if (Help == null) {
			Help = new JMenu("Help");
		}
		return Help;
	}

	/**
	 * This method initializes Exit	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getExit() {
		if (Exit == null) {
			Exit = new JMenu("Exit");
		}
		return Exit;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {"1", "CPE102", "1", "5", "Never", "Check Boxes", "", null, "None"},
		                {"2", "CPE102", "3", "15", "Never", "Drawn Answer", null, null, "None"},
		                {"3", "CPE102", "4", "15", "Never", "Essay", null, null, "None"},
		                {"4", "CPE102", "2", "5", "Never", "Fill in the Blank", null, null, "None"},
		                {"5", "CPE102", "4", "6", "Never", "Matching", null, null, "None"},
		                {"6", "CPE102", "5", "5", "Never", "Multiple Choice", null, null, "None"},
		                {"7", "CPE102", "2", "4", "Never", "Point and Click", null, null, "None"},
		                {"8", "CPE102", "5", "20", "Never", "Programming", null, null, "None"},
		                {"9", "CPE102", "3", "5", "Never", "Short Answer", null, null, "None"},
		                {"10", "CPE102", "1", "2", "Never", "True/False", null, null, "None"}
		            },
		            new String [] {
		                "#", "Class", "Difficulty", "Time Allowed", "Last Used", "Type of Question", "Question", "Answer", "HTML File"
		            }
		        ));
		}
		return jTable1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				QuestionDB thisClass = new QuestionDB();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public QuestionDB() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("JFrame");
		this.setSize(1280, 720);
	    this.setLayout(new FlowLayout());
	    this.getContentPane().setBackground(Color.WHITE);
	    this.setForeground(Color.BLACK);
	    this.setContentPane(getJScrollPane());
	    this.setJMenuBar(getMenu());
	}

}  //  @jve:decl-index=0:visual-constraint="1,-45"
