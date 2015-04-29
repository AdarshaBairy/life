package main.java.edu.asu.cst316.gameboard;

public class GameBoard {
	
	public static final int SPACESIZE = 128;
	
	private static GameBoard gameboard = new GameBoard();
	
	//private static GameSpace playerSpace;
	private static GameSpace playerSpace;
	//public String playerLandSpace;
		
	private static GameSpace endSpace;
	private	GameSpace[] forkSpaces = new GameSpace[6];
	private GameSpace[] joinSpaces = new GameSpace[6];
	private static GameSpace[][] redSpaces;
	private static GameSpace[][] greenSpaces;
	private static GameSpace[][] commonSpaces;
	private static GameSpace startSpace;
	public static GameSpace currentSpace;
	
	
	private GameBoard(){

		greenSpaces = new GameSpace[6][];
		commonSpaces = new GameSpace[6][];
		redSpaces = new GameSpace[6][];
		
		
		//Instantiate the space arrays for each chunk of spaces on the board
		for(int i = 0; i < redSpaces.length; ++i){
			redSpaces[i] = new GameSpace[7];
		}
		for(int i = 0; i < 6; ++i){
			greenSpaces[i] = new GameSpace[17];
		}
		commonSpaces[0] = new GameSpace[2];
		commonSpaces[1] = new GameSpace[8];
		commonSpaces[2] = new GameSpace[3];
		commonSpaces[3] = new GameSpace[1];
		commonSpaces[4] = new GameSpace[4];
		commonSpaces[5] = new GameSpace[4];
	
		//Attach the spaces of each chunk with the rest of the spaces in their chunk
		endSpace = new GameSpace("end", null, null);
		attachSpaces(redSpaces, "red");
		attachSpaces(commonSpaces, "common"); //Blue spaces
		attachSpaces(greenSpaces, "green");
		for(int i = 0; i < forkSpaces.length; ++i){
			forkSpaces[i] = new GameSpace("fork", redSpaces[i][0], greenSpaces[i][0]);
		}	
		for(int i = 0; i < joinSpaces.length-1; ++i){
			joinSpaces[i] = new GameSpace("join", commonSpaces[i+1][0], null);
		}
		joinSpaces[joinSpaces.length-1] = new GameSpace("end", null, null);
		
		//Attach each chunk of spaces with each other
		attachSpaces2(greenSpaces, joinSpaces);
		attachSpaces2(redSpaces, joinSpaces);
		attachSpaces2(commonSpaces, forkSpaces);
		
		startSpace = new GameSpace("start", commonSpaces[0][0], null);
		currentSpace = new GameSpace("start", commonSpaces[0][0], null);
		

		startSpace.setPosition(-256, 470);
		////System.out.println(startSpace.getPosX());
		////System.out.println(startSpace.getPosY());
		assignPositions(-256, 470);

		assignPositions2(-256, 470);
		
		greenSpaces[4][9].setType("payday");
		greenSpaces[5][9].setType("payday");
		assignPaydayType();
		greenSpaces[4][7].setType("reen");
		greenSpaces[5][7].setType("green");
		//assignMileStoneType();
		playerSpace = startSpace;
		
	}
	
	public void reset(){
		playerSpace = startSpace;
	}
	
	public static GameBoard getInstance(){
		return gameboard;
	}
	
	public GameSpace getCurrentSpace(){
		return playerSpace;
	}
	
	
	//Moves the player across the board
	//Stops is the space is a fork, milestone, payday, or end space
	public void movePlayer(int moveAmount){
		if(playerSpace.getType().equals("end")){
			moveAmount = 0;
		}
		for(int i = 0; i < moveAmount; ++i){
			if(playerSpace.getNextSpace() != null){
				playerSpace = playerSpace.getNextSpace();
			}
			if(playerSpace != null){
				if("fork".equals(playerSpace.getType()) &&
				"milestone".equals(playerSpace.getType()) &&
				"payday".equals(playerSpace.getType()) &&
				"end".equals(playerSpace.getType())){
					i = moveAmount;
				}	
			}
		}
		
		if(playerSpace.getType().equals("join")){
			playerSpace = playerSpace.getNextSpace();
		}
	}
	

	//Player moves to a green space from a fork space
	public void movePlayerToAlternativeRoute(){
		playerSpace = playerSpace.getAlternativeSpace();
	}
	
	/*
	public void assignPositions2(int x, int y, int length, String direction){
		for(int i = 0; i < length; i++){
			playerSpace.setPosition(x, y);
			playerSpace = playerSpace.getNextSpace();
			x += SPACESIZE;
		}
	}
	*/

	
	public void assignPositions(int x, int y){ 
		currentSpace = startSpace.getNextSpace();
		for(int i = 0; i < 28; i++){
			x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		for(int i = 0; i < 4; i++){
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		for(int i = 0; i < 23; i++){
			x -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		for(int i = 0; i < 8; i++){
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		for(int i = 0; i < 13; i++){
			x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}	
	}

	
	public void assignPositions2(int x, int y){ 
		currentSpace = startSpace.getNextSpace();
		////System.out.println(currentSpace.getType());
		for(int i = 0; i < 2; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		x += SPACESIZE;
		//System.out.println(currentSpace.getType());
		assignPositionToGreenChunk(x, y, 1);
		x = currentSpace.getPosX();
		y = currentSpace.getPosY();
		
		for(int i = 0; i < 9; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		//System.out.println(currentSpace.getType());
		assignPositionToGreenChunk(x, y, 1);
		x = currentSpace.getPosX();
		y = currentSpace.getPosY();
		
		for(int i = 0; i < 4; i++){
			y += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		//System.out.println(currentSpace.getType());
		assignPositionToGreenChunk(x, y, -1);	
		x = currentSpace.getPosX();
		y = currentSpace.getPosY();
		
		for(int i = 0; i < 2; i++){
			x -= SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		//System.out.println(currentSpace.getType());
		assignPositionToGreenChunk(x, y, -1);	
		x = currentSpace.getPosX();
		y = currentSpace.getPosY();
		
		for(int i = 0; i < 5; i++){
			x -= SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		//System.out.println(currentSpace.getType());
		assignPositionToGreenChunk(x, y, 0);	
		x = currentSpace.getPosX();
		y = currentSpace.getPosY();
		
		
		
		for(int i = 0; i < 5; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		assignPositionToGreenChunk(x, y, -2);
		//x = currentSpace.getPosX();
		//y = currentSpace.getPosY();
	
	}
	
	//Direction is the direction the player will go when going the alternative route aka the green route
	// 1 = Up
	// 0 = Left
	//-1 = Down
	//-2 = DownRight
	public static int[] assignPositionToGreenChunk(int x, int y, int direction){
		for(int i = 0; i < 5; i++){
			//move position up
			if (direction == 1) y -= SPACESIZE;
			else if (direction == 0) x -= SPACESIZE;
			else if (direction == -1) y += SPACESIZE;
			else if (direction == -2) y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		for(int i = 0; i < 8; i++){
			//move position across
			if (direction == 1) x += SPACESIZE;
			else if (direction == 0) y += SPACESIZE;
			else if (direction == -1) x -= SPACESIZE;
			else if (direction == -2) x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}
		for(int i = 0; i < 4; i++){
			//move position down
			if (direction == 1) y += SPACESIZE;
			else if (direction == 0) x += SPACESIZE;
			else if (direction == -1) y -= SPACESIZE;
			else if (direction == -2) y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
			//System.out.println(currentSpace.getType());
		}	
		int[] positions = new int[2];
		positions[0] = x;
		positions[1] = y;
		return positions;
	}
	
	
	//used for attaching the entered chunk of spaces together
	public static void attachSpaces(GameSpace[][] spaces, String type){
		for(int index = 0; index < spaces.length; ++index){
			spaces[index][spaces[index].length-1] = new GameSpace(type, null, null);
			for(int i = spaces[index].length-1; i > 0; --i){
				spaces[index][i-1] = new GameSpace(type, spaces[index][i], null);
			}
		}
	}
	
	//Used for attaching the chunks of spaces with other chunk of spaces
	public static void attachSpaces2(GameSpace[][] spaces, GameSpace[] nextSpace){
		for(int i = 0; i < spaces.length; ++i){
			spaces[i][spaces[i].length-1].setNextSpace(nextSpace[i]);
		}
	}
	//TODO: implement this with the board without breaking it
	//Used for assigning payday type to the appropriate spaces
	public static void assignPaydayType(){
		for(int i = 0; i < greenSpaces.length; ++i){
			greenSpaces[i][7].setType("payday");
		}
	}
	
	//Used for assigning milestone type to the appropriate spaces
	public static void assignMileStoneType(){
		commonSpaces[1][0].setType("milestone");
		commonSpaces[1][7].setType("milestone");
		commonSpaces[3][0].setType("milestone");
		commonSpaces[4][0].setType("milestone");	
	}
	
}