package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ActionWindows.MoveWindow;

public class MoveButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		//Running new Window to move file
		new MoveWindow();
		
	}
	
	
}
