/**
 * 
 */
package gui.menu.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class AboutMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 7510835448282502427L;

	public AboutMenuItem(String title) {
		super(title);
		this.addActionListener(this);
		this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
