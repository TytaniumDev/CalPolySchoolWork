/**
  Sample JDBC code illustrating updating a database using 
  a parameterized query string, with transaction processing.
  Professor M. Liu, Fall 2009
 **/
 
import java.io.*;
import java.util.*;
import java.sql.*;

class Update{
   public static void main (String[] args ){
      Scanner keyboard  = null;
      Connection conn = null;
      ResultSet rset = null;
      PreparedStatement pstmt1 = null, pstmt2 = null;
      String query = null, line = null; 
      int rowCount = 1;	  
      String cno_ = null, zip_ = null;
	  
      try {
         conn = login();
         conn.setAutoCommit(false);
         conn. setTransactionIsolation 
           (Connection.TRANSACTION_SERIALIZABLE);

         // For keyboard input
         keyboard = new Scanner(System.in);
         
         pstmt1 = conn.prepareStatement
            ("SELECT * FROM customers WHERE cno = ?");
         pstmt2 = conn.prepareStatement
            ("UPDATE customers SET zip = ? WHERE cno = ?");
         
         cno_= " ";
         while (cno_.length( ) != 0){  
            System.out.println
               ("Enter CNO to update, or press return to quit:");
            cno_ = keyboard.nextLine( );
            try {
               // Set the parameter in the query string 
               // prepared with pstmt1
               pstmt1.setString(1, cno_);  
               // now execute the query       
               rset = pstmt1.executeQuery();
               rset.next();
               System.out.println
                  ("The customer's current zipcode is " + 
               rset.getString("ZIP"));
               System.out.println("Enter the new zipcode:");
               zip_ = keyboard.nextLine(); 
               // Set the parameters in the query string 
               //  prepared with pstmt2
               pstmt2.setString(1, zip_); 
               pstmt2.setString(2, cno_);          
               if (pstmt2.executeUpdate() != 1)
                  throw new Exception(); 
               System.out.println("Update made.");
            }
            catch (Exception ex) {
               System.out.println
                  ("That didn't work. Please try again.");
            }
         }

         // List the resulting customers table     
         query = "SELECT * FROM customers";
         pstmt1.close( );
         pstmt1 = conn.prepareStatement(query);
         rset = pstmt1.executeQuery(); 
         System.out.println
            ("The customers table now contains:");	
         System.out.println
            ("\tCNO    \tCNAME\tSTREET\t\tZIP\tPHONE");
         while (rset.next ()){
            System.out.print(rowCount + ".\t" 
               + rset.getString ("CNO") + "\t"
               + rset.getString ("CNAME") + "\t"
               + rset.getString ("STREET") + "\t"
               + rset.getString ("ZIP") + "\t"
               + rset.getString ("PHONE") + "\t");
            System.out.println( );
            rowCount++;
         } //end while
         System.out.println
            ("Want to make the changes made permanent?" +
             " Enter Y or N.");
         line = keyboard.next( ).toUpperCase( ); 
         if (line.charAt(0)== 'Y')
            conn.commit( );
         else
            conn.rollback( );
      } //end try
      catch (Exception ex){
  	     ex.printStackTrace( );
      }
      finally {
      	 try {
             // Strictly speaking, each of the close statements should 
             // be enclosed in try-catch.
             keyboard.close( );
             pstmt1.close( );
             pstmt2.close( );
             rset.close( );
             conn.close( ); 
         }
         catch (Exception ex) {  
   	   }    	
      } // end finally   	
  
   } //end main

   /**
    * Helper method for making an Oracle connection
    */
  private static Connection login() throws Exception{	  
     Console console = System.console();
     String id = console.readLine
        ("Enter your Oracle userID: "); 
     char[ ] pword = console.readPassword
             ("Enter your Oracle password: ");
     Connection conn = null;
     System.out.println ("Connecting...");
     Class.forName ("oracle.jdbc.OracleDriver"); 
     System.out.println ("Driver class found and loaded.");   
     conn = DriverManager.getConnection(
      "jdbc:oracle:thin:@hercules.csc.calpoly.edu:1522:ora10g"
       , id, new String(pword));
     System.out.println ("connected.");  
     return conn;
   }
   
} //end class
