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
	
	private static CustomArrayList<Integer> arrayListTest;
	private static CustomLinkedList<Integer> linkedListTest;
	
	public CollectionVisualizerController(){
		arrayListTest = new CustomArrayList<Integer>();
		linkedListTest = new CustomLinkedList<Integer>();
	
	}
	
	public static void initializeLists(int size){
		assert size > 0 || size < Integer.MAX_VALUE : "TOO BIG";
		
		for(int i = 0; i < size; ++i){
			arrayListTest.add(i);
			linkedListTest.add(i);
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String... args){
		CollectionVisualizerController c = new CollectionVisualizerController();
		c.initializeLists(100);
		
		System.out.println("Contains for value: 23");
		System.out.println("ArrayList: " + arrayListTest.checkContains(23) + " ms");
		System.out.println("LinkedList: " +  linkedListTest.checkContains(23) + " ms");
		
		System.out.println("Add value: 101");
		System.out.println("ArrayList: " + arrayListTest.addItem(101) + " ms");
		System.out.println("LinkedList: " +  linkedListTest.addItem(101) + " ms");
		
		System.out.println("Remove value: 57");
		System.out.println("ArrayList: " + arrayListTest.removeItem(57) + " ms");
		System.out.println("LinkedList: " +  linkedListTest.removeItem(57) + " ms");

		
		
	}


}
