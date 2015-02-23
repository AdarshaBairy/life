package edu.asu.cst316.menu;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Douglas Greenbaum on 2/5/2015.
 */
public class StateChangingMouseOverArea extends MouseOverArea {

    private StateBasedGame stateBasedGame;

    /**
     * Create a new mouse over area
     *
     * @param container The container displaying the mouse over area
     * @param image     The normalImage to display
     * @param x         The position of the area
     * @param y         the position of the area
     * @param listener
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, int x, int y, ComponentListener listener) {
        super(container, image, x, y, listener);
    }

    /**
     * Create a new mouse over area
     *
     * @param container The container displaying the mouse over area
     * @param image     The normalImage to display
     * @param x         The position of the area
     * @param y
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, int x, int y) {
        super(container, image, x, y);
    }

    /**
     * Create a new mouse over area
     *
     * @param container The container displaying the mouse over area
     * @param image     The normalImage to display
     * @param x         The position of the area
     * @param y         the position of the area
     * @param width     The width of the area
     * @param height    The height of the area
     * @param listener
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, int x, int y, int width, int height, ComponentListener listener) {
        super(container, image, x, y, width, height, listener);
    }

    /**
     * Create a new mouse over area
     *
     * @param container The container displaying the mouse over area
     * @param image     The normalImage to display
     * @param x         The position of the area
     * @param y         the position of the area
     * @param width     The width of the area
     * @param height
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, int x, int y, int width, int height) {
        super(container, image, x, y, width, height);
    }

    /**
     * Create a new mouse over area
     *
     * @param container The container displaying the mouse over area
     * @param image     The normalImage to display
     * @param shape
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, Shape shape) {
        super(container, image, shape);
    }

    /**
     * Create a new mouse over area
     *
     * @param container      The container displaying the mouse over area
     * @param image          The normalImage to display
     * @param x              The position of the area
     * @param y
     * @param stateBasedGame Controls for the game state.
     */
    public StateChangingMouseOverArea(GUIContext container, Image image, int x, int y, StateBasedGame stateBasedGame) {
        super(container, image, x, y);
        this.stateBasedGame = stateBasedGame;
    }

    @Override
    public void mousePressed(int button, int mx, int my) {
        stateBasedGame.enterState(1);
    }
}
