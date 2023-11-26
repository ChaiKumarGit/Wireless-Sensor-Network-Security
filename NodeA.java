import java.io.*;
import java.net.*;

class NodeA 
{
    
	public static void main(String[] args) 
	{
	    ServerSocket socketA;
	    Socket sockA;
	   String message="";
	   String msg = "";
			try
			{
				socketA = new ServerSocket(777);
				 while(true)
				{
				  sockA = socketA.accept();
				  DataInputStream dis = new DataInputStream(sockA.getInputStream());
				 message = dis.readUTF();//first read
				 System.out.println(message);
                 
				 msg = dis.readUTF();//second read
				 System.out.println(msg);
     		    new MessageReceiver(msg);	 
				}
			
			}
			catch (Exception ex)
			{
			  ex.printStackTrace();
			}
			
		System.out.println("Message received!!!");
	}
}
