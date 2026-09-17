package shop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import carmodel.CreateCarList;

public class ShopManagers {
	static Scanner scan = new Scanner(System.in);

	private static List<Shop> shops;

	public ShopManagers() {
		shops = new ArrayList<>();

		// 店舗を登録
		shops.add(new Shop(
				"錦糸町",
				LocalTime.of(7, 0),
				LocalTime.of(21, 0)));

		shops.add(new Shop(
				"亀戸",
				LocalTime.of(8, 0),
				LocalTime.of(20, 0)));

		shops.add(new Shop(
				"スカイツリー",
				LocalTime.of(8, 0),
				LocalTime.of(21, 0)));

		shops.add(new Shop(
				"葛西",
				LocalTime.of(7, 30),
				LocalTime.of(20, 30)));
	}

	public static void createCars() {

		Shop kinshi = ShopManagers.getShop("錦糸町");
		Shop kame = ShopManagers.getShop("亀戸");
		Shop sky = ShopManagers.getShop("スカイツリー");
		Shop kasai = ShopManagers.getShop("葛西");

		CreateCarList.registerKinshiCars(kinshi);
		CreateCarList.registerKameCars(kame);
		CreateCarList.registerSkyCars(sky);
		CreateCarList.registerKasaiCars(kasai);
	}

	public static List<Shop> getShops() {
		return shops;
	}

	public static Shop getShop(String name) {
		for (Shop shop : shops) {
			if (shop.getName().equals(name)) {
				return shop;
			}
		}

		return null;
	}

	public static void addShop() {

		System.out.println("店舗名を入力してください");
		String storeName = scan.next();
		System.out.println("開店時間の時を入力してください");
		int openTime = scan.nextInt();
		System.out.println("開店時間の分を入力してください");
		int openMin = scan.nextInt();
		System.out.println("閉店時間の時を入力してください");
		int closeTime = scan.nextInt();
		System.out.println("閉店時間の分を入力してください");
		int closeMin = scan.nextInt();

		shops.add(new Shop(
				storeName,
				LocalTime.of(openTime, openMin),
				LocalTime.of(closeTime, closeMin)));

	}

	public static void updateShop() {
		System.out.println("どこの店舗を変更しますか");
		int x = 1;
		for (Shop shop : shops) {
			System.out.println(x + ":" + shop.getName());
			x += 1;
		}
		int shopSelect = scan.nextInt();
		Shop selectedShop = shops.get(shopSelect - 1);

		System.out.println("何を変更しますか");
		System.out.println("1:店舗名");
		System.out.println("2:開店時間");
		System.out.println("3:閉店時間");
		System.out.println("4:何も変更しない");

		int select = scan.nextInt();
		if (select == 1) {
			System.out.println("新しく設定する店舗名を入力してください");
			String newStorename = scan.next();
			selectedShop.setName(newStorename);
		} else if (select == 2) {
			System.out.println("新しく開店時間の時を入力してください");
			int openTime = scan.nextInt();
			System.out.println("新しく開店時間の分を入力してください");
			int openMin = scan.nextInt();
			selectedShop.setOpenTime(LocalTime.of(openTime, openMin));

		} else if (select == 3) {
			System.out.println("新しく閉店時間の時を入力してください");
			int closeTime = scan.nextInt();
			System.out.println("新しく閉店時間の分を入力してください");
			int closeMin = scan.nextInt();
			selectedShop.setCloseTime(LocalTime.of(closeTime, closeMin));

		}

	}

	public static void showShop() {
		System.out.println("店舗一覧");
		int x = 1;

		for (Shop shop : shops) {
			System.out.println(x + ":" + shop.getInfoShop());
			x++;
		}
	}

}