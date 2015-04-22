package test.java.edu.asu.cst316;

//import static org.junit.Assert.*;

import main.java.edu.asu.cst316.GameMain;

//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
//import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.Image;
//import org.newdawn.slick.SlickException;
//import org.newdawn.slick.state.BasicGameState;
//import org.newdawn.slick.state.StateBasedGame;

import junit.framework.TestCase;

public class GameMainTest extends TestCase {
	
	private static GameMain gameMain = new GameMain(2);
	int test;
	
	@Test
	public void testState() {
		assertTrue(gameMain.getID() == 2);
		assertFalse(gameMain.getID() == 0);
		
	}
	
	@Test
	public void testSpinWheel(){
		for (int i = 0; i < 100; i++){
		gameMain.getSpinNum(test);
		assertTrue((test >= 1) && (test <= 6));
		}
		
	}
	
}
