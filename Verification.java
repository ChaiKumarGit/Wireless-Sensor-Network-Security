
  import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
  
 public class Verification extends JFrame 
 { 
 	
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JTextField jTextField1; 
 	private JTextField jTextField2; 
 	private JButton jButton1; 
 	private JPanel contentPane; 
	String pvalue="";
	String qvalue="";
	String nvalue="";
	String secretkey="";
	String []keyvalues;
 	
  
  
 	public Verification(String value) 
 	{ 
 		super(); 
 		initializeComponent(); 
		this.setVisible(true); 
 		
          keyvalues = value.split("#");
		  pvalue = keyvalues[0];
		  qvalue = keyvalues[1];
		  nvalue = keyvalues[2];
          jTextField1.setText(pvalue);
          jTextField2.setText(qvalue);
 		
 	} 
  
 	
 	private void initializeComponent() 
 	{ 
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jTextField1 = new JTextField(); 
 		jTextField2 = new JTextField(); 
 		jButton1 = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		
 		jLabel1.setText("Signing And Verification"); 
 		
 		jLabel2.setBackground(new Color(255, 255, 255)); 
 		jLabel2.setIcon(new ImageIcon("images\\banner-network.jpg")); 
 		
 		jLabel3.setBackground(new Color(255, 255, 255)); 
 		jLabel3.setText("Pub Value:"); 
 		
 		jLabel4.setBackground(new Color(255, 255, 255)); 
 		jLabel4.setText("pri value:"); 
 		
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
 		
 		jButton1.setBackground(new Color(255, 255, 255)); 
 		jButton1.setText("Sign & Verify"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jButton1_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(254, 254, 254)); 
 		addComponent(contentPane, jLabel1, 155,4,120,32); 
 		addComponent(contentPane, jLabel2, 2,79,167,224); 
 		addComponent(contentPane, jLabel3, 186,98,100,31); 
 		addComponent(contentPane, jLabel4, 184,166,100,18); 
 		addComponent(contentPane, jTextField1, 333,102,100,22); 
 		addComponent(contentPane, jTextField2, 335,165,100,22); 
 		addComponent(contentPane, jButton1, 259,232,102,28); 
 		
 		this.setTitle("verfication"); 
 		this.setLocation(new Point(0, 0)); 
 		this.setSize(new Dimension(470, 407)); 
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
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 
 		
		pvalue=jTextField1.getText();
		qvalue = jTextField2.getText();
		secretkey = pvalue+"#"+qvalue+"#";
		new keyestablish(secretkey);

		System.out.println("\njButton1_actionPerformed(ActionEvent e) called."); 
 		
       this.dispose();
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
 		new Verification(""); 
 	} 
 
  
  
 } 
  
 