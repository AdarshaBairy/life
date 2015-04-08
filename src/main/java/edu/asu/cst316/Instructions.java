package main.java.edu.asu.cst316;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class Instructions extends BasicGameState{
	//variables
	public String mouse = "";
	public Image background;
	public Image instructions;
	public Image instruc;
	int y = 0;
	int x = 0;
	
	public Instructions(int state){
	}

	//@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//images used
		background = new Image("images/u1.png");
		instructions = new Image("images/instructions.png");
		
		//displays the instructions image
		instruc = instructions.getSubImage(x, y, 800, 340);
	}

	//@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;		
		
		//This if is for the back button
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 20 &&
				xPosition < 170 &&
				yPosition < 60 &&
				yPosition > 20)
		{
			sbg.enterState(0);
		}
		
		//This is for the instruction image scroll up
		if(
				input.isMouseButtonDown(0) &&
				xPosition > 730 &&
				xPosition < 761 &&
				yPosition < 389 &&
				yPosition > 288 &&
				y >= 0) //prevents for the image to go in circles 
		{
			
			y -= 25;
			//sends an updated x and y to change what's being displayed 
			updateBoardView(x , y);
		}
		
		//This is for the instruction image scroll down
		if (
				input.isMouseButtonDown(0)&&
				xPosition > 730 &&
				xPosition < 761 &&
				yPosition < 217 &&
				yPosition > 114 &&
				y <= 500) //prevents for the image to go in circles
		{
			y += 25;
			//sends an updated x and y to change what's being displayed 
			updateBoardView(x , y);
		}
			
		
	}

	//@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(instruc, 40, 175);
		g.drawString(mouse, 10, 10);
		
	}
	
	//id for the class instructions
	public int getID(){
		return 1;
	}
	
	//method updates what section of the image instructions is being displayed. 
	public void updateBoardView(int x, int y){
		instruc = instructions.getSubImage(x, y, 800, 340);
	}
	
	
}