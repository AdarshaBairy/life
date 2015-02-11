package edu.asu.cst316;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class EventNotification extends BasicGameState{
	public String mouse = "";
	public Image background;
	
	public EventNotification(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("images/event.png");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		if(
				input.isMousePressed(0) &&
				xPosition > 0 &&
				xPosition < 100 &&
				yPosition < 100 &&
				yPosition > 0)
		{
			sbg.enterState(2);
		}
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
	}
	
	public int getID(){
		return 3;
	}
	
}