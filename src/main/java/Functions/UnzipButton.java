package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import org.zeroturnaround.zip.ZipUtil;

import FrameLook.Panels;


public class UnzipButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		//Checking if file is choosed and is zip folder
		if(Panels.getLastPath(SideChanger.getSide())!=null&&Panels.getLastPath(SideChanger.getSide()).endsWith(".zip")) {
			
			//File that will be unpacked
			//and destination where will be saved
			File fileToUnzip = new File(Panels.getLastPath(SideChanger.getSide()));
			File unzippedFile = new File(Panels.getLastPath(SideChanger.getSide()).toString().substring(0,Panels.getLastPath(SideChanger.getSide()).toString().lastIndexOf('\\')));

			//Method from ZipUtils
			//Library added by Maven
			//Allows to unpack zip folders
			ZipUtil.unpack(fileToUnzip,unzippedFile);
			
			//Refreshing panel function
			Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
			
		}else {
			
			//Throws message if file was not choosed
			JOptionPane.showMessageDialog(null, "Choose zip file to unzip");
		}
		
		
	}
	
   

}
