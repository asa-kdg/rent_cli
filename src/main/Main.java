package main;

import java.util.Scanner;

import shop.ShopManagers;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		new ShopManagers();

		if (CsvManager.isShopEmpty()) {
			System.out.println("初回起動：初期店舗を作成します");
		} else {
			System.out.println("CSVから店舗を読み込みます");
			CsvManager.loadShops();
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
				AdminMethod.login();
				break;

			case 3:
				CsvManager.saveShops();
				running = false;
				break;

			default:
				System.out.println("正しい番号を入力してください");
			}
		}

	}

}
