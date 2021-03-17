package Pages;

import POM.UPPDistributorsPOM;

public class UPPDistributorsPage extends SuperTestNG {

	public void Distributors() throws InterruptedException {

		UPPDistributorsPOM UPPDistributorsPOM = new UPPDistributorsPOM(driver);
		UPPDistributorsPOM.Distributors();
	}

}
