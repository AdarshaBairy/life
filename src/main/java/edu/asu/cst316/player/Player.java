/**
 * 
 */

package main.java.edu.asu.cst316.player;
import java.util.*;

/**
 * @author Owner
 *
 */
public class Player {
	
	private String name;
	private String career;
	private int income;
	private int savedMoney;
	private int risk;
	/**
	 * @param name
	 * @param career
	 * @param salary
	 * @param savedMoney
	 * @param heldCards
	 */
	public Player(String name, String career, int income, int savedMoney) {
		this.name = name;
		this.career = career;
		this.income = income;
		this.risk = 1;
		this.savedMoney = savedMoney;
	}	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the career
	 */
	public String getCareer() {
		return career;
	}
	/**
	 * @param career the career to set
	 */
	public void setCareer(String career) {
		this.career = career;
	}
	/**
	 * @return the salary
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setIncome(int income) {
		this.income = income;
	}
	/**
	 * @return the savedMoney
	 */
	public int getSavedMoney() {
		return savedMoney;
	}
	/**
	 * @param savedMoney the savedMoney to set
	 */
	public void setSavedMoney(int savedMoney) {
		this.savedMoney = savedMoney;
	}
	
	public void payDay(){
		
	Random rand = new Random();
	savedMoney = savedMoney + (income/(risk/2)) + (income *(rand.nextInt(risk) + 1 ));
	
	}
	
}
