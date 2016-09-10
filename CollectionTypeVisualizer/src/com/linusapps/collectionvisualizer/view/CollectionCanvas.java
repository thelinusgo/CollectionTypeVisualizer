package com.linusapps.collectionvisualizer.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.linusapps.collectionvisualizer.model.CustomArrayList;
/**
 * This represents the canvas where all the painting and redrawing will be done on.
 * @author linus
 *
 */
public class CollectionCanvas extends JPanel{
	/**Holds an instance of the frame that is holding this canvas. */
	private CollectionFrame collectionFrame;
	/**Holds an instance of the ArrayList*/
	private CustomArrayList<Integer> theList;
	/**Holds an instance of the LinkedList*/
	private CustomArrayList<Integer> theLinkedList;
	
	/*Holds the Width and the height constants for the canvas dimensions.	 */
	private final int CANVAS_WD = 1201;
	private final int CANVAS_HT = 620;
	
	@SuppressWarnings("unchecked")
	public CollectionCanvas(CollectionFrame collectionFrame){
		this.collectionFrame = collectionFrame;
		theList = collectionFrame.controller().getArrayList();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1210, 567); //avoid clipping or weird artificating.
	}
	
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(CANVAS_WD,CANVAS_HT);
	}
	

		
}
