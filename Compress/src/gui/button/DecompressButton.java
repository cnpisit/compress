package gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class DecompressButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -1034375876909673231L;

	public DecompressButton(String title) {
		super(title);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getClass());
	}

}
