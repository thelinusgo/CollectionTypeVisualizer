package com.linusapps.collectionvisualizer.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
/**
 * An Extension of a  ArrayList, but has methods that return the elapsed time for certain operations.
 * The method returns the elapsed time taken to perform the operation, but if it was not successful, it returns -1.
 * @author linus
 *
 * @param <E>
 */
public class CustomArrayList<E> extends ArrayList<E> implements CustomAbstractCollection<E>{

	/*Constant fields */
	private static final int CELL_WIDTH = 50;
	private static final int CELL_HEIGHT = 50;
	
	/*Various constructors for the ArrayList...*/

	
	
	public CustomArrayList() {
		super();
	}

	public CustomArrayList(int initialCapacity){
		super(initialCapacity);
	}

	public CustomArrayList(Collection <? extends E> c){
		super(c);
	}

	/**
	 * Permits drawing the list in a textual form.
	 */
	public void draw(Graphics g){
		int size = super.size();
		int x = 50;
		int y = 50;
		System.out.println("\nArrayList: " + "contains " + (super.size()-1) + (super.size() > 1 ? " values" : " value"));
		for(int i = 1; i < size; ++i){
			System.out.print("["+ super.get(i).toString() + "]");
			//drawCell(x, y, g, super.get(i));
			x+= CELL_WIDTH;
			
		}
	}
	
	/**
	 * Draws an individual cell in an ArrayList.
	 */
	private void drawCell(int xPos, int yPos, Graphics g, E val){
		g.drawRect(xPos,yPos, CELL_WIDTH, CELL_HEIGHT);
		g.setColor(Color.black);
		g.drawString(val.toString(), xPos+(CELL_WIDTH/2), yPos+(CELL_HEIGHT/2));
	}

	/**
	 * Adds an item, and returns the time taken to add that item.
	 * @param item.
	 * @return elapsed time
	 */
	@Override
	public long timeToAddItem(E item){
		long startTime = System.nanoTime();
		boolean success = super.add(item);
		long endTime = System.nanoTime();
		return success == true ? endTime-startTime : -1;
	}
	
	public long timeToAddItem(E item, int index){
		long startTime = System.nanoTime();
		super.add(index, item);
		long endTime = System.nanoTime();
		return endTime-startTime;
	}

	/**
	 * Removes an item and returns the time taken to remove that item.
	 */
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
	public long timeToCheckContains(E item){
		long startTime = System.nanoTime();
		super.contains(item);
		long endTime = System.nanoTime();
		return super.contains(item) == true ? endTime-startTime : -1;
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
		System.out.println(s);
	}

	@Override
	public void drawContainingItem(E item) {
		this.drawLines(80);
		System.out.println("Checking if list has value " + item.toString());
		int foundIndex = -1;
		for(int i = 1; i < super.size(); ++i){
			if(super.get(i).equals(item)){
				System.out.print("[**"+ super.get(i).toString() + "**]");
				foundIndex = i-1;
			}else
			System.out.print("["+ super.get(i).toString() + "]");
		}

		if(foundIndex != -1){
			System.out.println("\nItem found in index " + foundIndex);
		}else{
			System.out.println("\n ¯\\_(:/)_/¯ \nItem not found");
		}
		System.out.printf("It took %d ms to do this operation.", this.timeToCheckContains(item));
		this.drawLines(80);


	}

	@Override
	public void drawAddingItem(E item) {
		this.drawLines(80);
		Graphics g = null; //TODO: MUST FIX this and remove it later. Placeholder value.
		System.out.println("Adding value : " + item.toString());
		System.out.println("\nstate before adding: ");
		this.draw(g);
		System.out.println("\n\nstate after adding: ");
		long time = this.timeToAddItem(item);
		this.draw(g);
		System.out.println("\nThe value was added to the end of the list.");
		System.out.printf("\nIt took %d ms to perform this operation\n", time);
		this.drawLines(80);
	}

	@Override
	public void drawAddingItem(E item, int index) {
		this.drawLines(80);
		Graphics g = null; //TODO: MUST FIX this and remove it later. Placeholder value.
		System.out.println("Adding value : " + item.toString());
		System.out.println("\nstate before adding: ");
		this.draw(g);
		System.out.println("\n\nstate after adding: ");
		boolean nullCheck = this.get(index) == null;
		long time = this.timeToAddItem(item, index);
		this.draw(g);
		System.out.printf("\nThe value was added at index %d\n", index);
		if(!nullCheck)
		System.out.println("It has been inserted between values " + this.get(index-1) + " and " + this.get(index+1));
		else{}
		System.out.printf("\nIt took %d ms to perform this operation\n", time);
		this.drawLines(80);

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
