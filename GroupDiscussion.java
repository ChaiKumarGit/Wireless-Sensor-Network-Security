import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;

public class GroupDiscussion extends JFrame
{
	
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;

	private JLabel jLabel2;
	private JButton jButton1;
	private JPanel jPanel1;

	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;

	private JTable jTable2;
	private JScrollPane jScrollPane2;
	private JPanel jPanel3;
	


	public GroupDiscussion()
	{
		super();
		initializeComponent();
		

		this.setVisible(true);
	
	}

	
	private void initializeComponent()
	{
		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
	
		jLabel2 = new JLabel();
		jButton1 = new JButton();
		jPanel1 = new JPanel();
	
		jTable1 = new JTable();
		jScrollPane1 = new JScrollPane();
		jPanel2 = new JPanel();
	
		jTable2 = new JTable();
		jScrollPane2 = new JScrollPane();
		jPanel3 = new JPanel();
		
		
		jTabbedPane1.addTab("Initalization", jPanel1);
		
		jTabbedPane1.setBackground(new Color(255, 255, 255));
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				jTabbedPane1_stateChanged(e);
			}

		});
		
		contentPane.setLayout(null);
		addComponent(contentPane, jTabbedPane1, 2,2,653,484);
		
		jLabel2.setBackground(new Color(255, 255, 255));
		jLabel2.setIcon(new ImageIcon("images\\adhoc.gif"));
		
		
		jButton1.setText("Compute Key");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				jButton1_actionPerformed(e);
			}

		});
		
		jPanel1.setLayout(null);
		jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
		jPanel1.setBackground(new Color(153, 53, 255));
		jPanel1.setForeground(new Color(255, 55, 255));
		jPanel1.setOpaque(false);
		addComponent(jPanel1, jLabel2, 20,5,249,279);
		addComponent(jPanel1, jButton1,336,120,103,38);
		
		
		this.setTitle("Compute-Public,private Key");
		//this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(800,550));
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
   
	private void jButton1_actionPerformed(ActionEvent e)
	{
		
					
		Nodekey ky = new Nodekey();
		this.dispose();
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");

		
	     
	  }
	  
	





























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
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
		new GroupDiscussion();
	}
//= End of Testing =

}
