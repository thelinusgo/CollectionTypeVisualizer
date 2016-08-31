package com.linusapps.collectionvisualizer.model;

import java.awt.Graphics;
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
		boolean isSuccessful = super.add(item);
		long endTime = System.nanoTime();
		return isSuccessful == true ? endTime-startTime : -1;
	}

	/**
	 * Removes an item and returns the time taken to remove that item.
	 */
	@Override
	public long timeToRemoveItem(E item){
		long startTime = System.nanoTime();
		boolean isSuccessful = super.remove(item);
		long endTime = System.nanoTime();
		return isSuccessful == true ? endTime-startTime : -1;
	}
	
	/**
	 * Removes an item and returns the time taken to remove that item at the specified index.
	 */
	
	public long timeToRemoveItemIndex(int index){
		long startTime = System.nanoTime();
		super.remove(index);
		long endTime = System.nanoTime();
		return endTime-startTime ;
	}
	


	/**
	 * Returns how long it checks to find an item.
	 * @param item
	 * @return
	 */
	@Override
	public long timeToCheckContains(E item){
		long startTime = System.nanoTime();
		boolean isSuccessful = super.contains(item);
		long endTime = System.nanoTime();
		return isSuccessful == true ? endTime-startTime : -1;
	}

	/**
	 * Draws the list.
	 */
	@Override
	public void draw(Graphics g){
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
	public void drawContainingItem(E item, Graphics g) {
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

		if(foundIndex != -1){
			System.out.println("\nItem found in index " + foundIndex);
		}else{
			System.out.println("\n ¯\\_(:/)_/¯ \nItem not found");
		}
		System.out.printf("It took %d ms to do this operation.", this.timeToCheckContains(item));
		this.drawLines(80);
	}
	
	public long timeToAddItem(E item, int index){
		long startTime = System.nanoTime();
		super.add(index, item);
		long endTime = System.nanoTime();
		return endTime-startTime;
	}

	@Override
	public void drawAddingItem(E item, Graphics g) {
		this.drawLines(80);
		System.out.println("Adding value : " + item.toString());
		System.out.println("\nstate before adding: ");
		this.draw(g);
		System.out.println("\n\nstate after adding: ");
		this.timeToAddItem(item);
		this.draw(g);
		System.out.println("\nThe value was added to the end of the list.");
		this.drawLines(80);
	}

	@Override
	public void drawAddingItem(E item, int index, Graphics g) {
		this.drawLines(80);
		System.out.println("Adding value : " + item.toString());
		System.out.println("\nstate before adding: ");
		this.draw(g);
		System.out.println("\n\nstate after adding: ");
		boolean nullCheck = this.get(index) == null;
		this.timeToAddItem(item, index);
		this.draw(g);
		System.out.printf("\nThe value was added at index %d\n", index);
		if(!nullCheck)
		System.out.println("It has been inserted between values " + this.get(index-1) + " and " + this.get(index+1));
		else{}
		this.drawLines(80);
	}

	@Override
	public void drawRemovingItem(E item, Graphics g) {
		this.drawLines(80);
		System.out.println("Removing value : " + item.toString());
		System.out.println("\nstate before removing: ");
		this.draw(g);
		System.out.println("\n\nstate after removing: ");
		long time = this.timeToRemoveItem(item);
		this.draw(g);
		if(time != -1){
		System.out.println("\nThe value has been removed.");
		}else{
		System.out.println("\n The element cannot be found.");
		}
		
		this.drawLines(80);
	}
	
	@Override
	public void drawRemovingItem(int index, Graphics g) {
		this.drawLines(80);
		System.out.println("Removing value at index : " + index);
		System.out.println("\nstate before removing: ");
		this.draw(g);
		System.out.println("\n\nstate after removing: ");
		long time = this.timeToRemoveItemIndex(index);
		this.draw(g);
		if(time != -1){
		System.out.println("\nThe value has been removed.");
		}else{
		System.out.println("\n The element cannot be found.");
		}
		this.drawLines(80);
	}

}
