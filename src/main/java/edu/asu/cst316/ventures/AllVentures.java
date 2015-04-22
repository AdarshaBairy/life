package main.java.edu.asu.cst316.ventures;


public class AllVentures {
	
	private static AllVentures ventures = new AllVentures();

	private static Venture venture[];
	
	public AllVentures(){
		venture = new Venture[3];
		
		venture[0] = new Venture();
		venture[0].setIncome(10000);
		venture[0].setStartingMoney(50000);
		venture[0].setImageName("images/charCreationInt1.png");
		venture[0].setRisk(4);
		venture[0].setCareer("Restaurant");
		
		venture[1] = new Venture();
		venture[1].setIncome(15000);
		venture[1].setStartingMoney(50000);
		venture[1].setImageName("images/charCreationInt2.png");
		venture[1].setRisk(6);
		venture[1].setCareer("Real Estate");
		
		venture[2] = new Venture();
		venture[2].setIncome(20000);
		venture[2].setStartingMoney(50000);
		venture[2].setImageName("images/charCreationInt3.png");
		venture[2].setRisk(8);
		venture[2].setCareer("Software");
		
	}
	
	public Venture[] getVentures() {
		return venture;
	}
	
	public static AllVentures getInstance() {
		return ventures;
	}
	
}
