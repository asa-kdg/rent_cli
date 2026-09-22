package carmodel;

public class Pb extends Car {

	public Pb(String name, int car_number, int price, int passengers, String category) {
		super(name, car_number, price, passengers, category);
	}

	public Pb(String name, int car_number) {
		super(name, car_number, 1700, 8, "PB");
	}

	public Pb(String name, int car_number, int price) {
		super(name, car_number, price, 6, "LA");
	}

}