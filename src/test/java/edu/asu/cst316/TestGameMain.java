package test.java.edu.asu.cst316;

import static org.junit.Assert.*;

import java.util.List;

import main.java.edu.asu.cst316.FullBoard;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestGameMain extends TestCase {
private static FullBoard fullboard = new FullBoard(4);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testState() {
		assertTrue(fullboard.getID() == 4);
	}
}
