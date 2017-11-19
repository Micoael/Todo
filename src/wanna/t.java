package wanna;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class t extends JFrame{
	static DefaultListModel listset = new DefaultListModel();
	JList list = new JList(listset);
	private JTextField textField;
	JButton btnAdd = new JButton("ADD ");
	private final JButton btnRemove = new JButton("REMOVE");
	public t() {
		setSize(490, 414);
		
		
		getContentPane().add(list, BorderLayout.CENTER);
		
		textField = new JTextField();
		
		getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0){
					addNewPlan(textField.getText());
					textField.setText("");
				}
			}
		});
		
		
		getContentPane().add(btnAdd, BorderLayout.NORTH);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					listset.remove(list.getSelectedIndex());
				}catch(ArrayIndexOutOfBoundsException){
					
				}
			}
		});
		
		getContentPane().add(btnRemove, BorderLayout.WEST);
		setVisible(true);
	}
	
	public static void addNewPlan(String atr){
		listset.addElement(atr);
	}
	public static void main(String[] args) {
		new t();
		//getContentPane().add("222");
		//getContentPane().add("555");
	}
}
