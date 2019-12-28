package main.game;

import main.game.blocks.BreakableBlock;
import main.game.blocks.SolidBlock;

public class BlockIdentifier {

	public static Block getBlockFromID(String id) {
		switch (id) {
		case "1": {
			return new SolidBlock();
		}
		
		case "2": {
			return new BreakableBlock();
		}
		default: {
			return new Block();
		}
		}
		
	}
}
