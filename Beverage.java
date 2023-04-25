
public abstract class Beverage {
	private TYPE type;
	private SIZE size;
	private String name;
	private final double BASE_PRICE=2;
	private final double SIZE_PRICE=1;
	
	public Beverage(String n, TYPE ty, SIZE sz) {
		type=ty;
		size=sz;
		name=n;
	}
	public abstract double calcPrice();
	public String toString() {
		String str=name+" "+size;
		return str;
	}
	public boolean equals(Beverage b) {
		if(type==b.getType()&&size==b.getSize()&&name.equals(b.getBevName()))
			return true;
		else 
			return false;
	}
	public TYPE getType() {
		return type;
	}
	public SIZE getSize() {
		return size;
	}
	public String getBevName() {
		return name;
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public double getSizePrice() {
		return SIZE_PRICE;
	}
	public void setType(TYPE ty) {
		type=ty;
	}
	public void setSize(SIZE sz) {
		size=sz;
	}
	public void setName(String n) {
		name=n;
	}
}
