
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	public String mouse = "";
	public Image background;
	public String state = "start";
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		background = new Image("src/u0.png");
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		int xPosition = Mouse.getX();
		int yPosition = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x: " + xPosition + " y: " + yPosition;
		
		if(
				state.equals("start") &&
				input.isMouseButtonDown(0) &&
				xPosition > 250 &&
				xPosition < 550 &&
				yPosition < 175 &&
				yPosition > 125)
		{
			state = "instructions";
			background = new Image("src/u1.png");
		}
		else if(
				state.equals("instructions") &&
				input.isMouseButtonDown(0) &&
				xPosition > 20 &&
				xPosition < 170 &&
				yPosition < 60 &&
				yPosition > 20)
		{
			state = "start";
			background = new Image("src/u0.png");
		}
		else if(
				state.equals("start") &&
				input.isMouseButtonDown(0) &&
				xPosition > 250 &&
				xPosition < 550 &&
				yPosition < 100 &&
				yPosition > 50)
		{
			state = "game";
			background = new Image("src/u2.png");
			//Image board = new Image("/Slick2dTest/src/image.png");
			//gc.drawImage(board, 0, 0);
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawString(mouse, 10, 10);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(800, 600, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}