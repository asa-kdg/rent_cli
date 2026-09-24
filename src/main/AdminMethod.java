package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import carmodel.Bc;
import carmodel.Car;
import carmodel.Cx;
import carmodel.Pb;
import carmodel.Va;
import reserve.Reservation;
import reserve.ReservationManager;
import shop.Shop;
import shop.ShopManagers;

public class AdminMethod {
	static Scanner scan = new Scanner(System.in);

	public static void Login() {

	}

	public static int selectAdminFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:店舗情報更新");
			System.out.println("2:店舗登録");
			System.out.println("3:車両登録");
			System.out.println("4:車両削除");
			System.out.println("5:予約情報確認");
			System.out.println("6:予約");
			System.out.println("7:終了する");

			int selectFunc = scan.nextInt();

			switch (selectFunc) {
			case 1: {
				ShopManagers.updateShop();
				break;
			}
			case 2: {
				ShopManagers.addShop();
				break;
			}
			case 3: {
				addCar();
				break;
			}
			case 4: {
				deleteCar();
				break;
			}
			case 5: {
				checkreserve();
				break;
			}
			case 6: {
				bookAdmin(checkFreeCar());
				break;
			}
			case 7: {
				System.out.println("終了します");
				break;
			}
			default:
				System.out.println("正しい番号を入力してください");
			}

		}

	}

	//ログイン
	public static boolean login() {
		System.out.println("ID入力してください");
		String id = scan.next();
		System.out.println("パスワードを入力してください");
		int pw = scan.nextInt();
		if (id.equals(Admin.getId()) && pw == Admin.getPassword()) {
			System.out.println("パスワードが認証されました。");
			return true;
		} else {
			System.out.println("IDまたはパスワードが違います。");
			return false;
		}
	}

	//店の選択
	public static Shop seleShop() {
		List<Shop> shops = ShopManagers.getShops();
		while (true) {
			System.out.println("どの店舗にしますか？");
			ShopManagers.showShop();
			int selectshop = scan.nextInt();
			if (selectshop < 1 && selectshop > shops.size()) {
				System.out.println("正しい番号を入力してください");
				continue;
			}
			return shops.get(selectshop - 1);
		}

	}

	//車の追加
	public static void addCar() {
		Shop addedShop = seleShop();
		List<Car> car = addedShop.getCars();
		System.out.println("車種クラスを選択してください");
		Car.showcategory(car);
		String category = scan.next();
		Car findCateCar = findCategory(car, category);
		//車種クラスの入力チェック
		if (findCateCar == null) {
			System.out.println("正しい車種クラスを入力してください");
			addCar();
			return;
		}
		int price = findCateCar.getPrice();
		int passengers = findCateCar.getPassengers();
		int capacity = 0;
		if (category.equals("VA") || category.equals("TC")) {
			Va findVaCar = (Va) findCateCar;
			capacity = findVaCar.getCapacity();
		}
		//ナンバーチェック
		int number = 0;
		while (true) {
			System.out.println("ナンバーを入力してください");
			number = scan.nextInt();
			for (Car c : car) {
				if (number == c.getCar_number()) {
					System.out.println("重複している車があります");
				}
			}
			break;
		}
		System.out.println("車種名を入力してください");
		String name = scan.next();

		Car newCar = null;
		if (category.equals("VA") || category.equals("TC")) {
			newCar = new Va(name, number, price, passengers, category, capacity);
		} else if (category.equals("BC") || category.equals("CH")) {
			newCar = new Bc(name, number, price, passengers, category);
		} else if (category.equals("CX") || category.equals("EX")) {
			newCar = new Cx(name, number, price, passengers, category);
		} else if (category.equals("PB") || category.equals("LA")) {
			newCar = new Pb(name, number, price, passengers, category);
		}

		addedShop.addCar(newCar);

	}

	//カテゴリー検索
	public static Car findCategory(List<Car> cars, String category) {
		for (Car car : cars) {
			if (car.getCategory().equals(category)) {
				return car;
			}
		}
		return null;
	}

	//車両削除
	public static void deleteCar() {
		Shop deletedShop = seleShop();
		List<Car> deleCar = deletedShop.getCars();
		for (Car de : deleCar) {
			System.out.println(de.getInfoCars());
		}
		System.out.println("どの車を削除しますか 車番を入力してください");
		int number = scan.nextInt();

		for (Car de : deleCar) {
			if (de.getCar_number() == number) {
				deletedShop.removeCar(de);
				System.out.println("削除が完了しました。");
				return;
			}
		}
		System.out.println("該当する車両はありません");
	}

	//予約確認
	public static void checkreserve() {
		Shop checkshop = seleShop();
		List<Car> checkCar = checkshop.getCars();
		System.out.println("=====予約情報=====");
		for (Car ch : checkCar) {
			List<Reservation> cheReservations = ch.getReservations();
			ReservationManager.showReservations(cheReservations);
		}
	}

	//フリー車の確認
	public static List<Car> checkFreeCar() {
		Shop checkshop = seleShop();
		System.out.println("=====予約検索======");
		System.out.println("検索する開始日を入力してください(2020-09-22)");
		String stDate = scan.next();
		System.out.println("検索する開始時間の時を入力してください(13:25)");
		String stTime = scan.next();
		LocalDateTime stLocalDateTime = changeLocalDateTime(stDate, stTime);

		System.out.println("検索する終了日を入力してください(2020-09-22)");
		String fiDate = scan.next();
		System.out.println("検索する終了時間の時を入力してください(13:25)");
		String fiTime = scan.next();
		LocalDateTime fiLocalDateTime = changeLocalDateTime(fiDate, fiTime);
		List<Car> freeCars = Shop.shopFreeCar(stLocalDateTime, fiLocalDateTime, checkshop);
		showFreeCarsAdmin(freeCars);
		return freeCars;

	}

	//空き車両表示
	public static void showFreeCarsAdmin(List<Car> freeCar) {
		int x = 1;
		for (Car c : freeCar) {
			System.out.println(x + ". "
					+ c.getName()
					+ "  "
					+ c.getCategory()
					+ "クラス　ナンバー:"
					+ c.getCar_number());
			x++;
		}
	}

	public static LocalDateTime changeLocalDateTime(String date, String time) {
		LocalDate changeDate = LocalDate.parse(date);
		LocalTime changeTime = LocalTime.parse(time);

		LocalDateTime DateTime = LocalDateTime.of(changeDate, changeTime);

		return DateTime;

	}

	//予約(userがわの予約メソッドがカスすぎる)
	public static void bookAdmin(List<Car> avalablears) {
		Car selectCar = selectCar(avalablears);

	}

	//車両選択
	public static Car selectCar(List<Car> avaCars) {
		while (true) {
			System.out.println("どの車を選択しますか。ナンバーを入力してください");
			int number = scan.nextInt();

			for (Car c : avaCars) {
				if (number == c.getCar_number()) {
					return c;
				}
			}
			System.out.println("正しいナンバーを入力してください");
		}
	}

}
