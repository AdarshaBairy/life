package main.java.edu.asu.cst316.gameboard;

public class GameBoard {
	
	private static GameSpace playerSpace;
	
	public static void createGameBoard(){
		playerSpace = new GameSpace("start", 3, null, null);
		playerSpace.setNextSpace(new GameSpace("neutral", 2, null, null));
		
	}
	
}