package asu.edu.cst316;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class GameMain extends BasicGameState{
	public String mouse = "";
	public Image background;
	public Image gameBoard;
	
	public GameMain(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board.png").getSubImage(300, 600, 20, 20);
		//gameBoard = gameBoard.getSubImage(300, 600, 680, 310);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 20 &&
				xPosition < 170 &&
				yPosition < 60 &&
				yPosition > 20)
		{
			sbg.enterState(0);
		}
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoard, 65, 545);
		g.drawString(mouse, 10, 10);
		
	}
	
	public int getID(){
		return 2;
	}
	
}