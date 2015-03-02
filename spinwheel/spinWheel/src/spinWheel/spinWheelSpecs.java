package spinWheel;

import java.util.Random;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class spinWheelSpecs extends BasicGameState{

	Image wheel , wheelHover, spinFlipper, wheel1, wheel2, wheel3, wheel4, wheel5, wheel6, wheelSpinning;
	Animation spinningAnimation, flipperAnimation;
	SpriteSheet spinning, flipperAnim;
	int spinNum = 0, sNum =0, centerOfImageX = 0, centerOfImageY = 0, spinCount =0;
	float mouseX, mouseY;
	boolean mouseOverSpin = false, spinClicked = false, spun = false, shouldSpin = false, 
			defaultImage = true, spinAnimation = false;
	
	public spinWheelSpecs(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{

		// declares the sprite sheets to be used, first number is x pixels, second number is y pixels
		flipperAnim = new SpriteSheet("res/flipperspritesheet.png", 24, 30);
		spinning = new SpriteSheet ("res/spinwheelspritesheet.png", 168, 168);
		
		//assigns the sprite sheets to animations number is duration of each frame
		spinningAnimation = new Animation (spinning, 100);
		flipperAnimation = new Animation (flipperAnim, 75);
		}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{

		//declare the images used
		wheel = new Image("res/spinwheeldefault.png");
		wheelHover = new Image("res/spinwheelhover.png");
		wheelSpinning = new Image ("res/spinwheelspinning.png");
		spinFlipper = new Image("res/spinflipper.png");	
		
		// creates the center of the image for the rotation
		centerOfImageX = (wheelSpinning.getWidth()/2);
		centerOfImageY = (wheelSpinning.getHeight()/2);
		wheelSpinning.setCenterOfRotation(centerOfImageX, centerOfImageY);
		
		if (defaultImage == true){
			g.drawImage(wheel, 200, 130);
			g.drawImage(spinFlipper, 355, 180);
		}

		if (spinClicked == true){
				defaultImage = false;
				spinClicked =false;
				spinNum = getSpinNum(sNum);
				System.out.println(spinNum);
				spinAnimation = true;
			}
				
		// keeps background image
		g.drawImage(wheel, 200, 130);
		g.drawImage(spinFlipper, 355, 180);
		
		if (spinAnimation){
			spinningAnimation.draw(223,172);
			flipperAnimation.draw(355,180);
		} else{
		
		if (spinNum == 1){
			wheelSpinning.setRotation(0);
			g.drawImage(wheelSpinning, 221, 171);
			g.drawImage(spinFlipper, 355, 180);
		}	
		if (spinNum == 2){
			wheelSpinning.setRotation(330);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
		}
		if (spinNum == 3){
			wheelSpinning.setRotation(275);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
		}		
		if (spinNum == 4){
			wheelSpinning.setRotation(180);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
		}
		if (spinNum == 5){
			wheelSpinning.setRotation(120);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
		}		
		if (spinNum == 6){
			wheelSpinning.setRotation(90);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
		}		
		spinAnimation = false;
		spinClicked = false;
	} // end else 
		
		if (mouseOverSpin == true){
			g.drawImage(wheelHover, 200, 130);
		}		
}//end render
	
		/*
		//if (mouseOverSpin == true)
		//	g.drawImage(wheelHover, 200, 130);
		
		switch(sNum){
		case 1: 
			wheelSpinning.setRotation(0);
			g.drawImage(wheelSpinning, 221, 171);
			g.drawImage(spinFlipper, 355, 180);
			break;
		
		case 2:
			wheelSpinning.setRotation(330);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
			break;
		
		case 3:
			wheelSpinning.setRotation(275);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
			break;
		case 4: 
			wheelSpinning.setRotation(180);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
			break;
		
		case 5:
			wheelSpinning.setRotation(120);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
			break;
		
		case 6:
			wheelSpinning.setRotation(90);
			g.drawImage(wheelSpinning, 222, 172);
			g.drawImage(spinFlipper, 355, 180);
			break;
	
		//default:// if no cases are true do a default statement
		//	break;
			}}*/
	//}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		
		if((mouseX > 275 && mouseX < 340) && (mouseY > 200 && mouseY < 220)){
			mouseOverSpin = true;
			if(Mouse.isButtonDown(0)){
				spinClicked = true;
			}else spinClicked = false;		
		}else mouseOverSpin = false;
		
		if(spinClicked == true){
			spinningAnimation.update(delta);
		}
		
		//System.out.println(delta);
		
		if (spinAnimation){
			spinCount += (delta);
		}
		
		if (spinCount > 3000){
			spinCount = 0;
			spinAnimation = false;
		}
		
	}
		
	int getSpinNum(int sNum) {
	try {
	    Thread.sleep(250);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	Random rand = new Random();
	sNum = (rand.nextInt(6))+1;
	return sNum;
	}
	
	public int getID(){
		return 0;
	}		
}


