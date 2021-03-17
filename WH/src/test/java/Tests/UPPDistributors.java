package Tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SuperTestNG;
import Pages.UPPDistributorsPage;


public class UPPDistributors extends SuperTestNG {
	
	LoginPage LP = new LoginPage();
	UPPDistributorsPage Distributors = new UPPDistributorsPage();
	
	@Test
	public void UPPDistributor() throws InterruptedException, IOException, InvalidFormatException {
		
		test=Uppdistributor.createNode("<b><font color=407899>"+"UPP Distributors" + "</font></b>");
		LP.login();
		Distributors.Distributors();
	}
}
