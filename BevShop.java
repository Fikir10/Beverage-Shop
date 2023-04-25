import java.util.ArrayList;
public class BevShop implements BevShopInterface {
	private int currentIndex;
	private int numOfAlcoholDrink;
	private ArrayList<Order> orders;
	
	public BevShop() {
		orders=new ArrayList<>();
	}
	public String toString() {
		String str="Monthly Orders\n";
		for(Order ord: orders) {
			str+=ord.toString();
			}
		str+="Total Sale: "+totalMonthlySale();
		return str;
	}
	public boolean validAge(int age) {
		if(age>MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}
	public boolean validTime(int time) {
		if(time<=MAX_TIME&&time>=MIN_TIME) {
			return true;
		}
		return false;
	}
	public boolean eligibleForMore() {
		if(numOfAlcoholDrink<3) {
			return true;
		}
		return false;
	}
	public boolean isMaxFruit(int num) {
		if(num>MAX_FRUIT) {
			return true;
		}
		return false;
	}
	public void startNewOrder(int time, DAY day,String customerName, int customerAge) {
		Customer customer=new Customer(customerName,customerAge);
		Order order=new Order(time,day,customer);
		orders.add(order);
		currentIndex=orders.indexOf(order);
		numOfAlcoholDrink=0;
	}
	public void processCoffeeOrder(String bevName,SIZE size,boolean extraShot, boolean extraSyrup) {
		orders.get(currentIndex).addNewBeverage(bevName, size,extraShot, extraSyrup);
	}
	public void processSmoothieOrder(String bevName,SIZE size,int numOfFruits,boolean addProtein) {
		orders.get(currentIndex).addNewBeverage(bevName,size,numOfFruits,addProtein);
	}
	public void processAlcoholOrder(String bevName,SIZE size) {
		orders.get(currentIndex).addNewBeverage(bevName,size);
		numOfAlcoholDrink++;
	}
	public int findOrder(int orderNo) {
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i).getOrderNo()==orderNo) {
				return i;
			}
		}
		return -1;
	}
	public double totalOrderPrice(int orderNo) {
		double price=0;
		for(Order ord:orders) {
			if(ord.getOrderNo()==orderNo) {
				for(Beverage bev: ord.getBeverage()) {
					price+=bev.calcPrice();
				}
			}
		}
		return price;
	}
	public double totalMonthlySale() {
		double sale=0;
		for(Order ord:orders) {
			for(Beverage bev:ord.getBeverage()) {
				sale+=bev.calcPrice();
			}
		}
		return sale;
	}
	//
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	public void sortOrders() {
		for(int i=0;i<orders.size()-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<orders.size();j++) {
				if(orders.get(j).getOrderNo()<orders.get(minIndex).getOrderNo()) {
					minIndex=j;
				}
			}
			Order ord=orders.get(minIndex);
			orders.set(minIndex, orders.get(i));
			orders.set(i, ord);
		}
	}
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	public Order getCurrentOrder() {
		return orders.get(currentIndex);
	}
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}
	public int getMaxAlcoholOrder() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
}
