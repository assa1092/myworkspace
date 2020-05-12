package kr.co.ca;

public class Apple {
	private String name;
	private int price;
	public Apple() {
		// TODO Auto-generated constructor stub
	}
	public Apple(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
