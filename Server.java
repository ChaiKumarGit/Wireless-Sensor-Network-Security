import java.rmi.server.*;
import java.rmi.*;

class Server 
{
	public static void main(String[] args) 
	{
		try
		{
			Interface i=new Implement();
			Naming.rebind("Server",i);
			System.out.println("Server Started Sucessfully !");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
