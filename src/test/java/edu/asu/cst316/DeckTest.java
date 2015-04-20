package test.java.edu.asu.cst316;

import static org.junit.Assert.*;
import main.java.edu.asu.cst316.cards.Deck;

import org.junit.Test;

public class DeckTest {
	
	@Test
	public void test() {
		//check that the cards give the correct card color

		Deck deck = Deck.getInstance();
		for (int i=0; i<=100; i++){
			assertTrue(deck.getCommonCard().getValue() < 5001);
			assertTrue(deck.getRedCard().getValue() < 11001);
			assertTrue(deck.getGreenCard().getValue() < 3001);

			assertTrue(deck.getCommonCard().getValue() > -5001);
			assertTrue(deck.getRedCard().getValue() > -11001);
			assertTrue(deck.getGreenCard().getValue() > -2501);
		}
		
	}

}
