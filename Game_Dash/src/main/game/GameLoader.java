package main.game;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import main.Main;
/**
 * A class used to contain the processes that involving loading and reading internal data
 * 
 * @author Aaron
 *
 */
public class GameLoader {

	public static String path = Main.class.getResource("").toString();
	
	/**
	 * This function takes in the name of the level file to read the data and convert
	 * it into a Map object.
	 * 
	 * @param levelname the absolute name of the level file including the extension name 
	 * @return			the Map object of the corresponding file
	 * @throws FileNotFoundException
	 */
	public static Map loadLevel(String levelname) throws FileNotFoundException {
		InputStream path= Main.class.getResourceAsStream("levels/" + levelname);
		Scanner in = null;
		in = new Scanner(path);
		
		String name = in.nextLine();
		String coords = in.nextLine();
		int w = Integer.parseInt(coords.split(" ")[0]);
		int h = Integer.parseInt(coords.split(" ")[1]);
		
		String playerCoords = in.nextLine();
		int p_x = Integer.parseInt(playerCoords.split(" ")[0]);
		int p_y = Integer.parseInt(playerCoords.split(" ")[1]);
		
		Map level = new Map(name,w,h,p_x,p_y);
		for (int i = 0; i < w; i++) {
			String row = in.nextLine();
			String regex = row.substring(0,1);
			String[] row_ = row.substring(1).split(regex);
			for (int j = 0; j < row_.length; j++) {
				level.setBlock(i, j, BlockIdentifier.getBlockFromID(row_[j]));
				
			}
		}
		
		
		
		in.close();
		
		return level;
	}
}
