package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ActionWindows.DeleteWindow;

public class DeleteButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		//Running new Window to delete files
		new DeleteWindow();
		
	}

}
