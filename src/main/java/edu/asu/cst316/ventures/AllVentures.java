package main.java.edu.asu.cst316.ventures;


public class AllVentures {
	private Venture ventures[];

	public AllVentures(){
		ventures = new Venture[3];
		
		ventures[0] = new Venture();
		ventures[0].setIncome(10000);
		ventures[0].setStartingMoney(50000);
		ventures[0].setImageName("images/charCreationInt1.png");
		ventures[0].setRisk(4);
		
		ventures[1] = new Venture();
		ventures[1].setIncome(15000);
		ventures[1].setStartingMoney(50000);
		ventures[1].setImageName("images/charCreationInt2.png");
		ventures[1].setRisk(6);
		
		ventures[2] = new Venture();
		ventures[2].setIncome(20000);
		ventures[2].setStartingMoney(50000);
		ventures[2].setImageName("images/charCreationInt3.png");
		ventures[2].setRisk(8);
	}
	
	public Venture[] getVentures() {
		return ventures;
	}

	public void setVentures(Venture[] ventures) {
		this.ventures = ventures;
	}
	
}
