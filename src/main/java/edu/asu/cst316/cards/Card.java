package main.java.edu.asu.cst316.cards;

public class Card {
	private String text;
	private int value;
	private String type;
	
	public Card(String text, int value){
		//throw exception if string is blank
			if (text.equals(" ")){
				throw  new IllegalArgumentException("Text must not be empty");
			}

		this.text = text;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getText(){
		return text;
	}
	public int getValue(){
		return value;
	}
	
	public void setText(String text){
		this.text = text;
	}
	public void setValue(int value){
		this.value = value;
	}
}
