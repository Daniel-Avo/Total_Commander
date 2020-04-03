package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ActionWindows.ZipWindow;


public class ZipButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
				//Running new Window to Zip files
				new ZipWindow();
	}

}
