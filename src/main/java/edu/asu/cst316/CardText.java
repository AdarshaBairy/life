package main.java.edu.asu.cst316;

import java.util.Random;

public class CardText {
	
	private String cardText;
	int cardNum =0;
	
	public String getCardText(){
		cardText = textList[getCardNum(cardNum)];
		return cardText;
	}
		
int getCardNum(int cardNum) {
	Random rand = new Random();
	cardNum = (rand.nextInt(3));
	return cardNum;
	}
	
	String[] textList = {
			"hello card", 
			"goodbye card",
			"whats up dog",
	};

}
