package Pages;

import POM.KycPOM;

public class KycSendSMS extends SuperTestNG {
	public void sendsms() {
		KycPOM KycPOM = new KycPOM(driver);
		KycPOM.SendSMS();
		POM.KycPOM.verifyMail("cbsumankalyan@gmail.com", "likeyou12", "KYC Documents Uploaded Succesfully");
	}
}
