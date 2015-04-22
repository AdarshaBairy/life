package main.java.edu.asu.cst316;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class HistoryCards extends BasicGameState{
	
	StateBasedGame stateBasedGame;
	public String mouse = "";
	public Image background;
	
	
	public HistoryCards(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		stateBasedGame = sbg;
		background = new Image("images/HistoryCard.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;				
	}

	@Override
	public int getID() {
		
		return 6;
	}
	
	
	public void mousePressed(int button, int x, int y) {
		y = 600 - y;
		System.out.println("click");
		System.out.println(x);
		System.out.println(y);
		if(button == 0){
			backButtonAction(x, y);
			nextButtonAction(x, y);
			gameMainAction(x,y);
		}
	}

	public void backButtonAction(int x, int y){
		
	}
	
	public void nextButtonAction(int x, int y){
		
	}
	
	public void gameMainAction(int x, int y){
		if(x >= 50 &&
		x <= 202 &&
		y >= 39 &&
		y <= 85){
			stateBasedGame.enterState(2);
		}
	}
}
