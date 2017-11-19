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
	static JList list = new JList(listset);
	private JTextField textField;
	JButton btnAdd = new JButton("ADD ");
	private final JButton btnRemove = new JButton("REMOVE");
	boolean isOp=true;
	private final JScrollPane scrollPane = new JScrollPane();
	public t() {
		setBackground(UIManager.getColor("Button.focus"));
		setSize(490, 414);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 345, 472, 22);
		
		getContentPane().add(textField);
		textField.setColumns(10);
		btnAdd.setBounds(401, 3, 71, 342);
		btnAdd.setForeground(Color.GREEN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0){
					addNewPlan(textField.getText());
					if(!isOp)
						textField.setText("");
				}
			}
		});
		
		
		getContentPane().add(btnAdd);
		btnRemove.setBounds(0, 3, 83, 342);
		btnRemove.setForeground(Color.RED);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveAPlan();
			}
		});
		
		getContentPane().add(btnRemove);
		scrollPane.setBounds(84, 3, 329, 342);
		
		getContentPane().add(scrollPane);
		list.setFont(new Font("等线", Font.BOLD, 23));
		scrollPane.setViewportView(list);
		list.setValueIsAdjusting(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setVisible(true);
	}
	
	public static void addNewPlan(String atr){
		listset.addElement(atr);
	}
	public static void RemoveAPlan(){
		try{
			if(list.getSelectedIndex()==-1){
				list.setSelectedIndex(0);
			}
			listset.remove(list.getSelectedIndex());
			
		}catch(ArrayIndexOutOfBoundsException ee){
			ee.printStackTrace();
			
		}
	}
	public static void main(String[] args) {
		new t();
		//getContentPane().add("222");
		//getContentPane().add("555");
	}
}
