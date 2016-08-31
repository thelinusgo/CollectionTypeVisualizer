package com.linusapps.collectionvisualizer.view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * This represents the canvas that will be drawn on. 
 * @author linus
 *
 */
public class CollectionCanvas extends JPanel{
	
	public CollectionCanvas(){
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1201,620);
	}
		
}
