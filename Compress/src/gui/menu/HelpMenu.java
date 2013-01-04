package gui.menu;

import gui.Constant;
import gui.menu.item.AboutMenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;

public class HelpMenu extends JMenu {

	private static final long serialVersionUID = -4332243209859924860L;
	private JFrame compresserFrame;
	private AboutMenuItem aboutMenuItem;

	public HelpMenu(String title, JFrame compresserFrame) {
		super(title);
		this.aboutMenuItem = new AboutMenuItem(Constant.ABOUT);
		this.add(aboutMenuItem);
	}

}
