package gui.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ExitMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 8762331990424074148L;
	private JFrame frameToExit ;

	public ExitMenuItem(String title, JFrame frameToExit) {
		super(title);
		this.frameToExit = frameToExit;
		this.addActionListener(this);
		this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.frameToExit.dispose();
	}

}
