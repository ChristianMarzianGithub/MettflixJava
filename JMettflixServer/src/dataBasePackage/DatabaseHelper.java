package dataBasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    public DatabaseHelper(){
        
    }
    
    
    public Connection getDBConnect() throws ClassNotFoundException
        {
            // load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");
	    Connection connection = null;
            try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Chris/Desktop/chinook.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
            
            return connection;
        }    
}
