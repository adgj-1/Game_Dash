package main.util;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.List;

import main.Game;

/**
 * Base class of each screen object. Manages input on the screen as well as
 * constructs a basic structure of screen classes.
 * 
 * @author Aaron
 *
 */
public abstract class Screens {

	public static Screens activeScreen;
	public static InterfaceButton selectedButton;
	protected List<InterfaceComponent> interfaceComponents;
	
	/**
	 * Constructor calls initialization method
	 */
	public Screens() {
		init();
	}
	
	/**
	 * Function to load the current screen object onto the game.
	 * Sets the active screen to the current object and replaces
	 * the existing interface components on the game with the
	 * interface components attached to the current screen.
	 */
	public void load() {
		activeScreen = this;
		Game.setActiveInterface(interfaceComponents);
	}
	
	/**
	 * Update function of the current screen.
	 * Called every tick.
	 */
	public abstract void update();
	
	/**
	 * Update function for the graphics side
	 * of the current screen.
	 * 
	 * @param g graphics component of the frame
	 */
	public abstract void draw(Graphics g);
	
	/**
	 * Initialization method of the screen.
	 * Sets up the necessary part of the
	 * object.
	 */
	public abstract void init();
	
	/**
	 * Activates whenever mouse moves on the screen.
	 * Transfers the information on the update to
	 * the active interface UI components.
	 */
	public void mouseMove() {
		for (InterfaceComponent e : interfaceComponents) {
			e.updateMouseStatus();
		}
	}
	
	/**
	 * Activates whenever mouse clicks on the screen
	 * Transfers the information on the click as well as
	 * the position of the click on to the active
	 * interface UI components.
	 * 
	 * @param x x-position of the mouse click
	 * @param y y-position of the mouse click
	 */
	public void click(int x, int y) {
		for (InterfaceComponent e : interfaceComponents) {
			e.click(x, y);
		}
	}
	
	/**
	 * Activates whenever a key is pressed on the screen.
	 * Primarily used to apply control the UI using keys
	 * Can be overridden to listen for specific key presses
	 * in the screen.
	 * 
	 * @param key the key pressed
	 */
	public void enterKey(int key) {
		if (key == KeyEvent.VK_UP) {
			int i;
			if (selectedButton == null) {
				i = 1;
			} else {
				i = interfaceComponents.indexOf(selectedButton);
			}
			for (int j = 0; j < interfaceComponents.size(); j++) {
				i--;
				if (i < 0) {
					i = interfaceComponents.size() - 1;
				}
				if (interfaceComponents.get(i) instanceof InterfaceButton) {
					((InterfaceButton)interfaceComponents.get(i)).select();
					break;
				}
				
			}
		
		} else if (key == KeyEvent.VK_DOWN) {
			int i;
			if (selectedButton == null) {
				i = interfaceComponents.size() - 1;
			} else {
				i = interfaceComponents.indexOf(selectedButton);
			}
			for  (int j = 0; j < interfaceComponents.size(); j++) {
				i++;
				if (i >= interfaceComponents.size()) {
					i = 0;
				}
				if (interfaceComponents.get(i) instanceof InterfaceButton) {
					((InterfaceButton)interfaceComponents.get(i)).select();
					break;
				}
				
			}
		} else if (key == KeyEvent.VK_ENTER) {
			if (selectedButton != null) {
				selectedButton.activate();
			}
		}
	}

	public void releaseKey(int keyCode) {
		
		
	}
}
