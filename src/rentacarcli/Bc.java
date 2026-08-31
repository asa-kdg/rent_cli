package rentacarcli;

public class Bc extends Car {
	private int passengers;

	public Bc(String name, int car_number) {
		super(name, car_number, 1000, "BC");
		this.passengers = 5;
	}

	public Bc(String name, int car_number, int price) {
		super(name, car_number, price, "CH");
		this.passengers = 5;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
