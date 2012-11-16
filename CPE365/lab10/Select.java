// Sample JDBC code illustrating executing a SELECT statement using 
//  a Prepared Statement object. 
// Professor M. Liu, fall 2009
import java.io.*;
import java.util.*;
import java.sql.*;

class Select{	
   public static void main (String args []){
      Connection conn = null;
      ResultSet rset = null;
      PreparedStatement pstmt = null;
      String query = null, line = null; 	  
      int rowCount = 1;	   // row number for display
      try {
         conn = login();   
         query = "select * from zipcodes"; // NO semi-colon
         pstmt = conn.prepareStatement(query);
         rset = pstmt.executeQuery();
         System.out.println("****The zipcodes are:");	
         System.out.println("\tZIP    \tCITY");  
         // demonstrate fetching column values by column name
         while (rset.next( )) {
            System.out.print(rowCount + "\t");
            System.out.print (rset.getString ("zip") + "\t");
            System.out.print (rset.getString ("city") + "\t");
            System.out.println( );
            rowCount++;
         }
         // If the PreparedStatement object is used to execute
         // a different query string, close the previous 
         // object and re-prepare the statement.
         pstmt.close();  
         query = "select * from parts";  // NOTE: NO semi-colon
         pstmt = conn.prepareStatement(query);
         rset = pstmt.executeQuery();
         System.out.println("****The parts are:");

        // demonstrate fetching column values by column number	
         rowCount = 1;    
         ResultSetMetaData rsMetaData = rset.getMetaData();
         int numColumns = rsMetaData.getColumnCount();
         while (rset.next( )) {
            System.out.print(rowCount + ". ");
            for (int col = 1; col <= numColumns; col++){
               // NOTE: column numbers start with 1, not 0
               System.out.print (rset.getString (col) + "|");
            }
            System.out.println( );
            rowCount++;
         }         
      } //end try
      catch (Exception ex){
  	     ex.printStackTrace( );
      }
      finally {
      	 try { // strictly speaking, each close statement  
               // should be in its own try block
             pstmt.close( );
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
