package gui.button;

import gui.CompresserFrame;
import gui.menu.item.OpenMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import asset.Asset;

import tools.LZW;
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
		JFileChooser jfc = new JFileChooser();
		int chooser = jfc.showSaveDialog(getParent());
		File destination = jfc.getSelectedFile();
		
		try {
			((CompresserFrame) this.compresserFrame).getCenterPanel().add(
					new JLabel(Tools.readFile(Asset.class.getResource("input/Input-File").getPath())));
		} catch (FileNotFoundException fnof) {
		} catch (IOException ioe) {
		}
		//compress code writen here.
		
		String content = null ;
//		String filepath = null;
		try {
			System.out.println(OpenMenuItem.filePath);
			content = Tools.readFile(OpenMenuItem.filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(LZW.compress(content).getClass());
		try {
			Tools.writeToFile(destination.getPath(), LZW.compress(content));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		this.compresserFrame.validate();
	}

}
