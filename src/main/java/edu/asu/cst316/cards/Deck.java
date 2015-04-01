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
		
		//Populate the deck with cards
		commonCards[0] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[1] = new Card("Blue Space: You lose -3500", -3500);
		commonCards[2] = new Card("Blue Space: You lose -4000", -4000);
		commonCards[3] = new Card("Blue Space: You gain 3500", 3500);
		commonCards[4] = new Card("Blue Space: You gain 5000", -5000);
		commonCards[5] = new Card("Blue Space: You lose -3000", -3000);
		commonCards[6] = new Card("Blue Space: You gain 4000", 4000);
		commonCards[7] = new Card("Blue Space: You lose -2000", -2000);
		commonCards[8] = new Card("Blue Space: You gain 3000", 3000);
		commonCards[9] = new Card("Blue Space: You lose -3000", -3000);
		
		redCards[0] = new Card("Red Space: You lose -6000", -6000);
		redCards[1] = new Card("Red Space: You gain 8000", 8000);
		redCards[2] = new Card("Red Space: You gain 7000", 7000);
		redCards[3] = new Card("Red Space: You gain 11000", 11000);
		redCards[4] = new Card("Red Space: You lose -5000", -5000);
		redCards[5] = new Card("Red Space: You lose -9000", -9000);
		redCards[6] = new Card("Red Space: You lose -6000", -6000);
		redCards[7] = new Card("Red Space: You lose -9000", -9000);
		redCards[8] = new Card("Red Space: You gain 7500", 7500);
		redCards[9] = new Card("Red Space: You lose -8000", -8000);
		
		greenCards[0] = new Card("Green Space: You gain 2000", 2000);
		greenCards[1] = new Card("Green Space: You gain 1000", -1000);
		greenCards[2] = new Card("Green Space: You lose -1000", -1000);
		greenCards[3] = new Card("Green Space: You gain 2000", 2000);
		greenCards[4] = new Card("Green Space: You lose -2500", -2500);
		greenCards[5] = new Card("Green Space: You gain 3000", 3000);
		greenCards[6] = new Card("Green Space: You lose -500", -500);
		greenCards[7] = new Card("Green Space: You gain 1500", -1500);
		greenCards[8] = new Card("Green Space: You gain 3000", 3000);
		greenCards[9] = new Card("Green Space: You lose -2000", -2000);
	}
	
	public static Deck getInstance(){
		return deck;
	}
	
	
	//Get a random common card from the deck
	public Card getCommonCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return commonCards[cardIndex];
	}
	
	//Get a random red card from the deck
	public Card getRedCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return redCards[cardIndex];
	}
	
	//Get a random green card from the deck
	public Card getGreenCard(){
		Random randomInt = new Random();
		int cardIndex = randomInt.nextInt(9);
		return greenCards[cardIndex];
	}
}
