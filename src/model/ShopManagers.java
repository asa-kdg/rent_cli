package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public List<Shop> getShops(String name) {
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

	public void addShop() {

		System.out.println("店舗名を入力してください");
		String storeName = scan.next();
		System.out.println("開店時間の時を入力してください");
		int openTime = scan.nextInt();
		System.out.println("開店時間の時を入力してください");
		int openMin = scan.nextInt();
		System.out.println("閉店時間の時を入力してください");
		int closeTime = scan.nextInt();
		System.out.println("閉店時間の時を入力してください");
		int closeMin = scan.nextInt();

		shops.add(new Shop(
				storeName,
				LocalTime.of(openTime, openMin),
				LocalTime.of(closeTime, closeMin)));

	}
}