package main;

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

	public static int selectAdminFunction() {
		System.out.println("どの操作をしますか");
		scan.nextLine();
		while (true) {
			System.out.println("1:店舗情報更新");
			System.out.println("2:店舗登録");
			System.out.println("3:車両登録");
			System.out.println("4:予約確認");
			System.out.println("5:予約状態変更");
			System.out.println("6:終了する");

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
				checkreserve();
				break;

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

	//店の選択
	public static Shop seleShop() {
		System.out.println("どの店舗にしますか？");
		ShopManagers.showShop();
		int selectshop = scan.nextInt();
		if (selectshop < 0 && selectshop > 5) {
			System.out.println("正しい番号を入力してください");
		}
		List<Shop> shops = ShopManagers.getShops();
		Shop shop = shops.get(selectshop - 1);
		return shop;

	}

	//車の追加
	public static void addCar() {
		Shop addedShop = seleShop();
		List<Car> car = Shop.getCars();
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
			if (car.getCategory() == category) {
				return car;
			}
		}
		return null;

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

}
