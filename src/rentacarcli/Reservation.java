package rentacarcli;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {
	private int reserveId;
	private String name;
	private int car_number;
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private LocalTime rentaLocalTime;

	public Reservation(int reserveId, String name, int car_number, LocalDateTime startTime, LocalDateTime finishTime,
			LocalTime rentaLocalTime) {

		this.reserveId = reserveId;
		this.name = name;
		this.car_number = car_number;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.rentaLocalTime = rentaLocalTime;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public LocalTime getRentaLocalTime() {
		return rentaLocalTime;
	}

	public void setRentaLocalTime(LocalTime rentaLocalTime) {
		this.rentaLocalTime = rentaLocalTime;
	}

}
