package main.java.edu.asu.cst316;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.ArrayList;



public class HistoryCards extends BasicGameState{
	
	public String mouse = "";
	public Image background;
	public Image blueCard;
	public Image redCard;
	public Image greenCard;
	public Image cardDisplay;
	public ArrayList<Integer> cards = new ArrayList<Integer>();
	int currentCardIndex = 0;
	boolean test = false;
	
	
	
	
	
	public HistoryCards(int state){
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		background = new Image("images/HistoryCard.png");
		blueCard = new Image("images/bluecard.png");
		redCard = new Image("images/redcard.png");
		greenCard = new Image("images/greencard.png");
		
		cards.add(1);
		cards.add(2);
		cards.add(3);
		cards.add(2);
		cards.add(3);
		cards.add(1);
		
		cardDisplay = blueCard.getSubImage(0, 0, 400, 500);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {	
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
		g.drawImage(cardDisplay, 215, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;	
		input.clearMousePressedRecord(); 
		
		
		if(
				input.isMouseButtonDown(0) &&
				xPosition >= 50 &&
				xPosition <= 202 &&
				yPosition >= 39 &&
				yPosition <= 85)
		{
			sbg.enterState(2);
		}
		
		if(     //button to left
				input.isMousePressed(Input.MOUSE_LEFT_BUTTON) &&
				//input.isMouseButtonDown(0) &&
				//Mouse.isButtonDown(0) &&
				xPosition >= 60 &&
				xPosition <= 113 &&
				yPosition >= 261 &&
				yPosition <= 326 &&
				currentCardIndex >= 1)
		{
		
			currentCardIndex -= 1;
			updateCard(currentCardIndex);
			
		}
		if(		//button to the right
				//input.isMousePressed(Input.MOUSE_LEFT_BUTTON) &&
				//input.isMouseButtonDown(0) && 
				Mouse.isButtonDown(0) &&
				xPosition >= 686 &&
				xPosition <= 740 &&
				yPosition >= 264 &&
				yPosition <= 328 &&
				currentCardIndex <= 4)
		{
			
			currentCardIndex += 1;
			updateCard(currentCardIndex);
			
		}
		
	
	}

	@Override
	public int getID() {
		
		return 6;
	}

	public void updateCard(int index){
		 int cardType = cards.get(index);
		 if (cardType == 1){
			 cardDisplay = blueCard.getSubImage(0, 0, 400, 500);
		 }else if(cardType == 2){
			 cardDisplay = greenCard.getSubImage(0, 0, 400, 500);			
		 }else if (cardType == 3){
			 cardDisplay = redCard.getSubImage(0, 0, 400, 500);
		 }
	}
	
	
    public void cardsHold(){
		
	}
	
}
