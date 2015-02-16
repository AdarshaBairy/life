package main.java.edu.asu.cst316.menu;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.MouseOverArea;

public class Button {

    private MouseOverArea mouseOverArea;

    public Button(MouseOverArea mouseOverArea) {
        setMouseOverArea(mouseOverArea);
    }


    public void setMouseOverArea(MouseOverArea mouseOverArea) {
        this.mouseOverArea = mouseOverArea;
    }

    public MouseOverArea getMouseOverArea() {
        return mouseOverArea;
    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        mouseOverArea.render(gameContainer, graphics);
    }
}
