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
import Pages.UPPDistributorsPage;

public class Orders extends SuperTestNG {
	
	LoginPage LP = new LoginPage();
	SendSMS SMS = new SendSMS();
	ImportOrder Import = new ImportOrder();
	CreateOrder Create = new CreateOrder();
	
	KycPage kyc = new KycPage();
	KycSendSMS kycsendsms = new KycSendSMS();
	
	WareHouses WareHouses = new Pages.WareHouses();
	SMSTemplate smstemplate = new SMSTemplate();
	
	UPPDistributorsPage Distributors = new UPPDistributorsPage();
	
	@Test
	public void WareHouseOrders() throws InterruptedException, IOException, InvalidFormatException {
		
		test=WarehouseOrders.createNode("<b><font color=407899>"+"Import Orders" + "</font></b>");
		LP.login();
		Import.Import();
	}
	
	@Test
	public void CreateOrder() throws InterruptedException, IOException, InvalidFormatException {
		test=WarehouseOrders.createNode("<b><font color=407899>"+"Create Order" + "</font></b>");
		LP.login();
		Create.Create();
		SMS.SMS();
	}
	
}
