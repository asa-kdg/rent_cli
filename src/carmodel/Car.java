package carmodel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import reserve.Reservation;

public class Car {
	private String name;
	private int car_number;
	private int price;
	private int passengers;
	private String category;
	private static List<Reservation> reservations;

	public Car(String name, int car_number, int price, int passengers, String category) {
		this.name = name;
		this.car_number = car_number;
		this.price = price;
		this.category = category;
		this.passengers = passengers;
		this.reservations = new ArrayList<>();

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public static void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public String getInfoCar() {
		return "車名:" + name + "値段: 1時間あたり" + price + "円";
	}

	//この時間に車両が使用可能か
	public boolean isAvailable(LocalDateTime startDate, LocalDateTime finDate) {
		for (Reservation r : reservations) {
			LocalDateTime startReserved = r.getStartTime();
			LocalDateTime finReserved = r.getFinishTime();

			if (startDate.isBefore(finReserved.plusHours(1)) &&
					finDate.isAfter(startReserved.minusHours(1))) {
				return false;
			}

		}
		return true;

	}

}