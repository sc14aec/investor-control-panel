import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class InvestorControlPanel implements Runnable{
	
	public void run() {
		
		// Windows look & feel
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// Linux look & feel
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				
				//If neither work, apply system look & feel.
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e2) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

		
		ControlFrame MainFrame = new ControlFrame("ICP: Investor Control Panel V1");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setSize(450, 450);
		MainFrame.setVisible(true);
	
	}
	
	public static void main(String args[]){
		
		// Thread for GUI.
		SwingUtilities.invokeLater(new InvestorControlPanel());
			
	}

}