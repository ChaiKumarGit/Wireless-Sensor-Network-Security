import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessageReceiver extends JFrame
{
	
	private JLabel jLabel1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JPanel contentPane;
	String message ="";
	


	public MessageReceiver(String msg)
	{
		super();
		initializeComponent();
		
        message = msg;
		this.setVisible(true);
	}

	
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		
		jLabel1.setIcon(new ImageIcon("images\\404.jpg"));
		jLabel1.setText("jLabel1");
		
		jTextArea1.setText("");
		
		jScrollPane1.setViewportView(jTextArea1);
		
		jButton1.setText("View Message");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		addComponent(contentPane, jLabel1, -3,5,354,347);
		addComponent(contentPane, jScrollPane1, 379,70,253,319);
		addComponent(contentPane, jButton1, 471,414,83,28);
		
		this.setTitle("Receiver");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(657, 502));
	}

	
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	
	private void jButton1_actionPerformed(ActionEvent e)
	{
		
		//new Decryption();
		jTextArea1.setText(message);
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
		new MessageReceiver("");
	}
//= End of Testing =


}
