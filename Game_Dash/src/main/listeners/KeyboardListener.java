package main.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.util.Screens;
/**
 * Key listener that detects key presses and forwards
 * it to the current screen that's active.
 * 
 * @author Aaron
 *
 */
public class KeyboardListener implements KeyListener {

	/**
	 * Function that runs whenever a key is pressed down
	 * then released.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function that runs whenever a key is pressed down.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		Screens.activeScreen.enterKey(e.getKeyCode());
	}

	/**
	 * Function that runs whenever a key is released.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		Screens.activeScreen.releaseKey(e.getKeyCode());
		
	}

}
