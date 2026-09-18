package reserve;

import java.time.LocalDateTime;

public class Reservation {
	private int reserveId;
	private String user;
	private int car_number;
	private LocalDateTime startTime;
	private LocalDateTime finishTime;
	private int totalTime;

	public Reservation(int reserveId, String user, int car_number, LocalDateTime startTime, LocalDateTime finishTime,
			int totalTime) {

		this.reserveId = reserveId;
		this.user = user;
		this.car_number = car_number;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.totalTime = totalTime;
	}

	public int getReserveId() {
		return reserveId;
	}

	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public String getInfoReservation() {
		return "予約名義" + user + "車両" + car_number + "貸出時間" + startTime + "返却時間" + finishTime;
	}

}
