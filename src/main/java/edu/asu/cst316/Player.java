/**
 * 
 */
package main.java.edu.asu.cst316;

/**
 * @author Owner
 *
 */
public class Player {
	/**
	 * @param name
	 * @param career
	 * @param salary
	 * @param savedMoney
	 * @param heldCards
	 */
	public Player(String name, String career, int income, int savedMoney) {
		super();
		this.name = name;
		this.career = career;
		this.income = income;
		this.savedMoney = savedMoney;
		this.heldCards = new Object[10];
	}
	
	private String name;
	private String career;
	private int income;
	private int savedMoney;
	//todo held cards. replace with card object when ready
	private Object[] heldCards;
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
		savedMoney = savedMoney + income;
	}

}
