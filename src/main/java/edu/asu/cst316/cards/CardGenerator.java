package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class CardGenerator {
		
		private String cardText;
		//card = (String cardtext, int cardValue);
		//allCards = blueCards[], greenCArds[], redCards[];
		
		public String getCardText(){
			Random rand = new Random();
			int cardNum = (rand.nextInt(3));
			cardText = textList[cardNum];
			return cardText;
		}

		//The text list for the green cards
		String[] textList = {
				"hello card win $5000", 
				"goodbye card",
				"whats up dog",
		};
	}

