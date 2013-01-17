package gui.button;

import gui.menu.item.OpenMenuItem;
import gui.radio.MethodChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import tools.LZ78;
import tools.LZW;

public class DecompressButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -1034375876909673231L;
	private JFrame compresserFrame ;
	public String destination = null;
	public String chooser = null;

	public DecompressButton(String title, JFrame mainFrame) {
		super(title);
		this.compresserFrame =  mainFrame;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//code decompress writen here
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(getParent());
		this.destination = jfc.getSelectedFile().getPath();
		chooser = MethodChooser.method;
		LZW lzw = new LZW();
		LZ78 lz78 = new LZ78();
		
		if(chooser.equals("lzw")){
			try {
				lzw.decompress(new FileInputStream(OpenMenuItem.filePath), new FileOutputStream(destination));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (chooser.equals("lz78")){
			try {
				lz78.decompress(new FileInputStream(OpenMenuItem.filePath), new FileOutputStream(destination));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
//		System.out.println(this.getClass());
	}

}
