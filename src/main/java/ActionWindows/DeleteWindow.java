package ActionWindows;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import FrameLook.Panels;
import Functions.SideChanger;

public class DeleteWindow extends JFrame{

	JButton yes = new JButton("Yes");
	
	JLabel info = new JLabel("Are you sure?");
	
	public DeleteWindow(){
		
		setLayout(new FlowLayout());
		
		yes.setSize(80, 40);
		
		setLocation(600,300);
		setSize(220,90);
		setTitle("Delete");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		
		yes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					File to_del = new File(Panels.getLastPath(SideChanger.getSide()));
					to_del.delete();
					dispose();
					Panels.repaintingTree(SideChanger.getSide().pathPlace, SideChanger.getSide().tree, SideChanger.getSide().model,SideChanger.getSide().pathPlace.getText());
				}catch(NullPointerException e1) {
					dispose();
					JOptionPane.showMessageDialog(null, "You have to choose file");
				}
			}
		});
		
		
		add(info);
		add(yes);
	}
}
