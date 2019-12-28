package main.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.listeners.MouseListener;

/**
 * Main UI button of the program, used independently of the game
 * and is bounded to the current loaded screen.
 * 
 * @author Aaron
 *
 */
public class InterfaceButton extends InterfaceComponent {

	Runnable command;
	String text;
	int x;
	int y;
	int w;
	int h;
	boolean selected = false;
	
	/**
	 * Class constructor, takes in the runnable type
	 * command of the button.
	 * 
	 * @param t the command that the button does after
	 * 			it is clicked
	 */
	public InterfaceButton(Runnable t) {
		command = t;
	}
	
	/**
	 * Class constructor, takes in the display name of
	 * the button as well as runnable command and the
	 * coordinates of the button.
	 * 
	 * @param txt display name of the button
	 * @param t   the command that the button when clicked
	 * @param x_  x-coordinate of the button
	 * @param y_  y-coordinate of the button
	 */
	public InterfaceButton(String txt, Runnable t, int x_, int y_) {
		command = t;
		text = txt;
		x = x_;
		y = y_;
		w = 0;
		h = 0;
	}
	
	/**
	 * Draw function of the button, allowing
	 * it to display on the screen it is
	 * attached to.
	 */
	@Override
	public void draw(Graphics g) {
		g.getFontMetrics().getStringBounds(text, g);
		g.setFont(new Font("Calibri", 35,35));
		if (!selected) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.RED);
		}
		g.drawString(text, x, y);
		Rectangle2D bound = g.getFontMetrics().getStringBounds(text, g);
		w = (int) bound.getWidth();
		h = (int) bound.getHeight();
	}

	/**
	 * Update function of the button, allowing
	 * it to update its status based on the
	 * currently selected button.
	 */
	@Override
	public void update() {
		if (Screens.selectedButton == this) {
			selected = true;
		} else {
			selected = false;
		}
	}
	
	/**
	 * Function that runs after the button
	 * has been clicked.
	 */
	public void activate() {
		command.run();
	}

	/**
	 * Function that selects this button object.
	 */
	public void select() {
		Screens.selectedButton = this;
	}
	
	/**
	 * Click function triggered after detecting
	 * a mouse click in the current screen. Can
	 * be used to run test of whether the button
	 * has been clicked.
	 */
	@Override
	public void click(int x, int y) {
		if (x > this.x && x < this.x + w && y > this.y - h/2 && y < this.y) {
			activate();
		}
	}

	/**
	 * Mouse move function triggered after detecting
	 * mouse movement in the current screen. Can be
	 * used to test whether mouse is hovering above
	 * the button.
	 */
	@Override
	public void updateMouseStatus() {
		int x = MouseListener.mouseX;
		int y = MouseListener.mouseY;
		if (x > this.x && x < this.x + w && y > this.y - h/2 && y < this.y) {
			select();
		}
	}
}
