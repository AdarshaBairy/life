/**
 * 
 */
package main.java.edu.asu.cst316.gameboard;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * @author Owner
 *
 */
public class Spinwheel {
	int	centerOfImageX = 0; 
	int	centerOfImageY = 0;
	
	private Image spinner;
	private Image wheelSpinning;
	private Image wheel;
	private Image spinFlipper;
	private Image wheelHover;
	
	private Animation spinningAnimation;
	private Animation flipperAnimation;
	
	private SpriteSheet spinning;
	private SpriteSheet flipperAnim;
	
	
	
	public Spinwheel(){
		try {
			spinner = new Image("images/spinner.png");
		
			// declares the sprite sheets to be used, first number is x pixels, second number is y pixels
			flipperAnim = new SpriteSheet("res/flipperspritesheet.png", 24, 30);
			spinning = new SpriteSheet ("res/spinwheelspritesheet.png", 168, 168);
			//assigns the sprite sheets to animations number is duration of each frame
			spinningAnimation = new Animation (spinning, 100);
			flipperAnimation = new Animation (flipperAnim, 75);
			//declare the images used
			wheel = new Image("res/spinwheeldefault.png");
			wheelHover = new Image("res/spinwheelhover.png");
			wheelSpinning = new Image ("res/spinwheelspinning.png");
			spinFlipper = new Image("res/spinflipper.png");	
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		centerOfImageX = (wheelSpinning.getWidth()/2);
		centerOfImageY = (wheelSpinning.getHeight()/2);
		wheelSpinning.setCenterOfRotation(centerOfImageX, centerOfImageY);
	}
	
	public void drawDefault(Graphics g){
		g.drawImage(wheel, 200, 130);
		g.drawImage(spinFlipper, 355, 180);
	}
	
	public int getSpinNum() {
		try {
		    Thread.sleep(250);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		Random rand = new Random();
		int result = (rand.nextInt(6))+1;
		return result;
	}

	public void rotate(boolean spinAnimation, int spinNum, Graphics g){
		if (spinAnimation){
			spinningAnimation.draw(329, 415);
			flipperAnimation.draw(460, 420);
		} else{
		if (spinNum == 1){
			wheelSpinning.setRotation(0);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}	
		if (spinNum == 2){
			wheelSpinning.setRotation(330);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}
		if (spinNum == 3){
			wheelSpinning.setRotation(275);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}		
		if (spinNum == 4){
			wheelSpinning.setRotation(180);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}
		if (spinNum == 5){
			wheelSpinning.setRotation(120);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}		
		if (spinNum == 6){
			wheelSpinning.setRotation(90);
			g.drawImage(wheelSpinning, 329, 415);
			g.drawImage(spinFlipper, 460, 420);
		}	
		spinAnimation = false;
		spinClicked = false;
		}
	
		}
}