package main.java.edu.asu.cst316.gameboard;

public class GameSpace {
	
	private String type = "";
	private int size;
	private GameSpace nextSpace = null;
	private GameSpace alternativeSpace = null;
	
	public GameSpace(String type, int size, GameSpace nextSpace, GameSpace alternativeSpace){
		this.type = type;
		this.size = size;
		this.nextSpace = nextSpace;
		this.alternativeSpace = alternativeSpace;
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
