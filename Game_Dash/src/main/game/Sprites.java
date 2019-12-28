package main.game;

import java.awt.Graphics;
/**
 * Game entities capable of interacting within the game
 * 
 * @author Aaron
 *
 */
public abstract class Sprites {

	protected int x;
	protected int y;
	
	public Sprites(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Function to update the view of the sprite
	 * 
	 * @param g graphics component of the frame
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Function to update the sprite for each tick
	 */
	public abstract void update();
}
