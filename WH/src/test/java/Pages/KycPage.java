package Pages;

import POM.KycPOM;

public class KycPage extends SuperTestNG{
	public void KYC() {
		KycPOM KycPOM = new KycPOM(driver);
		KycPOM.Kyc();
		KycPOM.KycUpload();
		driver.navigate().to("https://india.unicityportal.com/test_warehouseorder/kycpage");
		KycPOM.KycView();
		driver.navigate().to("https://india.unicityportal.com/test_warehouseorder/kycpage");
		KycPOM.KycValidate();
	}

}
