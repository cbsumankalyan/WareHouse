package Pages;

import POM.WHOrdersPOM;

public class SendSMS extends SuperTestNG{
	public void SMS() throws InterruptedException {
		WHOrdersPOM WHOrdersPOM = new WHOrdersPOM(driver);
		WHOrdersPOM.SendSMS();
	}

}
