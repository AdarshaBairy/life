/**
 * 
 */

package main.java.edu.asu.cst316;
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
	//todo held cards. replace with card object when ready
	private Object[] heldCards;
	
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
		this.heldCards = new Object[10];
	}
	
	public Player(String name){
		if (name.compareToIgnoreCase("venture 1") == 1){
			this.name = name;
			this.career = "venture 1";
			this.income = 1000;
			this.savedMoney = 5000;
			
		}
		
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
	
	private void payDay(){
		Random rand = new Random();
		savedMoney = savedMoney + (income/(risk/2)) + (income *(rand.nextInt(risk) + 1 ));

	}
	
	private void addCard(Object card){
	}
	

}
