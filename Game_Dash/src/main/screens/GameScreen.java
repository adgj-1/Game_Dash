package main.screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import main.Game;
import main.game.GameLoader;
import main.game.Map;
import main.game.Player;
import main.game.Sprites;
import main.util.InterfaceButton;
import main.util.InterfaceComponent;
import main.util.Screens;
/**
 * Main screen that display the game content.
 * 
 * @author Aaron
 *
 */
public class GameScreen extends Screens {

	Map map;
	boolean paused;
	List<InterfaceComponent> component_p;
	List<InterfaceComponent> component_g;
	
	List<Sprites> entityList;
	Player player;
	
	@Override
	public void update() {
		if (!paused) {
			updateGame();
		}
	}

	@Override
	public void draw(Graphics g) {
		map.displayMap(g);
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).draw(g);
		}
		
	}

	/**
	 * Initialization function that sets up the interface components
	 * as well as loading in the level files.
	 */
	@Override
	public void init() {
		//Initializes Components
		interfaceComponents = new ArrayList<InterfaceComponent>();
		interfaceComponents.add(new InterfaceButton("Pause", new Runnable() {public void run() {pause();}}, 10, 100));
		component_g = interfaceComponents;
		component_p = new ArrayList<InterfaceComponent>();
		component_p.add(new InterfaceButton("Resume", new Runnable() {public void run() {resume();}}, 300, 300));
		try {
			map = GameLoader.loadLevel("level1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Sets up player sprite
		entityList = new ArrayList<Sprites>();
		player = new Player(map.getPlayerSpawnLocation()[0],map.getPlayerSpawnLocation()[1]);
		entityList.add(player);
		paused = false;
	}

	public void updateGame() {
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).update();
		}
		
	}
	
	public void pause() {
		paused = true;
		interfaceComponents = component_p;
		Game.setActiveInterface(interfaceComponents);
	}
	
	public void resume() {
		paused = false;
		interfaceComponents = component_g;
		Game.setActiveInterface(interfaceComponents);
	}
	
	@Override
	public void enterKey(int key) {
		super.enterKey(key);
		if (key == KeyEvent.VK_UP) {
			player.move(0, -1);
		} else if (key == KeyEvent.VK_DOWN) {
			player.move(0, 1);
		} else if (key == KeyEvent.VK_LEFT) {
			player.move(-1, 0);
		} else if (key == KeyEvent.VK_RIGHT) {
			player.move(1, 0);
		}
	}
	
	public void releaseKey(int key) {
		player.move(0, 0);
	}
	
	public Map getMap() {
		return map;
	}
	
	public Player getPlayer() {
		return player;
	}
}
