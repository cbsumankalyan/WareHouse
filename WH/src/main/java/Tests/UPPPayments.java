package Tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SuperTestNG;
import Pages.UPPPaymentPage;

public class UPPPayments extends SuperTestNG {
	
	LoginPage LP = new LoginPage();
	UPPPaymentPage payments = new UPPPaymentPage();
	
	@Test
	public void KotakAvenueAborted() throws InterruptedException, IOException, InvalidFormatException {
		
		test=UppPayment.createNode("<b><font color=407899>"+"Kotak Avenue Aborted" + "</font></b>");
		LP.login();
		payments.KotakAvenuePaymentAborted();
	}
	
	@Test
	public void KotakAvenueFailure() throws InterruptedException, IOException, InvalidFormatException {
		
		test=UppPayment.createNode("<b><font color=407899>"+"Kotak Avenue Failure" + "</font></b>");
		LP.login();
		payments.KotakAvenuePaymentCancelled();
	}
	
	@Test
	public void KotakAvenueSucess() throws InterruptedException, IOException, InvalidFormatException {
		
		test=UppPayment.createNode("<b><font color=407899>"+"Kotak Avenue Success" + "</font></b>");
		LP.login();
		payments.KotakAvenuePaymentSuccess();
	}
	
	@Test
	public void RazorPay() throws InterruptedException, IOException, InvalidFormatException {
		
		test=UppPayment.createNode("<b><font color=407899>"+"RazorPay" + "</font></b>");
		
		LP.login();
		payments.RazorPay();
	}

}
