package main;

import java.util.Scanner;

import model.ShopManagers;

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

			if (selectFunc <= 5 && selectFunc >= 1) {
				return selectFunc;
			} else {
				System.out.println("不正な入力です。数字で選択してください");
			}

			if (selectFunc == 1) {
				ShopManagers.showShop();
			} else if (selectFunc == 2) {
				ShopManagers.addShop();
			} else if (selectFunc == 3) {
				ShopManagers.addShop();
			} else if (selectFunc == 4) {
				ShopManagers.addShop();
			} else if (selectFunc == 5) {
				ShopManagers.addShop();
			}
		}
	}

}
