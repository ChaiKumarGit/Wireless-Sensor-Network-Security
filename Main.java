import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
	
	private JLabel jLabel1,jLabel2;
	private JButton jButton1;
	private JPanel contentPane;
	


	public Main()
	{
		super();
		initializeComponent();
		

		this.setVisible(true);
	}

	
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jButton1 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		jLabel1.setIcon(new ImageIcon("images\\ist2_8080443-internet.gif"));
		jLabel1.setText("jLabel1");
		
		jLabel2.setIcon(new ImageIcon("images\\security.gif"));
		jLabel2.setText("jLabel2");
		
		jButton1.setText("SIGN IN");
		jButton1.setFont(new Font("alpha",Font.BOLD,25));
		jButton1.setBackground(new Color(122,222,111));
		jButton1.setForeground(new Color(122,222,111));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(153, 153, 255));
		addComponent(contentPane, jLabel1, -5,179,600,500);
		addComponent(contentPane, jLabel2, 10,10,832,155);
		addComponent(contentPane, jButton1, 583,313,99,38);
		
		this.setTitle("Wireless Sensor Network Security model using Zero Knowledge Protocol");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(860, 650));
	}

	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	
	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		new NodeRegistration();
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
		new index();
	}


}
