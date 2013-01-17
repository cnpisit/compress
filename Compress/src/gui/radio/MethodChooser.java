package gui.radio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MethodChooser extends JRadioButton implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame compresserFrame;
	public static String method;
	
	
	public MethodChooser(String title, JFrame mainFrame){
		super(title);
		this.compresserFrame = mainFrame;
		this.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String comd = arg0.getActionCommand();
//		System.out.println(comd);
		if(comd=="LZW"){
			this.method="lzw";
		}
		else{
			this.method="lz78";
		}

	}

	
}
