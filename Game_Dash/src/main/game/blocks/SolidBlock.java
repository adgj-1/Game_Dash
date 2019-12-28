package main.game.blocks;

import java.awt.Color;
import java.awt.Graphics;

import main.game.Block;
import main.game.CoordinateManager;
import main.game.Player;
import main.screens.GameScreen;
import main.util.Screens;

public class SolidBlock extends Block {

	public void drawBlock(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
	}
	
	@Override
	public void hit() {
		Player p = ((GameScreen)(Screens.activeScreen)).getPlayer();
		p.revertStep(this);
		p.directionX = 0;
		p.directionY = 0;
		p.velocity = 0;
	}
}
