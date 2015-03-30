package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class GreenCardText {

	private String cardText;
	
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
