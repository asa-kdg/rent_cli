package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ShopManagers {

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
}