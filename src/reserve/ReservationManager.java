package reserve;

import java.util.List;
import java.util.Scanner;

import model.ShopManagers;

public class ReservationManager {
	static Scanner scan = new Scanner(System.in);

	private static List<Reservation> reservations;

	public static void createResevation() {
		System.out.println("何店で予約しますか？");
		ShopManagers.showShop();
		int x = scan.nextInt();
		while (true) {
			switch (x) {
			case 1: {

			}
			case 2: {

			}
			}

		}

	}

}
