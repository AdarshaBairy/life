package main.java.edu.asu.cst316;

import java.awt.Font;

import main.java.edu.asu.cst316.cards.Card;
import main.java.edu.asu.cst316.cards.PlayerCardStack;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class HistoryCards extends BasicGameState{
	
	StateBasedGame stateBasedGame;
	public String mouse = "";
	public Image background;
	PlayerCardStack pcs = PlayerCardStack.getInstance();
	int index = 0;
	Card currentCard;
	
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
		
		if(pcs.getSize() != 0){
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
			String cardText = currentCard.getText();
			TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
			
			TextField cardTextBox = new TextField(gc, trueTypeFont, 190, 280, 420, 120);
			
			if(cardText.length() > 40) cardTextBox.setText(cardText.substring(0, 40)+"-");
			else cardTextBox.setText(cardText);
			cardTextBox.setBorderColor(new Color(0, 0, 0, 0));
			cardTextBox.setBackgroundColor(new Color(0, 0, 0, 0));
			cardTextBox.render(gc, g);
			for(int i = 40; i < 121; i = i + 40){
				if(cardText.length() > i){
					TextField cardTextBox2 = new TextField(gc, trueTypeFont, 190, 280+(i/2), 420, 120);
					if(cardText.length() < (i+41))cardTextBox2.setText(cardText.substring(i));
					else cardTextBox2.setText(cardText.substring(i, (i+40))+"-");
					cardTextBox2.setBorderColor(new Color(0, 0, 0, 0));
					cardTextBox2.setBackgroundColor(new Color(0, 0, 0, 0));
					cardTextBox2.render(gc, g);	
				}
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		
		
		if(pcs.getSize() == 0){
			background = new Image("images/historycardnone.png");
		}
		else{
			
		}
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
			try {
				backButtonAction(x, y);
				nextButtonAction(x, y);
			} catch (SlickException e) {
				e.printStackTrace();
			}
			gameMainAction(x,y);
		}
	}

	public void backButtonAction(int x, int y) throws SlickException{
		if(x > 50 && 
		x < 80 &&
		y > 100 &&
		y < 500){
			index--;
			if(index == 0){
				index = pcs.getSize()-1;
				
				currentCard = pcs.getCurrentCard(index);
				if(currentCard.getType().equals("common")){
					background = new Image("images/historycardblue.png");
				}
				else if(currentCard.getType().equals("red")){
					background = new Image("images/historycardred.png");
				}
				else if(currentCard.getType().equals("green")){
					background = new Image("images/historycardgreen.png");
				}
			}
			
		}
	}
	
	public void nextButtonAction(int x, int y) throws SlickException{
		if(x > 720 && 
		x < 750 &&
		y > 100 &&
		y < 500){
			index++;
			if(index == pcs.getSize()){
				index = 0;
				
				currentCard = pcs.getCurrentCard(index);
				if(currentCard.getType().equals("common")){
					background = new Image("images/historycardblue.png");
				}
				else if(currentCard.getType().equals("red")){
					background = new Image("images/historycardred.png");
				}
				else if(currentCard.getType().equals("green")){
					background = new Image("images/historycardgreen.png");
				}
			}
			

		}
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
