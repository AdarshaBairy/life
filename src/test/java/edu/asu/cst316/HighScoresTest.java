package test.java.edu.asu.cst316;

import static org.junit.Assert.*;
import main.java.edu.asu.cst316.highscore.HighScores;
import main.java.edu.asu.cst316.highscore.PlayerRecord;

import org.junit.Test;

import junit.framework.TestCase;


public class HighScoresTest {
	@Test
	public void testHighScoreList() {
		HighScores highScores = HighScores.getInstance();
		assertTrue(highScores.getHighScoreList().size() == 0);

		highScores.addPlayerRecord("player1", 200);
		assertTrue(highScores.getHighScoreList().size() == 1);
		for(int i = 0; i < 99; i++){
			highScores.addPlayerRecord("player1", 200);
		}
		assertTrue(highScores.getHighScoreList().size() == 100);
		highScores.serialize();
		assertTrue(highScores.checkForExistingFile());
		
		highScores.init();
		assertTrue(highScores.getHighScoreList().size() == 0);
		
		highScores.deSerialize();
		assertTrue(highScores.getHighScoreList().size() == 100);
		
	}
	
	
	@Test
	public void testDeleteList() {
		HighScores highScores = HighScores.getInstance();
		highScores.init();
		
		assertTrue(highScores.checkForExistingFile());
		assertTrue(highScores.deleteFile());
		
	}
	
	@Test
	public void testOrder() {
		HighScores highScores = HighScores.getInstance();
		highScores.addPlayerRecord("player0", 600);
		highScores.addPlayerRecord("player1", 900);
		highScores.addPlayerRecord("player2", 400);
		highScores.addPlayerRecord("player3", 500);
		
		assertTrue(highScores.getHighScoreList().get(0).getPlayerName().equals("player1"));
		assertTrue(highScores.getHighScoreList().get(3).getPlayerName().equals("player2"));
		assertTrue(highScores.getHighScoreList().get(1).getPlayerName().equals("player0"));
		assertTrue(highScores.getHighScoreList().get(2).getPlayerName().equals("player3"));
	}
}
