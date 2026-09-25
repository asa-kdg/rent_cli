package main;

import java.util.Scanner;

import shop.ShopManagers;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Admin admin = new Admin("admin", 1234);

		new ShopManagers();

		if (CsvManager.isShopEmpty()) {
			System.out.println("初回起動：初期店舗を作成します");
		} else {
			System.out.println("CSVから店舗を読み込みます");
			CsvManager.loadShops();
		}

		if (CsvManager.isCarsEmpty()) {

			System.out.println("初回起動：初期車両を作成します");
			ShopManagers.createCars();

		} else {

			System.out.println("CSVから車両を読み込みます");
			CsvManager.loadCars();
		}

		if (CsvManager.isReservationsEmpty()) {

			System.out.println("予約CSVは空です");

		} else {

			System.out.println("CSVから予約を読み込みます");
			CsvManager.loadReservations();
		}

		boolean running = true;

		while (running) {

			System.out.println();
			System.out.println("===== レンタカー予約システム =====");
			System.out.println("1. ユーザー");
			System.out.println("2. 管理者");
			System.out.println("3. 終了");
			System.out.print("選択してください：");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				UserMethod.selectUserFunction();
				break;

			case 2:
				AdminMethod.login(admin);
				AdminMethod.selectAdminFunction();
				break;

			case 3:
				CsvManager.saveShops();
				CsvManager.saveCars();
				CsvManager.saveReservations();

				running = false;
				break;

			default:
				System.out.println("正しい番号を入力してください");
			}
		}

	}

}
