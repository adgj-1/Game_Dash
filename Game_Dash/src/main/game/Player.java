package main.game;

import java.awt.Color;
import java.awt.Graphics;

import main.screens.GameScreen;
import main.util.Screens;

public class Player extends Sprites {

	public static final int size = 45;
	float horizontal = 0;
	float vertical = 0;
	
	public float velocity = 0;
	public float directionX = 0;
	public float directionY = 0;
	public Player(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), size, size);
		g.setColor(Color.BLACK);
		g.drawString("" + (int)velocity, CoordinateManager.getDisplayX(x) + 5, CoordinateManager.getDisplayY(y) + size - 5);
	}

	@Override
	public void update() {
		CoordinateManager.cameraX = x;
		CoordinateManager.cameraY = y;
		
		if (horizontal != 0 && directionX == 0 && directionY == 0) {
			directionX = horizontal;
			velocity = 1;
		}
		if (vertical != 0 && directionX == 0 && directionY == 0) {
			directionY = vertical;
			velocity = 1;
		}
		x += directionX * velocity;
		y += directionY * velocity;
		
		if (velocity > 0) {
			velocity += 0.1;
		}
		
		Map level = ((GameScreen)Screens.activeScreen).getMap();
		for (int i = 0; i < level.map.length; i++) {
			for (int j = 0; j < level.map[i].length; j++) {
				if (testHitBlock(level.map[i][j])) {
					level.map[i][j].hit();
				}
			}
		}
	}

	public boolean testHitBlock(Block b) {
		if (x + size > b.x && x < b.x + Block.SIZE && y + size > b.y && y < b.y + Block.SIZE) {
			return true;
		}
		return false;
	}
	
	public void move(float h, float v) {
		horizontal = h;
		vertical = v;
	}
	
	public void revertStep(Block interactingBlock) {
		while (testHitBlock(interactingBlock)) {
			x -= directionX;
			y -= directionY;
		}
	}
}
