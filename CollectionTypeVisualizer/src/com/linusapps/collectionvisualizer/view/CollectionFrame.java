package com.linusapps.collectionvisualizer.view;
import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * The class that represents the main GUI of this program.
 * @author linus
 *
 */
public class CollectionFrame extends JFrame{
	
	private CollectionCanvas theCanvas;
	
	/**
	 * Create a new instance of a CollectionFrame
	 */
	public CollectionFrame(){
		super("Collection Visualizer");
		theCanvas = new CollectionCanvas();
		setLayout(new BorderLayout()); 
		add(theCanvas, BorderLayout.CENTER); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); 
		setResizable(false); 
		setVisible(true); 
	}
		
}
