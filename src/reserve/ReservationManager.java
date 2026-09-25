package reserve;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import carmodel.Car;
import shop.Shop;

public class ReservationManager {
	static Scanner scan = new Scanner(System.in);

	//予約番号の自動取得
	private static int useReserveId = 1000;

	// 予約番号を設定
	public static void setUseReserveId(int reserveId) {
		useReserveId = reserveId;
	}

	//トータル時間計算
	public static int calcTotalTime(LocalDateTime sTime, LocalDateTime fTime) {
		int totalTime = (int) Duration.between(sTime, fTime).toMinutes() / 60;
		return totalTime;
	}

	//予約
	public static Reservation createResevation(Car car,
			String name, Shop shop,
			LocalDateTime startTime, LocalDateTime finTime) {
		int reserveId = ++useReserveId;

		//貸出時間切り上げ
		int totalTime = calcTotalTime(startTime, finTime);

		Reservation reservation = new Reservation(
				reserveId,
				name,
				car.getCar_number(),
				shop,
				startTime,
				finTime,
				totalTime);

		car.addReservation(reservation);

		return reservation;

	}

	//1件のみの予約情報参照
	public static void showReservation(Reservation reservation) {
		System.out.println("=====予約情報=====");
		System.out.println(reservation.getInfoReservation());
	}

	//複数件の予約情報表示
	public static void showReservations(List<Reservation> reservations) {
		for (Reservation re : reservations) {
			System.out.println(re.getInfoReservation());
		}
	}

	//予約検索(店舗指定あり)主にadmin側で使用
	public static Reservation findResevation(Shop shop, int reserveId) {
		for (Car c : shop.getCars()) {
			for (Reservation re : c.getReservations()) {
				if (re.getReserveId() == reserveId) {
					return re;
				}
			}
		}
		return null;
	}

	//予約検索(店舗指定なし)主にUser側で使用
	public static Reservation findResevation(List<Shop> shops, String name, int reserveId) {

		for (Shop shop : shops) {
			for (Car c : shop.getCars()) {
				for (Reservation re : c.getReservations()) {
					if (re.getReserveId() == reserveId &&
							re.getUser().equals(name)) {
						return re;
					}
				}
			}
		}
		return null;
	}

	//予約情報の更新(時間のみ)
	public static void updateReservation(Reservation reservation, LocalDateTime newStartTime,
			LocalDateTime newFinTime) {
		int totalTime = calcTotalTime(newStartTime, newFinTime);
		reservation.setStartTime(newStartTime);
		reservation.setFinishTime(newFinTime);
		reservation.setTotalTime(totalTime);

	}

	//予約キャンセル
	public static void canselReservation(Reservation canRe, List<Shop> shops) {
		for (Shop s : shops) {

			for (Car c : s.getCars()) {
				if (c.getCar_number() == canRe.getCar_number()) {
					c.removeReservation(canRe);

					return;
				}
			}
		}

	}

}
