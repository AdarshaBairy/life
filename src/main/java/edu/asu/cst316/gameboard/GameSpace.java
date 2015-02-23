package edu.asu.cst316.gameboard;

public class GameSpace {
	
	private String type = "";
	private int size;
	private GameSpace nextSpace = null;
	private GameSpace alternativeSpace = null;
	private int posX;
	private int posY;
	
	public GameSpace(String type, int size, GameSpace nextSpace, GameSpace alternativeSpace, int posX, int posY){
		this.type = type;
		this.size = size;
		this.nextSpace = nextSpace;
		this.alternativeSpace = alternativeSpace;
		this.posX = posX;
		this.posY = posY;
	}
	
	public String getType(){
		return type;
	}
	public int getSize(){
		return size;
	}
	public GameSpace getNextSpace(){
		return nextSpace;
	}
	public GameSpace getAlternativeSpace(){
		return alternativeSpace;
	}
	public void setNextSpace(GameSpace nextSpace){
		this.nextSpace = nextSpace;
	}
	public void setAlternativeSpace(GameSpace alternativeSpace){
		this.alternativeSpace = alternativeSpace;
	}
}
