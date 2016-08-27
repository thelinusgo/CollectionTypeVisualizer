package com.linusapps.collectionvisualizer.model;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * An Extension of a  LinkedList, but has methods that return the elapsed time for certain operations.
 * The method returns the elapsed time taken to perform the operation, but if it was not successful, it returns -1.
 * @author linus
 *
 * @param <E>
 */
public class CustomLinkedList<E> extends LinkedList<E>{
	
	
	public CustomLinkedList() {
		super();
	}

	
	/**
	 * Adds an item, and returns the time taken to add that item.
	 * @return
	 */
	public long addItem(E item){
		long startTime = System.nanoTime();
		super.add(item);
		long endTime = System.nanoTime();
		return super.add(item) == true ? endTime-startTime : -1; 
	}
	
	/**
	 * Removes an item and returns the time taken to remove that item.
	 */
	public long removeItem(E item){
		long startTime = System.nanoTime();
		super.remove(item);
		long endTime = System.nanoTime();
		return super.remove(item) == true ? endTime-startTime : -1; 
	}
	
	/**
	 * Returns how long it checks to find an item.
	 * @param item
	 * @return
	 */
	public long checkContains(E item){
		long startTime = System.nanoTime();
		super.contains(item);
		long endTime = System.nanoTime();
		return super.contains(item) == true ? endTime-startTime : -1; 
	}
	
	
}
