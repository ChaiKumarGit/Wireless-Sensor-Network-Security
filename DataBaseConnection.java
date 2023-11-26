
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import java.sql.SQLException;


public class DataBaseConnection {
    Connection con;
   public Connection dbconnect()throws SQLException{
   try
   {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     con=DriverManager.getConnection("jdbc:odbc:manet","sa","sa");
   }
   catch(Exception ae)
   {
     ae.printStackTrace();
   }
   return con;
   }
   }


