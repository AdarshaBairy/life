package edu.asu.cst316.menu;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class ButtonArray extends ArrayList<Button> {

    public ButtonArray(Image[] i, int startX, int startY, GameContainer gameContainer, StateBasedGame stateBasedGame) {
        this(i, startX, startY, gameContainer, stateBasedGame, false);
    }

    public ButtonArray(Image[] i, int startX, int startY, GameContainer gameContainer, StateBasedGame stateBasedGame, boolean horizontal) {
        int displacementX = 1;
        int displacementY = 1;
        for (Image anI : i) {
            this.add(new Button(new StateChangingMouseOverArea(gameContainer, anI, startX * displacementX, startY * displacementY, stateBasedGame)));
            if(horizontal){
                displacementX ++;
            } else {
                displacementY ++;
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        for( Button b : this) {
            b.render(gameContainer, graphics);
        }
    }
}
