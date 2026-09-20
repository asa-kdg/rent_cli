package reserve;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import carmodel.Car;

public class ReservationManager {
	static Scanner scan = new Scanner(System.in);

	private static int useReserveId = 1000;

	public static void createResevation(Car car,
			String name,
			LocalDateTime startTime, LocalDateTime finTime) {
		int reserveId = useReserveId + 1;
		//貸出時間切り上げ
		int totalTime = (int) Duration.between(startTime, finTime).toMinutes() / 60;

		Reservation reservation = new Reservation(
				reserveId,
				name,
				car.getCar_number(),
				startTime,
				finTime,
				totalTime);

		car.addReservation(reservation);

		useReserveId++;

	}

}
