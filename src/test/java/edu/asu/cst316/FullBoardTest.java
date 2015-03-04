package test.java.edu.asu.cst316;

//import static org.junit.Assert.*;

import main.java.edu.asu.cst316.FullBoard;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import junit.framework.TestCase;

public class FullBoardTest extends TestCase {
	
	private static FullBoard fullboard = new FullBoard(4);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testState() {
//		assertTrue(fullboard.getID() == 4 && fullboard.getID() != 0);
		//assertFalse(fullboard.getID() == 0);
	}
	
}
