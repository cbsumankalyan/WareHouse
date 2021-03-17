package Pages;

import POM.WHOrdersPOM;

public class CreateOrder extends SuperTestNG{
	public void Create() throws InterruptedException {
		WHOrdersPOM WHOrdersPOM = new WHOrdersPOM(driver);
		WHOrdersPOM.CreateOrder();
		WHOrdersPOM.SearchOrder();
		WHOrdersPOM.DeleteImportOrder();
		WHOrdersPOM.ViewOrder();
		WHOrdersPOM.EditOrder();
	}
}
