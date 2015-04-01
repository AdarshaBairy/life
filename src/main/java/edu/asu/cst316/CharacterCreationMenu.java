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



public class CharacterCreationMenu extends BasicGameState{
	public String mouse = "";
	
	public Image background;
	public UnicodeFont font;
	public TextField careerName;
	public Player entrP = Player.getInstance();
	
	public CharacterCreationMenu(int state){
	}
	
	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/charCreationInt.png");
		Font font = new Font("Verdana", Font.PLAIN, 26);
		TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
		//font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC,26));
		careerName = new TextField(gc, trueTypeFont, 330, 210, 290, 45);
		careerName.setBackgroundColor(new Color(20, 25, 34));
		careerName.setTextColor(new Color(234, 226, 217));
		careerName.setText("newPlayer");
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
		careerName.render(gc, g);
		careerName.setFocus(true);
		
		Font font = new Font("Verdana", Font.PLAIN, 26);
		TrueTypeFont trueTypeFont = new TrueTypeFont(font, true);
		
		trueTypeFont.drawString(333, 316, "Venture 1");
		trueTypeFont.drawString(333, 366, "Venture 2");
		trueTypeFont.drawString(333, 416, "Venture 3");
		//g.drawString("Venture 2", 330, 350);
		//g.drawString("Venture 3", 330, 405);
		//g.drawString("Select Business Venture", 50, 300);

	}

	//@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		// TODO Auto-generated method stub
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;
		
		
		//create text fields and combo boxes to get info
		careerName.setFocus(false);
		//back button
		if(input.isMouseButtonDown(0) &&
		xPosition > 22 &&
		xPosition < 172 &&
		yPosition < 64 &&
		yPosition > 18){
			sbg.enterState(0);
		}
		//next button
		if(input.isMouseButtonDown(0) &&
		xPosition > 621 &&
		xPosition < 773 &&
		yPosition < 64 &&
		yPosition > 18){
			sbg.enterState(2);
		}
		
		//venture 1
		if(input.isMouseButtonDown(0) &&
		xPosition > 330 &&
		xPosition < 415 &&
		yPosition < 285 &&
		yPosition > 250){
			
			System.out.println(careerName.getText());
			entrP.setName(careerName.getText());
			entrP.setCareer("venture 1");
			entrP.setIncome(10000);
			entrP.setSavedMoney(50000);
			entrP.setRisk(4);
			background = new Image("images/charCreationInt1.png");
		}
		//venture 2
		if(input.isMouseButtonDown(0) &&
		xPosition > 330 &&
		xPosition < 415 &&
		yPosition < 235 &&
		yPosition > 200){
			System.out.println(careerName.getText());
			entrP.setName(careerName.getText());
			entrP.setCareer("venture 2");
			entrP.setIncome(15000);
			entrP.setSavedMoney(50000);
			entrP.setRisk(6);
			background = new Image("images/charCreationInt2.png");	
		}
		//venture 3
		if(input.isMouseButtonDown(0) &&
		xPosition > 330 &&
		xPosition < 415 &&
		yPosition < 185 &&
		yPosition > 150){
			System.out.println(careerName.getText());
			entrP.setName(careerName.getText());
			entrP.setCareer("venture 3");
			entrP.setIncome(20000);
			entrP.setSavedMoney(50000);
			entrP.setRisk(8);
			background = new Image("images/charCreationInt3.png");
		}
		careerName.setFocus(true);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	

}
