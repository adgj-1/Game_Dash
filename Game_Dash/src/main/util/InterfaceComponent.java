package main.util;

import java.awt.Graphics;
/**
 * Individual components of the game UI,
 * unaffected by the game content.
 * 
 * @author Aaron
 *
 */
public abstract class InterfaceComponent {

	/**
	 * Updates the graphics portion of the component
	 * 
	 * @param g graphics component of the frame
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Update function for the component,
	 * runs every game tick.
	 */
	public abstract void update();
	
	/**
	 * Function called whenever a click is detected in
	 * the current screen, used to determine whether
	 * the click affects the component or not.
	 * 
	 * @param x x-position of the mouse click
	 * @param y y-position of the mouse click
	 */
	public abstract void click(int x, int y);
	
	/**
	 * Function called whenever mouse movement is detected
	 * in the current screen, useful for updating component
	 * status regarding mouse movement
	 */
	public abstract void updateMouseStatus();
}
