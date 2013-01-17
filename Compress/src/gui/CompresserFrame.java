package gui;

import gui.button.CompressButton;
import gui.button.DecompressButton;
import gui.menubar.CompresserMenuBar;
import gui.radio.MethodChooser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import tools.Tools;
import asset.Asset;

public class CompresserFrame extends JFrame {

	private static final long serialVersionUID = 1159140659861253290L;
	public static final Dimension DEFAULT_SIZE = new Dimension(400, 520);
	public JPanel northPanel = new JPanel();
	public JPanel centerPanel = new JPanel();
	public JPanel topcontent = new JPanel();
	private JTextArea content =new JTextArea();
	JPanel radioPanel = new JPanel();
//	public static JRadioButton lz78;
//	public static JRadioButton lz;
	

	public JTextArea getContent() {
		return content;
	}

	public void setContent(JTextArea content) {
		this.content = content;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
	
	public JPanel getTopContentPanel(){
		return topcontent;
	}
	public void setTopContentPanel(JPanel topcontent) {
		this.topcontent = topcontent;
	}

	public CompresserFrame(String title) {
		super(title);
		this.setSize(DEFAULT_SIZE);
//		this.setResizable(false);
		this.setLayout(new BorderLayout(5, 5));

		this.initializeMenu();
		this.initializeButton();
		this.initializePanel();

		this.setVisible(true);
		this.setLocation(getMidPoint());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initializeRadioBotton();
	}
	
	private void initializeRadioBotton(){
		ButtonGroup b = new ButtonGroup();
		MethodChooser lzw = new MethodChooser("LZW", this);
		MethodChooser lz78 = new MethodChooser("LZ78", this);
		b.add(lzw); b.add(lz78);
		this.northPanel.add(lzw);
		this.northPanel.add(lz78);
		
//		this.radioPanel.add(lz78);
//		this.radioPanel.add(lzw);
	}

	private void initializeMenu() {
		this.setJMenuBar(new CompresserMenuBar(this));
	}

	private void initializeButton() {
		this.northPanel.add(new CompressButton("Compress", this));
		this.northPanel.add(new DecompressButton("Decompress", this));
	}

	private void initializePanel() {
		this.add(northPanel, BorderLayout.NORTH);
		initializeCenterPanel();
		this.add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeCenterPanel() {
		this.content.setWrapStyleWord(true);
		this.content.setLineWrap(true);
		this.content.setCaretPosition(0);
		this.content.setEditable(false);
		JScrollPane jScrollPane = new JScrollPane(this.content);
		

		this.centerPanel.setLayout(new BorderLayout());
		this.centerPanel.add(jScrollPane);
	}

	private Point getMidPoint() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		return new Point((screenSize.width - frameSize.width) / 3, (screenSize.height - frameSize.height) / 3);
	}

}
