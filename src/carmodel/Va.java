package carmodel;

public class Va extends Car {

	private int capacity;

	public Va(String name, int car_number, int price, int passengers, String category, int capacity) {
		super(name, car_number, price, passengers, category);
		this.capacity = capacity;
	}

	public Va(String name, int car_number, int capacity) {
		super(name, car_number, 2000, 3, "TC");
		this.capacity = capacity;
	}

	public Va(String name, int car_number, int price, int capacity) {
		super(name, car_number, price, 5, "VA");
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}