import java.util.ArrayList;
import java.util.Random;
public class Order implements OrderInterface, Comparable<Order> {
	private int orderNum;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage>beverage;
	
	public Order(int ordTime, DAY ordDay, Customer cust) {
		orderNum=generateRandNum();
		orderTime=ordTime;
		orderDay=ordDay;
		customer=cust;
		beverage=new ArrayList<>();
	}
	public int generateRandNum() {
		Random rand=new Random();
		int randomNum=rand.nextInt(90000-10000)+10000;
		return randomNum;
	}
	public String toString() {
		String str="___________________________"+orderDay.toString()
		+", "+orderTime+"\n"+customer.toString()+" Order Num: "+orderNum;
		for(Beverage bev: beverage) {
			str+="\n"+bev.toString();
		}
		str+="\n Order Total: "+calcOrderTotal();
		return str;
	}
	public boolean isWeekend() {
		if(orderDay==DAY.SUNDAY||orderDay==DAY.SATURDAY)
			return true;
		else
			return false;
	}
	public Beverage getBeverage(int itemNo) {
		return beverage.get(itemNo);
	}
	public int compareTo(Order ord) {
		if(orderNum==ord.getOrderNo())
			return 0;
		else if(orderNum>ord.getOrderNo())
			return 1;
		else
			return -1;
	}
	public double calcOrderTotal() {
		double total=0;
		for(Beverage bev: beverage) {
			total+=bev.calcPrice();
		}
		return total;
	}
	public int findNumOfBeveType(TYPE type) {
		int tracker=0;
		for(Beverage bev: beverage) {
			if(bev.getType()==type) {
				tracker++;
			}
		}
		return tracker;
	}
	//
	public int getTotalItems() {
		return beverage.size();
	}
	public void addNewBeverage(String name, SIZE size, 
			boolean extraShot, boolean extraSyrup) {
		Coffee cof=new Coffee(name, size, extraShot, extraSyrup);
		beverage.add(cof);
	}
	public void addNewBeverage(String name,SIZE size, int numOfFruits,
			boolean proteinPowder) {
		Smoothie sm=new Smoothie(name,size,numOfFruits,proteinPowder);
		beverage.add(sm);
	}
	public void addNewBeverage(String name, SIZE size) {
		boolean weekend=false;
		if(orderDay==DAY.SUNDAY||orderDay==DAY.SATURDAY) {
			weekend=true;
		}
		Alcohol alc=new Alcohol(name, size, weekend);
		beverage.add(alc);
	}
	
	public int getOrderNo() {
		return orderNum;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public DAY getOrderDay() {
		return orderDay;
	}
	public Customer getCustomer() {
		return new Customer(customer);
	}
	public ArrayList<Beverage> getBeverage(){
		return beverage;
	}
	public void setOrderNum(int num) {
		orderNum=num;
	}
	public void setOrderTime(int time) {
		orderTime=time;
	}
	public void setOrderDay(DAY day) {
		orderDay=day;
	}
	public void setCustomer(Customer cust) {
		customer=cust;
	}
}
