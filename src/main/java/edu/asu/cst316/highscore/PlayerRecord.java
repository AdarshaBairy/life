package main.java.edu.asu.cst316.highscore;

import java.io.Serializable;

public class PlayerRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	private String playerName;
	private int score;
	
	public PlayerRecord(){
	
	}
	public PlayerRecord(String playerName, int score){
		this.playerName = playerName;
		this.score = score;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	public int getScore(){
		return score;
	}
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	public void setScore(int score){
		this.score = score;
	}
}

