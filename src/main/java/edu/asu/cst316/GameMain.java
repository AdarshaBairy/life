package main.java.edu.asu.cst316;

import java.util.Random;

import main.java.edu.asu.cst316.cards.CardGenerator;
import main.java.edu.asu.cst316.cards.CardText;
import main.java.edu.asu.cst316.gameboard.GameBoard;
import main.java.edu.asu.cst316.gameboard.GameSpace;

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
	
	GameBoard gameboard = GameBoard.getInstance();
	
	public String mouse = "";
	public String cardType = "";
	public Image background;
	public Image gameBoard;	
	public Image notification;
	public Image eventWindow;
	public Image gameBoardZoom;
	public Image spinner;
	public Image player;
	public Image blueCard;
	public Image greenCard;
	public Image redCard;

	private int playerX = -256;
	private int playerY = 464;

	String cardText;
	public static String playerSpaceColor;

	int spinNum = 0; 
	int	sNum = 0; 
	int	centerOfImageX = 0; 
	int	centerOfImageY = 0; 
	int	spinCount = 0;
	int cardValue = 0;
	int cardDisplayTime = 0;
	
	Image wheel; 
	Image wheelHover;
	Image spinFlipper;
	Image wheelSpinning;
	Image cardColor;
	
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
	boolean showEventWindow = false;
	boolean cardGenerated = false;
	boolean cardSelected = false;
	
	public GameMain(int state){
	}

	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board5.png");
		notification = new Image("images/notification_window.png");
		eventWindow = new Image("images/event_window.png");
		
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
		
		//assigns the cards to their proper image
		blueCard = new Image("images/bluecard.png");
		greenCard = new Image("images/greencard.png");
		redCard = new Image("images/redcard.png");
	}

	//@Override

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		
		if(input.isMousePressed(0) &&
		xPosition > 333 &&
		xPosition < 490 &&
		yPosition < 180 &&
		yPosition > 20){
			gameboard.movePlayer(1);
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
		}
		
		if(input.isMouseButtonDown(0) &&
		xPosition > 564 &&
		xPosition < 715 &&
		yPosition < 215 &&
		yPosition > 180){
			sbg.enterState(4);
		}
		
		//recognize if the mouse is over spin and if spin is clicked
		if(xPosition > 340 && 
		xPosition < 470 && 
		yPosition > 190 && yPosition < 220){
			mouseOverSpin = true;
			if(Mouse.isButtonDown(0)){
				spinClicked = true;
				cardSelected = true;
			}else {
				spinClicked = false;
				cardSelected = false;
			}
		}else {
			mouseOverSpin = false;
		}
		
		if(spinClicked){
			spinningAnimation.update(delta);
		}
	
		if (spinAnimation){
			spinCount += (delta);
	    }
		
		boolean updatePlayer = false;
		
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
			cardGenerated = true;
			updatePlayer = true;
		}
		
		if(cardGenerated){
			cardDisplayTime += (delta);
		}
		
		if (cardDisplayTime > 2000){
			cardDisplayTime = 0;
			cardGenerated = false;
		}
		
		if(updatePlayer){
			for(int i = 0; i < spinNum; i++){
				gameboard.movePlayer(1);
				if( "fork".equals(gameboard.getCurrentSpace().getType()) ){
					i = spinNum;
				}
			}
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			CardGenerator cardgenerator = new CardGenerator(gameboard.getCurrentSpace().getType(), cardText, cardValue);
			cardColor = blueCard.getScaledCopy((float) .8);
			cardText = cardgenerator.getFinalCardText();
			
			
			showEventWindow = true;
			updatePlayer = false;
		}
		
		//if player clicks spin generate card text	
		//if (cardSelected) {
		//	CardGenerator cardgenerator = new CardGenerator(cardType, cardText, cardValue);
		//	cardColor = blueCard.getScaledCopy((float) .8);
		//	cardText = cardgenerator.getFinalCardText();
		//}
		
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

		
				
		/////NEED to know if player information provides space landed on.
		////Color methods are in gameboard and gamespace
		////MAKE an array to store the cards
		////NEED to store value with card
		// if player lands on "color" space draw that card
		//playerSpaceColor = GameSpace.getType();
		//System.out.println(playerSpaceColor);
		//if (cardGenerated ==true) {
		//CardGenerator cardgenerator = new CardGenerator(cardType, cardText, cardValue);
		//if (playerSpaceColor == "blueSpaces"){
	
		//cardColor = blueCard.getScaledCopy((float) .8);
		//cardText = cardgenerator.getCommonCardText();
		//}else cardGenerated = false;
	//	}
		//if playerSpaceColor is green
		//if (playerSpaceColor == "greenSpaces"){
		//cardColor = greenCard.getScaledCopy((float) .8);
		//cardText = cardgenerator.getGreenCardText();
	//	}
		//if playerSpaceColor is red
		//if (playerSpaceColor == "redSpaces"){
		//cardColor = redCard.getScaledCopy((float) .8);
		//cardText = cardgenerator.getRedCardText();
		//}
		
		//checks for user clicking in the cards icon to display its card history.
		if(input.isMouseButtonDown(0) &&
		xPosition >= 660 &&
		xPosition <= 745 &&
		yPosition >= 50 &&
		yPosition <= 155){
			sbg.enterState(6);
		}
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 62, 53);
		g.drawString(mouse, 10, 10);
		g.drawImage(player, 336, 136);
		if(showNotification){
			g.drawImage(notification, 0, 0);
		}
		if(showEventWindow){
			g.drawImage(eventWindow, 0, 0);
			g.drawString(cardText, 250, 40);
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

		//Display the card the player draws when he lands on a space
		//if(playerSpaceColor == "redSpaces"){
		//if (cardGenerated) {
		//	g.drawImage(eventWindow, 0, 0);
		//	g.drawString(cardText, 250, 40);
	    //}
		
		
		//if the wheel is clicked do what we need it to do
		if (spinClicked){
			defaultImage = false;
			spinClicked = false;
			spinNum = getSpinNum(sNum);
			spinAnimation = true;
		}
		
		//once the spin is clicked do the animation
		if (spinClicked == true){
			defaultImage = false;
			spinClicked = false;
			spinNum = getSpinNum(sNum);
			System.out.println(spinNum);
			spinAnimation = true;
		}
						
		if (spinAnimation){
			spinningAnimation.draw(329, 415);
			flipperAnimation.draw(460, 420);
		//animation is complete now set the number spun	
		} else{

			wheelSpinning.setRotation(360-(60*(spinNum-1)));
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
			spinAnimation = false;
			spinClicked = false;
		} // end else 
		
		if (mouseOverSpin){
			g.drawImage(wheelHover, 306, 375);
		}		
		
}//end render

	
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