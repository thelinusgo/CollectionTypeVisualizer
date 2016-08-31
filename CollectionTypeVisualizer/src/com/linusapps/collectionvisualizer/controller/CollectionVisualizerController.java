package com.linusapps.collectionvisualizer.controller;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.linusapps.collectionvisualizer.model.CustomArrayList;
import com.linusapps.collectionvisualizer.model.CustomLinkedList;
import com.linusapps.collectionvisualizer.view.CollectionFrame;

/**
 * This class represents the Controller for the Collection Visualizer.
 * @author linus
 *TODO: This is obviously still a work in progress! Please dont hate.
 */
public class CollectionVisualizerController<E> {

	/* This holds the data structures for the Collection types. */
	private CustomArrayList<Integer> theArrayList;
	private CustomLinkedList<Integer> theLinkedList;
	
	private static CollectionFrame theFrame;
	
	
	/**
	 * The state of the controller. Can be "arraylist" or "linkedlist".
	 */
	private String controllerState;
	
	
	public CollectionVisualizerController(){
		theArrayList = new CustomArrayList<Integer>();
		theLinkedList = new CustomLinkedList<Integer>();
		System.out.println(theArrayList);
		System.out.println(theArrayList.size());

	}
	
	/**
	 * Return the state of the controller.
	 * @return
	 */
	public String getControllerState(){
		return this.controllerState;
	}
	
	/**
	 * Set the state of the controller to a new value.
	 * e.g. value can be "linkedlist", "arraylist" or "set"
	 * @param val
	 */
	public void setControllerState(String val){
		this.controllerState = val;
	}
	
	/**
	 * Returns the current ArrayList.
	 * @return
	 */
	public CustomArrayList getArrayList(){
		return this.theArrayList;
	}
	
	/**
	 * Returns the Current LinkedList.
	 * @return
	 */
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
	
	
	
	public static void main(String[] args){
		theFrame = new CollectionFrame();
		
	}
	
	
//	/**
//	 * Main method. To remove later!
//	 * @param args
//	 */
//	public static void main(String... args){
//		CollectionVisualizerController c = new CollectionVisualizerController();
//		//c.initializeLists(21);
//		//theArrayList.draw();
//		//theLinkedList.drawContainingItem(10);
//		theArrayList.drawAddingItem(1);
//		theArrayList.drawAddingItem(2);
//		//theArrayList.drawAddingItem(3);
//
//	}


}
