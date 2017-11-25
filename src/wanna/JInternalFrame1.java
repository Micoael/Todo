package wanna;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;
import java.awt.*;

public class JInternalFrame1 extends JFrame implements ActionListener {
	JTextField Tplan;
	JTextField Tdesc;
	JDesktopPane desktopPane;
	int count = 1;
	//a constructor.
	public JInternalFrame1() {
		super("JInternalFrame1");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JButton b = new JButton("Add an new plan");
		b.addActionListener(this);
		contentPane.add(b, BorderLayout.SOUTH);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
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

		setSize(350, 350);
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
		
		addNewList("hi");
	}
	/**
	* This method is a add method and it could add a new frame in the JFrame.
	*Usage: addNewJList
	*
	**/
	public void addNewList(String titlename){
		
		JInternalFrame inframe = new JInternalFrame(titlename, true, true, true, true);

		inframe.setLocation(20, 20);
		
		inframe.setSize(200, 200);
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
		
		
		
		
		inframe.getContentPane().add(lbPlan);
		inframe.getContentPane().add(lbDesc);
		inframe.getContentPane().add(Tplan);
		inframe.getContentPane().add(Tdesc);
		inframe.getContentPane().setLayout(null);
		inframe.getContentPane().add(btnE);
		
		desktopPane.add(inframe);

	}
	
	public static void main(String[] args) {
		new JInternalFrame1();
	}
}
