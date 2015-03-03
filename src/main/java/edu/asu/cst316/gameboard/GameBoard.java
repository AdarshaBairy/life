package main.java.edu.asu.cst316.gameboard;

public class GameBoard {
	
	private static final int SPACESIZE = 64;
	
	private static GameBoard gameboard = new GameBoard();
	
	private static GameSpace playerSpace;
		
	private GameSpace endSpace;
	private	GameSpace[] forkSpaces = new GameSpace[6];
	private	GameSpace[] joinSpaces = new GameSpace[6];
	private	GameSpace[][] redSpaces = new GameSpace[6][];
	private	GameSpace[][] greenSpaces = new GameSpace[6][];
	private	GameSpace[][] commonSpaces = new GameSpace[6][];
	private	GameSpace startSpace;
	
	private GameBoard(){

		redSpaces[0] = new GameSpace[5];
		redSpaces[1] = new GameSpace[8];
		redSpaces[2] = new GameSpace[7];
		redSpaces[3] = new GameSpace[7];
		redSpaces[4] = new GameSpace[7];
		redSpaces[5] = new GameSpace[7];
		
		greenSpaces[0] = new GameSpace[12];
		greenSpaces[1] = new GameSpace[17];
		greenSpaces[2] = new GameSpace[17];
		greenSpaces[3] = new GameSpace[17];
		greenSpaces[4] = new GameSpace[17];
		greenSpaces[5] = new GameSpace[17];
		
		commonSpaces[0] = new GameSpace[2];
		commonSpaces[1] = new GameSpace[7];
		commonSpaces[2] = new GameSpace[3];
		commonSpaces[3] = new GameSpace[1];
		commonSpaces[4] = new GameSpace[4];
		commonSpaces[5] = new GameSpace[3];
	
		endSpace = new GameSpace("end", null, null);
		attachSpaces(redSpaces, "red");
		attachSpaces(commonSpaces, "common");
		attachSpaces(greenSpaces, "green");

		for(int i = 0; i < forkSpaces.length; ++i){
			forkSpaces[i] = new GameSpace("fork", redSpaces[i][0], greenSpaces[i][0]);
		}
		
		for(int i = 0; i < joinSpaces.length-1; ++i){
			joinSpaces[i] = new GameSpace("join", commonSpaces[i+1][0], null);
		}
		joinSpaces[joinSpaces.length-1] = new GameSpace("join", endSpace, null);
				
		attachSpaces2(greenSpaces, joinSpaces);
		attachSpaces2(redSpaces, joinSpaces);
		attachSpaces2(commonSpaces, forkSpaces);
		
		startSpace = new GameSpace("start", commonSpaces[0][0], null);
		
		startSpace.setPosition(0, 0);
	
		playerSpace = startSpace;
		
		
	}
	
	
	public static GameBoard getInstance(){
		return gameboard;
	}
	
	public GameSpace getCurrentSpace(){
		return playerSpace;
	}
	
	public void movePlayer(int moveAmount){
		for(int i = 0; i < moveAmount; ++i){
			playerSpace = playerSpace.getNextSpace();
		}
	}
	
	public static void attachSpaces(GameSpace[][] spaces, String type){
		for(int index = 0; index < spaces.length; ++index){
			spaces[index][spaces[index].length-1] = new GameSpace(type, null, null);
			for(int i = spaces[index].length-1; i > 0; --i){
				spaces[index][i-1] = new GameSpace(type, spaces[index][i], null);
			}
		}
	}
	
	public static void attachSpaces2(GameSpace[][] spaces, GameSpace[] nextSpace){
		for(int i = 0; i < spaces.length; ++i){
			spaces[i][spaces[i].length-1].setNextSpace(nextSpace[i]);
		}
	}
	
}