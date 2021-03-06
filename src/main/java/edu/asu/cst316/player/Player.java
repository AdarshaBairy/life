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
	private static Player player = new Player();
	
	private Player(){

	}
	
	/**
	 * @param name
	 * @param career
	 * @param salary
	 * @param savedMoney
	 * @param heldCards
	 */
	
	public static Player getInstance(){
		return player;		
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
		System.out.println(name);
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
	public int getIncome() {
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
	
	public void setRisk(int risk){
		this.risk = risk;
	}
	
	public int payDay(){
		
		Random rand = new Random();
		int modifiedIncome = income/(risk/2);
		int result = (modifiedIncome *(rand.nextInt(risk) + 1 ));
		savedMoney = savedMoney + result;
		return result;

	}
}