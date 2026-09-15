package main;

import java.util.Scanner;

import model.ShopManagers;

public class AdminMethod {
	static Scanner scan = new Scanner(System.in);

	public static int selectAdminFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:車両更新");
			System.out.println("2:車両登録");
			System.out.println("3:車両削除");
			System.out.println("4:予約確認");
			System.out.println("5:予約状態変更");
			int selectFunc = scan.nextInt();

			if (selectFunc <= 5 && selectFunc >= 1) {
				return selectFunc;
			} else {
				System.out.println("不正な入力です。数字で選択してください");
			}
			if (selectFunc == 1) {
				ShopManagers.updateShop();
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
