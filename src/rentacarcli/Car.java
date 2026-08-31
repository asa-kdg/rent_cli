package rentacarcli;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private String name;
	private int car_number;
	private int price;
	private String catergory;
	private List<Reservation> reserve;

	public Car(String name, int car_number, int price, String catergory) {
		this.name = name;
		this.car_number = car_number;
		this.price = price;
		this.catergory = catergory;
		this.reserve = new ArrayList<>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCar_number() {
		return car_number;
	}

	public void setCar_number(int car_number) {
		this.car_number = car_number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCatergory() {
		return catergory;
	}

	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}

}
