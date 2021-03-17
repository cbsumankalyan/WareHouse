package Pages;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import POM.WHOrdersPOM;

public class ImportOrder extends SuperTestNG{
	public void Import() throws InterruptedException, IOException, InvalidFormatException {
		WHOrdersPOM WHOrdersPOM = new WHOrdersPOM(driver);
		WHOrdersPOM.ImportOrder();
		WHOrdersPOM.DeleteImportOrder();
	}

}
