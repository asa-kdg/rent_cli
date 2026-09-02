package admin;

import java.util.Scanner;

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

}
