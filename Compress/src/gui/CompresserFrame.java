package gui;

import gui.button.CompressButton;
import gui.button.DecompressButton;
import gui.menubar.CompresserMenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import tools.Tools;
import asset.Asset;

public class CompresserFrame extends JFrame {

	private static final long serialVersionUID = 1159140659861253290L;
	public static final Dimension DEFAULT_SIZE = new Dimension(240, 520);
	public JPanel northPanel = new JPanel();
	public JPanel centerPanel = new JPanel();

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public CompresserFrame(String title) {
		super(title);
		this.setSize(DEFAULT_SIZE);
		this.setResizable(false);
		this.setLayout(new BorderLayout(5, 5));

		this.initializeMenu();
		this.initializeButton();
		this.initializePanel();

		this.setVisible(true);
		this.setLocation(getMidPoint());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeMenu() {
		new CompresserMenuBar(this);
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
		JTextArea jTextArea = new JTextArea();
//		new JScrollPane(jTextArea).setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String contents = null;
		try {
			contents = Tools.readFile(Asset.class.getResource("input/Input-File").getPath());
		} catch (Exception e) {
		}

		jTextArea.setText(contents);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setLineWrap(true);
		jTextArea.setCaretPosition(0);
		jTextArea.setEditable(false);
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		

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
