package com.linusapps.collectionvisualizer.controller;

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
	 * This holds the Data structures that will be used for Demonstration.
	 */
	private static CustomArrayList<Integer> theArrayList;
	private static CustomLinkedList<Integer> theLinkedList;

	public CollectionVisualizerController(){
		theArrayList = new CustomArrayList<Integer>();
		theLinkedList = new CustomLinkedList<Integer>();

	}

	/**
	 * Initialize the lists with a various size, with random elements.
	 * @param size
	 */
	public static void initializeLists(int size){
		for(int i = 0; i < size; ++i){
			Collections.shuffle(theArrayList);
			int value = (int) (Math.random() * 10);
			theArrayList.add(value);
			theLinkedList.add(value);
		}
	}

	/**
	 * Main method. To remove later!
	 * @param args
	 */
	public static void main(String... args){
		CollectionVisualizerController<Integer> c = new CollectionVisualizerController<>();
		initializeLists(0);
		theArrayList.drawContainingItem(44);
	}


}
