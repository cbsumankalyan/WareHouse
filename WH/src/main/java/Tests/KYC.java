package Tests;

import org.testng.annotations.Test;
import Pages.KycPage;
import Pages.KycSendSMS;
import Pages.LoginPage;
import Pages.SuperTestNG;

public class KYC extends SuperTestNG {
	
	LoginPage LP = new LoginPage();
	KycPage kyc = new KycPage();
	KycSendSMS kycsendsms = new KycSendSMS();
	
	@Test
	public void KYCPortal () {
		
		test=WarehouseOrders.createNode("<b><font color=407899>"+"KYC Portal" + "</font></b>");
		LP.login();
		kyc.KYC();
		kycsendsms.sendsms();
	}
}
