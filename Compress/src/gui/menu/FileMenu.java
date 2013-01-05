package gui.menu;

import gui.Constant;
import gui.menu.item.ExitMenuItem;
import gui.menu.item.OpenMenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;

public class FileMenu extends JMenu {

	private JFrame compresserFrame;
	private OpenMenuItem openMenuItem;
	private ExitMenuItem exitMenuItem;
	
	public FileMenu(String title, JFrame compresserFrame) {
		super(title);
		this.compresserFrame = compresserFrame;
		
		this.openMenuItem = new OpenMenuItem(Constant.OPEN, this.compresserFrame);
		this.exitMenuItem = new ExitMenuItem(Constant.EXIT, this.compresserFrame);
		this.add(openMenuItem);
		this.add(exitMenuItem);
	}

	private static final long serialVersionUID = -8361769954173003410L;

}
