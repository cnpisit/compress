package gui.menu.item;

import gui.CompresserFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import tools.Tools;

public class OpenMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = -793626679121029988L;
	public static String filePath = null;
	private JFrame compresserFrame;

	public OpenMenuItem(String title, JFrame compresserFrame) {
		super(title);
		this.compresserFrame = compresserFrame;
		this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(getParent());
		OpenMenuItem.filePath = jfc.getSelectedFile().getPath();
		
		try {
			((CompresserFrame)this.compresserFrame).getContent().setText(Tools.readFile(filePath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
