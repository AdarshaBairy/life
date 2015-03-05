package main.java.edu.asu.cst316.gameboard;

public class GameBoard {
	
	public static final int SPACESIZE = 128;
	
	private static GameBoard gameboard = new GameBoard();
	
	private static GameSpace playerSpace;
		
	private static GameSpace endSpace;
	private	GameSpace[] forkSpaces = new GameSpace[6];
	private GameSpace[] joinSpaces = new GameSpace[6];
	private GameSpace[][] redSpaces = new GameSpace[6][];
	private GameSpace[][] greenSpaces = new GameSpace[6][];
	private GameSpace[][] commonSpaces = new GameSpace[6][];
	private static GameSpace startSpace;
	GameSpace currentSpace;
	
	private GameBoard(){

		//Instantiate the space arrays for each chunk of spaces on the board
		for(int i = 0; i < redSpaces.length; ++i){
			redSpaces[i] = new GameSpace[7];
		}
		for(int i = 0; i < greenSpaces.length; ++i){
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
		attachSpaces(commonSpaces, "common");
		attachSpaces(greenSpaces, "green");
		for(int i = 0; i < forkSpaces.length; ++i){
			forkSpaces[i] = new GameSpace("fork", redSpaces[i][0], greenSpaces[i][0]);
		}	
		for(int i = 0; i < joinSpaces.length-1; ++i){
			joinSpaces[i] = new GameSpace("join", commonSpaces[i+1][0], null);
		}
		joinSpaces[joinSpaces.length-1] = new GameSpace("join", endSpace, null);
		
		//Attach each chunk of spaces with each other
		attachSpaces2(greenSpaces, joinSpaces);
		attachSpaces2(redSpaces, joinSpaces);
		attachSpaces2(commonSpaces, forkSpaces);
		
		startSpace = new GameSpace("start", commonSpaces[0][0], null);
		currentSpace = new GameSpace("start", commonSpaces[0][0], null);
		

		startSpace.setPosition(-256, 470);
		//System.out.println(startSpace.getPosX());
		//System.out.println(startSpace.getPosY());
		assignPositions(-256, 470);

		
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
	
	public void movePlayer(int moveAmount){
		for(int i = 0; i < moveAmount; ++i){
			playerSpace = playerSpace.getNextSpace();
		}
	}
	
	public void assignPositions2(int x, int y, int length, String direction){
		for(int i = 0; i < length; i++){
			playerSpace.setPosition(x, y);
			playerSpace = playerSpace.getNextSpace();
			x += SPACESIZE;
		}
	}
	
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
		for(int i = 0; i < 2; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
		
		
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		

		for(int i = 0; i < 9; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
		
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		
		for(int i = 0; i < 4; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
		
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			x -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}

		
		currentSpace = currentSpace.getNextSpace();
		
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			x -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		
		for(int i = 0; i < 4; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
	
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			x -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			x += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}		
		
		
		for(int i = 0; i < 4; i++){
			x += SPACESIZE;
			currentSpace = currentSpace.getNextSpace();
		}
		
		//set green spaces
		currentSpace = currentSpace.getAlternativeSpace();
		for(int i = 0; i < 5; i++){
			//move position up
			y += SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 8; i++){
			//move position across
			x -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}
		for(int i = 0; i < 4; i++){
			//move position down
			y -= SPACESIZE;
			currentSpace.setPosition(x, y);
			currentSpace = currentSpace.getNextSpace();
		}	
	
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
	/*
	//Used for assigning payday type to the appropriate spaces
	public static void assignPaydayType(){
		for(int i = 0; i < greenSpaces.length; ++i){
			greenSpaces[i][7].setType("payday");
		}
	}
	
	//Used for assigning milestone type to the appropriate spaces
	public static void assignMileStoneType(){
		commonSpaces[1][0].setType("milestone");
		commonSpaces[1][6].setType("milestone");
		commonSpaces[3][0].setType("milestone");
		commonSpaces[4][0].setType("milestone");	
	}
	*/
}