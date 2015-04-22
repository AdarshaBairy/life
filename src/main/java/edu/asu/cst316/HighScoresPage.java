package main.java.edu.asu.cst316;


import java.util.List;

import main.java.edu.asu.cst316.highscore.HighScores;
import main.java.edu.asu.cst316.highscore.PlayerRecord;
import main.java.edu.asu.cst316.player.Player;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class HighScoresPage extends BasicGameState{
	//variables
	public String mouse = "";
	public Image background;
	public Image instructions;
	public Image instruc;
	public String[] playerRecordEntries;
	
	boolean isThisState = true;
	int y = 0;
	int x = 0;
	
	public Player entrP = Player.getInstance();
	
	public HighScoresPage(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		background = new Image("images/highscores.png");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		
		//This if is for the back button
		if(input.isMouseButtonDown(0) &&
		xPosition > 20 &&
		xPosition < 170 &&
		yPosition < 60 &&
		yPosition > 20){
			isThisState = true;
			System.out.println(isThisState);
			sbg.enterState(0);
		}

	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
		if(playerRecordEntries == null){
			playerRecordEntries = new String[1];
			playerRecordEntries[0] = "no highscores";
		}
		for(int i = 0; i < playerRecordEntries.length && playerRecordEntries[i] != null; ++i){
			g.drawString(playerRecordEntries[i], 100, 200 + i*30);
		}
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		HighScores highScores = HighScores.getInstance();
		List<PlayerRecord> playerRecords = highScores.getHighScoreList();
		playerRecordEntries = new String[playerRecords.size()];
		
		for (int i = 0; i < playerRecords.size() && i < 10; i++) {
			playerRecordEntries[i] = (i+1)+". "+playerRecords.get(i).getPlayerName()
					+"    "+playerRecords.get(i).getScore();
		}
		highScores.serialize();
	}
	
	
	//id for the class instructions
	public int getID(){
		return 9;
	}
	
	//method updates what section of the image instructions is being displayed. 
	public void updateBoardView(int x, int y){
		instruc = instructions.getSubImage(x, y, 800, 340);
	}

}