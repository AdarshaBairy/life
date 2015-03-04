package main.java.edu.asu.cst316.gameboard;

public class GameSpace {
	
	private String type = "";
	private GameSpace nextSpace = null;
	private GameSpace alternativeSpace = null;
	private int posX;
	private int posY;
	public GameSpace newSpace;
	
	public GameSpace(String type, GameSpace nextSpace, GameSpace alternativeSpace, int posX, int posY){
		this.type = type;
		this.nextSpace = nextSpace;
		this.alternativeSpace = alternativeSpace;
		this.posX = posX;
		this.posY = posY;
	}
	
	public GameSpace(String type, GameSpace nextSpace, GameSpace alternativeSpace){
		this.type = type;
		this.nextSpace = nextSpace;
		this.alternativeSpace = alternativeSpace;
	}
	
	public GameSpace(GameSpace copySpace){
		newSpace = copySpace.newSpace;
	}
	
	public String getType(){
		return type;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public GameSpace getNextSpace(){
		return nextSpace;
	}
	public GameSpace getAlternativeSpace(){
		return alternativeSpace;
	}
		
	public void setType(String type){
		this.type = type;
	}
	public void setPosition(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	public void setPosX(int x){
		this.posX = x;
	}
	public void setPosY(int y){
		this.posY = y;
	}
	public void setNextSpace(GameSpace nextSpace){
		this.nextSpace = nextSpace;
	}
	public void setAlternativeSpace(GameSpace alternativeSpace){
		this.alternativeSpace = alternativeSpace;
	}
	
	
}
