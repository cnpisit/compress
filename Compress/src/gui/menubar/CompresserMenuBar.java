package gui.menubar;

import gui.Constant;
import gui.menu.FileMenu;
import gui.menu.HelpMenu;
import gui.menu.item.AboutMenuItem;
import gui.menu.item.ExitMenuItem;
import gui.menu.item.OpenMenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class CompresserMenuBar extends JMenuBar {

	private static final long serialVersionUID = 4653199524130779333L;
	private JFrame mainFrame;
	private JMenu fileMenu;
	private JMenu helpMenu;

	public CompresserMenuBar(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		this.fileMenu = new FileMenu(Constant.FILE);
		this.helpMenu = new HelpMenu(Constant.HELP);

		this.fileMenu.add(new OpenMenuItem(Constant.OPEN));
		this.fileMenu.add(new ExitMenuItem(Constant.EXIT, this.mainFrame));
		this.helpMenu.add(new AboutMenuItem(Constant.ABOUT));

		this.add(this.fileMenu);
		this.add(this.helpMenu);
		
		this.mainFrame.setJMenuBar(this);
	}
}
