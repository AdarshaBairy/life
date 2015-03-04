package main.java.edu.asu.cst316;

import java.util.Random;

import main.java.edu.asu.cst316.gameboard.GameBoard;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameMain extends BasicGameState{
	public String mouse = "";
	public Image background;
	public Image gameBoard;
	public Image gameBoardZoom;
	public Image spinner;
	public Image player;
	Image wheel; 
	Image wheelHover;
	Image spinFlipper;
	Image wheelSpinning;
	Animation spinningAnimation;
	Animation flipperAnimation;
	SpriteSheet spinning;
	SpriteSheet flipperAnim;
	private int playerX = -256;
	private int playerY = 464;
	int spinNum = 0;
	int sNum =0;
	int centerOfImageX = 0;
	int centerOfImageY = 0;
	int spinCount =0;
	float mouseX;
	float mouseY;
	boolean mouseOverSpin = false;
	boolean spinClicked = false;
	boolean spun = false;
	boolean shouldSpin = false; 
	boolean defaultImage = true;
	boolean spinAnimation = false;

	GameBoard gameboard = GameBoard.getInstance();
	
	public GameMain(int state){
	}

	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board5.png");
		
		
		player = new Image("images/player.png").getScaledCopy((float) .5);
		spinner = new Image("images/spinner.png");
		
		//Take the game board, resize it to game board view size, and then zoom out for better view
		gameBoardZoom = gameBoard.getSubImage(playerX, playerY, 1372, 624).getScaledCopy((float) .5); //686 312
		
		// declares the sprite sheets to be used, first number is x pixels, second number is y pixels
		flipperAnim = new SpriteSheet("res/flipperspritesheet.png", 24, 30);
		spinning = new SpriteSheet ("res/spinwheelspritesheet.png", 168, 168);
		
		//assigns the sprite sheets to animations number is duration of each frame
		spinningAnimation = new Animation (spinning, 100);
		flipperAnimation = new Animation (flipperAnim, 75);
		
	}

	//@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
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
			gameboard.movePlayer(1);
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
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
		
		//recognize if the mouse is over spin and if spin is clicked
		if((xPosition > 340 && xPosition < 470) && (yPosition > 190 && yPosition < 220)){
				mouseOverSpin = true;
				if(Mouse.isButtonDown(0)){
					spinClicked = true;
				}else spinClicked = false;		
			}else mouseOverSpin = false;
			
			//update spinningAnimation
			if(spinClicked){
				spinningAnimation.update(delta);
			}

			//update spinCount
			if (spinAnimation){
				spinCount += (delta);
			}
			
			//set the duration of the spin animation
			if (spinCount > 3000){
				spinCount = 0;
				spinAnimation = false;
			}
		boolean updatePlayer = false;
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
			updatePlayer = true;
		}
		if(updatePlayer){
			gameboard.movePlayer(spinNum);
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			updatePlayer = false;
		}
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 62, 53);
		g.drawString(mouse, 10, 10);
		g.drawImage(player, 336, 136);
		
		//declare the images used
		wheel = new Image("res/spinwheeldefault.png");
		wheelHover = new Image("res/spinwheelhover.png");
		wheelSpinning = new Image ("res/spinwheelspinning.png");
		spinFlipper = new Image("res/spinflipper.png");	
		
		// creates the center of the image for the rotation
		centerOfImageX = (wheelSpinning.getWidth()/2);
		centerOfImageY = (wheelSpinning.getHeight()/2);
		wheelSpinning.setCenterOfRotation(centerOfImageX, centerOfImageY);
		
		//keep the default image until something is clicked
		if (defaultImage){
			g.drawImage(wheel, 200, 130);
			g.drawImage(spinFlipper, 355, 180);
		}

		//if the wheel is clicked do what we need it to do
		if (spinClicked){
				defaultImage = false;
				spinClicked = false;
				spinNum = getSpinNum(sNum);
				//System.out.println(spinNum);
				spinAnimation = true;
			}
				
		// keeps background image
		g.drawImage(wheel, 200, 130);
		g.drawImage(spinFlipper, 355, 180);
		
		//once the spin is clicked do the animation
		if (spinAnimation){
			spinningAnimation.draw(223,172);
			flipperAnimation.draw(355,180);
		//animation is complete now set the number spun	
		} else{
		wheelSpinning.setRotation(360-(60*(spinNum-1)));
		g.drawImage(wheelSpinning, 222, 172);
		g.drawImage(spinFlipper, 355, 180);
		spinAnimation = false;
		spinClicked = false;
		} // end else 
		
		if (mouseOverSpin){
			g.drawImage(wheelHover, 200, 130);
		}		
		
}//end render
	
	public int getID(){
		return 2;
	}
	
	public void updateBoardView(int x, int y){
		gameBoardZoom = gameBoard.getSubImage(x, y, 1372, 624).getScaledCopy((float) .5); 
		playerX = x;
		playerY = y;
	}
	
	int getSpinNum(int sNum) {
	try {
	    Thread.sleep(250);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
		Random rand = new Random();
		sNum = (rand.nextInt(6))+1;
		return sNum;
	}
	
}