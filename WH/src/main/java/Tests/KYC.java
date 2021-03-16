package Tests;

import org.testng.annotations.Test;
import Pages.KycPage;
import Pages.KycSendSMS;
import Pages.SuperTestNG;

public class KYC extends SuperTestNG {
	
	KycPage kyc = new KycPage();
	KycSendSMS kycsendsms = new KycSendSMS();
	
	@Test
	public void KYCPortal () {
		
		test=WarehouseOrders.createNode("<b><font color=407899>"+"KYC Portal" + "</font></b>");
		kyc.KYC();
		kycsendsms.sendsms();
	}
}
