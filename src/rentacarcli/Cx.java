package rentacarcli;

public class Cx extends Car {
	private int passengers;

	public Cx(String name, int car_number) {
		super(name, car_number, 1200, "CX");
		this.passengers = 5;
	}

	public Cx(String name, int car_number, int price) {
		super(name, car_number, price, "EX");
		this.passengers = 5;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

}
