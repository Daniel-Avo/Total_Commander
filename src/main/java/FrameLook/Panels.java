package FrameLook;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import ActionWindows.DeleteWindow;

//Class contains Panels functionality to print trees
public class Panels extends JPanel{

	File f1 = new File("C:\\Users");
	
	//Starting tree model
	public TreeConstructor model = new TreeConstructor(f1);

	public JTree tree = new JTree(model);

	public JTextField pathPlace = new JTextField(100);
	
	JScrollPane scrollPane = new JScrollPane(tree);
	
	Panels(){
		 
		pathPlace.setText("C:\\Users");
		
		//Sets rendering to avoid all paths printing
		tree.setCellRenderer(new FileTreeRenderer());
		
		tree.addMouseListener(new MouseListener() {
			
			//If node was double cilcked it jumps to it
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {      
					System.out.println();
					
					//Used for repaint tree after choosing the node
					repaintingTree(pathPlace, tree, model);
				}
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			/*
			 * Not overrided methods
			 */
			
		});
		
		//Repaints the tree if new directory was written in text field
		pathPlace.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Used to repaint tree after pressing enter button
				repaintingTree(pathPlace, tree, model, pathPlace.getText());
			
			}
		});
		
		setLayout(new BorderLayout());
		add(scrollPane);
		add(pathPlace,BorderLayout.NORTH);
	}
	
	//Used after taking some action for example: delete, paste etc.
	//to repaint tree if some nodes was changed
	public static void repaintingTree(JTextField pathPlace, JTree tree, TreeConstructor model){
		
		File place = new File(tree.getLastSelectedPathComponent().toString());
		
		if(place.isDirectory()) {
			
			pathPlace.setText(tree.getLastSelectedPathComponent().toString());
			
			model = new TreeConstructor(place);
			
			tree.setModel(model);
			tree.repaint();
	}}
	
	//Overloaded repainting tree method 
	//used to repaint tree for text field in Panel section
	public static void repaintingTree(JTextField pathPlace, JTree tree, TreeConstructor model, String path){
		
		File place = new File(path);
		
		if(place.isDirectory()) {
			
			pathPlace.setText(path);
			
			model = new TreeConstructor(place);
			
			tree.setModel(model);
			tree.repaint();
			}
		else {
			
			//Called if directory was wrong
			JOptionPane.showMessageDialog(null, "Wrong directory");
		}
	}

	//Gives last choosed node path
	public static String getLastPath(Panels panel) {
		try {
			
			return panel.tree.getLastSelectedPathComponent().toString();
			
		}catch (NullPointerException e) {
			
			return null;
		}
	}
}
