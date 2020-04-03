package ActionWindows;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.zeroturnaround.zip.ZipUtil;

import FrameLook.Panels;
import Functions.SideChanger;

public class ZipWindow extends JFrame{

	//Labes in window
	JLabel zip = new JLabel("Zip");
	JLabel to = new JLabel("To");
	
	//Text areas
	static JTextField arena_from;
	static JTextField arena_to;
	
	public ZipWindow(){
		
		//If any node was not choosed it prints empty areas
		//Which can be filled
		try {
			
			//Initiates fields with last choosen node and its zip interpretation
			arena_from= new JTextField(Panels.getLastPath(SideChanger.getSide()));
			File name = new File(Panels.getLastPath(SideChanger.getSide()));
			arena_to = new JTextField(Panels.getLastPath(SideChanger.getSide()).substring(0,Panels.getLastPath(SideChanger.getSide()).lastIndexOf("\\")+1)+name.getName()+".zip",20);
			
		}catch(NullPointerException e){
			
			arena_to = new JTextField(20);
			arena_from = new JTextField(20);
			
		}
	
		//Window appearance 
		setLocation(600,300);
		setTitle("Zip");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//Adding action after clicking enter button in text area
		arena_from.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//File to zip and destination 
				File directoryChecker = new File(arena_from.getText());
				File zippedFile = new File(arena_from.getText()+".zip");
				
				//Checks if it is directory or file
				if(directoryChecker.isDirectory()) {
					
						//Zips the directory and close window
						//Method from ZipUtils
						//Library added by Maven
						ZipUtil.pack(directoryChecker, zippedFile);
						dispose();
				        
				}else {
					
					//Zips the file and close window
					//Method from ZipUtils
					//Library added by Maven
					ZipUtil.packEntry(directoryChecker, new File(arena_from.getText().substring(0,arena_from.getText().lastIndexOf('.'))+".zip"));
					dispose();
				}
				
				
				//Repaints tree nodes
				Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
				
			}
		});
		
		//Adding action after clicking enter button in text area
		arena_to.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//File to zip and destination 
				File directoryChecker = new File(arena_from.getText());
				File zippedFile = new File(arena_from.getText()+".zip");
				
				//Checks if it is directory or file
				if(directoryChecker.isDirectory()) {
					
						//Zips the directory and close window
						//Method from ZipUtils
						//Library added by Maven
						ZipUtil.pack(directoryChecker, zippedFile);
						dispose();
				        
				}else {
					
					//Zips the file and close window
					//Method from ZipUtils
					//Library added by Maven
					ZipUtil.packEntry(directoryChecker, new File(arena_from.getText().substring(0,arena_from.getText().lastIndexOf('.'))+".zip"));
					dispose();
				}
				
				
				//Repaints tree nodes
				Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
				
			}
		});
		
		//Adding all buttons
		add(zip);
		add(arena_from);
		add(to);
		add(arena_to);
		
		pack();
	}
	
	
	
}