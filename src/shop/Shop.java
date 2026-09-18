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

	public void addCar(Car car) {
		cars.add(car);
	}

	public String getInfoShop() {
		return name + "店　開店時間" + openTime + "　閉店時間" + closeTime;
	}

	//空き車両検索
	public void shopFreeCar(LocalDateTime straTime, LocalDateTime finTime) {
		int x = 0;
		for (Car c : cars) {
			if (c.isAvailable(straTime, finTime)) {
				System.out.println(x + ". "
						+ c.getName()
						+ "  "
						+ c.getCategory()
						+ "クラス　基本料金:"
						+ c.getPrice()
						+ "円　乗車人数"
						+ c.getPassengers()
						+ "人　車種例"
						+ c.getName());

				x++;
			}
		}

	}
}
