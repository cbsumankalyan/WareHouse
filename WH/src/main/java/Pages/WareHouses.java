package Pages;

import POM.WareHousesPOM;

public class WareHouses extends SuperTestNG{
	public void WH() {
		WareHousesPOM WH = new WareHousesPOM(driver);
		WH.WareHousesList();
	}
}
