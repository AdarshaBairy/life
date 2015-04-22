package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class CardGenerator {

	private String cardText = " ";
	private String cardType = " ";
	private int cardValue;
	
	public String finalCardText = " ";
	public String finalCardType = " ";
	public int finalCardValue;
	
	public CardGenerator(String finalCardType, String finalCardText, int finalCardValue){
		this.finalCardType = cardType;
		this.finalCardText = cardText;
		this.finalCardValue = cardValue;
	};
	
	//Gets the random value for the blue card
	public int getCommonCardValue(){
		cardValue = 100;
		return cardValue;
	}
	
	//Gets the random value for the green card
	public int getGreenCardValue(){
		cardValue = 2000;
		return cardValue;
	}
	
	//Gets the random value for the red card
	public int getRedCardValue(){
		//Random rand = new Random();
		//int cardNum = (rand.nextInt(3));
		//cardText = redTextList[cardNum];
		cardValue = 300000;
		return cardValue;
	}
	
	public String getFinalCardText(){
		Random rand = new Random();
		int cardNum = (rand.nextInt(3));
		cardText = cardTextList[cardNum];
		return cardText;
	}
		
	public String getFinalCardType(){
		cardType="red";
		return cardType;
	}
	
	String[] cardTextList = {
			"hello card win $5000", 
			"goodbye card",
			"whats up dog",
	};
	
	/*
 		public int getRedCardValue(){
		//Random rand = new Random();
		//int cardNum = (rand.nextInt(3));
		//cardText = redTextList[cardNum];
		cardValue = 300000;
		return cardValue;
	}
	
	//public int getFinalCardText(){
	//	return cardText;
	//}
	
	//The text list for the blue cards
	String[] commonTextList = {
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
	};*/
		
}
