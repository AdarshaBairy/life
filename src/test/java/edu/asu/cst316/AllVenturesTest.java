package test.java.edu.asu.cst316;

import junit.framework.TestCase;
import main.java.edu.asu.cst316.ventures.AllVentures;
import main.java.edu.asu.cst316.ventures.Venture;

import org.junit.Test;

public class AllVenturesTest extends TestCase {
	
	@Test
	public void testSpaceTypes() {
		AllVentures ventures = AllVentures.getInstance();
		Venture[] venture = ventures.getVentures();
		
		assertTrue(venture[0].getCareer().equals("Restaurant"));
		assertTrue(venture[1].getCareer().equals("Real Estate"));
		assertTrue(venture[2].getCareer().equals("Software"));
		
		assertTrue(venture[0].getRisk() == 4);
		assertTrue(venture[1].getRisk() == 6);
		assertTrue(venture[2].getRisk() == 8);
		
		assertTrue(venture[0].getIncome() == 10000);
		assertTrue(venture[1].getIncome() == 15000);
		assertTrue(venture[2].getIncome() == 20000);
		
		assertTrue(venture[0].getImageName().equals("images/charCreationInt1.png"));
		assertTrue(venture[1].getImageName().equals("images/charCreationInt2.png"));
		assertTrue(venture[2].getImageName().equals("images/charCreationInt3.png"));
		
		assertTrue(venture[0].getStartingMoney() == 50000);
		assertTrue(venture[1].getStartingMoney() == 50000);
		assertTrue(venture[2].getStartingMoney() == 50000);
	}
	
}

