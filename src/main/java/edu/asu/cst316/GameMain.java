package main.java.edu.asu.cst316;

import java.awt.Font;
import java.util.List;
import java.util.Random;

import main.java.edu.asu.cst316.cards.Card;
//import main.java.edu.asu.cst316.cards.CardGenerator;
//import main.java.edu.asu.cst316.cards.CardText;
import main.java.edu.asu.cst316.cards.Deck;
import main.java.edu.asu.cst316.cards.PlayerCardStack;
import main.java.edu.asu.cst316.gameboard.GameBoard;
//import main.java.edu.asu.cst316.gameboard.GameSpace;
import main.java.edu.asu.cst316.highscore.HighScores;
import main.java.edu.asu.cst316.highscore.PlayerRecord;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import main.java.edu.asu.cst316.player.*;
import main.java.edu.asu.cst316.gameboard.*;
public class GameMain extends BasicGameState{
	
	GameBoard gameboard = GameBoard.getInstance();
	Player playerObj = Player.getInstance();
	StateBasedGame stateBasedGame;
	PlayerCardStack pcs = PlayerCardStack.getInstance();
	
	public String mouse = "";
	public String cardText;
	public String cardType = "";
	public Image background;
	public Image gameBoard;	
	public Image notification;
	public Image eventWindow;
	public Image endGameWindow;
	public Image gameBoardZoom;
	public Image spinner;
	public Image player;
	public Image quit;

	//public Spinwheelhelper spinHelp = new Spinwheelhelper(); 
	

	private int playerX = -256;
	private int playerY = 464;

	
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
	boolean showEndGameWindow = false;
	boolean cardGenerated = false;
	boolean cardSelected = false;
	boolean quitting = false;
	
	public GameMain(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		stateBasedGame = sbg;
		background = new Image("images/u2.png");
		gameBoard = new Image("images/board5.png");
		notification = new Image("images/notification_window.png");
		quit = new Image("images/quit_image.png");
		eventWindow = new Image("images/event_window.png");
		endGameWindow = new Image("images/endGame.png");
		
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
		boolean updatePlayer = false;
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;	
		// Cheat code
		/*
		if(input.isMousePressed(0) && !gameboard.getCurrentSpace().getType().equals("end") &&
		xPosition > 333 &&
		xPosition < 490 &&
		yPosition < 180 &&
		yPosition > 20){
			gameboard.movePlayer(1);
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			System.out.println(gameboard.getCurrentSpace().getType());
		}
		*/
		if(input.isMouseButtonDown(0) &&
		xPosition > 564 &&
		xPosition < 715 &&
		yPosition < 215 &&
		yPosition > 180){
			sbg.enterState(4);
		}
		
		if(gameboard.getCurrentSpace().getType().equals("start")){
			showNotification = false;
			showEventWindow = false;
		}
		
		//recognize if the mouse is over spin and if spin is clicked
		if(xPosition > 340 && 
		xPosition < 470 && 
		yPosition > 190 && 
		yPosition < 220 &&
		!showNotification &&
		!quitting){
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
		

		updatePlayer = animate(updatePlayer, delta);
		
		/*if(spinClicked == true){

			spinningAnimation.update(delta);
		}
	
		if (spinAnimation){
			spinCount += (delta);
	    }
		
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
			cardGenerated = true;
			updatePlayer = true;
		}	*/	
		
		if(cardGenerated){
			cardDisplayTime += (delta);
		}
		
		if (cardDisplayTime > 2000){
			cardDisplayTime = 0;
			cardGenerated = false;
		}
		
		/*
			Once the spinner has finished spinning the player space updates
		*/
		if(updatePlayer){
			for(int i = 0; i < spinNum; i++){
				gameboard.movePlayer(1);
				if( "fork".equals(gameboard.getCurrentSpace().getType()) ||
				"payday".equals(gameboard.getCurrentSpace().getType()) ){
					i = spinNum;
				}
			}
			updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());

			if(!gameboard.getCurrentSpace().getType().equals("fork")){
				showEventWindow = true;
				Deck deck = Deck.getInstance();
				System.out.println(playerObj.getSavedMoney());
				
				if(gameboard.getCurrentSpace().getType().equals("common")){
					Card newCard = deck.getCommonCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("red")){
					Card newCard = deck.getRedCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("green")){
					Card newCard = deck.getGreenCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("payday")){
					int incomeValue = playerObj.payDay();
					cardText = "Payday! You earn "+incomeValue;
					Card newCard = new Card(cardText, incomeValue);
					newCard.setType("green");
					pcs.addCard(newCard);
				}
				System.out.println(cardText);
				System.out.println(playerObj.getSavedMoney());
			}
			updatePlayer = false;
		}

		//if player clicks spin generate card text and type
		if (cardSelected) {
			cardType = gameboard.getCurrentSpace().getType();
		}
		
		//When the player lands on a fork space they will see a window giving 
		//of which way they want to go
		if(gameboard.getCurrentSpace().getType().equals("fork")){
			showNotification = true;
			showEventWindow = false;
			//If the player clicks on safe
			if(input.isMouseButtonDown(0) &&
			xPosition > 175 &&
			xPosition < 300 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayerToAlternativeRoute();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				
				showEventWindow = true;
				Deck deck = Deck.getInstance();
				System.out.println(playerObj.getSavedMoney());
				if(gameboard.getCurrentSpace().getType().equals("common")){
					Card newCard = deck.getCommonCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("red")){
					Card newCard = deck.getRedCard();
					PlayerCardStack playerCard = PlayerCardStack.getInstance();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("green")){
					Card newCard = deck.getGreenCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}
				System.out.println(cardText);
				System.out.println(playerObj.getSavedMoney());
			}
			//If the player clicks on risky
			if(input.isMouseButtonDown(0) &&
			xPosition > 500 &&
			xPosition < 630 &&
			yPosition < 370 &&
			yPosition > 330){
				gameboard.movePlayer(1);
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
			
				showEventWindow = true;
				Deck deck = Deck.getInstance();
				System.out.println(playerObj.getSavedMoney());
				if(gameboard.getCurrentSpace().getType().equals("common")){
					Card newCard = deck.getCommonCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("red")){
					Card newCard = deck.getRedCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}else if(gameboard.getCurrentSpace().getType().equals("green")){
					Card newCard = deck.getGreenCard();
					cardText = newCard.getText();
					int cardMoneyValue = newCard.getValue();
					int currentMoney = playerObj.getSavedMoney();
					playerObj.setSavedMoney(currentMoney+cardMoneyValue);
					pcs.addCard(newCard);
				}
				System.out.println(cardText);
				System.out.println(playerObj.getSavedMoney());
			}
		}else{
			showNotification = false;
		}

		if(gameboard.getCurrentSpace().getType().equals("end")){
			showEndGameWindow = true;
			if(input.isMouseButtonDown(0) &&
			xPosition > 285 &&
			xPosition < 510 &&
			yPosition < 290 &&
			yPosition > 235){
				recordPlayerScore();
				showEndGameWindow = false;
				showNotification = false;
				gameboard.reset();
				pcs.resetStack();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				sbg.enterState(0);
			}
			if(input.isMouseButtonDown(0) &&
			xPosition > 285 &&
			xPosition < 510 &&
			yPosition < 215 &&
			yPosition > 160){
				recordPlayerScore();
				showEndGameWindow = false;
				showNotification = false;
				gameboard.reset();
				pcs.resetStack();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				sbg.enterState(9);
			}
			if(input.isMouseButtonDown(0) &&
			xPosition > 285 &&
			xPosition < 510 &&
			yPosition < 145 &&
			yPosition > 90){
				recordPlayerScore();
				System.exit(0);
			}

			System.out.println(gameboard.getCurrentSpace().getType());
		}
	
		
		if(showEventWindow){
			//If the player clicks on close
			if(input.isMouseButtonDown(0) &&
			xPosition > 333 &&
			xPosition < 450 &&
			yPosition < 370 &&
			yPosition > 330){
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				showEventWindow = false;
			}
		}
		

		

	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(gameBoardZoom, 62, 53);
		//g.drawString(mouse, 10, 10);
		
		//todo status initial render

		g.drawString(playerObj.getName(), 120, 410);
		g.drawString(playerObj.getCareer(), 145, 448);
		g.drawString(Integer.toString(playerObj.getIncome()), 135, 490);
		g.drawString(Integer.toString(playerObj.getSavedMoney()), 195, 530);

		
		g.drawImage(player, 336, 136);
		if(showNotification){
			g.drawImage(notification, 0, 0);
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
			TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
			TextField cardTextBox = new TextField(gc, trueTypeFont, 190, 100, 420, 120);
			cardTextBox.setText("You have a decision to make!");
			cardTextBox.setBorderColor(new Color(0, 0, 0, 0));
			cardTextBox.setBackgroundColor(new Color(0, 0, 0, 0));
			cardTextBox.render(gc, g);
		}
		
		
		
		if(showEventWindow){
			
			g.drawImage(eventWindow, 0, 0);
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
			TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
			
			
			TextField cardTextBox = new TextField(gc, trueTypeFont, 190, 100, 420, 120);
			
			if(cardText.length() > 40) cardTextBox.setText(cardText.substring(0, 40));
			else cardTextBox.setText(cardText);
			cardTextBox.setBorderColor(new Color(0, 0, 0, 0));
			cardTextBox.setBackgroundColor(new Color(0, 0, 0, 0));
			cardTextBox.render(gc, g);
			if(cardText.length() > 40){
				TextField cardTextBox2 = new TextField(gc, trueTypeFont, 190, 120, 420, 120);
				if(cardText.length() < 81)cardTextBox2.setText(cardText.substring(40));
				else cardTextBox2.setText(cardText.substring(40, 80));
				cardTextBox2.setBorderColor(new Color(0, 0, 0, 0));
				cardTextBox2.setBackgroundColor(new Color(0, 0, 0, 0));
				cardTextBox2.render(gc, g);	
			}
			if(cardText.length() > 80){
				TextField cardTextBox3 = new TextField(gc, trueTypeFont, 190, 140, 420, 120);
				if(cardText.length() < 121)cardTextBox3.setText(cardText.substring(80));
				else cardTextBox3.setText(cardText.substring(80, 120));
				cardTextBox3.setBorderColor(new Color(0, 0, 0, 0));
				cardTextBox3.setBackgroundColor(new Color(0, 0, 0, 0));
				cardTextBox3.render(gc, g);	
			}
			if(cardText.length() > 120){
				TextField cardTextBox4 = new TextField(gc, trueTypeFont, 190, 160, 420, 120);
				cardTextBox4.setText(cardText.substring(120));
				cardTextBox4.setBorderColor(new Color(0, 0, 0, 0));
				cardTextBox4.setBackgroundColor(new Color(0, 0, 0, 0));
				cardTextBox4.render(gc, g);	
			}
		}
		
		if(showEndGameWindow){
			g.drawImage(endGameWindow, 0, 0);
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);
			TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
			TextField cardTextBox = new TextField(gc, trueTypeFont, 380, 240, 420, 120);
			cardTextBox.setText(Integer.toString(playerObj.getSavedMoney()));
			cardTextBox.setBorderColor(new Color(0, 0, 0, 0));
			cardTextBox.setBackgroundColor(new Color(0, 0, 0, 0));
			cardTextBox.render(gc, g);
		}
		
		if(quitting){
			g.drawImage(quit, 0, 0);
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
		
		if (defaultImage == true && !showEndGameWindow){
			g.drawImage(wheel, 306, 375);
			g.drawImage(spinFlipper, 460, 420);
		}
		
		//Display the card the player draws when he lands on a space
		if (cardGenerated && cardType != "fail") {
//			g.drawImage(cardColor, 200, 20);
//			g.drawString(cardText, 250, 40);
	    }
		
		//if the wheel is clicked do what we need it to do
		if (spinClicked){
			if(!showEndGameWindow){
				defaultImage = false;
				spinClicked = false;
				spinNum = getSpinNum();
				spinAnimation = true;
			}
		}


		if (mouseOverSpin && !showEndGameWindow){
			g.drawImage(wheelHover, 306, 375);
		}	
		//clicked spin button procedure
		if (spinClicked == true){
			defaultImage = false;
			spinClicked =false;
			spinNum = getSpinNum();
			System.out.println(spinNum);
			spinAnimation = true;

		}
		
		
		//spin animation logic
		if (spinAnimation && !showEndGameWindow){
			spinningAnimation.draw(329, 415);
			flipperAnimation.draw(460, 420);
		} else if(!spinAnimation && !showEndGameWindow){ 
			drawRotatedResult(spinNum, g);
		

		spinAnimation = false;
		spinClicked = false;
	}      // end else 

		
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
	
	public int getSpinNum() {
		try {
		    Thread.sleep(250);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Random rand = new Random();
		int result = (rand.nextInt(6))+1;
		return result;
	}
	
	public void drawRotatedResult( int spinNum, Graphics g){
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
		
	}
	
	public boolean animate(boolean updatePlayer, int delta){
		if(spinClicked == true){
			spinningAnimation.update(delta);
		}
		
		if (spinAnimation){
			spinCount += (delta);
		}
				
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
			updatePlayer = true;
		}
		return updatePlayer;
	}
	

	public void recordPlayerScore(){
		HighScores highScores = HighScores.getInstance();
		highScores.init();
		try{
			highScores.deSerialize();
		}catch(Exception e){
			System.out.println("No highscore file saved");
		}
		highScores.addPlayerRecord(playerObj.getName(), playerObj.getSavedMoney());
	}
	
	@Override
	public void mousePressed(int button, int x, int y){
		y = 600 - y;
		if(button == 0){
			if(x >= 660 &&
			x <= 745 &&
			y >= 50 &&
			y <= 155){
				stateBasedGame.enterState(6);
			}
			else if(x > 585 &&
			x < 718 &&
			y < 36 &&
			y > 7){
				quitting = true;
				/*recordPlayerScore();
				showEndGameWindow = false;
				gameboard.reset();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				stateBasedGame.enterState(0);*/
			}
			else if(x > 175 &&
					x < 302 &&
					y > 332 &&
					y < 370 &&
					quitting){
				quitting = false;
				}
			else if(x > 500 &&
					x < 630 &&
					y > 332 &&
					y < 370 &&
					quitting){
				recordPlayerScore();
				showEndGameWindow = false;
				showNotification = false;
				gameboard.reset();
				pcs.resetStack();
				updateBoardView(gameboard.getCurrentSpace().getPosX(), gameboard.getCurrentSpace().getPosY());
				stateBasedGame.enterState(0);
				quitting = false;
				
			}
		}
	}
	

	
	public void drawCardText(String text, GameContainer gc, TrueTypeFont trueTypeFont, Graphics g){
		TextField cardTextBox = new TextField(gc, trueTypeFont, 190, 140, 420, 120);
		if(cardText.length() < 81)cardTextBox.setText(cardText.substring(80));
		else cardTextBox.setText(cardText.substring(80, 100)+"-");
		cardTextBox.setBorderColor(new Color(0, 0, 0, 0));
		cardTextBox.setBackgroundColor(new Color(0, 0, 0, 0));
		cardTextBox.render(gc, g);
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		spinAnimation = false;
	}
}
