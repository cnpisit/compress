package gui.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class OpenMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = -793626679121029988L;

	public OpenMenuItem(String title) {
		super(title);
		this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(getParent());
	}

}
