package edu.asu.cst316.gameboard;

public class GameBoard {
	
	private static GameSpace playerSpace;
	private static GameSpace endSpace;
	
	private static int endX;
	private static int endY;
	
	public GameBoard(){
		
		endSpace = new GameSpace("end", 2, null, null, endX, endY);
		//short red path
		GameSpace[] redSpaces5 = new GameSpace[7];
		redSpaces5[6] = new GameSpace("red", 2, endSpace, null, endX-128, endY);
		
		int lastX = endX-128;
		int lastY = endY;
		
		for(int i = 5; i >= 0; --i){
			redSpaces5[i] = new GameSpace("red", 2, redSpaces5[i+1], null, lastX-128, lastY);
		}
		
	
		//long greenpath
		GameSpace[] greenSpaces5 = new GameSpace[17];
		greenSpaces5[16] = new GameSpace("green", 2, endSpace, null, endX, endY-128);
		
		lastX = endX;
		lastY = endY - 128;
		
		for(int i = 15; i >= 13; --i){
			redSpaces5[i] = new GameSpace("green", 2, redSpaces5[i+1], null, endX-128, endY);
		}
		greenSpaces5[12] = new GameSpace("green", 2, redSpaces5[13], null, endX, endY-64);
		for(int i = 11; i >= 7; --i){
			redSpaces5[i] = new GameSpace("green", 2, redSpaces5[i+1], null, endX-128, endY);
		}
		greenSpaces5[6] = new GameSpace("green", 2, redSpaces5[7], null, endX-128, endY);
		
		GameSpace[] mergeJoinSpace = new GameSpace[11];
	}
	
}