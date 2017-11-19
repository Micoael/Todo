package wanna;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class t extends JFrame{
	static DefaultListModel listset = new DefaultListModel();
	JList list = new JList(listset);
	private JTextField textField;
	public t() {
		
		
		
		getContentPane().add(list, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				add(textField.getText());
			}
		});
		getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		setVisible(true);
	}
	
	public static void add(String atr){
		listset.addElement(atr);
	}
	public static void main(String[] args) {
		new t();
		
	}
}
