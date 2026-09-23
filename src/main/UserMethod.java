package main;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carmodel.Car;
import carmodel.Va;
import reserve.Reservation;
import reserve.ReservationManager;
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
			System.out.println("5:予約キャンセル");
			System.out.println("6:予約時間変更");
			System.out.println("7:終了する");
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
				book();
				break;
			}
			case 4: {
				checkReservation();
				break;
			}
			case 5: {
				int cancelId = inputId();
				String cancelName = inputName();
				cancelReservation(cancelName, cancelId);
				break;
			}
			case 6: {
				System.out.println("予約時間を変更します");
				int changeId = inputId();
				String changeName = inputName();
				changeReservation(changeName, changeId);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selectFunc);
			}
		}
	}

	//車の車種カテゴリーごとに一覧を表示
	public static void showCarCategory() {
		Shop shop = chooseShop();
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
	public static Shop chooseShop() {
		while (true) {
			System.out.println("店舗を数字で選択してください");
			ShopManagers.showShop();
			List<Shop> shops = ShopManagers.getShops();
			int shopsele = scan.nextInt() - 1;

			if (shopsele >= 0 && shopsele < shops.size()) {
				Shop seleShop = shops.get(shopsele);
				return seleShop;
			}

			System.out.println("正しい店舗の番号を選択してください");

		}
	}

	//予約
	public static void book() {
		System.out.println("レンタカーの予約をします");
		//店舗指定
		Shop choShop = chooseShop();
		//時間指定
		LocalDateTime startDateTime = choseDateTime("貸出", choShop);
		LocalDateTime finDateTime = choseDateTime("返却", choShop);
		//空き車両の表示
		List<Car> freecars = Shop.shopFreeCar(startDateTime, finDateTime, choShop);
		showFreeCars(freecars);
		//空き車両の有無
		if (freecars.isEmpty()) {
			System.out.println("空き車両がありません");
			return;
		}
		//予約車両の選択
		Car selected = selectCar(freecars);
		//予約
		String name = inputName();
		Reservation newReservation = ReservationManager.createResevation(selected, name, choShop, startDateTime,
				finDateTime);
		System.out.println("予約が完了しました");
		ReservationManager.showReservation(newReservation);
		System.out.println("予約情報を確認、変更およびキャンセルする場合は名前、予約者IDが必要になります");
		System.out.println("必ず保管してください");

	}

	//空き車両表示
	public static void showFreeCars(List<Car> freeCar) {
		int x = 1;
		for (Car c : freeCar) {
			System.out.println(x + ". "
					+ c.getName()
					+ "  "
					+ c.getCategory()
					+ "クラス　基本料金:"
					+ c.getPrice()
					+ "円　乗車人数"
					+ c.getPassengers()
					+ "人　車種例"
					+ c.getName());

			x++;
		}
	}

	//時間の指定
	public static LocalDateTime choseDateTime(String when, Shop shop) {
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
			LocalTime shopOpen = shop.getOpenTime();
			LocalTime shopClose = shop.getCloseTime();

			if (selectedTime.isBefore(shopOpen) || selectedTime.isAfter(shopClose)) {
				System.out.println("営業時間外です。営業時間内の時間を指定してください。");
				System.out.println(shop.getName() + "店　営業時間　" + shopOpen + "-" + shopClose);

			} else {
				return DateTime;
			}
		}
	}

	//予約車両の選択(番号選択の条件)
	public static Car selectCar(List<Car> freecar) {
		while (true) {
			System.out.println("予約する車両を選択してください");
			int select = scan.nextInt() - 1;

			if (select < 0 || select >= freecar.size()) {
				System.out.println("正しい番号を指定してください");
				continue;
			}
			return freecar.get(select);
		}
	}

	public static void checkReservation() {
		System.out.println("予約の確認をします");
		int reId = inputId();
		String reName = inputName();
		Reservation checkReserve = ReservationManager.findResevation(reName, reId);
		if (checkReserve == null) {
			System.out.println("予約が見つかりませんでした");
			return;
		} else {
			ReservationManager.showReservation(checkReserve);
			Shop shop = checkReserve.getShop();
			System.out.println("店舗 " + shop.getName() + "店");
		}

		System.out.println("予約の変更、キャンセルを行いますか？");
		System.out.println("1:予約変更");
		System.out.println("2:予約キャンセル");
		System.out.println("3:変更しない");
		int x = scan.nextInt();
		if (x == 1) {
			changeReservation(reName, reId);
		} else if (x == 2) {
			cancelReservation(reName, reId);
		} else if (!(x == 3)) {
		}
	}

	//予約キャンセル
	public static void cancelReservation(String name, int Id) {
		Reservation cancelReservation = ReservationManager.findResevation(name, Id);
		if (cancelReservation == null) {
			System.out.println("予約が見つかりませんでした。");
		} else {
			Car.removeReservation(cancelReservation);
			System.out.println("キャンセルが完了しました。");
		}
	}

	//予約変更
	public static void changeReservation(String changeName, int changeId) {
		Reservation changeReserve = ReservationManager.findResevation(changeName, changeId);
		if (changeReserve == null) {
			System.out.println("予約が見つかりません");
		} else {
			LocalDateTime newStartTime = choseDateTime("新しい開始", changeReserve.getShop());
			LocalDateTime newFinTime = choseDateTime("新しい返却", changeReserve.getShop());
			Boolean check = Car.isAvailable(newStartTime, newFinTime);
			if (check) {
				ReservationManager.updateReservation(changeReserve, newStartTime, newFinTime);
				System.out.println("変更が完了しました");
				ReservationManager.showReservation(changeReserve);
				System.out.println("予約情報を確認、変更およびキャンセルする場合は名前、予約者IDが必要になります");
				System.out.println("必ず保管してください");
			} else {
				System.out.println("その時間はすでに予約が埋まっています");
			}
		}
	}

	public static int inputId() {
		System.out.println("予約IDを入力してください");
		int reId = scan.nextInt();
		return reId;
	}

	public static String inputName() {
		System.out.println("予約者名を入力してください");
		String reName = scan.next();
		return reName;
	}
}
