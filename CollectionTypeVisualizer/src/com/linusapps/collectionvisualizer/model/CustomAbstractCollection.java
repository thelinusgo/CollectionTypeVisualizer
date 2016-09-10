package com.linusapps.collectionvisualizer.model;

import java.awt.Graphics;

/**
 * This represents an abstract class that the custom arraylist and custom abstract list will extend.
 * @author linus
 *
 * @param <E>
 */
public interface CustomAbstractCollection<E>{
	/**
	 * Draws the list in textual form.
	 */
	public abstract void draw(Graphics g);

	/**
	 * Draws a depiction of a list, and the location of the item highlighted neatly.
	 */
	public abstract void drawContainingItem(E item, Graphics g);

	/**
	 * Draws a depiction of a list before and after an item is added.
	 */
	public abstract void drawAddingItem(E item, Graphics g);
	/**
	 * Draws a depiction of a list before and after an item is added, with a specified index.
	 */
	public abstract void drawAddingItem(E item, int index, Graphics g);
	/**
	 * Draws a depiction of a list before and after an item is removed.
	 *
	 */
	public abstract void drawRemovingItem(E item, Graphics g);

	/**
	 * Draws a depiction of a list before and after an item is being added, with a specified index.
	 * @param item
	 * @param index
	 */	
	public abstract void drawRemovingItemIndex(int index, Graphics g);





}
