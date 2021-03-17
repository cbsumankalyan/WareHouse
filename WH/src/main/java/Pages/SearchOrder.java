package Pages;

import POM.WHOrdersPOM;

public class SearchOrder extends SuperTestNG{
	public void Search() {
		WHOrdersPOM WHOrdersPOM = new WHOrdersPOM(driver);
		WHOrdersPOM.SearchOrder();
	}

}
