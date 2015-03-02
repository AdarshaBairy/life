package edu.asu.cst316.gameboard;

public class GameBoard {
	
	private static GameBoard gameboard = new GameBoard();
	
	private static GameSpace playerSpace;
	
	private static int endX;
	private static int endY;
	
	private GameSpace endSpace;
	private	GameSpace[] forkSpaces = new GameSpace[6];
	private	GameSpace[] joinSpaces = new GameSpace[5];
	private	GameSpace[][] redSpaces = new GameSpace[6][];
	private	GameSpace[][] greenSpaces = new GameSpace[6][];
	private	GameSpace[][] commonSpaces = new GameSpace[6][];
	private	startSpace = new GameSpace("start", null, null, null, null);
	
	
	private GameBoard(){
		
		
		attachSpaces(5, forkSpaces[5], endSpace);
/*		attachRedSpaces(4, forkSpaces[4], mergeSpaces[4]);
		attachRedSpaces(3, forkSpaces[3], mergeSpaces[3]);
		attachRedSpaces(2, forkSpaces[2], mergeSpaces[2]);
		attachRedSpaces(1, forkSpaces[1], mergeSpaces[1]);
		attachRedSpaces(0, forkSpaces[0], mergeSpaces[0]);		*/
		

		attachSpaces(redSpaces, "red");
		attachSpaces(commonSpaces, "blue");
		attachSpaces(greenSpaces, "green");

		for(int i = 0; i < forkSpaces.length; ++i){
			forkSpaces[i] = new GameSpace("fork", redSpaces[i][0], greenSpaces[i]);
		}
		
		for(int i = 0; i < joinSpaces.length; ++i){
			joinSpaces[i] = new GameSpace("join", commonSpaces[i+1][0], null);
		}
		
		for(int i = 0; i < greenSpaces.length; ++i){
			greenSpaces[i][greenSpaces[i].length].setNextSpace(joinSpaces[i][0]);
		}
		
		
		startSpace = new GameSpace("start", commonSpaces[i+1], null);
		
		
		
		redSpaces[5][6] = new GameSpace("red", 2, endSpace, null, endX-128, endY);
		
		int lastX = endX-128;
		int lastY = endY;
		
		for(int i = 5; i >= 0; --i){
			redSpaces5[i] = new GameSpace("red", 2, redSpaces5[i+1], null, lastX-128, lastY);
		}
		
		//merge
		
		mergeJoinSpaces[10] = new GameSpace("merge", 3, redSpaces5[0], greenSpaces5[0], 500, 500);
		
		//blue
		GameSpace[] blueSpaces4 = new GameSpace[3];
		blueSpaces4[2] = new GameSpace("blue", 2, mergeJoinSpaces[10], null, endX-128, endY);
		blueSpaces4[1] = new GameSpace("blue", 2, blueSpaces4[2], null, endX-128, endY);
		blueSpaces4[0] = new GameSpace("blue", 2, blueSpaces4[0], null, endX-128, endY);
		
		//merge
		mergeJoinSpaces[9] = new GameSpace("merge", 3, blueSpaces4[0], greenSpaces5[0], 500, 500);
		
	
	
	
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
		greenSpaces5[6] = new GameSpace("payday", 2, redSpaces5[7], null, endX-128, endY);
		
		
		
		
		
		
		for(int i = 15; i >= 13; --i){
			redSpaces5[i] = new GameSpace("green", 2, redSpaces5[i+1], null, endX-128, endY);
		}
		greenSpaces5[12] = new GameSpace("green", 2, redSpaces5[13], null, endX, endY-64);
		for(int i = 11; i >= 7; --i){
			redSpaces5[i] = new GameSpace("green", 2, redSpaces5[i+1], null, endX-128, endY);
		}
		greenSpaces5[6] = new GameSpace("payday", 2, redSpaces5[7], null, endX-128, endY);
		
		
	}
	
	
	public static GameBoard getInstance(){
		return gameboard;
	}
	
	public GameSpace getCurrentSpace(){
		return playerSpace;
	}
	
	public static instantiateSpaceArrays(){
	
	}
	
	public static attachGreenSpaces(int index){
		greenSpaces[index][greenSpaces[index].length-1] = new GameSpace("green", joinSpaces[index], null, endX, endY);
		for(int i = greenSpaces[index].length-1; i > 0; --i){
			greenSpaces[index][i-1] = new GameSpace("green", greenSpaces[index][i], null, endX, endY);
		}
		forkSpaces[index].setAlternativeSpace(greenSpaces[index][0]);
	}
	
	public static attachRedSpaces(int index, GameSpace start, GameSpace end){
		end = new GameSpace("end", null, null, endX, endY);
		
		redSpaces[index][redSpaces[index].length-1] = new GameSpace("red", endSpace, null, endX, endY);
		for(int i = redSpaces[index].length-1; i > 0; --i){
			redSpaces[index][i-1] = new GameSpace("red", redSpaces[index][i], null, endX, endY);
		}
		GameSpace start = new GameSpace("red", redSpaces[index][0], null, endX, endY);
	}
	
	public static attachSpaces(GameSpace[][] spaces, String type){
		for(int index = 0; i < spaces.length; ++i){
			spaces[index][spaces[index].length-1] = new GameSpace(type, null, null, null, null);
			for(int i = spaces[index].length-1; i > 0; --i){
				spaces[index][i-1] = new GameSpace(type, spaces[index][i]);
			}
		}
	}
	
	
	
}