package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carmodel.Car;
import carmodel.Va;
import shop.Shop;
import shop.ShopManagers;

public class UserMethod {
	static Scanner scan = new Scanner(System.in);

	public static int selectUserFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:店舗一覧表示");
			System.out.println("2:車種クラス一覧表示");
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
				showCarCategory();
				break;
			}
			case 3: {
				//予約メソッド

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selectFunc);
			}
		}
	}

	//車の車種カテゴリーごとに一覧を表示
	public static void showCarCategory() {
		Shop shop = ShopManagers.getShop(chooseShop());
		System.out.println("====車種クラス一覧====");

		List<String> categories = new ArrayList<>();

		for (Car car : shop.getCars()) {

			if (!categories.contains(car.getCategory())) {
				categories.add(car.getCategory());

				//Vaのみ積載量の掲載もする
				if (car instanceof Va) {
					Va va = (Va) car;

					System.out.println(
							car.getCategory()
									+ "クラス　基本料金："
									+ car.getPrice()
									+ "円　乗車人数："
									+ car.getPassengers()
									+ "人　積載量："
									+ va.getCapacity()
									+ "kg 車種例" + car.getName());

				} else {
					System.out.println(
							car.getCategory()
									+ "クラス　基本料金:"
									+ car.getPrice()
									+ "円　乗車人数"
									+ car.getPassengers()
									+ "人　車種例"
									+ car.getName());
				}

			}

		}

	}

	//店舗選択
	public static String chooseShop() {
		while (true) {
			System.out.println("店舗を数字で選択してください");
			ShopManagers.showShop();
			List<Shop> shops = ShopManagers.getShops();
			int shopsele = scan.nextInt() - 1;

			if (shopsele >= 0 && shopsele < shops.size()) {
				Shop seleShop = shops.get(shopsele);
				return seleShop.getName();
			}

			System.out.println("正しい店舗の番号を選択してください");

		}
	}

	//予約
	public static void book() {
		chooseShop();

	}
}
