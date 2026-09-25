package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import carmodel.Car;
import reserve.Reservation;
import shop.Shop;
import shop.ShopManagers;

public class CsvManager {

	//店舗csv
	private static final String ShopCsv = "data/shops.csv";
	//車両csv
	private static final String CarCsv = "data/cars.csv";
	// 予約csv
	private static final String ReservationCsv = "data/reservations.csv";

	//店舗csvが空どうか判定
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

	//車両csvが空か判定
	public static boolean isCarsEmpty() {

		try (BufferedReader br = new BufferedReader(new FileReader(CarCsv))) {

			br.readLine();

			return br.readLine() == null;

		} catch (IOException e) {
			return true;
		}
	}

	//cars.csvから読み込む
	public static void loadCars() {

		try (BufferedReader br = new BufferedReader(new FileReader(CarCsv))) {

			// ヘッダーを飛ばす
			br.readLine();

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String shopName = data[0];
				String name = data[1];
				int carNumber = Integer.parseInt(data[2]);
				int price = Integer.parseInt(data[3]);
				int passengers = Integer.parseInt(data[4]);
				String category = data[5];

				Shop shop = ShopManagers.getShop(shopName);

				if (shop != null) {

					Car car = new Car(
							name,
							carNumber,
							price,
							passengers,
							category);

					shop.addCar(car);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 車両をcarss.csvに保存する
	public static void saveCars() {

		try (FileWriter fw = new FileWriter(CarCsv)) {

			fw.write("shopName,name,carNumber,price,passengers,category\n");

			for (Shop shop : ShopManagers.getShops()) {

				for (Car car : shop.getCars()) {

					fw.write(
							shop.getName() + ","
									+ car.getName() + ","
									+ car.getCar_number() + ","
									+ car.getPrice() + ","
									+ car.getPassengers() + ","
									+ car.getCategory()
									+ "\n");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 予約をreservations.csvに保存する
	public static void saveReservations() {

		try (FileWriter fw = new FileWriter(ReservationCsv)) {

			// ヘッダー
			fw.write("shopName,carNumber,reserveId,user,startTime,finishTime,totalTime\n");

			// 店舗
			for (Shop shop : ShopManagers.getShops()) {

				// 車
				for (Car car : shop.getCars()) {

					// 予約
					for (Reservation reservation : car.getReservations()) {

						fw.write(
								shop.getName() + ","
										+ car.getCar_number() + ","
										+ reservation.getReserveId() + ","
										+ reservation.getUser() + ","
										+ reservation.getStartTime() + ","
										+ reservation.getFinishTime() + ","
										+ reservation.getTotalTime()
										+ "\n");
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
