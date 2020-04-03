package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import FrameLook.Panels;

public class BackButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		//Variable that contains path to the previous directory
		String path = SideChanger.getSide().pathPlace.getText().substring(0,SideChanger.getSide().pathPlace.getText().lastIndexOf('\\'));
		
		//When previous directory is a driver for instance: D or C
		//It blocks function to do not go to previous again
		if(path.length()==2) {
			
			path= path+"\\";
			
			//Used to repaint tree nodes after getting to previous directory
			Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree,SideChanger.getSide().model,path);
			
		}
		else {
			
			//Used in normal cases when we are not in disc directory
			Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree,SideChanger.getSide().model, path);
		}
		
	}

}
