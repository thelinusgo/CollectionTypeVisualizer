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
	CustomArrayList<Integer> theList;
	
	public CollectionCanvas(CollectionFrame collectionFrame){
		this.collectionFrame = collectionFrame;
		theList = collectionFrame.controller().getArrayList();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

	}
	
	
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1201,620);
	}
	
	@Override
	public void paint(Graphics g){
	theList.draw(g);
	}
		
}
