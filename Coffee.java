
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_COST=0.50;
	private final double EXTRA_SYRUP_COST=0.50;

	public Coffee(String n,SIZE sz, boolean exShot, boolean exSyrup ) {
		super(n,TYPE.COFFEE,sz);
		extraShot=exShot;
		extraSyrup=exSyrup;
	}
	public String toString() {
		String str=getBevName()+", "+getSize();
		if(extraSyrup) {
			str+=" Extra syrup";
		}
		if(extraShot) {
			str+=" Extra shot";
		}
		str+=", $"+calcPrice();
		return str;
	}
	public double calcPrice() {
		double cost=super.getBasePrice();
		if(super.getSize()==SIZE.LARGE) {
			cost+=2*this.getSizePrice();
		}
		else if(super.getSize()==SIZE.MEDIUM) {
			cost+=this.getSizePrice();
		}
		if(extraSyrup) {
			cost+=EXTRA_SYRUP_COST;
		}
		if(extraShot) {
			cost+=EXTRA_SHOT_COST;
		}
		return cost;
	}
	public boolean equals(Coffee cof) {
		if(extraSyrup==cof.getExtraSyrup()&&extraShot==cof.getExtraShot()&&this.equals(cof))
			return true;
		else
			return false;
	}
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public double getExtraShotCost() {
		return EXTRA_SHOT_COST;
	}
	public double getExtraSyrupCost() {
		return EXTRA_SYRUP_COST;
	}
	public void setExtraShot(boolean exShot) {
		extraShot=exShot;
	}
	public void setExtraSyrup(boolean exSyrup) {
		extraSyrup=exSyrup;
	}
}
