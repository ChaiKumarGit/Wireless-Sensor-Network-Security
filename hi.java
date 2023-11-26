import java.rmi.*;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
public class hi 
{
		
	public hi() 
	{
      String sa="";
	  String nodename="";
      String ipadrs="";
      String portnumber="";
	  String read="";
      String [] fileread;
	  String  []averagevalues;
	 String average="";
	  String fevalue="";
	  String fdvalue="";
	  String fnvalue="";
	  try
	  {
	    FileReader fr =new FileReader("ipaddress.txt");
	    BufferedReader br = new BufferedReader(fr);
		
		while((read=br.readLine())!=null)
		  {
		    sa+=read;
		  }
		Interface inf = (Interface)Naming.lookup(sa+"/Server");
		System.out.println(sa);
		average = inf.average();
		JOptionPane jp = new JOptionPane();
		jp.showMessageDialog(null,"The average "+average);
		System.out.println(average);
		averagevalues = average.split("#");
        fevalue = averagevalues[0];
		//fdvalue = averagevalues[1];
		//fnvalue = averagevalues[2];
		System.out.println(averagevalues[0]);
		
	  }
	  catch (Exception ae)
	  {
	   ae.printStackTrace();
	  }
	 
	}
    public static void main(String[] args)
	{
	  new hi();
	
	}

}
