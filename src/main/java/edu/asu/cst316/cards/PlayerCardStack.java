package main.java.edu.asu.cst316.cards;

import java.util.ArrayList;

public class PlayerCardStack {
	
	private static PlayerCardStack pcs = new PlayerCardStack();

	ArrayList<Card> playerCards = new ArrayList<Card>();
	
	public void addCard(Card currentCard){
		playerCards.add(currentCard);
	}
	
	public int getSize(){
		return playerCards.size();
	}
	
	public Card getCurrentCard(int i){
		if (i >= playerCards.size()){
			Card card = new Card("No more Cards", i);
			card.setType("no cards");
			return card;
		}else
			return playerCards.get(i);
	}

	public static PlayerCardStack getInstance(){
		return pcs;
	}
	
}
