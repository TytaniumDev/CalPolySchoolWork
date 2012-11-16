// Tyler Holland (tyhollan)
// Lab 10 Part 1 Question 2

import java.io.*;
import java.util.*;
import java.sql.*;

public class OrderValue 
{
   public static void main (String args []){
      Connection conn = null;
      ResultSet rset = null;
      PreparedStatement pstmt = null;
      String query = null, line = null;     
      int rowCount = 1;    // row number for display
      try {
         conn = login();  
         query = "select ono, orderValue(ono) as VALUE from orders order by ono"; // NO semi-colon
         pstmt = conn.prepareStatement(query);
         rset = pstmt.executeQuery();
         System.out.println("\tONO    \tVALUE");  
         // demonstrate fetching column values by column name
         while (rset.next( )) {
            System.out.print(rowCount + "\t");
            System.out.print (rset.getString ("ono") + "\t");
            System.out.print (rset.getString ("value") + "\t");
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
    * The log-in information is provided using command-line arguments.
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
