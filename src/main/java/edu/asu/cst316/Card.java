/**
 * A card of the game of life.
 *
 * Created by Doug Greenbaum on 11/30/2014.
 */
package main.java.edu.asu.cst316;

public class Card {
    private static int eogValue = 100000;
    private int effectValue;
    private String description;

    public static int getEogValue() {
        return eogValue;
    }

    public static void setEogValue(int eogValue) {
        Card.eogValue = eogValue;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(int effectValue) {
        this.effectValue = effectValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Card(int value, String desc) {
        setEffectValue(value);
        setDescription(desc);
    }

    public String toString() {
        return getDescription() + ": " + getEffectValue() + ", EoG:  " + getEogValue();
    }
}
