package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ActionWindows.NewFolderWindow;


public class NewFolderButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		//Running new Window to name new file
		new NewFolderWindow();
	}

}
