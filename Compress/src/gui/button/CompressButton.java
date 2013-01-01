package gui.button;

import gui.CompresserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import asset.Asset;

import tools.Tools;

public class CompressButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -1034375876909673231L;
	private JFrame compresserFrame;

	public CompressButton(String title, JFrame mainFrame) {
		super(title);
		this.compresserFrame = mainFrame;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			((CompresserFrame) this.compresserFrame).getCenterPanel().add(
					new JLabel(Tools.readFile(Asset.class.getResource("input/Input-File").getPath())));
		} catch (FileNotFoundException fnof) {
		} catch (IOException ioe) {
		}
		this.compresserFrame.validate();
	}

}
