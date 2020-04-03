package FrameLook;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.rmi.server.LoaderHandler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Functions.BackButton;
import Functions.CopyButton;
import Functions.DeleteButton;
import Functions.MoveButton;
import Functions.NewFolderButton;
import Functions.PasteButton;
import Functions.SideChanger;
import Functions.UnzipButton;
import Functions.ZipButton;



public class Window extends JFrame {
	
	//Panels objects 
	public static Panels leftPanel = new Panels();
	public static Panels rightPanel = new Panels();
	
	//Side Changer instance to jump from one to another
	static SideChanger side_changer = new SideChanger(leftPanel, rightPanel);
	
	//It contains all Buttons
	JToolBar toolbar = new JToolBar();
	
	//It allows to get two Panels
	JSplitPane SplitPane;
	
	/*
	 * In this section all buttons getting their icons 
	 */	
	ImageIcon move= new ImageIcon("icons/move.png");
	JButton movebutton = new JButton(move);
	
	ImageIcon copy = new ImageIcon("icons/copy.png");
	JButton copybutton = new JButton(copy);
	
	ImageIcon paste = new ImageIcon("icons/paste.png");
	JButton pastebutton = new JButton(paste);
	
	ImageIcon delete= new ImageIcon("icons/delete.png");
	JButton deletebutton = new JButton(delete);
	
	ImageIcon zip= new ImageIcon("icons/zip.png");
	JButton zipbutton = new JButton(zip);
	
	ImageIcon unzip= new ImageIcon("icons/unzip.png");
	JButton unzipbutton = new JButton(unzip);
	
	ImageIcon back= new ImageIcon("icons/back.png");
	JButton backbutton = new JButton(back);
	
	
	ImageIcon newFolder = new ImageIcon("icons/NewFolder.png");
	JButton newFolderButton  = new JButton(newFolder);
	
	public Window(){
		
		//Sets icon in window
		setIcon();
		
		/*
		 * In this section all buttons getting their functionality and tool tips
		 */
		newFolderButton.setToolTipText("Create new folder");
		newFolderButton.addActionListener(new NewFolderButton());
		
		movebutton.setToolTipText("Move");
		movebutton.addActionListener(new MoveButton());
		
		copybutton.setToolTipText("Copy");
		copybutton.addActionListener(new CopyButton());
		
		pastebutton.setToolTipText("Paste");
		pastebutton.addActionListener(new PasteButton());
		
		deletebutton.setToolTipText("Delete");
		deletebutton.addActionListener(new DeleteButton());
		
		zipbutton.setToolTipText("Zip");
		zipbutton.addActionListener(new ZipButton());
		
		unzipbutton.setToolTipText("Unzip");
		unzipbutton.addActionListener(new UnzipButton());
		
		backbutton.setToolTipText("Back");
		backbutton.addActionListener(new BackButton());
		
		/*
		 * Adding all buttons to toolbar
		 */
		add(toolbar , BorderLayout.NORTH);
		toolbar.add(newFolderButton);
		toolbar.add(movebutton);
		toolbar.add(copybutton);
		toolbar.add(pastebutton);
		toolbar.add(deletebutton);
		toolbar.add(zipbutton);
		toolbar.add(unzipbutton);
		toolbar.add(backbutton);
		
		//Adding listeners to panels
		side_changer.sideChanger();
		
		//Window appearance 
		SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel);
		SplitPane.setDividerLocation(500);
		add(SplitPane);
		setTitle("Total Commander");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setSize(1000, 600);
	}

	//Method used to set icon in window
	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/Total-Commander-icon.png"));
		
	}
	
}
