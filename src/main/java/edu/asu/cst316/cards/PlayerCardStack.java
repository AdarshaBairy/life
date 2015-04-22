package main.java.edu.asu.cst316.cards;

import java.util.ArrayList;

public class PlayerCardStack {
	
	private static PlayerCardStack pcs = new PlayerCardStack();

	ArrayList<Card> playerCards = new ArrayList<Card>();
	
	public void addCard(Card currentCard){
		playerCards.add(currentCard);
		System.out.println(playerCards.get(playerCards.size()-1).getText());
		System.out.println(playerCards.get(playerCards.size()-1).getType());
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
	
	public void printOutAll(){
		for(int i = 0; i < playerCards.size(); ++i){
			System.out.print(playerCards.get(i).getType());
			System.out.print(playerCards.get(i).getText());
		}
	}
}
