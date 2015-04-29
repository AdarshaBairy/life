package main.java.edu.asu.cst316;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.gui.*;
import org.newdawn.slick.Color;

import java.awt.Font;

import main.java.edu.asu.cst316.player.*;
import main.java.edu.asu.cst316.ventures.AllVentures;
import main.java.edu.asu.cst316.ventures.Venture;



public class CharacterCreationMenu extends BasicGameState{
	StateBasedGame stateBasedGame;
	public String mouse = "";
	
	public Image background;
	public UnicodeFont font;
	public TextField careerName;
	public Player entrP = Player.getInstance();
	
	boolean displayWarningText = false;
	boolean displayWarningVenture = false;
	boolean ventureSelected = false;
	
	AllVentures ventures = AllVentures.getInstance();
	Venture[] venture = ventures.getVentures();
	
	public CharacterCreationMenu(int state){
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		stateBasedGame = sbg;
		background = new Image("images/charCreationInt.png");
		Font font = new Font("Verdana", Font.PLAIN, 26);
		TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
		//font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC,26));
		careerName = new TextField(gc, trueTypeFont, 330, 210, 290, 45);
		careerName.setBackgroundColor(new Color(20, 25, 34));
		careerName.setTextColor(new Color(234, 226, 217));
		careerName.setText("");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		//g.drawString(mouse, 10, 10);
		careerName.render(gc, g);
		careerName.setFocus(true);
		
		Font font = new Font("Verdana", Font.PLAIN, 26);
		TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
		
		trueTypeFont.drawString(333, 316, venture[0].getCareer());
		trueTypeFont.drawString(333, 366, venture[1].getCareer());
		trueTypeFont.drawString(333, 416, venture[2].getCareer());

		if(displayWarningText){
			trueTypeFont.drawString(200, 550, "Invalid name inputted");
		}
		else if(displayWarningVenture){
			trueTypeFont.drawString(200, 550, "Venture must be selected");
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		// TODO Auto-generated method stub
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		yPosition = 600 - yPosition;
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public void mousePressed(int button, int x, int y) {
		y = 600 - y;
		System.out.println("click");
		System.out.println(x);
		System.out.println(y);
		if(button == 0){
			backButtonAction(x, y);
			nextButtonAction(x, y);
			try {
				ventureAction(x, y);
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	public void backButtonAction(int x, int y){
		if(x > 22 &&
		x < 172 &&
		y < 64 &&
		y > 18){
			stateBasedGame.enterState(0);
		}
	}
	
	public void nextButtonAction(int x, int y){
		if(x > 621 &&
		x < 773 &&
		y < 64 &&
		y > 18){
			System.out.println(careerName.getText().equals(null));
			System.out.println(careerName.getText().equals(""));
			System.out.println(entrP.getCareer() == null);
			if(careerName.getText().equals(null) || 
			careerName.getText().equals("")){
				displayWarningText = true;
			}
			else{
				displayWarningText = false;
				if(entrP.getCareer() == null){
					displayWarningVenture = true;
				}
				else{
					entrP.setName(careerName.getText());
					entrP.setSavedMoney(50000);
					stateBasedGame.enterState(2);
				}
			}
			
		}
	}	
	
	public void ventureAction(int x, int y) throws SlickException{
		
		if(x > 330 &&
		x < 660 &&
		y < 285 &&
		y > 250){
			entrP.setCareer(venture[0].getCareer());
			entrP.setIncome(venture[0].getIncome());
			entrP.setSavedMoney(venture[0].getStartingMoney());
			entrP.setRisk(venture[0].getRisk());
			background = new Image(venture[0].getImageName());
			displayWarningText = false;
			displayWarningVenture = false;
			
		}
		else if(x > 330 &&
		x < 660 &&
		y < 235 &&
		y > 200){
			System.out.println(venture[1].getCareer());
			entrP.setCareer(venture[1].getCareer());
			entrP.setIncome(venture[1].getIncome());
			entrP.setSavedMoney(venture[1].getStartingMoney());
			entrP.setRisk(venture[1].getRisk());
			background = new Image(venture[1].getImageName());
			displayWarningText = false;
			displayWarningVenture = false;
			System.out.println(entrP.getCareer());
		}
		else if(x > 330 &&
		x < 660 &&
		y < 185 &&
		y > 150){
			entrP.setCareer(venture[2].getCareer());
			entrP.setIncome(venture[2].getIncome());
			entrP.setSavedMoney(venture[2].getStartingMoney());
			entrP.setRisk(venture[2].getRisk());
			background = new Image(venture[2].getImageName());
			displayWarningText = false;
			displayWarningVenture = false;
		}
		
	}
}
