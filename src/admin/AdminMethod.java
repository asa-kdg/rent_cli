package admin;

import java.util.Scanner;

import model.ShopManagers;

public class AdminMethod {
	static Scanner scan = new Scanner(System.in);

	public static int selectFunc() {
		while (true) {
			System.out.println("1:");
			System.out.println("2:");
			System.out.println("3:");
			System.out.println("4:");
			System.out.println("5:");
			int select = scan.nextInt();

			if (select <= 5 && select >= 1) {
				return select;
			} else {
				System.out.println("不正な入力です。数字で選択してください");
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

	public void selectCommand() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		System.out.println("1:店舗情報の更新");
		System.out.println("2:店舗の登録");
		System.out.println("3:車両の登録");
		System.out.println("4:車両の削除");
		System.out.println("5:予約一覧の表示");
		System.out.println("6:予約状態の変更");
		System.out.println("7:");
		int selctCommand = scan.nextInt();
		if (selctCommand == 1) {
			ShopManagers.updateShop();
		} else if (selctCommand == 2) {
			ShopManagers.addShop();
		} else if (selctCommand == 3) {
			ShopManagers.addShop();
		} else if (selctCommand == 4) {
			ShopManagers.addShop();
		} else if (selctCommand == 5) {
			ShopManagers.addShop();
		} else if (selctCommand == 6) {
			ShopManagers.addShop();
		} else if (selctCommand == 7) {
			ShopManagers.addShop();
		}

	}

}
