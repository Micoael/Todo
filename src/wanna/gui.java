package wanna;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class gui extends JFrame{
	JTextField Tplan;
	JTextField Tdesc;
	JDesktopPane desktopPane;
	int count = 1;
	String code;
	
	public gui() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		/**
		 * SETS
		 */
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		JInternalFrame inframe = new JInternalFrame("hi", true, true, true, true);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		JInternalFrame inframe1 = new JInternalFrame("\u65B0\u5EFA", true, true, true, true);
		inframe1.setLocation(20, 20);
		setMinimumSize(new Dimension(20,20));
		inframe1.setSize(272, 173);
		inframe1.setVisible(true);
		JButton btnE = new JButton("\u221A");
		btnE.setBounds(105, 0, 40, 27);
		inframe1.setMaximizable(false);
		Tdesc=new JTextField();
		Tdesc.setHorizontalAlignment(SwingConstants.CENTER);
		
		Tdesc.setBounds(16, 86, 227, 35);
		inframe1.getContentPane().add(Tdesc);
		Tdesc.setText("\u5728\u8FD9\u91CC\u8F93\u5165\u8BA1\u5212\u63CF\u8FF0");
		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		JLabel textPlan = new JLabel();
		textPlan.setBounds(6, 34, 251, 87);
		inframe1.getContentPane().add(textPlan);
		textPlan.setHorizontalAlignment(SwingConstants.CENTER);
		textPlan.setVisible(true);
		desktopPane.add(inframe1);
		inframe1.getContentPane().setLayout(null);
		inframe1.getContentPane().add(btnE);
		Tplan=new JTextField();
		Tplan.setBounds(16, 39, 227, 35);
		inframe1.getContentPane().add(Tplan);
		Tplan.setHorizontalAlignment(SwingConstants.CENTER);
		Tplan.setText("\u5728\u8FD9\u91CC\u8F93\u5165\u60A8\u7684\u8BA1\u5212");
		Tplan.setForeground(Color.BLACK);
		
		/*
		 * Mouse Event
		 */
		
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code="<html><p style='text-align: center;'><span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'>"+Tplan.getText()+"</span></strong></span></p><hr/><p style='text-align: center;'>"+Tdesc.getText()+"<span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'></span></strong></span><br/></p><p style='text-align: center;'><br/></p></html>";
				if(Tdesc.isVisible()&&Tplan.isVisible()){
					//IS AVALIABLE TO UNAVALIABLE.
					code="<html><p style='text-align: center;'><span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'>"+Tplan.getText()+"</span></strong></span></p><hr/><p style='text-align: center;'>"+Tdesc.getText()+"<span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'></span></strong></span><br/></p><p style='text-align: center;'><br/></p></html>";
					textPlan.setText(code);
					Tdesc.setVisible(false);
					Tplan.setVisible(false);
					
					inframe1.setTitle(Tplan.getText()+" - "+Tdesc.getText());
					textPlan.setVisible(true);
					
					btnE.setText("/");
					//String html = "<html><p>ƒ„œ÷‘⁄¥ÚÀ„"+Tplan.getText+"<span style ='color'+"
				}else{
					code="<html><p style='text-align: center;'><span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'>"+Tplan.getText()+"</span></strong></span></p><hr/><p style='text-align: center;'>"+Tdesc.getText()+"<span style='color: rgb(0, 32, 96);'><strong><span style='font-size: 18px;'></span></strong></span><br/></p><p style='text-align: center;'><br/></p></html>";
					textPlan.setText(code);
					Tdesc.setVisible(true);
					Tplan.setVisible(true);
					inframe1.setTitle(Tplan.getText()+" - "+Tdesc.getText());
					textPlan.setVisible(false);
					
					
					btnE.setText("°Ã");
				}
				
				
			}
		});
		inframe1.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				
			}
		});
		
		Tplan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				inframe1.setTitle(Tplan.getText());
			}
			@Override
			public void focusGained(FocusEvent e) {
				Tplan.setText("");
			}
		});
		Tdesc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Tdesc.setText("");
			}
		});
	}

}
