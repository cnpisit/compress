package gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DecompressButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -1034375876909673231L;
	private JFrame compresserFrame ;

	public DecompressButton(String title, JFrame mainFrame) {
		super(title);
		this.compresserFrame =  mainFrame;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//code decompress writen here
		System.out.println(this.getClass());
	}

}
