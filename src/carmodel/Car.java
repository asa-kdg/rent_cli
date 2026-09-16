package carmodel;

import java.util.ArrayList;
import java.util.List;

import reserve.Reservation;

public class Car {
	private String name;
	private int car_number;
	private int price;
	private int passengers;
	private String catergory;
	private List<Reservation> reserve;

	public Car(String name, int car_number, int price, int passengers, String catergory) {
		this.name = name;
		this.car_number = car_number;
		this.price = price;
		this.catergory = catergory;
		this.passengers = passengers;
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

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getCatergory() {
		return catergory;
	}

	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}

	public String getInfoCar() {
		return "車名:" + name + "値段: 1時間あたり" + price + "円";
	}

}