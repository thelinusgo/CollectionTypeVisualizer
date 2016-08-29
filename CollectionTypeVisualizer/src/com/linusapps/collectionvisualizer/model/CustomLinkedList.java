package com.linusapps.collectionvisualizer.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
/**
 * An Extension of a doubly LinkedList, but has methods that return the elapsed time for certain operations.
 * The method returns the elapsed time taken to perform the operation, but if it was not successful, it returns -1.
 * @author linus
 *
 * @param <E>
 */
public class CustomLinkedList<E> extends LinkedList<E> implements CustomAbstractCollection<E>{


	public CustomLinkedList() {
		super();
	}

	public CustomLinkedList(Collection <? extends E> c){
		super(c);
	}

	/**
	 * Adds an item, and returns the time taken to add that item.
	 * @return
	 */
	@Override
	public long timeToAddItem(E item){
		long startTime = System.nanoTime();
		super.add(item);
		long endTime = System.nanoTime();
		return super.add(item) == true ? endTime-startTime : -1;
	}

	/**
	 * Removes an item and returns the time taken to remove that item.
	 */
	@Override
	public long timeToRemoveItem(E item){
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
	@Override
	public long timeToCheckContains(E item){
		long startTime = System.nanoTime();
		super.contains(item);
		long endTime = System.nanoTime();
		return super.contains(item) == true ? endTime-startTime : -1;
	}

	/**
	 * Draws the list.
	 */
	@Override
	public void draw(){
		System.out.println("\nLinkedList: " + "contains " + (super.size()-1) + (super.size() > 1 ? " values" : " value"));
		for(int i = 1; i < super.size(); ++i){
			System.out.print(super.get(i).toString() + "->");

		}
		System.out.print("/NULL");
	}

	/**
	 * Draws lines up to the amount specified in the argument.
	 * @param amount
	 */
	public void drawLines(int amount){
		String s = "";
		for(int i = 0 ; i != amount; ++i){
			s+="-";
		}
		System.out.println("\n" + s);
	}

	@Override
	public void drawContainingItem(E item) {
		this.drawLines(80);
		System.out.println("Checking if list has value " + item.toString());
		boolean found = false;
		int foundIndex = -1;
		for(int i = 1; i < super.size(); ++i){
			if(super.get(i).equals(item)){
				System.out.print("**"+ super.get(i).toString() + "**->");
				found = true;
				foundIndex = i-1;
			}else
			System.out.print(super.get(i).toString() + "->");
		}
		System.out.print("/NULL");

//		if(!found){
//			System.out.println("\nItem not in this list.");
//		}


		if(foundIndex != -1){
			System.out.println("\nItem found in index " + foundIndex);
		}else{
			System.out.println("\n ¯\\_(ツ)_/¯ Item not found");
		}
		System.out.printf("It took %d ms to do this operation.", this.timeToCheckContains(item));
		this.drawLines(80);
	}

	@Override
	public void drawAddingItem(E item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawAddingItem(E item, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawRemovingItem(E item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawRemovingItem(E item, int index) {
		// TODO Auto-generated method stub

	}




}
