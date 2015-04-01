package main.java.edu.asu.cst316.cards;

import java.util.Random;

public class Deck {
	
	private static Deck deck = new Deck();
	
	private Card commonCards[];
	private Card redCards[];
	private Card greenCards[];
	
	private Deck(){
		commonCards = new Card[10];
		redCards = new Card[10];
		greenCards = new Card[10];
		
		commonCards[0] = new Card("Common: 0", 4000);
		commonCards[1] = new Card("Common: 1", -3500);
		commonCards[2] = new Card("Common: 2", -4000);
		commonCards[3] = new Card("Common: 3", 3500);
		commonCards[4] = new Card("Common: 4", 5000);
		commonCards[5] = new Card("Common: 5", -3000);
		commonCards[6] = new Card("Common: 6", 4000);
		commonCards[7] = new Card("Common: 7", -2000);
		commonCards[8] = new Card("Common: 8", 3000);
		commonCards[9] = new Card("Common: 9", -3000);
		
		redCards[0] = new Card("Risky: 0", -6000);
		redCards[1] = new Card("Risky: 1", 8000);
		redCards[2] = new Card("Risky: 2", 7000);
		redCards[3] = new Card("Risky: 3", 11000);
		redCards[4] = new Card("Risky: 4", -5000);
		redCards[5] = new Card("Risky: 5", -9000);
		redCards[6] = new Card("Risky: 6", -6000);
		redCards[7] = new Card("Risky: 7", -9000);
		redCards[8] = new Card("Risky: 8", 7500);
		redCards[9] = new Card("Risky: 9", -8000);
		
		greenCards[0] = new Card("Safe: 0", 2000);
		greenCards[1] = new Card("Safe: 1", 1000);
		greenCards[2] = new Card("Safe: 2", -1000);
		greenCards[3] = new Card("Safe: 3", 2000);
		greenCards[4] = new Card("Safe: 4", -2500);
		greenCards[5] = new Card("Safe: 5", 3000);
		greenCards[6] = new Card("Safe: 6", -500);
		greenCards[7] = new Card("Safe: 7", 1500);
		greenCards[8] = new Card("Safe: 8", 3000);
		greenCards[9] = new Card("Safe: 9", -2000);
	}
	
	public static Deck getInstance(){
		return deck;
	}
	
	public Card getCommonCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return commonCards[cardIndex];
	}
	
	public Card getRedCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return redCards[cardIndex];
	}
	
	public Card getGreenCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return greenCards[cardIndex];
	}
}
