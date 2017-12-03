package animation;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonToLocation extends JFrame implements Runnable{
	JButton btnNewButton = new JButton("New button");
	public JButtonToLocation() {
		this.setVisible(true);
		getContentPane().setLayout(null);
		this.setSize(618,393);
		
		
		
		btnNewButton.setBounds(206, 182, 113, 27);
		getContentPane().add(btnNewButton);
	}
	
	
	
	public void JbtnToLocation(JButton jbtn,int destX,int destY,int speed) throws InterruptedException{
		int btnX=jbtn.getX();
		int btnY=jbtn.getY();
		if(btnX-destX>0){
			if(btnY-destY>0){
				while(btnY-destY!=0){
					jbtn.setLocation(jbtn.getX(), jbtn.getY()-speed*20);
					btnY=jbtn.getY();
					
					//update(this.getGraphics());
					Thread.sleep(10);
					System.out.println(btnY-destY);
				}
			}else if(btnY-destY<0){
				while(btnY-destY!=0){
					jbtn.setLocation(jbtn.getX(), jbtn.getY()+1);
					btnY=jbtn.getY();
					
					//update(this.getGraphics());
					Thread.sleep(10);
					System.out.println(btnY-destY);
				}
			}
			while(btnX-destX!=0){
				jbtn.setLocation(jbtn.getX()-1, jbtn.getY());
				btnX=jbtn.getX();
				
				//update(this.getGraphics());
				Thread.sleep(10);
			}
		}else if(btnX-destX<0){
			if(btnY-destY>0){
				while(btnY-destY!=0){
					jbtn.setLocation(jbtn.getX(), jbtn.getY()-1);
					btnY=jbtn.getY();
					
					//update(this.getGraphics());
					Thread.sleep(10);
					System.out.println(btnY-destY);
				}
			}else if(btnY-destY<0){
				while(btnY-destY!=0){
					jbtn.setLocation(jbtn.getX(), jbtn.getY()+1);
					btnY=jbtn.getY();
					
					//update(this.getGraphics());
					Thread.sleep(10);
					System.out.println(btnY-destY);
				}
			}
			while(btnX-destX!=0){
				jbtn.setLocation(jbtn.getX()+1, jbtn.getY());
				
				//update(this.getGraphics());
				Thread.sleep(10);
				btnX=jbtn.getX();
			}
		}
	}
	public static void main(String[] args) {
		new JButtonToLocation().run();
		
	}
	@Override
	public void run() {
		//while(true){
			try {
				JbtnToLocation(btnNewButton,-1,520);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			//}
		
	}
}
	}
