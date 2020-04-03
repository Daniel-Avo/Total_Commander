package FrameLook;

import java.io.File;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;

//This class allow the JTree to display files
class TreeConstructor implements TreeModel {
	
	//To constructor we need to give path
	//From where it it starts painting a tree
	protected File root;
	public TreeConstructor(File root) { this.root = root; }
	  
	//Giving root of a tree
	public Object getRoot() {
		return root;
	}
	
	//Function to change root 
	public void rootChanger(Object parent) {
		this.root = (File)parent;
	}

	//Returns File object for each node in tree
	//Allows JTree to paint it
	public Object getChild(Object parent, int index) {
		String[] children = ((File)parent).list();
		if((children.length<=index)||(children == null))return null;
		return new File((File)parent,children[index]);
	}

	//Gives number of nodes in tree
	public int getChildCount(Object parent) {
		String[] children = ((File)parent).list();
		if(children == null) return 0;
		return children.length;
	}

	//Tells if the node is Leaf(node that do not have children)
	public boolean isLeaf(Object node) {  return ((File)node).isFile(); }

	//Gives position of child in parent node
	public int getIndexOfChild(Object parent, Object child) {
		   String[] children = ((File)parent).list();
		    if (children == null) return -1;
		    String childname = ((File)child).getName();
		    for(int i = 0; i < children.length; i++) {
		      if (childname.equals(children[i])) return i;
		    }
		    return -1;
	}
	
	/*
	 * Not used methods
	 */
	public void valueForPathChanged(TreePath path, Object newValue) {}

	public void addTreeModelListener(TreeModelListener l) {}

	public void removeTreeModelListener(TreeModelListener l) {}

}
