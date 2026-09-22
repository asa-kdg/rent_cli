package carmodel;

public class Cx extends Car {

	public Cx(String name, int car_number, int price, int passengers, String category) {
		super(name, car_number, price, passengers, category);
	}

	public Cx(String name, int car_number) {
		super(name, car_number, 1200, 5, "CX");

	}

	public Cx(String name, int car_number, int price) {
		super(name, car_number, price, 5, "EX");

	}

}