package Functions;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import FrameLook.Panels;

//Class that jump from one panel to another, it provides no collision with choosing files from trees
public class SideChanger {

	//Contains information about actually used panel 
	private static int side_checker= 0;
	
	private static Panels left;
	private static Panels right;
	
	public SideChanger(Panels left,Panels right) {
		this.left = left;
		this.right = right;
	}
	
	public void sideChanger() {
		
		left.tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				
				//When tree node was selected it clears selection from right panel and change site
				right.tree.clearSelection();
				side_checker = 0;
			}
		});
		
		right.tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				
				//When tree node was selected it clears selection from left panel and change site
				left.tree.clearSelection();
				side_checker = 1;
			}
		});
		
	}
	
	//Method that gives information to other methods which panel is actually used
	public static Panels getSide(){
		
		if(side_checker==0) return left;
		else return right;
		
	}
}
