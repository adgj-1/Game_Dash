package main;

import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JFrame;

import main.game.CoordinateManager;
import main.listeners.ClickListener;
import main.listeners.KeyboardListener;
import main.listeners.MouseListener;
import main.screens.TitleScreen;
import main.util.InterfaceComponent;
import main.util.Screens;
/**
 * Shell class of the game that contains most of the functions related to basic performances,
 * including the main loop and UI system.
 * 
 * @author Aaron
 *
 */
public class Game {

	public static List<InterfaceComponent> activeInterface;
	
	public static Thread gameThread;
	public static Canvas canvas;
	public static JFrame frame;
	public static MouseMotionListener mLis;
	public static ClickListener cLis;
	public static KeyListener kLis;
	
	/**
	 * Initiation function for the game, sets up all the necessary listeners
	 * as well as the main thread that the game runs on.
	 */
	public static void init() {
		canvas = Main.c;
		frame = Main.j;
		mLis = new MouseListener();
		cLis = new ClickListener();
		kLis = new KeyboardListener();
		canvas.addMouseMotionListener(mLis);
		canvas.addMouseListener(cLis);
		frame.addKeyListener(kLis);
		CoordinateManager.init(canvas);
		gameThread = new Thread() {
			public void run() {
				while (true) {
					
					onGameTick();
					onDisplayTick();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		TitleScreen screen = new TitleScreen();
		screen.load();
	}
	
	/**
	 * Function to start the game
	 */
	public static void run() {
		gameThread.run();
	}
	
	/**
	 * Runs each tick of the game
	 */
	public static void onGameTick() {
		onUpdateInterface();
		Screens.activeScreen.update();
	}
	
	/**
	 * Run update method in every element of currently active UI interface
	 */
	public static void onUpdateInterface() {
		for (int i = 0; i < activeInterface.size(); i++) {
			activeInterface.get(i).update();
		}
	}
	
	/**
	 * Refresh display for each tick of the game
	 */
	public static void onDisplayTick() {
		canvas.repaint();
	}
	
	/**
	 * Getter method of activeInterface
	 * 
	 * @return	currently active list of UI interface
	 */
	public static List<InterfaceComponent> getActiveInterface() {
		return activeInterface;
	}
	
	/**
	 * Setter method of activeInterface
	 * 
	 * @param ic new list of UI interface to set active
	 */
	public static void setActiveInterface(List<InterfaceComponent> ic) {
		activeInterface = ic;
	}
}
