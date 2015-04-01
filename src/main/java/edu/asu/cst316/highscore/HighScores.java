package main.java.edu.asu.cst316.highscore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class HighScores {

	private static HighScores highScores = new HighScores();
	
	private List<PlayerRecord> highScoreList;
	
	private HighScores(){
		highScoreList = new ArrayList<PlayerRecord>();
	};
	
	public static HighScores getInstance(){
		return highScores;
	}
	
	//Read the high score list to a file
	@SuppressWarnings("unchecked")
	public void deSerialize(){
		try{
			FileInputStream fis = new FileInputStream("highscores.list");
			ObjectInputStream oin = new ObjectInputStream(fis);
			highScoreList = (List<PlayerRecord>) oin.readObject();
			oin.close();
			fis.close();
		}catch(IOException e){
		     e.printStackTrace();
		}catch(ClassNotFoundException e){
		     e.printStackTrace();
		}
	}
	
	
	//Write the high score list to a file
	public void serialize(){
		try{
			FileOutputStream fileOut = new FileOutputStream("highscores.list");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(highScoreList);
			out.close();
			fileOut.close();
		}catch(IOException e){
		     e.printStackTrace();
		}
	}
	
	//Start new high score list
	public void init(){
		highScoreList = new ArrayList<PlayerRecord>();
	}
	
	//Record the player's score and then sort the list by the player's score
	public void addPlayerRecord(String name, int score){
		PlayerRecord currentPlayer = new PlayerRecord();
		currentPlayer.setPlayerName(name);
		currentPlayer.setScore(score);
		highScoreList.add(currentPlayer);
		Collections.sort(highScoreList, new Comparator<PlayerRecord>() {
			@Override
			public int compare(PlayerRecord pr1, PlayerRecord pr2) {
				return  pr1.getScore() < pr2.getScore() ? 1 : -1;
			}
		});
	}
	
	public List<PlayerRecord> getHighScoreList(){
		return highScoreList;
	}
}
