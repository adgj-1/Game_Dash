package main.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import main.util.Screens;
/**
 * Mouse motion listener that detects whenever a mouse moved
 * and forwards it to the current active screen.
 * 
 * @author Aaron
 *
 */
public class MouseListener implements MouseMotionListener {

	public static int mouseX;
	public static int mouseY;
	
	/**
	 * Function that runs whenever the mouse is dragged
	 * across the screen.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function that runs whenever the mouse moves within
	 * the screen.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		Screens.activeScreen.mouseMove();
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

}
