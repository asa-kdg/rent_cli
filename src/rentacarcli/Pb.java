package rentacarcli;

public class Pb extends Car {
	private int passengers;

	public Pb(String name, int car_number) {
		super(name, car_number, 1700, "Pb");
		this.passengers = 8;
	}

	public Pb(String name, int car_number, int price, int passengers) {
		super(name, car_number, price, "Pb");
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
