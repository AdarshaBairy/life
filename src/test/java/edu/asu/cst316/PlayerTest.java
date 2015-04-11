package test.java.edu.asu.cst316;

import static org.junit.Assert.*;
import main.java.edu.asu.cst316.player.Player;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	Player player = Player.getInstance();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		player.setName("testname");
		player.setCareer("Test");
		player.setIncome(1000);
		player.setSavedMoney(2000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
		Player player2 = player.getInstance();
		assertTrue(player2.getName().compareTo("testname") == 0);
		assertTrue(player2.getCareer().compareTo("Test") == 0);
		assertTrue(player2.getIncome() == 1000);
		assertTrue(player2.getSavedMoney() == 2000);
	}

	@Test
	public void testGetSavedMoney() {
		assertTrue(player.getSavedMoney() == 2000);
		//fail("Not yet implemented");
	}

	@Test
	public void testPayDay() {
		player.setIncome(1000);
		player.setRisk(4);
		for(int i = 0; i <100; i++){
		player.setSavedMoney(0);
		player.payDay();
		assertTrue(player.getSavedMoney() >= 500 && player.getSavedMoney() <= 2000);
		System.out.println(player.getSavedMoney());
		//fail("Not yet implemented");
		}
	}

}
