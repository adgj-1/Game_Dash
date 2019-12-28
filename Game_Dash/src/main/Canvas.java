package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import main.util.InterfaceComponent;
import main.util.Screens;
/**
 * This is the canvas to display the game, it manages the drawing of all objects and
 * will be the shell for all graphical component to the program.
 * 
 * @author Aaron
 *
 */
public class Canvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public void paint(Graphics g) {
		update(g);
	}
	
	/**
	 * 
	 */
	public void update(Graphics g) {
		drawInterfaceUI(g);
		Screens.activeScreen.draw(g);
	}
	
	/**
	 * This calls draw method for all active interfaces of the game
	 * 
	 * @param g graphics component of this class
	 */
	public void drawInterfaceUI(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		List<InterfaceComponent> ic = Game.getActiveInterface();
		g.setColor(Color.BLACK);
		for (int i = 0; i < ic.size(); i++) {
			ic.get(i).draw(g);
		}
	}
	
}
