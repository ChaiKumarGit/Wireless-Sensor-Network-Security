import java.io.*;
import java.net.*;

class NodeB 
{
    
	public static void main(String[] args) 
	{
	    ServerSocket socketA;
	    Socket sockA;
	   String message="";
	   String msg = "";
			try
			{
				socketA = new ServerSocket(888);
				 while(true)
				{
				  sockA = socketA.accept();
				  DataInputStream dis = new DataInputStream(sockA.getInputStream());
				 message = dis.readUTF();//first read
				 msg = dis.readUTF();//second read
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
