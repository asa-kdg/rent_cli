package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import shop.Shop;
import shop.ShopManagers;

public class CsvManager {

	private static final String ShopCsv = "data/shops.csv";

	//csvが空どうか判定
	public static boolean isShopEmpty() {
		try (BufferedReader br = new BufferedReader(new FileReader(ShopCsv))) {
			String line = br.readLine();

			if (line == null) {
				return true;
			}

			line = br.readLine();

			return line == null;

		} catch (IOException e) {
			return true;
		}

	}

	//shops.csvから読み込む
	public static void loadShops() {
		try (BufferedReader br = new BufferedReader(new FileReader(ShopCsv))) {

			// ヘッダーを飛ばす
			br.readLine();

			// 初期店舗を削除
			ShopManagers.getShops().clear();

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String name = data[0];
				LocalTime openTime = LocalTime.parse(data[1]);
				LocalTime closeTime = LocalTime.parse(data[2]);

				Shop shop = new Shop(name, openTime, closeTime);

				ShopManagers.getShops().add(shop);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 店舗をshops.csvに保存する
	public static void saveShops() {

		try (FileWriter fw = new FileWriter(ShopCsv)) {

			// ヘッダー
			fw.write("name,openTime,closeTime\n");

			for (Shop shop : ShopManagers.getShops()) {

				fw.write(
						shop.getName() + ","
								+ shop.getOpenTime() + ","
								+ shop.getCloseTime()
								+ "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
