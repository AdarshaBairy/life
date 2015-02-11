package edu.asu.cst316;

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
	public Image spinner;
	public Image player;
	private int playerX = -416;
	private int playerY = 464;
	
	public GameMain(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board5.png");
		
		
		player = new Image("images/player.png").getScaledCopy((float) .5);
		spinner = new Image("images/spinner.png");
		
		//Take the game board, resize it to game board view size, and then zoom out for better view
		gameBoardZoom = gameBoard.getSubImage(playerX, playerY, 1372, 624).getScaledCopy((float) .5); //686 312
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		if(
				input.isMousePressed(0) &&
				xPosition > 333 &&
				xPosition < 490 &&
				yPosition < 180 &&
				yPosition > 20
		){
			updateBoardView(128, 0);
			//sbg.enterState(3);
		}
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 564 &&
				xPosition < 715 &&
				yPosition < 215 &&
				yPosition > 180
		){
			sbg.enterState(4);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 62, 53);
		g.drawString(mouse, 10, 10);
		g.drawImage(player, 336, 136);
	}
	
	public int getID(){
		return 2;
	}
	
	public void updateBoardView(int x, int y){
		gameBoardZoom = gameBoard.getSubImage(playerX+x, playerY+y, 1372, 624).getScaledCopy((float) .5); 
		playerX += x;
		playerY += y;
	}
	
}