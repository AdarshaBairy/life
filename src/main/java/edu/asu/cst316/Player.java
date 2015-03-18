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
	public Player(String name, String career, double salary, double savedMoney) {
		super();
		this.name = name;
		this.career = career;
		this.salary = salary;
		this.savedMoney = savedMoney;
		this.heldCards = new Object[10];
	}
	
	private String name;
	private String career;
	private double salary;
	private double savedMoney;
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
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @return the savedMoney
	 */
	public double getSavedMoney() {
		return savedMoney;
	}
	/**
	 * @param savedMoney the savedMoney to set
	 */
	public void setSavedMoney(double savedMoney) {
		this.savedMoney = savedMoney;
	}

}
