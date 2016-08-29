package com.linusapps.collectionvisualizer.controller;

import java.util.Collections;
import java.util.List;
import com.linusapps.collectionvisualizer.model.CustomArrayList;
import com.linusapps.collectionvisualizer.model.CustomLinkedList;

/**
 * This class represents the Controller for the Collection Visualizer.
 * @author linus
 *TODO: This is obviously still a work in progress! Please dont hate.
 */
public class CollectionVisualizerController<E> {

	/**
	 * This holds the Data structures that will be used for Demonstration.
	 */
	private static CustomArrayList<Integer> theArrayList;
	private static CustomLinkedList<Integer> theLinkedList;

	public CollectionVisualizerController(){
		theArrayList = new CustomArrayList<Integer>();
		theLinkedList = new CustomLinkedList<Integer>();

	}

	/**
	 * Initialize the lists with a various size.
	 * @param size
	 */
	public static void initializeLists(int size){
		for(int i = 0; i < size; ++i){
			theArrayList.add(i);
			theLinkedList.add(i);
		}


	}

	/**
	 * Main method. To remove later!
	 * @param args
	 */
	public static void main(String... args){
		CollectionVisualizerController c = new CollectionVisualizerController();
		c.initializeLists(21);
		//theArrayList.draw();
		//theLinkedList.draw();
		theArrayList.drawContainingItem(10);
		theLinkedList.drawContainingItem(10);

	}


}
