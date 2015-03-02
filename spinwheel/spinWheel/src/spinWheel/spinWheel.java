package spinWheel;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class spinWheel extends StateBasedGame{
	
	public static final String gamename = "spinWheel";
	public static final int spinWheelSpecs = 0;
	//public static final int play = 1;
	
	public spinWheel(String gamename){
		super(gamename);
		this.addState(new spinWheelSpecs(spinWheelSpecs));
		//this.addState(new play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(spinWheelSpecs).init(gc, this);
		//this.getState(play).init(gc, this);
		this.enterState(spinWheelSpecs);
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new spinWheel(gamename));
			appgc.setDisplayMode(640, 360, false);
			appgc.start();
	}catch (SlickException e){
		e.printStackTrace();
	}
	}
}
