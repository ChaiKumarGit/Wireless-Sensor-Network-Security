
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import java.sql.*;
 import java.rmi.*;
 import java.io.*;
 import java.net.*;
 
 public class NodeRegistration extends JFrame 
 { 
 	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	private JTextField jTextField1; 
 	private JPasswordField jPasswordField1; 
 	private JPasswordField jPasswordField2; 
 	private JButton jButton1; 
 	private JPanel contentPane; 
	int update=0;
	String iadr="";
	String IPAddress="";
	String status="";
	
 
  
  
 	public NodeRegistration() 
 	{ 
 		super(); 
 		this.setVisible(true);
		this.setSize(600,500);
		initializeComponent();
		getContentPane().setBackground(new Color(111,144,222));
 		
  
 		 
 	} 
  
 	
 	private void initializeComponent() 
 	{ 
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jPasswordField1 = new JPasswordField(); 
 		jPasswordField2 = new JPasswordField(); 
 		jButton1 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
        
 		
 		jLabel1.setBackground(new Color(204, 204, 204)); 
 		jLabel1.setForeground(new Color(0, 0, 204)); 
 		jLabel1.setText(" Node  Registeration"); 
		jLabel1.setFont(new Font("alpha",Font.BOLD,14));
		jLabel1.setBackground(new Color(104, 104, 104)); 
 		
 		jLabel2.setBackground(new Color(204, 204, 204)); 
 		jLabel2.setIcon(new ImageIcon("images\\wireless_networking.jpg")); 
 		
 		jLabel3.setBackground(new Color(204, 204, 204)); 
 		jLabel3.setText(" Node Name:"); 
 		
 		jLabel4.setBackground(new Color(204, 204, 204)); 
 		jLabel4.setText(" Password"); 
 		
 		jLabel5.setBackground(new Color(204, 204, 204)); 
 		jLabel5.setText(" RE-Password"); 
 		
 		jTextField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jTextField1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		jPasswordField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jPasswordField1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		jPasswordField2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jPasswordField2_actionPerformed(e); 
 			} 
  
 		}); 
 		 
 		jButton1.setBackground(new Color(204, 204, 204)); 
 		jButton1.setForeground(new Color(0, 0, 204)); 
 		jButton1.setText(" Register"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		contentPane.setLayout(null); 
 		contentPane.setBorder(BorderFactory.createEtchedBorder()); 
 		contentPane.setBackground(new Color(204, 204, 204)); 
 		addComponent(contentPane, jLabel1, 210,0,315,39); 
 		addComponent(contentPane, jLabel2, 5,43,400,300); 
 		addComponent(contentPane, jLabel3, 426,92,70,27); 
 		addComponent(contentPane, jLabel4, 429,149,60,18); 
 		addComponent(contentPane, jLabel5, 428,206,77,18); 
 		addComponent(contentPane, jTextField1, 530,99,100,22); 
 		addComponent(contentPane, jPasswordField1, 530,151,100,22); 
 		addComponent(contentPane, jPasswordField2, 530,202,100,22); 
 		addComponent(contentPane, jButton1, 460,275,83,28); 
 		
 		this.setTitle("NodeRegistration"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(655, 422)); 
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
  
 	private void jPasswordField2_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njPasswordField2_actionPerformed(ActionEvent e) called."); 
 		
  
 	} 
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		
		 try{
             String ipaddress="";
			 String read="";
             String nodename =jTextField1.getText();// TODO add your handling code here:
             String password = jPasswordField1.getText();
             String repassword = jPasswordField2.getText();
			 DataBaseConnection db = new DataBaseConnection();
             Connection con= db.dbconnect();
             Statement st = con.createStatement();

        if(password.equals(repassword))
		 {
             try{
			  InetAddress1();
			 FileReader fr = new FileReader("ipaddress.txt");
			 BufferedReader br = new BufferedReader(fr);
			 while((read=br.readLine())!=null)
			 {
			   ipaddress +=read;
			 }
			 System.out.println("nodename:"+nodename+"password"+password+"iadr"+iadr);
			 String query = "insert into NodeRegister values('"+nodename+"','"+password+"','"+iadr+"')";
			 Interface inf = (Interface)Naming.lookup(ipaddress+"/Server");
			 //inf.update(query);
			 inf.insertNode(nodename,password,iadr);
			 JOptionPane pane = new JOptionPane();
             int aa=pane.showConfirmDialog(null,"Node is Registered do you want to login","",pane.YES_NO_OPTION );
              System.out.println(aa);
			  if(aa==0)
			 {
			   new Login();
			   this.dispose();
			  }
			  else
			 {
			   JOptionPane.showMessageDialog(null,"register nodes ");
			   
			 }
             
             }
			 catch(Exception es)
			 {
			   es.printStackTrace();
			 }
       
           }
     else{
         JOptionPane.showMessageDialog(null,"Enter The Details Properly" );
        
        }
    }
    catch(Exception ae)
    {
        ae.printStackTrace();
    }
                                      
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
 		new NodeRegistration(); 
 	} 
 
  
  
 } 
  
 