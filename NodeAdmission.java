 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import javax.swing.JOptionPane;
 import javax.swing.event.*; 
 import javax.swing.table.*;
 import java.io.*;
 import java.net.*;
 import java.rmi.*;


public class NodeAdmission extends JFrame
{
	
 	private JTabbedPane jTabbedPane1; 
 	private JPanel contentPane; 
 	//----- 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
	private JLabel jLabel5;
 	private JRadioButton jRadioButton1; 
	private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
	private ButtonGroup btnGroup1;
 	private JButton jButton1; 
 	private JPanel jPanel1; 
 	//----- 
 	private JTable jTable1; 
 	private JScrollPane jScrollPane1; 
	private JButton jButton2;
 	private JPanel jPanel2; 
	
 	String iadr="";
	String portnumber="";
	String nodename="";
	String nodeaddress="";
	String keyvalue="";
	String read="";
	String ipadrs="";
	String i="";
	
	String []partialkeys;
	String IPAddress="";
	String pvalue="";
	String qvalue="";
	ServerSocket socketA;
	Socket socketAA;
	ServerSocket socketBB;
	ServerSocket socketCC;
	Socket socket1;
	Socket socket2;
	Socket socket3;
	

	public NodeAdmission(String nodename)
	{
		super();
		initializeComponent();
		

		this.setVisible(true);
	}

	
	private void initializeComponent()
	{
		jTabbedPane1 = new JTabbedPane(); 
 		contentPane = (JPanel)this.getContentPane();
        contentPane.setBackground(new Color(155, 200, 255)); 		
 		//----- 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
		jLabel5 = new JLabel();
 		jRadioButton1 = new JRadioButton(); 
		jRadioButton2 = new JRadioButton(); 
		jRadioButton3 = new JRadioButton();
		btnGroup1 = new ButtonGroup();
 		jButton1 = new JButton(); 
		//jButton2 = new JButton();
 		jPanel1 = new JPanel(); 
 		//----- 
 		jTable1 = new JTable(); 
 		jScrollPane1 = new JScrollPane(); 
 		jPanel2 = new JPanel(); 
 		
 		jTabbedPane1.addTab("Request", jPanel1); 
 		//jTabbedPane1.addTab("Response", jPanel2); 
 		jTabbedPane1.setBackground(new Color(155, 0, 255)); 
 		jTabbedPane1.addChangeListener(new ChangeListener() { 
 			public void stateChanged(ChangeEvent e) 
 			{ 
 				jTabbedPane1_stateChanged(e); 
 			} 
  
 		}); 
 		
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(155, 200, 255)); 
 		addComponent(contentPane, jTabbedPane1, 0,1,568,507); 
 		
 		jLabel2.setIcon(new ImageIcon("images\\globe_animation_clean.gif"));
		jLabel2.setText("Zero Knowledge Protocol (ZKP) Node Verifying"); 
 		 
 		jLabel3.setBackground(new Color(155, 200, 255)); 
 		jLabel3.setIcon(new ImageIcon("images\\3638445778_63ec894ed5_m.jpg")); 
 		jLabel3.setText("jLabel3"); 
 		
 		jLabel4.setText("Select The Query Type;"); 
 		
		jLabel5.setIcon(new ImageIcon("images\\globe_animation_clean.gif"));
        jLabel5.setText("Zero Knowledge Protocol (ZKP)");
		
		
 		jRadioButton1.setBackground(new Color(155, 200, 255)); 
 		jRadioButton1.setText("Man in the Middle"); 
		jRadioButton1.setSelected(true);
 		jRadioButton1.addItemListener(new ItemListener() { 
 			public void itemStateChanged(ItemEvent e) 
 			{ 
 				jRadioButton1_itemStateChanged(e); 
 			} 
  
 		}); 
		
             jRadioButton2.setBackground(new Color(155, 200, 255)); 
 		     jRadioButton2.setText("Clone "); 
 		     //jRadioButton2.setSelected(true); 
 		     jRadioButton2.addItemListener(new ItemListener() { 
 			  public void itemStateChanged(ItemEvent e) 
 			{ 
 				jRadioButton2_itemStateChanged(e); 
 			} 
  
 		    }); 
		
		
             jRadioButton3.setBackground(new Color(155, 200, 255)); 
 		     jRadioButton3.setText("Replay"); 
 		     //jRadioButton3.setSelected(true); 
 		     jRadioButton3.addItemListener(new ItemListener() { 
 			  public void itemStateChanged(ItemEvent e) 
 			{ 
 				jRadioButton3_itemStateChanged(e); 
 			} 
  
 		    }); 
 		 
 		jButton1.setText("Submit"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
		
 		jPanel1.setLayout(null); 
 		jPanel1.setBackground(new Color(155, 200, 255)); 
 		jPanel1.setOpaque(false); 
 		addComponent(jPanel1, jLabel2, 59,8,504,74); 
 		addComponent(jPanel1, jLabel3, 4,36,187,361); 
 		addComponent(jPanel1, jLabel4, 264,121,199,28); 
 		addComponent(jPanel1, jRadioButton1, 306,170,135,24); 
        addComponent(jPanel1, jRadioButton2, 306,234,135,24);
        addComponent(jPanel1, jRadioButton3, 306,284,135,24);
 		addComponent(jPanel1, jButton1, 300,335,83,28); 
 		
		
		btnGroup1.add(jRadioButton1);
		btnGroup1.add(jRadioButton2);
		btnGroup1.add(jRadioButton3);
		
		
 		jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null,null},
                {null, null, null, null},
                {null, null, null,null},
				{null, null, null,null},
                {null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
                {null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
                {null, null, null,null},
				{null, null, null,null},
				{null, null, null,null},
                {null, null, null,null}
            },
            new String [] {
                "IPaddress","pvalue","qvalue"
            }
        ));
 		
 		jScrollPane1.setViewportView(jTable1); 
 		jScrollPane1.setBackground(new Color(155, 200, 255)); 
 		
 		jPanel2.setLayout(null);
 		jPanel2.setBackground(new Color(155, 200, 255)); 
 		jPanel2.setOpaque(false); 
		addComponent(jPanel2, jLabel5, 159,8,504,74);
 		addComponent(jPanel2, jScrollPane1, 66,105,413,146); 
       
 		this.setTitle("New Node"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(585, 544)); 
 	} 
  
 
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	 
 	private void jTabbedPane1_stateChanged(ChangeEvent e) 
 	{ 
 		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called."); 
 		
  
 	} 
  
 	private void jRadioButton1_itemStateChanged(ItemEvent e) 
 	{ 
 		System.out.println("\njRadioButton1_itemStateChanged(ItemEvent e) called."); 
 		System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		
 		 
 	} 
	private void jRadioButton2_itemStateChanged(ItemEvent e) 
 	{ 
 		System.out.println("\njRadioButton2_itemStateChanged(ItemEvent e) called."); 
 		System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 				
 		 
 	} 
	private void jRadioButton3_itemStateChanged(ItemEvent e) 
 	{ 
 		
		System.out.println("\njRadioButton3_itemStateChanged(ItemEvent e) called."); 
 		System.out.println(">>" + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected":"unselected")); 
 		
 		 
 	} 
   
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 				 int update=0;
				 String message ="";
		         ServerSocket sock1;
				 Socket s;
				 String datas="";
				 String nodename="";
				 String ipadrs="";
				 String portnumber="";
				
	             
				 String messg = "";
					
				 
		if(jRadioButton1.isSelected())
		{
		  
		  
		  try
		  {
			     
				 FileReader fr = new FileReader("nodeaddress.txt");
				 BufferedReader br = new BufferedReader(fr);
				 while((read=br.readLine())!=null)
			     {
                  nodeaddress += read;
				 }
				 message = "JOIN_REQ";
				   
					socket1 = new Socket("localhost",1111);
                    DataOutputStream ds1 = new DataOutputStream(socket1.getOutputStream());
				 	ds1.writeUTF(message);//send request to group nodes.
					ds1.writeUTF(nodeaddress);
					JOptionPane jpane = new JOptionPane();
					jpane.showMessageDialog(null,"JOIN_REQ:Request has send to NodeA"+nodeaddress);
					
		            socketA = new ServerSocket(4444);
		            socketAA = socketA.accept();
					 DataInputStream dis = new DataInputStream(socketAA.getInputStream());
                     keyvalue = dis.readUTF();
                    jpane.showMessageDialog(null,"key received"+nodeaddress);
					
		  }

		  catch (Exception ex)
		  {
		    ex.printStackTrace();
		  }
		 
		}
		 else if(jRadioButton2.isSelected())
		{
		  JOptionPane jpane1 = new JOptionPane();
		  jpane1.showMessageDialog(null,"Clone node attack..verify Key"+nodeaddress);
		  
		   new Verification(keyvalue);
		  
		}
		
		else if(jRadioButton3.isSelected())
		{
		  
		   new Broadcast(keyvalue);
		   this.dispose();
		}
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
  
 	} 
 
	public void setData(Object o,int x,int  y)
	{
		jTable1.getModel().setValueAt(o,x,y);
	}
     
   public void tabledata()
	{
	   int x=0,y=0;
	  try
	  {
		 FileReader fr = new FileReader("ipaddress.txt");
	     BufferedReader br = new BufferedReader(fr);
	    while((i=br.readLine())!=null)
			    {
		          ipadrs+=i;
				 }
		Interface inf = (Interface)Naming.lookup(ipadrs+"/Server");
	   String average = inf.average();
		String  partial= inf.keyvalues();
		partialkeys = partial.split("#");
		IPAddress = partialkeys[0];
		pvalue = partialkeys[1];
		qvalue = partialkeys[2];
           setData(IPAddress,x,y);
		   y++;
		   setData(pvalue,x,y);
		   y++;
		   setData(qvalue,x,y);
		    x+=1;
		   y=0;
	  

		  }

	  
	  catch (Exception ae)
	  {
	    ae.printStackTrace();
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
		new NodeAdmission("");
	}


}
