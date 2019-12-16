package Tests;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import Pages.CreateOrder;
import Pages.ImportOrder;
import Pages.KycPage;
import Pages.KycSendSMS;
import Pages.LoginPage;
import Pages.SMSTemplate;
import Pages.WareHouses;
import Pages.SendSMS;
import Pages.SuperTestNG;

public class Admin extends SuperTestNG{
	
	LoginPage LP = new LoginPage();
	SendSMS SMS = new SendSMS();
	ImportOrder Import = new ImportOrder();
	CreateOrder Create = new CreateOrder();
	
	KycPage kyc = new KycPage();
	KycSendSMS kycsendsms = new KycSendSMS();
	
	WareHouses WareHouses = new Pages.WareHouses();
	SMSTemplate smstemplate = new SMSTemplate();
	
	@Test
	public void AdminUser() throws InterruptedException, IOException, InvalidFormatException {

		LP.login();
		Import.Import();
		Create.Create();
		SMS.SMS();
		kyc.KYC();
		kycsendsms.sendsms();
		smstemplate.Template();
		WareHouses.WH();
	}
}
