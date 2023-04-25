
public class Customer {
	private String name;
	private int age;
	public Customer(String n, int ag) {
		name=n;
		age=ag;
	}
	public Customer(Customer cust) {
		name=cust.getName();
		age=cust.getAge();
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int ag) {
		age=ag;
	}
	public void setName(String n) {
		name=n;
	}
	public String toString() {
		String str=name+", "+age+" years old";
		return str;
	}
}
