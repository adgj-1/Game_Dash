package main.screens;

import java.awt.Graphics;
import java.util.ArrayList;

import main.util.InterfaceButton;
import main.util.InterfaceComponent;
import main.util.Screens;
/**
 * Title screen of the game
 * 
 * @author Aaron
 *
 */
public class TitleScreen extends Screens {

	/**
	 * Function that runs any commands that
	 * needs to be repeatedly trigger when the
	 * title screen is active.
	 */
	@Override
	public void update() {
		
	}

	/**
	 * Function that draws any additional part
	 * of the title screen besides the interface
	 * components.
	 */
	@Override
	public void draw(Graphics g) {
		
	}

	/**
	 * Initialization function of the title screen
	 * creates all the interface components required
	 * in the title screen.
	 */
	@Override
	public void init() {
		interfaceComponents = new ArrayList<InterfaceComponent>();
		interfaceComponents.add(new InterfaceButton("Play", new Runnable() {public void run() {GameScreen screen = new GameScreen();
		screen.load();}}, 100, 200));
		interfaceComponents.add(new InterfaceButton("Quit", new Runnable() {public void run() {System.exit(0);}}, 100, 300));
		
		//interfaceComponents.add(new InterfaceButton("Command 2", new Runnable() {public void run() {}}, 100, 300));
	}


}
