package main;


import javax.swing.SwingUtilities;

import FrameLook.Window;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				//Running new Window
				new Window();
				
			}
		});
		
	}

}
