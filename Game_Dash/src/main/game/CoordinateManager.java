package main.game;

import main.Canvas;

public class CoordinateManager {

	public static int centerOffsetX;
	public static int centerOffsetY;
	
	public static int cameraX;
	public static int cameraY;
	
	/**
	 * Initiates the coordinate and camera system of the game
	 * 
	 * @param c the frame that the coordinate system is initiated in
	 */
	public static void init(Canvas c) {
		centerOffsetX = c.getWidth()/2;
		centerOffsetY = c.getHeight()/2;
		cameraX = 0;
		cameraY = 0;
	}
	
	/**
	 * Finds the pixel x-coordinate of the display item
	 * given the map location x-coordinate of the item
	 * 
	 * @param x the x-coordinate relative to the stationary map
	 * @return  the x-coordinate to display on the screen
	 */
	public static int getDisplayX(int x) {
		return x + centerOffsetX - cameraX;
	}
	
	/**
	 * Find the pixel y-coordinate of the display item
	 * given the map location y-coordinate of the item
	 * 
	 * @param y the y-coordinate relative to the stationary map
	 * @return  the y-coordinate to display on the screen
	 */
	public static int getDisplayY(int y) {
		return y + centerOffsetY - cameraY;
	}
}
