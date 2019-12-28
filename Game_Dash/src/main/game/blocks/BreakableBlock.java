package main.game.blocks;

import java.awt.Color;
import java.awt.Graphics;

import main.game.Block;
import main.game.CoordinateManager;
import main.game.Player;
import main.screens.GameScreen;
import main.util.Screens;

public class BreakableBlock extends Block {

	public void drawBlock(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(CoordinateManager.getDisplayX(x), CoordinateManager.getDisplayY(y), SIZE, SIZE);
	}
	
	@Override
	public void hit() {
		Player p = ((GameScreen)(Screens.activeScreen)).getPlayer();
		if (p.velocity <= 5) {
			p.revertStep(this);
			p.directionX = 0;
			p.directionY = 0;
			p.velocity = 0;
		} else {
			p.velocity /= 2;
			Block air = new Block();
			air.setLocation(x/SIZE, y/SIZE);
			((GameScreen)Screens.activeScreen).getMap().setBlock(x/SIZE, y/SIZE, air);
		}
	}
}
