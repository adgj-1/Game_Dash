package main.game;

import java.awt.Graphics;
/**
 * Game map object used to contain the blocks
 *  
 * @author Aaron
 *
 */
public class Map {
	Block[][] map;
	String name;
	int[] playerSpawn;
	/**
	 * Class constructor specifying the index width and height of the map.
	 * 
	 * @param width the index width of the map
	 * @param height the index height of the map
	 */
	public Map(int width, int height) {
		map = new Block[width][height];
		name = "";
		playerSpawn = new int[2];
	}
	
	/**
	 * Class constructor specifying the index width and height as well as
	 * name of the map created.
	 * 
	 * @param n      the name of the map 
	 * @param width  the index width of the map
	 * @param height the index height of the map
	 */
	public Map(String n, int width, int height) {
		map = new Block[width][height];
		name = n;
		playerSpawn = new int[2];
	}
	
	/**
	 * Class constructor specifying the index width, height, name of the
	 * map created, and also the spawn location of the player
	 * 
	 * @param n      the name of the map
	 * @param width  the index width of the map
	 * @param height the index height of the map
	 * @param p_x    the x-coordinate of player spawn
	 * @param p_y    the y-coordinate of player spawn
	 */
	public Map(String n, int width, int height, int p_x, int p_y) {
		map = new Block[width][height];
		name = n;
		playerSpawn = new int[] {p_x, p_y};
	}
	
	/**
	 * This takes in the index X and Y to place the specified block at that location.
	 * 
	 * @param X index coordinate left
	 * @param Y index coordinate top
	 * @param b the block placed
	 */
	public void setBlock(int X, int Y, Block b) {
		map[X][Y] = b;
		b.setLocation(X, Y);
	}
	
	/**
	 * This calls the drawBlock function for every single block in this map to display
	 * the visual portion of the map.
	 * 
	 * @param g the graphics component of the frame drawn onto
	 */
	public void displayMap(Graphics g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].drawBlock(g);
			}
		}
	}
	
	public int[] getPlayerSpawnLocation() {
		return playerSpawn;
	}
}
