package com.linusapps.collectionvisualizer.controller;

import java.awt.Graphics;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.linusapps.collectionvisualizer.model.CustomArrayList;
import com.linusapps.collectionvisualizer.model.CustomLinkedList;

/**
 * This class represents the Controller for the Collection Visualizer.
 * @author linus
 *TODO: This is obviously still a work in progress! Please dont hate.
 */
public class CollectionVisualizerController<E> {

	/**
	 * This holds the data structures for the Collection types.
	 * .
	 */
	private static CustomArrayList<Integer> theArrayList;
	private  CustomLinkedList<Integer> theLinkedList;
	/**
	 * The state of the controller. Can be "arraylist" or "linkedlist".
	 */
	private String controllerState = "arraylist";
	/**
	 * Boolean for determining whether a value should be removed via its index, or via the item itself.
	 */
	private boolean isIndexMode = false;
	
	public CollectionVisualizerController(){
		theArrayList = new CustomArrayList<Integer>();
		theLinkedList = new CustomLinkedList<Integer>();

	}
	
	public boolean isIndexMode(){
		return this.isIndexMode;
	}
	
	public void setisIndexMode(boolean value){
		this.isIndexMode = value;
	}
	
	public String getControllerState(){
		return this.controllerState;
	}
	
	public void setControllerState(String val){
		this.controllerState = val;
	}
	
	public CustomArrayList getArrayList(){
		return this.theArrayList;
	}
	
	public CustomLinkedList getLinkedList(){
		return this.theLinkedList;
	}

	/**
	 * Initialize the lists with a various size, with random elements.
	 * @param size
	 */
	public  void initializeLists(int size){
		for(int i = 0; i < size; ++i){
			Collections.shuffle(theArrayList);
			int value = (int) (Math.random() * 10);
			theArrayList.add(value);
			theLinkedList.add(value);
		}
	}
	
	/**
	 * Clears the lists and redraws
	 * @param g
	 */
	public void clearLists(){
	theArrayList.clear();
	theLinkedList.clear();
	}

	/**
	 * Main method. To remove later!
	 * @param args
	 */
	public static void main(String... args){
		CollectionVisualizerController c = new CollectionVisualizerController();
		//c.initializeLists(21);
		//theArrayList.draw();
		//theLinkedList.drawContainingItem(10);
		theArrayList.drawAddingItem(1);
		theArrayList.drawAddingItem(2);
		theArrayList.drawAddingItem(3);

	}


}
