package gui.textfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextFile extends JTextField implements ActionListener {
	
//	private static final long serialVersionUID = 1L;
	private JTextField compresserFrame;
	
	public JTextFile() {
		// TODO Auto-generated constructor stub
//		super(title);
//		this.compresserFrame = mainFrame;
		this.addActionListener(this);
		
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
