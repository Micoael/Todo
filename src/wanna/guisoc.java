package wanna;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JEditorPane;

public class guisoc extends JFrame{
	private JTextField Tplan;
	private JTextField Tdesc;
	Container desktopPane = null;
	public guisoc() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		JInternalFrame inframe = new JInternalFrame("hi", true, true, true, true);
		JEditorPane textPlan = new JEditorPane();
		inframe.setLocation(20, 20);
		setMinimumSize(new Dimension(20,20));
		inframe.setSize(298, 243);
		inframe.setVisible(true);
		
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
				if(Tdesc.isEnabled()&&Tplan.isEnabled()){
					Tdesc.setVisible(false);
					Tplan.setVisible(false);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
					textPlan.setVisible(true);
					lbDesc.setVisible(false);
					lbPlan.setVisible(false);
					//String html = "<html><p>你现在打算"+Tplan.getText+"<span style ='color'+"
				}else{
					Tdesc.setVisible(true);
					Tplan.setVisible(true);
					inframe.setTitle(Tplan.getText()+" - "+Tdesc.getText().substring(0,2)+" ...");
					textPlan.setVisible(false);
					lbDesc.setVisible(true);
					lbPlan.setVisible(true);
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
}
