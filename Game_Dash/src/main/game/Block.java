package main.game;

import java.awt.Color;
import java.awt.Graphics;

public class Block {

	public static final int SIZE = 50;
	protected int x;
	protected int y;
	
	/**
	 * Class constructor
	 */
	public Block() {
		
	}
	
	/**
	 * Function to draw the specific block on to
	 * the screen.
	 * @param g
	 */
	public void drawBlock(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
	}
	
	/**
	 * Sets the block's stationary pixel location
	 * based on the index location given.
	 * 
	 * @param X index left of the block
	 * @param Y index top of the block
	 */
	public void setLocation(int X, int Y) {
		x = X * SIZE;
		y = Y * SIZE;
	}

	public void hit() {
		
		
	}
}
