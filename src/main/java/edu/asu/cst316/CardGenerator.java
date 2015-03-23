/**
 * Tech demo for a card generator.
 *
 * Created by Doug Greenbaum on 11/24/2014.
 * Requires Apache Commons Math 3.3 http://www.trieuvan.com/apache//commons/math/binaries/commons-math3-3.3-bin.zip
 * Requires SQLite jdbc 3.8.7       https://bitbucket.org/xerial/sqlite-jdbc/downloads/sqlite-jdbc-3.8.7.jar
 */

package main.java.edu.asu.cst316;

import java.sql.*;
import java.util.Random;

import org.apache.commons.math3.distribution.*;

public class CardGenerator {

    private int mean  =  55294; // Mean assuming all score positive
    private int stdev =  54263;

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public int getStdev() {
        return stdev;
    }

    public void setStdev(int stdev) {
        this.stdev = stdev;
    }

    public CardGenerator() {

    }

    public CardGenerator(int mean, int stdev) {
        setMean(mean);
        setStdev(stdev);
    }

    public Card generateCard()
    {
        Connection c;
        Statement stmt;
        ResultSet rs;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");

            stmt = c.createStatement();

            // Determine the score of our new car
            NormalDistribution ndist = new NormalDistribution(mean, stdev);
            int score = (int) ndist.sample();

            // Count the messages in the DB.
            rs = stmt.executeQuery("SELECT COUNT(*) FROM EVENTS;");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }

            // Randomly pick an event id
            Random rand = new Random();
            int cardId = rand.nextInt(count + 1);
            while (cardId == 0) // Make sure we don't randomly pick 0
                cardId = rand.nextInt(count + 1);

            // Get the card desciption and alignment.
            rs = stmt.executeQuery("SELECT * FROM EVENTS WHERE id =" + cardId + ";");

            String message = "";
            int align = 1;
            while (rs.next()) {
                message = rs.getString("DESC");
                align = rs.getInt(3);
            }

            // Make the score negative if we get a bad event.
            if (align == 0){
                score = score *-1;
            }
            c.close();

            Card card = new Card(score, message);
            return card;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
