package carmodel;

import shop.Shop;

public class CreateCarList {
	public static void registerKinshiCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1111));
		shop.addCar(new Bc("フィット", 1112));
		shop.addCar(new Bc("mazda2", 1113));
		shop.addCar(new Bc("ソリオ", 1114));
		shop.addCar(new Bc("フィット", 1115));
		shop.addCar(new Bc("アクア", 1118, 1100));
		shop.addCar(new Bc("ノート", 1120, 1100));
		shop.addCar(new Cx("ヤリスクロス", 3121));
		shop.addCar(new Cx("ライズ", 3122));
		shop.addCar(new Cx("ヤリスクロス", 3125));
		shop.addCar(new Cx("クロストレック", 3126, 1300));
		shop.addCar(new Cx("イクリプスクロス", 3129, 1300));
		shop.addCar(new Cx("イクリプスクロス", 3133, 1300));
		shop.addCar(new Pb("シエンタ", 2111, 1600));
		shop.addCar(new Pb("フリード", 2112, 1600));
		shop.addCar(new Pb("シエンタ", 2113, 1600));
		shop.addCar(new Pb("セレナ", 2114));
		shop.addCar(new Pb("デリカ", 2117));
		shop.addCar(new Pb("ノア", 2120));
		shop.addCar(new Va("キャラバン", 4111, 1500, 1000));
		shop.addCar(new Va("ハイエース", 4112, 1500, 1000));
		shop.addCar(new Va("キャラバン", 4113, 1500, 1000));
		shop.addCar(new Va("ハイエース", 4114, 1500, 1000));
		shop.addCar(new Va("デュトロ", 4115, 2000));
		shop.addCar(new Va("エルフ", 4116, 1500));
		shop.addCar(new Va("デュトロ", 4117, 1500));

	}

	public static void registerKameCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1116));
		shop.addCar(new Bc("ヤリス", 1117));
		shop.addCar(new Bc("アクア", 1119, 1200));
		shop.addCar(new Cx("ヤリスクロス", 3123));
		shop.addCar(new Cx("ライズ", 3124));
		shop.addCar(new Cx("クロストレック", 3127, 1300));
		shop.addCar(new Cx("イクリプスクロス", 3128, 1300));
		shop.addCar(new Pb("セレナ", 2115));
		shop.addCar(new Pb("デリカ", 2116));
		shop.addCar(new Pb("シエンタ", 2118, 1600));
		shop.addCar(new Pb("ノア", 2119));
		shop.addCar(new Va("キャラバン", 4118, 1500, 1000));
		shop.addCar(new Va("ハイエース", 4119, 1500, 1000));

	}

	public static void registerSkyCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1121));
		shop.addCar(new Bc("フィット", 1122));
		shop.addCar(new Bc("ノート", 1123));
		shop.addCar(new Cx("ヤリスクロス", 3141));
		shop.addCar(new Cx("クロストレック", 3142, 1300));
		shop.addCar(new Cx("ライズ", 3145));
		shop.addCar(new Cx("イクリプスクロス", 3146, 1300));
		shop.addCar(new Pb("シエンタ", 2140, 1600));
		shop.addCar(new Pb("セレナ", 2121));
		shop.addCar(new Pb("セレナ", 2122));
		shop.addCar(new Pb("デリカ", 2123));

	}

	public static void registerKasaiCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1124));
		shop.addCar(new Bc("フィット", 1125));
		shop.addCar(new Bc("ノート", 1126));
		shop.addCar(new Cx("ヤリスクロス", 3143));
		shop.addCar(new Cx("クロストレック", 3144, 1300));
		shop.addCar(new Cx("ライズ", 3130));
		shop.addCar(new Cx("イクリプスクロス", 3131, 1300));
		shop.addCar(new Pb("シエンタ", 2124, 1600));
		shop.addCar(new Pb("セレナ", 2125));
		shop.addCar(new Pb("デリカ", 2126));
		shop.addCar(new Va("デュトロ", 4120, 2000));
		shop.addCar(new Va("エルフ", 4121, 1500));
		shop.addCar(new Va("デュトロ", 4122, 1500));

	}

}