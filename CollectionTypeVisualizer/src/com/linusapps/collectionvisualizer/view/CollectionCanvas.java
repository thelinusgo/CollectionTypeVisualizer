package com.linusapps.collectionvisualizer.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import com.linusapps.collectionvisualizer.model.CustomArrayList;
/**
 * This represents the canvas that will be drawn on. 
 * @author linus
 *
 */
public class CollectionCanvas extends JPanel{
	
	private CollectionFrame collectionFrame;
	private CustomArrayList<Integer> theList;
	private CustomArrayList<Integer> theLinkedList;
	
	public CollectionCanvas(CollectionFrame collectionFrame){
		this.collectionFrame = collectionFrame;
		theList = collectionFrame.controller().getArrayList();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("This is a very long test string", 50, 50);

	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1201,620);
	}
	

		
}
