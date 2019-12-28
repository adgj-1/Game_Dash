package main;

import javax.swing.JFrame;
/**
 * 
 * @author Aaron
 *
 */
public class Main {

	public static JFrame j;
	public static Canvas c;
	
	/**
	 * Main function to start the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		j = new JFrame("Game");
		c = new Canvas();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(c);
		j.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j.setUndecorated(true);
		j.setVisible(true);
		Game.init();
		Game.run();
	}
}
