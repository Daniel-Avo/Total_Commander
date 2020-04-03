package ActionWindows;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import FrameLook.Panels;
import Functions.SideChanger;


public class NewFolderWindow extends JFrame{

	//Adding label and text field
	JLabel label = new JLabel("New Folder name:");
	
	static JTextField newFolderName = new JTextField(20);
	
	public NewFolderWindow(){
		
		//Window appearance 
		setLayout(new FlowLayout());
		setLocation(600,300);
		setTitle("New Folder");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//Adding action after clicking enter button in text area
		newFolderName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Creating new file interpretation
				File newFile = new File(Panels.getLastPath(SideChanger.getSide())+'\\'+newFolderName.getText());
				
				//Making directory by method mkdir(),
				//throwing a message if ends successfull,
				//closing window and repainting tree nodes
				if(newFile.mkdir()) {
					
					JOptionPane.showMessageDialog(null, "Folder has been successfully created");
					dispose();
					
					Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
				}
				
				
			}
		});
		
		//Adding components
		add(label);
		add(newFolderName);
		
		pack();
	}
}
