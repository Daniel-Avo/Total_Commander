package Functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JOptionPane;

import FrameLook.Panels;

public class PasteButton implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		try {
				//Using copy method
				copyFolder(new File(CopyButton.getCopy().toString()),new File(Panels.getLastPath(SideChanger.getSide())+"\\"+CopyButton.getCopy().getName()));
				
				//Repainting tree
				Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
				
		} catch (NullPointerException e1) {
			
			//Message when there is no copied file
			//When getCopy() method from CopyButton returns null
			JOptionPane.showMessageDialog(null, "No file to paste");
			
		} catch (IOException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

    private static void copyFolder(File sourceFolder,File destinationFolder) throws IOException
    {
        //Check if sourceFolder is a directory or file
        if (sourceFolder.isDirectory()) {
        	
            //Verify if destinationFolder is already present; If not then create it
            if (!destinationFolder.exists()) {
            	
                destinationFolder.mkdir();
            }
             
            String files[] = sourceFolder.list();

            for (String file : files){
            	
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);

                copyFolder(srcFile, destFile);
            }
        }
        else
        {
            //Copy the file content from one place to another 
            Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
