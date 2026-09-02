package carmodel;

import model.Shop;
import model.ShopManagers;

public class InitialData {
	public static void createCars(ShopManagers shopManagers) {

		Shop kinshi = ShopManagers.getShop("錦糸町");
		Shop kame = ShopManagers.getShop("亀戸");
		Shop sky = ShopManagers.getShop("スカイツリー");
		Shop kasai = ShopManagers.getShop("葛西");

		CreateCarList.registerKinshiCars(kinshi);
		CreateCarList.registerKameCars(kame);
		CreateCarList.registerSkyCars(sky);
		CreateCarList.registerKasaiCars(kasai);
	}

}
