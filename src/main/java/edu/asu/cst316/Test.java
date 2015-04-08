package main.java.edu.asu.cst316;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import org.apache.commons.math3.distribution.*;

public class Test {
    public static void main(String[] args) {
        Connection c;
        Statement stmt;
        ResultSet rs;
        int mean = 55294; // Mean assuming all score positive
        int stdev = 54263;
        int min = -70000;
        int max = 200000;

        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:test.db");
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            // Create a table structure
//            String sql = "CREATE TABLE EVENTS " +
//                    "(ID INT PRIMARY KEY     NOT NULL," +
//                    " DESC           TEXT    NOT NULL," +
//                    " ALIGN          BOOLEAN NOT NULL)";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            System.out.println("Table created successfully");
//
//            // Insert some data
//            stmt = c.createStatement();
//            sql = "INSERT INTO EVENTS (ID,DESC,ALIGN) " +
//                    "VALUES (1, 'Something good.', 1);";
//            stmt.executeUpdate(sql);
//
//            stmt = c.createStatement();
//            sql = "INSERT INTO EVENTS (ID,DESC,ALIGN) " +
//                    "VALUES (2, 'Something neutral.', 1);";
//            stmt.executeUpdate(sql);
//
//            stmt = c.createStatement();
//            sql = "INSERT INTO EVENTS (ID,DESC,ALIGN) " +
//                    "VALUES (3, 'Something bad.', 0);";
//            stmt.executeUpdate(sql);
//            stmt.close();
//            System.out.println("Records created successfully");
//
//            // Commit changes
//            c.commit(); // Apparently auto-commit is default for sqlite
//
//            // Select some stuff
//            stmt = c.createStatement();
//            rs = stmt.executeQuery("SELECT * FROM EVENTS;");
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String desc = rs.getString("desc");
//                int align = rs.getInt("align");
//                System.out.println("ID = " + id);
//                System.out.println("DESC = " + desc);
//                System.out.println("ALIGN = " + align);
//                System.out.println();
//            }
//            System.out.println("Database functional.");
//            System.out.println();
//            rs.close();
//            stmt.close();

            // Make a stack of cards.
           // CardStack cs = new CardStack();
           // System.out.println(cs);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
