package Pages;

import POM.UPPPaymentsPOM;

public class UPPPaymentPage extends SuperTestNG {

	public void KotakAvenuePaymentAborted() throws InterruptedException {

		UPPPaymentsPOM UPPPaymentsPOM = new UPPPaymentsPOM(driver);
		UPPPaymentsPOM.KotakAborted();
	}
	
	public void KotakAvenuePaymentCancelled() throws InterruptedException {

		UPPPaymentsPOM UPPPaymentsPOM = new UPPPaymentsPOM(driver);
		UPPPaymentsPOM.KotakCanelled();
	}
	
	public void KotakAvenuePaymentSuccess() throws InterruptedException {

		UPPPaymentsPOM UPPPaymentsPOM = new UPPPaymentsPOM(driver);
		UPPPaymentsPOM.KotakSuccess();
	}

	public void RazorPay() throws InterruptedException {

		UPPPaymentsPOM UPPPaymentsPOM = new UPPPaymentsPOM(driver);
		UPPPaymentsPOM.RazorPay();
	}
}
