package test.java.edu.asu.cst316;

import junit.framework.TestCase;


import main.java.edu.asu.cst316.gameboard.GameBoard;

import org.junit.Test;

public class GameBoardTest extends TestCase {

	private static GameBoard gameboard = GameBoard.getInstance();
	
	@Test
	public void testSpaceTypes() {
		gameboard.reset();
		assertTrue(gameboard.getCurrentSpace().getType().equals("start"));
		
		testChunkOfCommonAndRedSpaces(2);
		testChunkOfCommonAndRedSpaces(8);
		testChunkOfCommonAndRedSpaces(3);
		testChunkOfCommonAndRedSpaces(1);
		testChunkOfCommonAndRedSpaces(4);
		testChunkOfCommonAndRedSpaces(4);
		
		gameboard.reset();
	}
	
	public static void testChunkOfCommonAndRedSpaces(int commonSpacesLength){
		for(int i = 0; i < commonSpacesLength; ++i){
			gameboard.movePlayer(1);
			assertTrue(gameboard.getCurrentSpace().getType().equals("common"));
		}	
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("fork"));	
		for(int i = 0; i < 7; ++i){
			gameboard.movePlayer(1);
			assertTrue(gameboard.getCurrentSpace().getType().equals("red"));
		}		
		gameboard.movePlayer(1);
		assertTrue(gameboard.getCurrentSpace().getType().equals("join"));
	}
	
	@Test
	public void testPosition() {
		gameboard.reset();
		int lastX = -256;
		int lastY = 470;
		assertTrue(gameboard.getCurrentSpace().getPosX() == lastX);
		assertTrue(gameboard.getCurrentSpace().getPosY() == lastY);
		
		for(int i = 0; i < 28; ++i){
			gameboard.movePlayer(1); lastX += 128;
			assertTrue(gameboard.getCurrentSpace().getPosX() == lastX);
			assertTrue(gameboard.getCurrentSpace().getPosY() == lastY);
		}	
		for(int i = 0; i < 4; ++i){
			assertTrue(gameboard.getCurrentSpace().getPosX() == lastX);
			assertTrue(gameboard.getCurrentSpace().getPosY() == lastY);
			gameboard.movePlayer(1);
			lastY += 128;
		}
	}
}
