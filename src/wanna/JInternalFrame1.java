import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JInternalFrame1 extends JFrame implements ActionListener {

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
		JInternalFrame internalFrame = new JInternalFrame("Internal Frame "
				+ (count++), true, true, true, true);

		internalFrame.setLocation(20, 20);
		internalFrame.setSize(200, 200);
		internalFrame.setVisible(true);
		
		Container icontentPane = internalFrame.getContentPane();
		JTextArea textArea = new JTextArea();
		JButton b = new JButton("Internal Frame Button");
		/*
		 * 将JTextArea与JButton对象加入JInternalFrame中。由此呆知，JInteranlFrame加入组件
		 * 的方式与JFrame是一模一样。
		 */
		icontentPane.add(textArea, "Center");
		icontentPane.add(b, "South");
	
		desktopPane.add(internalFrame);

		try {
			internalFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException ex) {
			System.out.println("Exception while selecting");
		}
	}
	/**
	* This method is a add method and it could add a new frame in the JFrame.
	*Usage: addNewJList
	*
	**/
	public void addNewList(String titlename){
		JInternalFrame internalFrame = new JInternalFrame(titlename, true, true, true, true);

		internalFrame.setLocation(20, 20);
		//TODO: Let the interalFrame *Seprate*
		internalFrame.setSize(200, 200);
		internalFrame.setVisible(true);
		
		Container icontentPane = internalFrame.getContentPane();
		JTextArea textArea = new JTextArea();
		JButton b = new JButton("Internal Frame Button");
		/*
		 * 将JTextArea与JButton对象加入JInternalFrame中。由此呆知，JInteranlFrame加入组件
		 * 的方式与JFrame是一模一样。
		 */
		icontentPane.add(textArea, "Center");
		icontentPane.add(b, "South");
	
		desktopPane.add(internalFrame);

	}
	
	public static void main(String[] args) {
		new JInternalFrame1();
	}
}
