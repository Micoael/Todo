package wanna;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;
import java.awt.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JInternalFrame1 extends JFrame implements ActionListener {
	JTextField Tplan;
	JTextField Tdesc;
	JDesktopPane desktopPane;
	int count = 1;
	//a constructor.
	public JInternalFrame1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		super("JInternalFrame1");
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Container contentPane = this.getContentPane();

		JButton b = new JButton("Add");
		b.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		
		desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 332, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 275, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b))
		);
		getContentPane().setLayout(groupLayout);

		setSize(583, 463);
		show();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
      		//ToDo: Write the logs into the databank.
				System.exit(0);
			}
		});
	}

	/*
	 * 产生一个可关闭、可改变大小、具有标题、可最大化与最小化的Internal Frame.
	 */
	public void actionPerformed(ActionEvent e) {
		
		try {
			addNewList("hi");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	* This method is a add method and it could add a new frame in the JFrame.
	*Usage: addNewJList
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	*
	**/
	public void addNewList(String titlename) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		JInternalFrame inframe = new JInternalFrame(titlename, true, true, true, true);

		inframe.setLocation(20, 20);
		setMinimumSize(new Dimension(20,20));
		inframe.setSize(274, 187);
		inframe.setVisible(true);
		
		Tplan=new JTextField();
		Tdesc=new JTextField();
		JLabel lbPlan=new JLabel("Plan");
		JLabel lbDesc=new JLabel("Descs");
		
		
		
		
		Tplan.setBounds(48, 12, 188, 30);
		lbPlan.setBounds(0, 0, 65, 50);
		lbPlan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbDesc.setBounds(0, 43, 50, 50);
		lbDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Tdesc.setBounds(48, 52, 188, 37);
		JButton btnE = new JButton("\u221A / e");
		btnE.setBounds(84, 102, 88, 27);
		inframe.setMaximizable(false);
		//inframe.setClosable(false);
		
		
		
		
		
		
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tdesc.isEnabled()&&Tplan.isEnabled()){
					Tdesc.setEnabled(false);
					Tplan.setEnabled(false);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
				}else{
					Tdesc.setEnabled(true);
					Tplan.setEnabled(true);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
				}
				
				
			}
		});
		
		Tplan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				inframe.setTitle(Tplan.getText());
			}
		});
		inframe.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		inframe.getContentPane().add(lbPlan);
		inframe.getContentPane().add(lbDesc);
		inframe.getContentPane().add(Tplan);
		inframe.getContentPane().add(Tdesc);
		inframe.getContentPane().setLayout(null);
		inframe.getContentPane().add(btnE);
		
		desktopPane.add(inframe);

	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		new JInternalFrame1();
	}
}
