package test.java.edu.asu.cst316;

import junit.framework.TestCase;


import main.java.edu.asu.cst316.gameboard.GameSpace;

import org.junit.Test;

public class GameSpaceTest extends TestCase {


	
	@Test
	public void testSpaces() {
		GameSpace gamespace = new GameSpace("", null, null, 1, 2);
		assertTrue(gamespace.getPosX() == 1);
		assertTrue(gamespace.getPosY() == 2);
		assertTrue(gamespace.getType().equals(""));
		
		assertNull(gamespace.getNextSpace());
		assertNull(gamespace.getAlternativeSpace());
		
		GameSpace gamespace1 = new GameSpace("", gamespace, null, 1, 2);
		assertTrue(gamespace1.getNextSpace() == gamespace);
		
		gamespace1.setType("common");
		assertTrue(gamespace1.getType().equals("common"));
		gamespace1.setAlternativeSpace(gamespace);
		
		assertTrue(gamespace1.getAlternativeSpace() == gamespace);
		
		gamespace1.setPosX(4);
		assertTrue(gamespace1.getPosX() == 4);
		gamespace1.setPosY(-6);
		assertFalse(gamespace1.getPosX() == -6);
	}


}
