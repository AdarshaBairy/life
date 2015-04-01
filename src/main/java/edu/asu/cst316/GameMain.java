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
import main.java.edu.asu.cst316.player.*;

public class GameMain extends BasicGameState{
	
	GameBoard gameboard = GameBoard.getInstance();
	Player playerObj = Player.getInstance();
	
	public String mouse = "";
	public Image background;
	public Image gameBoard;	
	public Image notification;
	public Image gameBoardZoom;
	public Image spinner;
	public Image player;
	
	private int playerX = -256;
	private int playerY = 464;

	int spinNum = 0; 
	int	sNum = 0; 
	int	centerOfImageX = 0; 
	int	centerOfImageY = 0; 
	int	spinCount = 0;
	
	Image wheel; 
	Image wheelHover;
	Image spinFlipper;
	Image wheel1; 
	Image wheel2;
	Image wheel3; 
	Image wheel4;
	Image wheel5; 
	Image wheel6; 
	Image wheelSpinning;
	
	Animation spinningAnimation;
	Animation flipperAnimation;
	
	SpriteSheet spinning;
	SpriteSheet flipperAnim;
	
	float mouseX; 
	float mouseY;
	
	boolean mouseOverSpin = false; 
	boolean	spinClicked = false; 
	boolean	spun = false; 
	boolean	shouldSpin = false; 
	boolean	defaultImage = true; 
	boolean	spinAnimation = false;
	boolean showNotification = false;
	
	public GameMain(int state){
	}

	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board5.png");
		notification = new Image("images/notification_window.png");
		
		
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
		
		if(xPosition > 340 && 
		xPosition < 470 && 
		yPosition > 190 && yPosition < 220){
			mouseOverSpin = true;
			if(Mouse.isButtonDown(0)){
				spinClicked = true;
			}else {
				spinClicked = false;		
			}
		}else {
			mouseOverSpin = false;
		}
		
		if(spinClicked == true){
			spinningAnimation.update(delta);
		}
	
		if (spinAnimation){
			spinCount += (delta);
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
		//When the player lands on a fork space they will see a window giving 
		//of which way they want to go
		if(gameboard.getCurrentSpace().getType().equals("fork")){
			showNotification = true;
			//If the player clicks on safe
			if(input.isMouseButtonDown(0) &&
			xPosition > 175 &&
			xPosition < 300 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayerToAlternativeRoute();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			}
			//If the player clicks on risky
			if(input.isMouseButtonDown(0) &&
			xPosition > 500 &&
			xPosition < 630 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayer(1);
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			}
		}else{
			showNotification = false;
			
		}
		
		if(gameboard.getCurrentSpace().getType().equals("end")){
			showNotification = true;
			//If the player clicks on safe
			if(input.isMouseButtonDown(0) &&
			xPosition > 175 &&
			xPosition < 300 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayerToAlternativeRoute();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			}
			//If the player clicks on risky
			if(input.isMouseButtonDown(0) &&
			xPosition > 500 &&
			xPosition < 630 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayer(1);
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			}
		}else{
			showNotification = false;
			
		}
		
		
		
		//checks for user clicking in the cards icon to display its card history.
		if(
			input.isMouseButtonDown(0) &&
			xPosition >= 660 &&
			xPosition <= 745 &&
			yPosition >= 50 &&
			yPosition <= 155
		){
			sbg.enterState(6);
		}
		
		
		
		
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 62, 53);
		g.drawString(mouse, 10, 10);
		
		//todo status initial render
		g.drawString(playerObj.getName(), 120, 200);
		g.drawString(playerObj.getCareer(), 145, 150);
		g.drawString(Integer.toString(playerObj.getIncome()), 135, 110);
		g.drawString(Integer.toString(playerObj.getSavedMoney()), 195, 70);
		
		g.drawImage(player, 336, 136);
		if(showNotification){
			g.drawImage(notification, 0, 0);
		}
		
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
	
	
	//This function is used for displaying the gameboard map to the viewer
	//X and Y starting corners of where to take the sub image of the entire gameboard image
	//the values 1372 and 624 were for creating the size of the gameboard window
	//Then it gets scaled by .5 making the size of the window into 686 by 312
	
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