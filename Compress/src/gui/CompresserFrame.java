package gui;

import gui.button.CompressButton;
import gui.button.DecompressButton;
import gui.menubar.CompresserMenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CompresserFrame extends JFrame {

	private static final long serialVersionUID = 1159140659861253290L;
	public static final Dimension DEFAULT_SIZE = new Dimension(240, 520);
	public JPanel northPanel = new JPanel();
	public JPanel centerPanel = new JPanel();

	public CompresserFrame(String title) {
		super(title);
		this.setSize(DEFAULT_SIZE);
		this.setResizable(false);
		this.setLayout(new BorderLayout(5, 5));

		this.initializeButton();
		this.initializeMenu();

		this.setVisible(true);
		this.setLocation(getMidPoint());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initializeMenu() {
		new CompresserMenuBar(this);
	}

	private void initializeButton() {
		this.northPanel.add(new CompressButton("Compress"));
		this.northPanel.add(new DecompressButton("Decompress"));
		this.add(northPanel);
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
