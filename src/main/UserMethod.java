package main;

import java.util.Scanner;

import shop.ShopManagers;

public class UserMethod {
	static Scanner scan = new Scanner(System.in);

	public static int selectUserFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:店舗一覧表示");
			System.out.println("2:車種一覧表示");
			System.out.println("3:予約");
			System.out.println("4:予約確認");
			System.out.println("5:予約変更、キャンセル");
			int selectFunc = scan.nextInt();

			switch (selectFunc) {
			case 1: {
				ShopManagers.showShop();
				break;
			}
			case 2: {

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selectFunc);
			}
		}
	}

}
