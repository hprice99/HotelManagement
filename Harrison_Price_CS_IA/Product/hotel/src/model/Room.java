package model;

public class Room implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String type;
	private int num;
	private double price;
	private boolean isBooked;
	

	public Room(String type, int num, double price) {
		super();
		this.type = type;
		this.num = num;
		this.price = price;
		isBooked = false;
	}

	public Room() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "Room [type=" + type + ", num=" + num + ", price=" + price + ", isBooked=" + isBooked + "]";
	}
	
}
