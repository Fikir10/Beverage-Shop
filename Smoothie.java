
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean proteinPowder;
	private final double addProtein=1.50;
	private final double addFruit=0.50;
	public Smoothie(String n, SIZE sz, int fruitNum,boolean addProt) {
		super(n, TYPE.SMOOTHIE,sz);
		numOfFruits=fruitNum;
		proteinPowder=addProt;
	}
	public String toString() {
		String str=getBevName()+", "+getSize()+" "+numOfFruits+" Fruits";
		if(proteinPowder) {
			str+=" Protein powder";
		}
		str+=", $"+calcPrice();
		return str;
	}
	public boolean equals(Smoothie sm) {
		if(numOfFruits==sm.getNumOfFruits()&&proteinPowder==sm.getProteinPowder()&&this.equals(sm))
			return true;
		else 
			return false;
	}
	public double calcPrice() {
		double cost=super.getBasePrice();
		if(super.getSize()==SIZE.LARGE) {
			cost+=2*this.getSizePrice();
		}
		else if(super.getSize()==SIZE.MEDIUM) {
			cost+=this.getSizePrice();
		}
		cost+=numOfFruits*addFruit;
		if(proteinPowder) {
			cost+=addProtein;
		}
		return cost;
	}
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getProteinPowder() {
		return proteinPowder;
	}
	public boolean getAddProtien() {
			return proteinPowder;
	}
	public double getAddedFruit() {
		return addFruit;
	}
	public void setProteinPowder(boolean protPow) {
		proteinPowder=protPow;
	}
	public void setNumOfFuits(int fruitNums) {
		numOfFruits=fruitNums;
	}
}
