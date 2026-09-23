package shop;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import carmodel.Car;

public class Shop {
	private String name;
	private LocalTime openTime;
	private LocalTime closeTime;
	private static List<Car> cars;

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

	public static List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void removeCar(Car car) {
		cars.remove(car);
	}

	public String getInfoShop() {
		return name + "店　開店時間" + openTime + "　閉店時間" + closeTime;
	}

	//空き車両検索
	public static List<Car> shopFreeCar(LocalDateTime straTime, LocalDateTime finTime, Shop shop) {
		Shop seleshop = shop;
		List<Car> seleCars = seleshop.getCars();
		List<Car> freeCars = new ArrayList<Car>();
		for (Car c : seleCars) {
			if (c.isAvailable(straTime, finTime)) {
				freeCars.add(c);
			}
		}
		return freeCars;

	}
}
