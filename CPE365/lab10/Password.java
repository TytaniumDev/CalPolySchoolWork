// Lab 10 Part 2 Question 3
// Tyler Holland (tyhollan)

import java.io.Console;
import java.sql.*;

class Password{
	
   public static void main (String args []){
      boolean done = false;
      Connection conn = null;
      PreparedStatement  pstmt = null;
      ResultSet rset = null;
      String query = null, input1 = null, input2 = null;
      Console console = null; 
 	  
      try { 
         console = System.console(); 
         conn = login(console);

         // Now accept a log-in from an end-user
         pstmt = conn.prepareStatement("Select * from PASSWORDS where username = ? and password = ?");  
         // Set up the part of the query that's static
         /*String query1 = 
           "Select * from PASSWORDS where username = ";	*/  
     
         while (!done) {      
            System.out.println("Enter your login name " +
              "to access your bank account");              
            input1 = console.readLine().trim( );
            System.out.println ("Enter your password");   
            input2 = console.readLine().trim( ); 
            // Make the query
            /*query = query1 + "'" + input1 + 
                    "' and password = '" + input2 + "'"; */
            pstmt.setString(1, input1);
            pstmt.setString(2, input2);
            try {
               rset= pstmt.executeQuery();
               if (rset.next( ))  // id-password combo found  
                 done = true;
                 // user can now access his/her bank account
            }
            catch (SQLException ex){
                System.out.println(
                    "Execution of that query string failed.\n "
                    + query);

            }
         }//end while
         System.out.println("Welcome to your bank account!");
      } //end try
      catch (Exception ex){
      }
      finally {
      	try {
             pstmt.close( );
         }
         catch (Exception ex) { }
         try {            
             conn.close( ); 
         }
         catch (Exception ex) { }
      } // end finally   	
  
   } //end main

   private static Connection login(Console console) 
   throws Exception{	  
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
