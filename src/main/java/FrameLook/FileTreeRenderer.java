package FrameLook;

import java.awt.Component;
import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;


public class FileTreeRenderer extends DefaultTreeCellRenderer {
	
	//Method used to render tree nodes.
	//It change path printing in panels 
	//to only file names.
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {
    	
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        if (value instanceof File) {
        	
            setText(((File) value).getName());
            
        }
        
        return this;
    }

}