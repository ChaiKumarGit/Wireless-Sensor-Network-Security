import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.*;
import java.net.*;
import java.io.*;

public class Nodemsg extends JFrame
{
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField jTextField1;
	private JTextArea jTextArea2;
	private JScrollPane jScrollPane2;
	private JButton jButton1;
	private JPanel contentPane;
	

	ServerSocket socketA;
	Socket sockA;
	ServerSocket socketAA;
	Socket sockAA;
	String message="";
	String nodename="";
	String fileread="";
	String read ="";
	String iadr ="";
	String averagekeyvalue ="";
	


	public Nodemsg()
	{
		super();
		initializeComponent();
		this.setVisible(true);
		try
		 {
			socketA = new ServerSocket(1111);
			
			   sockA = socketA.accept();
			   DataInputStream dis = new DataInputStream(sockA.getInputStream());
			    message = dis.readUTF();
                nodename = dis.readUTF();
              jTextField1.setText(nodename);
              jTextArea2.append(message);
			
		 }
		 catch (Exception ae)
		 {
			 ae.printStackTrace();
		 }

		
	}

	
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jTextField1 = new JTextField();
		jTextArea2 = new JTextArea();
		jScrollPane2 = new JScrollPane();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		
		jLabel1.setBackground(new Color(255, 255, 255));
		jLabel1.setForeground(new Color(51, 51, 255));
		jLabel1.setText(" Request Receiver");
		
		jLabel2.setBackground(new Color(255, 255, 255));
		jLabel2.setIcon(new ImageIcon("images\\computer.gif"));
		jLabel2.setText("jLabel2");
		
		jLabel3.setText(" Request Message From Node:");
		
		jLabel4.setBackground(new Color(255, 255, 255));
		jLabel4.setText(" View Message:");
		
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		jTextArea2.setText(message);
		
		jScrollPane2.setViewportView(jTextArea2);
		
		jButton1.setForeground(new Color(51, 51, 255));
		jButton1.setText(" Send Response");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		addComponent(contentPane, jLabel1, 192,12,97,27);
		addComponent(contentPane, jLabel2, -37,99,278,308);
		addComponent(contentPane, jLabel3, 253,122,156,23);
		addComponent(contentPane, jLabel4, 257,186,82,20);
		addComponent(contentPane, jTextField1, 440,120,100,25);
		addComponent(contentPane, jScrollPane2, 441,176,100,100);
		addComponent(contentPane, jButton1, 340,316,116,28);
		
		this.setTitle("NodeMessage");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(561, 447));
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
   public void  InetAddress1()
	{
		try
		{
	      InetAddress  ia = InetAddress.getLocalHost();
	      //System.out.println(ia);
	      iadr= ia.getHostAddress();
		  System.out.println(iadr);
		  //String sa = iadr;
			
		}
		catch ( Exception e)
		{
		 e.printStackTrace();
		}
	
	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		
	 try
		 {
			FileReader fr = new FileReader("ipaddress.txt");
		     BufferedReader br = new BufferedReader(fr);
			 while((fileread=br.readLine())!=null)
			 {
			   read = fileread;
			 }
			
		   Interface inf = (Interface)Naming.lookup(read+"/Server");
		   averagekeyvalue = inf.average();
		   System.out.println(averagekeyvalue);
		   sockAA = new Socket(nodename,4444);
		   DataOutputStream ds = new DataOutputStream(sockAA.getOutputStream());
		   ds.writeUTF(averagekeyvalue);//first write to new node.
		   JOptionPane jpane = new JOptionPane();
		   jpane.showMessageDialog(null,"The Partial key values has been send to the requested new node");
			
			
		 }
		 catch (Exception es)
		 {
		   es.printStackTrace();
		 }
		
		
		
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		
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
				
		new Nodemsg();
	
	
	}


}
