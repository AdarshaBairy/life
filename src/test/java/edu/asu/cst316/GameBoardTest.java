/*package test.java.edu.asu.cst316;

//import static org.junit.Assert.*;


import main.java.edu.asu.cst316.gameboard.GameBoard;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import junit.framework.TestCase;

public class GameBoardTest extends TestCase {

	@Test
	public void testBoardState() {
		GameBoard gameboard = GameBoard.getInstance();
		assertTrue(gameboard.getCurrentSpace().getType().equals("start"));
		
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("common"));
		
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("common"));
		
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("fork"));
		
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("red"));
		
		gameboard.movePlayer(5);
		assertTrue(gameboard.getCurrentSpace().getType().equals("join"));
		assertNull(gameboard.getCurrentSpace().getAlternativeSpace());
		
	}

	public void testPosition() {
		GameBoard gameboard = GameBoard.getInstance();
		System.out.println(gameboard.getCurrentSpace().getPosX());
		gameboard.movePlayer(1);
		System.out.println(gameboard.getCurrentSpace().getPosX());
		gameboard.movePlayer(1);
		System.out.println(gameboard.getCurrentSpace().getPosX());
	}
}
**/