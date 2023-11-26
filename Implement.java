import java.sql.*;
import javax.swing.*;
import java.rmi.server.*;
import java.rmi.*;
import java.io.*;
import java.net.*;

public class Implement extends UnicastRemoteObject implements Interface
{	
	
	int update=0;
	int countnum =0;
	int count=0;
	int result=0;
	String countnumber="";
	String ipadrs="";
	String nodename="";
	String username="";
	String password="";
	String portnumber="";
    Connection connection;
	String avgvalue="";
	String feavg="";
	String fdavg="";
	String fnavg="";
	String IPAddress="";
	String pvalue="";
	String qvalue="";
	String partialkey="";
	PreparedStatement preparedStatement,preparedStatement1;
	ResultSet resultSet,resultSet1;
	public Implement()throws RemoteException
	{
	
	}

	public int update(String query)throws java.rmi.RemoteException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		    Connection con = DriverManager.getConnection("jdbc:odbc:manet","sa","");
			Statement st = con.createStatement();

			update =st.executeUpdate(query);	
		}
		
		catch (Exception i)
		{
			i.printStackTrace();
		}
		return update;
	
	}
	
	public int nodevalidation(String nodename,String password,String ipaddress,int portnumber,String status)throws java.rmi.RemoteException
	{
	  try
	 {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con = DriverManager.getConnection("jdbc:odbc:manet","sa","");
		Connection con1 = DriverManager.getConnection("jdbc:odbc:manet","sa","");
		Statement st = con.createStatement();
		PreparedStatement pstmt=con.prepareStatement("select  * from  NodeRegister where nodename=? and password =?");
		pstmt.setString(1,nodename);
		pstmt.setString(2,password);
	    ResultSet res = pstmt.executeQuery();
        
		if(res.next())
		 {
		     PreparedStatement pstmt1=con1.prepareStatement("update NodeRegister set ipaddress='"+ipaddress+"','"+portnumber+"','"+status+"' where NodeName='"+nodename+"'");
		    count = 1;
		 }
	    else
		 {
		   count = 2;
		 }
	  }
	 catch (Exception ct)
	 {
	   ct.printStackTrace();
	   
	 }
	 return count;
	}
 
	public String insertNode(String nodename,String password,String ipaddress) throws java.rmi.RemoteException{
	try{
			String status="";
			String port="";
			//DBConnection dbConnection=new DBConnection();
			 connection=DriverManager.getConnection("jdbc:odbc:manet","sa","");
			preparedStatement=connection.prepareStatement("select count(*) from Noderegister");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				count=resultSet.getInt(1);
			}
			port="100"+count;
			connection.close();
			status="disconnected";
			
			connection=DriverManager.getConnection("jdbc:odbc:manet","sa","");
			preparedStatement=connection.prepareStatement("insert into Noderegister values(?,?,?,?,?)");
			preparedStatement.setString(1,nodename);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,ipaddress);
			preparedStatement.setString(4,port);
			preparedStatement.setString(5,status);
			update=preparedStatement.executeUpdate();
			countnumber ="updated";
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return countnumber;
	
	}


	public int checkLogin(String name,String pwd,String ipaddress) throws java.rmi.RemoteException{
		try{
			connection=DriverManager.getConnection("jdbc:odbc:manet","sa","");
			preparedStatement=connection.prepareStatement("select * from noderegister where nodename=? and password=? ");
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,pwd);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				update=1;
				}
				if(update>0){
					Connection connect=DriverManager.getConnection("jdbc:odbc:manet","sa","");;
					preparedStatement1=connect.prepareStatement("update noderegister set ipaddress=?, status='connected' where nodename=?");
					preparedStatement1.setString(1,ipaddress);
					preparedStatement1.setString(2,name);
					update=preparedStatement1.executeUpdate();
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return update;
	}
 

  public String average()throws java.rmi.RemoteException
	{
     try{
			connection=DriverManager.getConnection("jdbc:odbc:manet","sa","");
			preparedStatement=connection.prepareStatement("select AVG(pubvalue),AVG (privalue),AvG (nvalue) from userdetails ");
			ResultSet results = preparedStatement.executeQuery();
			while(results.next()){
				feavg=results.getString(1);
				fdavg=results.getString(2);
				fnavg=results.getString(3);
			}
			
            avgvalue = feavg+"#"+fdavg+"#"+fnavg+"#";
			System.out.println(avgvalue);
			
	   }
	   catch(Exception ae)
		{
		  ae.printStackTrace();
		}
      return avgvalue; 
   }
  public String keyvalues()throws java.rmi.RemoteException
	{
     try{
			connection=DriverManager.getConnection("jdbc:odbc:manet","sa","");
			preparedStatement=connection.prepareStatement("select IPAddress,pvalue,qvalue from userdetails ");
			ResultSet results = preparedStatement.executeQuery();
			while(results.next()){
				IPAddress=results.getString(1);
				pvalue=results.getString(2);
				qvalue=results.getString(3);
			}
			
            partialkey = IPAddress+"#"+pvalue+"#"+qvalue+"#";
			System.out.println(avgvalue);
			
	   }
	   catch(Exception ae)
		{
		  ae.printStackTrace();
		}
      return partialkey; 
    	 
	}

}

	