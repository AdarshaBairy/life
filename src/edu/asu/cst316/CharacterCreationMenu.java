package edu.asu.cst316;

import org.lwjgl.input.Mouse;
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



public class CharacterCreationMenu extends BasicGameState{
	public String mouse = "";
	public Image background;
	public UnicodeFont font;
	public TextField careerName;
	public CharacterCreationMenu(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/charCreationInt.png");
		font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC,26));
		careerName = new TextField(gc, font, 330, 210, 300, 50);
		careerName.setBackgroundColor(new Color(255, 226, 201));
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
		careerName.render(gc, g);
			
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i)
			throws SlickException {
		// TODO Auto-generated method stub
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;
		
		
		//create text fields and combo boxes to get info
		
		//back button
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 22 &&
				xPosition < 172 &&
				yPosition < 64 &&
				yPosition > 18)
		{
			sbg.enterState(0);
		}
		//next button
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 621 &&
				xPosition < 773 &&
				yPosition < 64 &&
				yPosition > 18)
		{
			//run a character/player constructor with info from comboboxes and 
			//text fields
			sbg.enterState(2);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	

}
