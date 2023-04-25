
public class Alcohol extends Beverage{
	private boolean offeredWeekend;
	private final double WEEKEND_COST=0.60;
	
	public Alcohol(String n, SIZE sz, boolean weekend) {
		super(n,TYPE.ALCOHOL,sz);
		offeredWeekend=weekend;
	}
	public String toString() {
		String str=getBevName()+", "+getSize();
		if(offeredWeekend) {
			str+=" Weekend";
		}
		str+=", $"+calcPrice();
		return str;
	}
	public boolean equals(Alcohol alc) {
		if(offeredWeekend==alc.getOfferedOnWeekends()&&this.equals(alc))
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
		if(offeredWeekend) {
			cost+=WEEKEND_COST;
		}
		return cost;
	}
	public double getWeekendCost() {
		return WEEKEND_COST;
	}
	public boolean getOfferedOnWeekends() {
		return offeredWeekend;
	}
	public void setWeekend(boolean wknd) {
		offeredWeekend=wknd;
	}
}
