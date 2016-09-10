package com.linusapps.collectionvisualizer.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

/**
 * An Extension of java.util.ArrayList, but it provides methods for drawing onto
 * the Canvas. All methods that were previously in ArrayList are still
 * accessible and usable.
 * 
 * @author linus
 *
 * @param <E>
 */
public class CustomArrayList<E> extends ArrayList<E> implements CustomAbstractCollection<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4388481113398341759L;

	/* Constant fields */
	private final int CELL_WIDTH = 50; // nominal width of a cell.
	private final int CELL_HEIGHT = 50; // nominal height of a cell.
	private final int SLEEP_TIME = 1000; // time between each delay (in ms)

	/* Various constructors for the ArrayList... */

	/**
	 * Create an ArrayList.
	 */
	public CustomArrayList() {
		super();
	}

	/**
	 * Create an ArrayList with an Initial Capacity.
	 * 
	 * @param initialCapacity
	 */
	public CustomArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Create an ArrayList initialized with a collection type.
	 * 
	 * @param c
	 */
	public CustomArrayList(Collection<? extends E> c) {
		super(c);
	}

	/**
	 * Permits drawing the entire list out graphically.
	 */
	public void draw(Graphics g) {
		int size = super.size();
		// offsets
		int x = 50;
		int y = 50;
		int index = 0;
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1210, 567); // avoid clipping or weird artificating.

		for (int i = 0; i < size; ++i) {
			drawCell(x, y, g, super.get(i));
			g.drawString(String.valueOf(index), x + (CELL_WIDTH / 2), y);
			x += CELL_WIDTH;
			index++;
		}
	}

	/**
	 * Draws an individual cell in an ArrayList.
	 */
	private void drawCell(int xPos, int yPos, Graphics g, E val) {
		g.setColor(Color.YELLOW);
		g.fillRect(xPos, yPos, CELL_WIDTH, CELL_HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, CELL_WIDTH, CELL_HEIGHT);
		g.drawString(val.toString(), xPos + (CELL_WIDTH / 2), yPos + (CELL_HEIGHT / 2));
	}

	/**
	 * Draws an individual cell in an ArrayList highlighed the color orange.
	 */
	private void drawHighlightedCell(int xPos, int yPos, Graphics g, E val) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		
		System.out.println("xpos: " + xPos + " ypos: " + yPos);
		
		g2.drawRect(xPos, yPos, CELL_WIDTH, CELL_HEIGHT);

		g2.setColor(Color.YELLOW);
		g2.fillRect(xPos, yPos, CELL_WIDTH, CELL_HEIGHT);
		g2.setColor(Color.BLACK);
		g2.drawRect(xPos, yPos, CELL_WIDTH, CELL_HEIGHT);
		g2.drawString(val.toString(), xPos + (CELL_WIDTH / 2), yPos + (CELL_HEIGHT / 2));

		/* Add a slight delay for dramatic effect. */
		try {
			Thread.sleep(SLEEP_TIME);
			g2.setStroke(new BasicStroke(1));
			this.draw(g2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * This method draws an Orange rectangle around an item if it is inside the
	 * list.
	 */
	@Override
	public void drawContainingItem(E item, Graphics g) {
		int foundIndex = -1;
		int x = 0;
		int y = 50;
		for (int i = 0; i < super.size(); ++i) {
			x += CELL_WIDTH;
			if (super.get(i).equals(item)) {
				this.drawHighlightedCell(x, y, g, item);
				foundIndex = i;
				break;
			}
		}

		if (foundIndex != -1) {
			System.out.println("\nItem found in index " + foundIndex);
		} else {
			System.out.println("\n ¯\\_(:/)_/¯ \nItem not found");
		}

	}

	@Override
	public void drawAddingItem(E item, Graphics g) {
		super.add(item);
		this.draw(g);
	}

	@Override
	public void drawAddingItem(E item, int index, Graphics g) {
		super.remove(index);
		boolean nullCheck = this.get(index) == null;
		this.draw(g);
	}

	@Override
	public void drawRemovingItem(E item, Graphics g) {
		for (int i = 1; i < size(); ++i) {
			this.drawHighlightedCell((CELL_WIDTH * i), CELL_HEIGHT, g, this.get(i - 1));

			if (this.get(i).equals(item)) {
				
        		/* Blink cause it equals the item. */
				for (int j = 0; j < 3; j++) {
					try {
						Thread.sleep(SLEEP_TIME / 4);
						System.out.println(i);
						this.drawHighlightedCell((CELL_WIDTH * i), CELL_HEIGHT, g, this.get(i-1));
						this.drawCell(((CELL_WIDTH * i)), CELL_HEIGHT, g, this.get(i-1));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}

		}
		super.remove(item);
		this.draw(g);
	}

	@Override
	public void drawRemovingItemIndex(int index, Graphics g) {
		this.draw(g);
		this.remove(index);
		this.draw(g);
	}

}
