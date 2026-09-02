package carmodel;

import model.Shop;

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
		shop.addCar(new Cx("イクリプスクロス", 3129, 1300));
		shop.addCar(new Pb("ヴォクシー", 2111, 0, 7));
		shop.addCar(new Pb("ヴォクシー", 2112, 0, 7));
		shop.addCar(new Pb("シエンタ", 2113, 1600, 7));
		shop.addCar(new Pb("セレナ", 2114));
		shop.addCar(new Pb("デリカ", 2117));
		shop.addCar(new Pb("アルファード", 2120, 2000, 7));
		shop.addCar(new Va("プロボックス", 4111, 1200, 5, 350));
		shop.addCar(new Va("ハイエース", 4112, 1300, 5, 1000));
		shop.addCar(new Va("プロボックス", 4113, 1200, 5, 350));
		shop.addCar(new Va("エブリィ", 4114, 1200, 4, 350));
		shop.addCar(new Va("デュトロ", 4115, 2000, 2000));
		shop.addCar(new Va("エルフ", 4116, 1800, 1500));
		shop.addCar(new Va("デュトロ", 4117, 1800, 1500));

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
		shop.addCar(new Pb("シエンタ", 2118, 1600, 6));
		shop.addCar(new Pb("アルファード", 2119, 2000, 7));
		shop.addCar(new Va("プロボックス", 4118, 1200, 5, 350));
		shop.addCar(new Va("ハイエース", 4119, 1300, 5, 1000));

	}

	public static void registerSkyCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1121));
		shop.addCar(new Bc("フィット", 1122));
		shop.addCar(new Bc("ノート", 1123));
		shop.addCar(new Cx("ヤリスクロス", 3124));
		shop.addCar(new Cx("クロストレック", 3125, 1300));
		shop.addCar(new Cx("ライズ", 3126));
		shop.addCar(new Cx("イクリプスクロス", 3127, 1300));
		shop.addCar(new Pb("シエンタ", 2120, 1600, 6));
		shop.addCar(new Pb("アルファード", 2121, 2000, 7));
		shop.addCar(new Pb("セレナ", 2122));
		shop.addCar(new Pb("デリカ", 2123));

	}

	public static void registerKasaiCars(Shop shop) {
		shop.addCar(new Bc("ヤリス", 1124));
		shop.addCar(new Bc("フィット", 1125));
		shop.addCar(new Bc("ノート", 1126));
		shop.addCar(new Cx("ヤリスクロス", 3128));
		shop.addCar(new Cx("クロストレック", 3129, 1300));
		shop.addCar(new Cx("ライズ", 3130));
		shop.addCar(new Cx("イクリプスクロス", 3131, 1300));
		shop.addCar(new Pb("シエンタ", 2124, 1600, 6));
		shop.addCar(new Pb("セレナ", 2125));
		shop.addCar(new Pb("デリカ", 2126));
		shop.addCar(new Va("デュトロ", 4120, 2000, 2000));
		shop.addCar(new Va("エルフ", 4121, 1800, 1500));
		shop.addCar(new Va("デュトロ", 4122, 1800, 1500));

	}

}
