package main;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
		System.out.println("レンタカーの予約をします");
		//店舗指定
		String shopName = chooseShop();
		//時間指定
		LocalDateTime startDateTime = choseDateTime("貸出", shopName);
		LocalDateTime finDateTime = choseDateTime("返却", shopName);
		//空き車両の表示
		List<Car> freecars = Shop.shopFreeCar(startDateTime, finDateTime);
		//空き車両の有無
		if (freecars.isEmpty()) {
			System.out.println("空き車両がありません");
			return;
		}
		//予約車両の選択
		int selected = selectCar(freecars);
		int carNumber = freecars.get(selected).getCar_number();

	}

	//時間の指定
	public static LocalDateTime choseDateTime(String when, String shopName) {
		while (true) {
			System.out.println(when + "日時を入力してください");
			System.out.println("「年」を入力してください(2026-)");
			int year = scan.nextInt();
			System.out.println("「月」を入力してください(1-12)");
			int month = scan.nextInt();
			System.out.println("「日」を入力してください(1-31)");
			int date = scan.nextInt();
			System.out.println("「時」を入力してください(0-23)");
			int hour = scan.nextInt();
			System.out.println("「分」を入力してください(0-59)");
			int min = scan.nextInt();

			LocalDateTime DateTime = LocalDateTime.of(year, month, date, hour, min);

			LocalTime selectedTime = DateTime.toLocalTime();
			Shop shop = ShopManagers.getShop(shopName);
			LocalTime shopOpen = shop.getOpenTime();
			LocalTime shopClose = shop.getCloseTime();

			if (selectedTime.isBefore(shopOpen) || selectedTime.isAfter(shopClose)) {
				System.out.println("営業時間外です。営業時間内の時間を指定してください。");
				System.out.println(shopName + "店　営業時間　" + shopOpen + "-" + shopClose);

			} else {
				return DateTime;
			}
		}
	}

	//予約車両の選択(番号選択の条件)
	public static int selectCar(List<Car> freecar) {
		while (true) {
			System.out.println("予約する車両を選択してください");
			int select = scan.nextInt() - 1;

			if (select < 0 || select >= freecar.size()) {
				System.out.println("正しい車両番号を指定してください");
				continue;
			}
			return select;
		}
	}

}
