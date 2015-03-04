package main.java.edu.asu.cst316;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
	
	public static final String gamename = "Game of Life";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int main = 2;
	public static final int event = 3;
	public static final int fullboard = 4;
	public static final int charCreation = 5;
	
	
	public Game(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Instructions(play));
		this.addState(new GameMain(main));
		this.addState(new EventNotification(event));
		this.addState(new FullBoard(fullboard));
		this.addState(new CharacterCreationMenu(charCreation));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(main).init(gc, this);
		this.getState(event).init(gc, this);
		this.getState(fullboard).init(gc, this);
		this.getState(charCreation).init(gc, this);
		
		this.enterState(menu);
	}
	
	public static void main(String[] args){
		
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(800, 600, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
}