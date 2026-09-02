package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import carmodel.Car;

public class Shop {
	private String name;
	private LocalTime openTime;
	private LocalTime closeTime;
	private List<Car> cars;

	public Shop(String name, LocalTime openTime, LocalTime closeTime) {
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.cars = new ArrayList<>();

	}

	///ゲッター、セッター
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	///車を追加
	public void addCar(Car car) {
		cars.add(car);
	}

}
