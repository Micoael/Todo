package wanna;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;
import java.awt.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.Window.Type;

public class JInternalFrame1 extends JFrame implements ActionListener {
	JTextField Tplan;
	JTextField Tdesc;
	JDesktopPane desktopPane;
	int count = 1;
	//a constructor.
	public JInternalFrame1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		super("JInternalFrame1");
		setType(Type.UTILITY);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		Container contentPane = this.getContentPane();
		
		JScrollPane scrollPane = new JScrollPane();
		
		desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 559, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 374, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		
				JButton b = new JButton("Add");
				b.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
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
		JInternalFrame inframe = new JInternalFrame("hi", true, true, true, true);
		JEditorPane textPlan = new JEditorPane();
		inframe.setLocation(20, 20);
		setMinimumSize(new Dimension(20,20));
		inframe.setSize(298, 243);
		inframe.setVisible(true);
		textPlan.setVisible(false);
		Tplan=new JTextField();
		Tplan.setForeground(Color.BLACK);
		Tdesc=new JTextField();
		JLabel lbPlan=new JLabel("\u8BA1\u5212");
		JLabel lbDesc=new JLabel("\u63CF\u8FF0");
		
		
		
		
		Tplan.setBounds(67, 10, 188, 33);
		lbPlan.setBounds(26, 10, 41, 30);
		lbPlan.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lbDesc.setBounds(26, 70, 41, 30);
		lbDesc.setFont(new Font("等线", Font.PLAIN, 17));
		Tdesc.setBounds(67, 53, 188, 67);
		JButton btnE = new JButton("\u5B8C\u6210");
		btnE.setBounds(84, 151, 88, 27);
		inframe.setMaximizable(false);
		//inframe.setClosable(false);
		
		
		
		
		
		
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Tdesc.isVisible()&&Tplan.isVisible()){
					Tdesc.setVisible(false);
					Tplan.setVisible(false);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
					textPlan.setVisible(true);
					lbDesc.setVisible(false);
					lbPlan.setVisible(false);
					btnE.setText("编辑");
					//String html = "<html><p>你现在打算"+Tplan.getText+"<span style ='color'+"
				}else{
					Tdesc.setVisible(true);
					Tplan.setVisible(true);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
					textPlan.setVisible(false);
					lbDesc.setVisible(true);
					lbPlan.setVisible(true);
					btnE.setText("完成");
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
				
			}
		});
		
		
		
		inframe.getContentPane().add(lbPlan);
		inframe.getContentPane().add(lbDesc);
		inframe.getContentPane().add(Tplan);
		inframe.getContentPane().add(Tdesc);
		inframe.getContentPane().setLayout(null);
		inframe.getContentPane().add(btnE);
		
		
		textPlan.setEditable(false);
		textPlan.setText("hidden...");
		textPlan.setBounds(0, 0, 280, 139);
		inframe.getContentPane().add(textPlan);
		
		
		desktopPane.add(inframe);

	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		new JInternalFrame1();
	}
}