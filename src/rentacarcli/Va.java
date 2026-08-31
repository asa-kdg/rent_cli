package rentacarcli;

public class Va extends Car {
	private int passengers;
	private int capacity;

	public Va(String name, int car_number, int price, int capacity) {
		super(name, car_number, price, "Tc");
		this.passengers = 4;
		this.capacity = capacity;
	}

	public Va(String name, int car_number, int price, int passengers, int capacity) {
		super(name, car_number, price, "Va");
		this.passengers = passengers;
		this.capacity = capacity;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
