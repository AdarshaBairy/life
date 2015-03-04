package main.java.edu.asu.cst316;

import java.util.Random;

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
	private int playerX = -416;
	private int playerY = 464;
	
	Image wheel , wheelHover, spinFlipper, wheel1, wheel2, wheel3, wheel4, wheel5, wheel6, wheelSpinning;
	Animation spinningAnimation, flipperAnimation;
	SpriteSheet spinning, flipperAnim;
	int spinNum = 0, sNum =0, centerOfImageX = 0, centerOfImageY = 0, spinCount =0;
	float mouseX, mouseY;
	boolean mouseOverSpin = false, spinClicked = false, spun = false, shouldSpin = false, 
			defaultImage = true, spinAnimation = false;
	
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
		
		if((xPosition > 340 && xPosition < 470) && (yPosition > 190 && yPosition < 220)){
			mouseOverSpin = true;
			if(Mouse.isButtonDown(0)){
				spinClicked = true;
			}else spinClicked = false;		
		}else mouseOverSpin = false;
		
		if(spinClicked == true){
			spinningAnimation.update(delta);
		}
	
		if (spinAnimation){
			spinCount += (delta);
		}
		
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
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
		
		if (defaultImage == true){
			g.drawImage(wheel, 306, 375);
			g.drawImage(spinFlipper, 460, 420);
		}

		if (mouseOverSpin == true){
			g.drawImage(wheelHover, 306, 375);
		}	
		
		if (spinClicked == true){
				defaultImage = false;
				spinClicked =false;
				spinNum = getSpinNum(sNum);
				System.out.println(spinNum);
				spinAnimation = true;
			}
						
		if (spinAnimation){
			spinningAnimation.draw(329, 415);
			flipperAnimation.draw(460, 420);
		} else{
		
		if (spinNum == 1){
			wheelSpinning.setRotation(0);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}	
		if (spinNum == 2){
			wheelSpinning.setRotation(330);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}
		if (spinNum == 3){
			wheelSpinning.setRotation(275);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}		
		if (spinNum == 4){
			wheelSpinning.setRotation(180);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}
		if (spinNum == 5){
			wheelSpinning.setRotation(120);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}		
		if (spinNum == 6){
			wheelSpinning.setRotation(90);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}		
		spinAnimation = false;
		spinClicked = false;
	} // end else 
		
}
	
	public int getID(){
		return 2;
	}
	
	public void updateBoardView(int x, int y){
		gameBoardZoom = gameBoard.getSubImage(playerX+x, playerY+y, 1372, 624).getScaledCopy((float) .5); 
		playerX += x;
		playerY += y;
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