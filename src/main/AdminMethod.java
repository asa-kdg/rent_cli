package main;

import java.util.Scanner;

import shop.ShopManagers;;

public class AdminMethod {
	static Scanner scan = new Scanner(System.in);

	public static int selectAdminFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:店舗情報更新");
			System.out.println("2:店舗登録");
			System.out.println("3:車両削除");
			System.out.println("4:予約確認");
			System.out.println("5:予約状態変更");
			System.out.println("6:終了する");

			int selectFunc = scan.nextInt();

			switch (selectFunc) {
			case 1: {
				ShopManagers.updateShop();
			}
			case 2: {
				ShopManagers.addShop();
			}
			case 3: {

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selectFunc);

			}

		}

	}

	public static boolean certificationPass() {
		System.out.println("パスワードを入力してください");
		String pw = scan.next();
		if (pw == Admin.getPass()) {
			System.out.println("パスワードが認証されました。");
			return true;
		} else {
			System.out.println("パスワードが違います。");
			return false;
		}
	}

}
