package com.linusapps.collectionvisualizer.model;
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
	public abstract long addItem(E item);
	/**
	 * Returns the time taken to remove an item. Returns -1 if not successful.
	 * @param item
	 * @return
	 */
	public abstract long removeItem(E item);
	
	/**
	 * Returns the time taken to check if a value is contained in this list. Returns
	 * -1 if not successful.
	 * @param item
	 * @return
	 */
	public abstract long checkContains(E item);
	
	
	/**
	 * Draws the list in textual form.
	 */
	public abstract void draw();
	
	
}
