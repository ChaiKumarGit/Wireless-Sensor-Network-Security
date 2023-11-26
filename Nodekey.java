import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import java.sql.*;

 class prime
{
	 int i;
	 String s;
	 int flag=0;
	 boolean checkPrime(long n)
	 {
		  if(n==0 || n==1)
		  {
		  System.out.println("not prime number");
		  }
		  else
		  {
			   for(i=2;i<n;i++)
			   {
					if(n%i == 0)
					{
						 flag=1;
						 break;
					}
			   }
		  }
		  if(flag==1)
			   return false;
		  else
			   return true;
	 }
}


class calculation
{
	 long great,a;
	 double aa,bb,cc,rm;
	 long rd;
	 long eval;
	 long calE(long pi,long p,long q)
	 {
		  great=0;
		  aa=Math.log(pi)/Math.log(10);
		  bb=Math.floor(aa);
		  cc=Math.pow(10,bb);
		  rm=Math.random()*cc;
		  System.out.println("rm :"+rm);
		  rd=Math.round(rm);
		  System.out.println("rd :"+rd);
		  while(great != 1)
		  {
			   rd=rd+1;
			   great=GCD(rd,pi);
			   pi=(p-1)*(q-1);
		  }
		  return rd;
	 }

	 long GCD(long e,long pi)
	 {
		 System.out.println("e :"+e);
		  if(e > pi)
		  {
			   while(e%pi != 0)
			   {
					a=e%pi;
					e=pi;
					pi=a;
			   }
			   great=pi;
		  }
		  else
		  {
			   while(pi%e != 0)
			   {
					a=pi%e;
					System.out.println("a :"+a);
					pi=e;
					System.out.println("pi :"+pi);
					e=a;
					System.out.println("e12 :"+e);
			   }
			   great=e;
		  }
		  return great;
	 }
}



public class Nodekey extends JFrame
{
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5; 
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel contentPane;
	String pstr = "";
	String qstr = "";
	String s, output;
	long p,q,pi,e,val,ds,r,qd;;
	static long d,n;
		int i,cnt;
	long rst[] = new long[100];
	long div[] = new long[100];
	long qud[] = new long[100];
	long rem[] = new long[100];
	String fe = "";
	String fd = "";
	String fn = "";
	String PubKey = "";
	String PriKey = "";
    String secretkey ="";
    Socket socket = null;
   PrintWriter out = null;
   BufferedReader in = null;
   String s1="";
   String iadr="";
   String sa ="";
   String ipadrs="";
   
		


	public Nodekey()
	{
		//super();
		initializeComponent();
		this.setVisible(true);
		this.setTitle("ZKP-key prover, P and verifier V");
		this.setSize(900,550);
    }

	
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel(); 
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jTextField4 = new JTextField();
		jButton1 = new JButton();
		jButton2 = new JButton();
		contentPane = (JPanel)this.getContentPane();
		getContentPane().setBackground(new Color(171,144,222));
 		
		

		
		jLabel1.setText("P Value");
		
		jLabel2.setText("Q Value");
		
		jLabel3.setText("Pub Key");
		
		jLabel4.setText("Pri Key");
		
		jLabel5.setBackground(new Color(204, 204, 204)); 
 		jLabel5.setIcon(new ImageIcon("images\\prover_verifier.gif")); 
 		
		
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		jTextField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField2_actionPerformed(e);
			}

		});
		
		jTextField3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField3_actionPerformed(e);
			}

		});
		
		jTextField4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField4_actionPerformed(e);
			}

		});
		
		jButton1.setText("Generate");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
        jButton2.setText("Send");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});

		
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 58,30,60,18);
		addComponent(contentPane, jLabel2, 59,76,60,18);
		addComponent(contentPane, jLabel3, 27,177,60,18);
		addComponent(contentPane, jLabel4, 221,180,60,18);
		addComponent(contentPane, jLabel5, 355,3,476,434);
		addComponent(contentPane, jTextField1, 156,29,100,22);
		addComponent(contentPane, jTextField2, 157,76,100,22);
		addComponent(contentPane, jTextField3, 76,208,100,22);
		addComponent(contentPane, jTextField4, 243,214,100,22);
		addComponent(contentPane, jButton1,96,131,93,28);
		addComponent(contentPane, jButton2, 206,131,83,28);
		
		 
	}

	
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		

	}

	private void jTextField2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField2_actionPerformed(ActionEvent e) called.");
		

	}

	private void jTextField3_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField3_actionPerformed(ActionEvent e) called.");
		

	}

	private void jTextField4_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField4_actionPerformed(ActionEvent e) called.");
		

	}

	public String jButton1_actionPerformed(ActionEvent e1)
	{
		
		
		prime pm = new prime();
		calculation cal = new calculation();
		pstr = jTextField1.getText();
		qstr = jTextField2.getText();
		p = Long.parseLong(pstr);
		q = Long.parseLong(qstr);
		
		
		
		if(p==q)
			{
			String msg1 = "VALUE OF p and q SHOULD NOT EQUAL";
			JOptionPane.showMessageDialog(null,msg1,"Key",JOptionPane.INFORMATION_MESSAGE);
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			}

  		else if(!pm.checkPrime(p))
			{
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			String msg2 = "PLEASE ENTER p VALUE AS PRIME NUMBER";
			JOptionPane.showMessageDialog(null,msg2,"Key",JOptionPane.INFORMATION_MESSAGE);
  			}
  		else if(!pm.checkPrime(q))
			{
			jTextField1.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			String msg3 = "PLEASE ENTER q VALUE AS PRIME NUMBER";
			JOptionPane.showMessageDialog(null,msg3,"Key",JOptionPane.INFORMATION_MESSAGE);
  			}
  		else if((!pm.checkPrime(p)) && (!pm.checkPrime(q)))
			{
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			String msg4 = "PLEASE ENTER p and q VALUE AS PRIME NUMBER";
			JOptionPane.showMessageDialog(null,msg4,"Key",JOptionPane.INFORMATION_MESSAGE);
			}
  		else if(pm.checkPrime(p) && pm.checkPrime(q))

  		{		
  			 n=p*q;
  			 pi=(p-1)*(q-1);
  			 e=cal.calE(pi,p,q);
  			 System.out.println("e :"+e);

			qd=pi/e;
   			r=pi%e;
   			cnt=0;
   			rst[cnt]=pi;
   			div[cnt]=e;
   			qud[cnt]=qd;
   			rem[cnt]=r;
			System.out.println("val	ds	qd	r");
   			do
   			{
				cnt++;
				val=div[cnt-1];	//val=e
				ds=rem[cnt-1];//ds = r
				qd=val/ds; // qd=e/r
				r=val%ds;  //  r=e%r
				System.out.println(val+"\t"+ds+"\t"+qd+"\t"+r);
				if(r != 0)
				{
					 rst[cnt]=val;		//e
					 div[cnt]=ds;		//r
					 qud[cnt]=qd;		//e/r
					 rem[cnt]=r; 		//e%r
				}
   			}while(r != 0);
   			long p1,q1,s1,t1,p2,q2,s2,t2,t;

			p1=rst[cnt-1];
			q1=-qud[cnt-1];
			s1=div[cnt-1];
			t=1;

			for(i=(cnt-2);i>=0;i--)
			{
				 p2=rst[i];
				 q2=-qud[i];
				 s2=div[i];
				 if(s1==rem[i])
				 {
				   if(p1==s2)
	   				{
						p1=p2;
						t1=t;
						t=q1;
						q1=t1+(q1*q2);
						s1=s2;
	   				}
				 }
			}
			if(q1<0)
				 d=pi+q1;
			else
				 d=q1;
				fe = String.valueOf(e);
				fd = String.valueOf(d);
				fn = String.valueOf(n);
		
			output ="\n\nPublic Key :"+"\n   Exponent Value (e) = "+fe+"\n   N Value (n)        ="+fn+"\n\nPrivate Key :"+"\n  Decryption Key (d)  ="+fd+"\n  N Value (n)         ="+fn;
	         JOptionPane.showMessageDialog(null,output,"Key",JOptionPane.INFORMATION_MESSAGE);
             System.out.println(output);
             
             PubKey = "(e, n) = ("+fe+", "+fn+")";
             PriKey = "(d, n) = ("+fd+", "+fn+")";
             
	         jTextField3.setText(PubKey);
	         jTextField4.setText(PriKey);
			 secretkey = PubKey+"#"+PriKey+"#";
		   System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");   
	  }return secretkey;
	}

	
   private void jButton2_actionPerformed(ActionEvent e2)
	{
		
		String ipadrs="";
		String i="";
		String name="";
		try
	  {
	     
		 
				//Send data over socket
			    InetAddress1();
				Random1();
				
			   System.out.println("1212212");
               FileReader fr = new FileReader("ipaddress.txt");
			   BufferedReader br = new BufferedReader(fr);
			   while((i=br.readLine())!=null)
			    {
		          ipadrs+=i;
				 }
				System.out.println(ipadrs+"hi");
				String txtfield1=jTextField1.getText();
				String txtfield2=jTextField2.getText();
				String txtfield3=jTextField3.getText();
				String txtfield4=jTextField4.getText();
				 
				//String portnumber="";
				String text = iadr+"#"+s1+"#"+name+"#"+txtfield1+"#"+txtfield2+"#"+txtfield3+"#"+txtfield4;
				String query="insert into UserDetails values('"+iadr+"','"+s1+"','"+txtfield1+"','"+txtfield2+"','"+fe+"','"+fd+"','"+fn+"')";
				System.out.println(text);
				Interface inf = (Interface)Naming.lookup(ipadrs+"/Server");
				inf.update(query);
				String  avg = inf.average();
				new sample(avg);
				JOptionPane  msgalert = new JOptionPane();
				msgalert.showMessageDialog(null,"key values has been send and verified nodes formed group!!"+avg);
				this.dispose();
				 
		 
		 
     }
	 catch (Exception e)
	 {
		 e.printStackTrace();
		 System.out.println("Read failed");
       	 System.exit(1);
     }
   	 
     System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");

	 
  }
		
	 public void Random1()
	{
	   String query;
	   Random random = new Random();
	  for (int i=0; i<6; i++)
       {
	  
	   int num = random.nextInt(10);
	   int count = num;
	   int count1 = count/2;
	      
		   if(count1<=3)
	       {
              s1 = "live";
		      
		   }
	     
		   else if(count1>=4)
			{
			   s1 = "uncertain";
			   
		   }
	     else if(count1>=8)
		   {
		    s1="suspect down";
		   }
			   
	   }
	
	}
	public void  InetAddress1()
	{
		try
		{
	      InetAddress  ia = InetAddress.getLocalHost();
	      //System.out.println(ia);
	      iadr= ia.getHostAddress();
		  System.out.println(iadr);
		  String sa = iadr;
			
		}
		catch ( Exception e)
		{
		 e.printStackTrace();
		}
	
	}
  
		
	

	









 	public static void main(String[] args)
	{
		
	Nodekey frame = new Nodekey();
	    frame.setTitle("Client Program");
        WindowListener l = new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                        System.exit(0);
                }
        };

        frame.addWindowListener(l);
        frame.pack();
       
      }
	}
