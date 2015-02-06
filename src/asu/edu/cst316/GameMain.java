package asu.edu.cst316;

import org.lwjgl.input.Mouse;
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
	public Image gameBoardZoom;
	private int playerX = 750;
	private int playerY = 900;
	
	public GameMain(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board3.png");
		gameBoardZoom = gameBoard.getSubImage(playerX, playerY, 680, 300);
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
				yPosition > 20
		){
			sbg.enterState(0);
		}
		if(
				input.isMouseButtonDown(0)
		){
			updateBoardView(50, 0);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 65, 60);
		g.drawString(mouse, 10, 10);
	}
	
	public int getID(){
		return 2;
	}
	
	public void updateBoardView(int x, int y){
		gameBoardZoom = gameBoard.getSubImage(playerX+x, playerY+y, 680, 300);
		playerX += x;
		playerY += y;
	}
}