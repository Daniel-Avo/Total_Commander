package ActionWindows;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import FrameLook.Panels;
import Functions.SideChanger;



public class MoveWindow extends JFrame{
	
	JLabel move = new JLabel("Move");
	JLabel to = new JLabel("To");
	

	JTextField arena_from = new JTextField(Panels.getLastPath(SideChanger.getSide()), 20);
	JTextField arena_to = new JTextField(20);
	
	public MoveWindow() {
		
		setLocation(600,300);
		setTitle("Move");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		arena_from.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				moving(new File(arena_from.getText()), new File(arena_to.getText()));
				dispose();
				Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
			}
		});
		
		arena_to.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				moving(new File(arena_from.getText()), new File(arena_to.getText()));
				dispose();
				Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
			}
		});
		
		add(move);
		add(arena_from);
		add(to);
		add(arena_to);
		
		pack();
	}
	
	private static void moving(File f1, File f2) {

		if(f1.exists()||f2.isDirectory()) {
			try {
				Files.move(Paths.get(f1.getAbsolutePath()), Paths.get(f2.getAbsolutePath()+"\\"+f1.getName()));
				JOptionPane.showMessageDialog(null, "Succesfully moved");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Wrong directory");
			}
		}
	}
}
