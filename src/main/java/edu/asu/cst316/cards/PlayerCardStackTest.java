package main.java.edu.asu.cst316.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerCardStackTest {

	@Test
	public void test() {
		PlayerCardStack playerCS = PlayerCardStack.getInstance();
	
		assertTrue(playerCS!=null);
		
		playerCS.addCard(new Card("Assert Card", 1000));
		assertTrue(playerCS.getCurrentCard(0).getText().equals("Assert Card"));
		assertTrue(playerCS.getCurrentCard(0).getValue() == 1000);
		
		playerCS.addCard(new Card("Assert Card", 1000));
		assertFalse(playerCS.getCurrentCard(5).getText().equals("Assert Card"));
		assertFalse(playerCS.getCurrentCard(5).getValue() == 1000);
		
	}
}
