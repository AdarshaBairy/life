package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class CardGenerator {

	private String cardText;
	private int cardValue;
	
	public String FinalCardText;
	public int FinaCardValue;
	
	
	
	public CardGenerator(String finalcardText, int finalCardValue){
		this.FinalCardText = cardText;
		this.FinaCardValue = cardValue;
	};
	
	//Gets the random text for the blue card
	public String getBlueCardText(){
		Random rand = new Random();
		int cardNum = (rand.nextInt(3));
		cardText = blueTextList[cardNum];
		return cardText;
	}
	
	//Gets the random text for the green card
	public String getGreenCardText(){
		Random rand = new Random();
		int cardNum = (rand.nextInt(3));
		cardText = greenTextList[cardNum];
		return cardText;
	}
	
	//Gets the random text for the red card
	public String getRedCardText(){
		Random rand = new Random();
		int cardNum = (rand.nextInt(3));
		cardText = redTextList[cardNum];
		return cardText;
	}
	
	public String getFinalCardText(){
		return cardText;
	}
	
	public int getFinalCardValue(){
		cardValue = 100;
		return cardValue;
	}
	
	//The text list for the blue cards
	String[] blueTextList = {
			"hello card win $5000", 
			"goodbye card",
			"whats up dog",
	};
	
	//The text list for the green cards
	String[] greenTextList = {
			"5000", 
			"card",
			"dog",
	};
	
	//The text list for the red cards
	String[] redTextList = {
			"hello", 
			"goodbye",
			"what",		
	};
		
}
