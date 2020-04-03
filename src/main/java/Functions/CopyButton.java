package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import FrameLook.Panels;

public class CopyButton implements ActionListener{

	
	static File copied_file;
	
	public void actionPerformed(ActionEvent e) {
		try {
			
			//Copy and assign to variable last choosed node
			copied_file = new File(Panels.getLastPath(SideChanger.getSide()));
			
			//Message success
			JOptionPane.showMessageDialog(null, "File copied");
			
		}catch(NullPointerException e1) {
			
			//Message if there was no choosed node
			JOptionPane.showMessageDialog(null, "You have to choose file");
		}
		
	}
	
	//Method returns node that was copied
	//Used in paste method
	public static File getCopy() {
		return copied_file;
	}

}
