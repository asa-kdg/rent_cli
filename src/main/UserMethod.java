package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carmodel.Car;
import shop.Shop;
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

	//車の車種カテゴリーごとに一覧を表示
	//絶対に良くないけど今回は錦糸町に全ての車種があるのでそこから参照
	public void showCarCategory() {
		Shop shop = ShopManagers.getShop("錦糸町");
		System.out.println("====車種一覧====");

		List<String> categories = new ArrayList<>();

		for (Car car : shop.getCars()) {

			if (!categories.contains(car.getCatergory())) {
				categories.add(car.getCatergory());

				System.out.println(
						car.getCatergory() + "クラス　基本料金:" + car.getPrice() + "円　乗車人数" + car.getPassengers() + "人");
			}

		}

	}

}
