package rentacarcli;

import java.time.LocalTime;

public class Main {
	public Main() {
		Shop kinshi = new Shop("錦糸町", 15, LocalTime.of(7, 00), LocalTime.of(21, 00));
		Shop kame = new Shop("亀戸", 15, LocalTime.of(8, 00), LocalTime.of(20, 00));
		Shop sky = new Shop("スカイツリー", 15, LocalTime.of(8, 00), LocalTime.of(21, 00));
		Shop kasai = new Shop("葛西", 15, LocalTime.of(7, 30), LocalTime.of(20, 30));

		CreateCarList.registerKinshiCars(kinshi);
		CreateCarList.registerKameCars(kame);
		CreateCarList.registerSkyCars(sky);
		CreateCarList.registerKasaiCars(kasai);
	}

}
