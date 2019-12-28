package main.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.util.Screens;
/**
 * Mouse click listener that detects when a mouse click
 * happened and passes on the information to the current
 * active screen.
 * 
 * @author Aaron
 *
 */
public class ClickListener implements MouseListener {

	/**
	 * Function that runs whenever any mouse button is
	 * pressed down then released.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function that runs whenever any mouse button is
	 * pressed down.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Screens.activeScreen.click(e.getX(), e.getY());
	}

	/**
	 * Function that runs whenever any mouse button is
	 * released.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function that runs whenever the mouse enters the
	 * clickable zone.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Function that runs whenever the mouse exits the
	 * clickable zone.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
