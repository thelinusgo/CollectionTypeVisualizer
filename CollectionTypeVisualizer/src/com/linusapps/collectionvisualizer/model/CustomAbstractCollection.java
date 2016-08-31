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
	 * Returns the time taken to add an item. Returns -1 if not successful.
	 * @param item
	 * @return
	 */
	public abstract long timeToAddItem(E item);
	/**
	 * Returns the time taken to remove an item. Returns -1 if not successful.
	 * @param item
	 * @return
	 */
	public abstract long timeToRemoveItem(E item);

	/**
	 * Returns the time taken to check if a value is contained in this list. Returns
	 * -1 if not successful.
	 * @param item
	 * @return
	 */
	public abstract long timeToCheckContains(E item);


	/**
	 * Draws the list in textual form.
	 */
	public abstract void draw(Graphics g);

	/**
	 * Draws a depiction of a list, and the location of the item highlighted neatly.
	 */
	public abstract void drawContainingItem(E item);

	/**
	 * Draws a depiction of a list before and after an item is added.
	 */
	public abstract void drawAddingItem(E item);
	/**
	 * Draws a depiction of a list before and after an item is added, with a specified index.
	 */
	public abstract void drawAddingItem(E item, int index);
	/**
	 * Draws a depiction of a list before and after an item is removed.
	 *
	 */
	public abstract void drawRemovingItem(E item);

	/**
	 * Draws a depiction of a list before and after an item is being added, with a specified index.
	 * @param item
	 * @param index
	 */
	public abstract void drawRemovingItem(E item, int index);





}
