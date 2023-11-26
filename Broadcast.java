 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.net.*;
 import java.io.*;
 
 public class Broadcast extends JFrame 
 { 
 	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
	private JLabel jLabel5; 
 	private JTextField jTextField1; 
 	private JTextField jTextField2; 
 	private JTextField jTextField3; 
 	private JComboBox jComboBox1; 
 	private JButton jButton1; 
 	private JButton jButton2; 
 	private JPanel contentPane; 
	ServerSocket socketA;
	Socket sockA;
	ServerSocket socketB;
	Socket sockB;
	ServerSocket socketC;
	Socket sockC;
	String msg="";
	String message="";
	String nodename="";
	String textfield1="";
	String textfield2="";
	String []keyvalues;
	String key ="";
	String pkey ="";
	String qkey ="";
	String i="";
	String readA="";
	String readB="";
	String readC="";
 	
  
  
 	public Broadcast(String keyvalue) 
 	{ 
 		super(); 
 		initializeComponent(); 
        keyvalues = keyvalue.split("#");
		textfield1 = keyvalues[0];
		textfield2 = keyvalues[1];
 		jTextField1.setText(textfield1);
        jTextField2.setText(textfield2);
		
  
 		this.setVisible(true); 
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
 		jComboBox1 = new JComboBox(); 
 		jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
         //
		 //jcombobox1
		 jComboBox1.addItem("NodeA");
         jComboBox1.addItem("NodeB");
		 jComboBox1.addItem("NodeC");
 		
 		jLabel1.setBackground(new Color(255, 255, 255)); 
 		jLabel1.setForeground(new Color(51, 102, 0)); 
 		jLabel1.setText(" Broadcast"); 
 		
 		jLabel2.setBackground(new Color(255, 255, 255)); 
 		jLabel2.setIcon(new ImageIcon("images\\400_F_14045833_bhBK58v9H8R0EXiDRGecFe7oiN6VnyEF.jpg")); 
 		jLabel2.setText("jLabel2"); 
 		
 		jLabel3.setText("PubValue:"); 
 		
 		jLabel4.setText("PriValue:"); 
		
 		jLabel5.setText("Destination:"); 
 		
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
 		
 		jComboBox1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				
					jComboBox1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		jButton1.setBackground(new Color(255, 255, 255)); 
 		jButton1.setForeground(new Color(0, 0, 255)); 
 		jButton1.setText(" Browse"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		jButton2.setBackground(new Color(255, 255, 255)); 
 		jButton2.setForeground(new Color(0, 51, 204)); 
 		jButton2.setText("Send"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton2_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(255, 255, 255)); 
 		addComponent(contentPane, jLabel1, 260,6,66,27); 
 		addComponent(contentPane, jLabel2, 3,34,365,384); 
 		addComponent(contentPane, jLabel3, 378,92,60,18); 
 		addComponent(contentPane, jLabel4, 377,142,60,23); 
		addComponent(contentPane, jLabel5, 376,203,60,18);
 		addComponent(contentPane, jTextField1, 520,89,100,22); 
 		addComponent(contentPane, jTextField2, 521,141,100,22); 
 		addComponent(contentPane, jTextField3, 381,248,115,22); 
 		addComponent(contentPane, jComboBox1, 521,194,100,22); 
 		addComponent(contentPane, jButton1, 524,246,83,28); 
 		addComponent(contentPane, jButton2, 467,317,83,28); 
 		
 		this.setTitle("Data Response to node"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(653, 451)); 
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
  
 	private void jComboBox1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called."); 
 		 
 		Object o = jComboBox1.getSelectedItem(); 
	    nodename = o.toString();
 		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected."); 
 		
 	} 
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		
		
		try
		{
			int b;
			msg="";
				FileDialog fd=new FileDialog(this,"Open",FileDialog.LOAD);
				fd.show();
				FileInputStream fos=new FileInputStream(fd.getDirectory()+fd.getFile());
				jTextField3.setFont(new Font("Serif", Font.PLAIN, 18));
				jTextField3.setText(fd.getDirectory()+fd.getFile());
				while((b=fos.read())!=-1)
				{
					msg+=(char)b;
                   

				}
				
			
 
		}
		catch (Exception ee)
		{
			JOptionPane.showMessageDialog(null,"Reload File Again..");
		}
		
		
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
  
 	} 
  
 	private void jButton2_actionPerformed(ActionEvent e) 
 	{ 
 	  message = "textmessage";
	  textfield1= jTextField1.getText();
	  textfield2 = jTextField2.getText();
      key = textfield1+"#"+textfield2+"#";
	 

	 if (nodename.equalsIgnoreCase("NodeA"))
		{
		try
		  {
			FileReader frA = new FileReader("nodeAddress.txt");
			BufferedReader brA= new BufferedReader(frA);
			while((i=brA.readLine())!=null)
			  {
			   readA += i;
			  }
			sockA = new Socket(readA,777);

			DataOutputStream dos = new DataOutputStream(sockA.getOutputStream());
			dos.writeUTF(message);//textfile message
			System.out.println(msg);
			dos.writeUTF(msg);//content
			
		  }
		catch (Exception es)
		  {
			es.printStackTrace();
		  }
		}
		else if(nodename.equalsIgnoreCase("NodeB"))
		{
		   try
		  {
			FileReader frB = new FileReader("nodeAddress.txt");
			BufferedReader brB= new BufferedReader(frB);
			while((i=brB.readLine())!=null)
			  {
			   readB += i;
			  }
			sockB = new Socket(readB,888);
			DataOutputStream dos = new DataOutputStream(sockB.getOutputStream());
			dos.writeUTF(message);//firstwrite
			dos.writeUTF(msg);//secondwrite
		  }
		catch (Exception es)
		  {
			es.printStackTrace();
		  }
		}
		else if(nodename.equalsIgnoreCase("NodeC"))
		{
		  
		try
		  {
			
			FileReader frC = new FileReader("nodeAddress.txt");
			BufferedReader brC= new BufferedReader(frC);
			while((i=brC.readLine())!=null)
			  {
			   readC += i;
			  }
			sockC = new Socket(readC,999);
			DataOutputStream dos = new DataOutputStream(sockC.getOutputStream());
			dos.writeUTF(message);
			dos.writeUTF(msg);

		  }
		catch (Exception es)
		  {
			es.printStackTrace();
		  }
		
		}
		else 
		{
		   try
		   {
			
			sockA = new Socket(readA,777);
			DataOutputStream dos1 = new DataOutputStream(sockA.getOutputStream());
			dos1.writeUTF(message);
			dos1.writeUTF(msg);
			
			
		   }
		   catch (Exception ex)
		   {
		    ex.printStackTrace();
		   }
		
		}

		System.out.println("\njButton2_actionPerformed(ActionEvent e) called."); 
 		
  
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
 		new Broadcast("12#13#"); 
 	} 

  
  
 } 
  
 