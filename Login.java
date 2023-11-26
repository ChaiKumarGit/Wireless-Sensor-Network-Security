import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.net.*;
import java.io.*;


public class Login extends JFrame
{
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jTextField1;
	private JPasswordField jPasswordField1;
	private JButton jButton1;
	private JPanel contentPane;
	String fileread="";
	String read="";
	String nodename="";
	String password="";
	String iadr="";
	String IPAddress="";
	String status="";
	int PortNumber=0;
	int update1=0;
	int countvalue=0;
	


	public Login()
	{
		super();
		initializeComponent();
		
        nodename();
		this.setVisible(true);
	}

	
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jTextField1 = new JTextField();
		jPasswordField1 = new JPasswordField();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		
		jLabel1.setForeground(new Color(0, 0, 204));
		jLabel1.setText(" Login");
		
		jLabel2.setBackground(new Color(255, 255, 255));
		jLabel2.setIcon(new ImageIcon("images\\logo.gif"));
		
		jLabel3.setText(" Node Name:");
		
		jLabel4.setText(" Password:");
		
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jPasswordField1
		//
		jPasswordField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jPasswordField1_actionPerformed(e);
			}

		});
		
		jButton1.setBackground(new Color(255, 255, 255));
		jButton1.setForeground(new Color(0, 0, 153));
		jButton1.setText(" Submit");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 255, 255));
		addComponent(contentPane, jLabel1, 166,16,47,23);
		addComponent(contentPane, jLabel2, 6,57,140,205);
		addComponent(contentPane, jLabel3, 156,94,72,18);
		addComponent(contentPane, jLabel4, 157,151,64,18);
		addComponent(contentPane, jTextField1, 256,91,100,22);
		addComponent(contentPane, jPasswordField1, 259,145,100,22);
		addComponent(contentPane, jButton1, 214,210,75,28);
		
		this.setTitle("Login");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(388, 300));
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

	private void jPasswordField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called.");
		

	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		
		
		try
		{
			FileReader  fr = new FileReader("ipaddress.txt");
			BufferedReader br = new BufferedReader(fr);
			while((fileread=br.readLine())!=null)
			{
			  read +=fileread;
			}
            InetAddress1();
			status = "Connected";
		    Interface inf = (Interface)Naming.lookup(read+"/Server");
		    update1=inf.checkLogin(nodename,password,iadr);
		    JOptionPane jp = new JOptionPane();
			jp.showMessageDialog(null,"The values are updated");
		    
			
            
		}
		catch (Exception ed)
		{
		 ed.printStackTrace();
		}
		//String query1 = "select  * from  NodeRegister where nodename='"+nodename+"'and password ='"+password+"')";
   	   
		new GroupDiscussion();
		this.dispose();
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		

	}

	public void  InetAddress1()
	{
		try
		{
	      InetAddress  ia = InetAddress.getLocalHost();
	      //System.out.println(ia);
	      iadr= ia.getHostAddress();
		  System.out.println(iadr);
		  IPAddress = iadr;
			
		}
		catch ( Exception e)
		{
		 e.printStackTrace();
		}
	   
	}

	public String nodename()
	{
	  
	  nodename = jTextField1.getText();
	  return nodename;
	}

		public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Login();
	}



}
