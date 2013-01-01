package gui;

import gui.button.CompressButton;
import gui.button.DecompressButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Help");

		JMenuItem openMenuItem = new JMenuItem("open");
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));

		openMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(e.toString());
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(getParent());
			}
		});

		JMenuItem exitMenuItem = new JMenuItem("exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CompresserFrame.this.dispose();
			}
		});

		JMenuItem aboutMenuItem = new JMenuItem("About");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* About action here */
			}
		});

		fileMenu.add(openMenuItem);
		fileMenu.add(exitMenuItem);

		editMenu.add(aboutMenuItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		this.setJMenuBar(menuBar);
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

		return new Point((screenSize.width - frameSize.width) / 3,
				(screenSize.height - frameSize.height) / 3);
	}

}
