package gui.button;

import gui.CompresserFrame;
import gui.menu.item.OpenMenuItem;
import gui.radio.MethodChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import asset.Asset;

import tools.LZ78;
import tools.LZW;
import tools.Tools;

public class CompressButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -1034375876909673231L;
	private JFrame compresserFrame;
	public static String destination = null;
	public String chooser= null; 
	

	public CompressButton(String title, JFrame mainFrame) {
		super(title);
		this.compresserFrame = mainFrame;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(getParent());
		this.destination = jfc.getSelectedFile().getPath();
		
		LZW lzw = new LZW();
		LZ78 lz78 = new LZ78();
		chooser =  MethodChooser.method; 

		
		if(chooser.equals("lzw")){
		try {
			lzw.compress(new FileInputStream(OpenMenuItem.filePath), new FileOutputStream(destination));
			System.out.println("success with LZW");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.compresserFrame.validate();
		}
		else if(chooser.equals("lz78")){
			try {
				lz78.compress(new FileInputStream(OpenMenuItem.filePath), new FileOutputStream(destination));
				System.out.println("success with LZ78");
			} catch ( IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
