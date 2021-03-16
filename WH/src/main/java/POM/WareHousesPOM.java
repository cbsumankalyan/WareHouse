package POM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class WareHousesPOM extends SuperTestNG{
	
	@FindBy(xpath = "//a[contains(@href, '/warehouses')]")
	private WebElement WareHousesPage;
	
	@FindBys(@FindBy(xpath = "//tbody/tr/td[2]"))
	List<WebElement> WareHouses;
	
	public WareHousesPOM(WebDriver dirver) {
		PageFactory.initElements(driver, this);
	}
	
	public void WareHousesList() {
		WareHousesPage.click();
		test.log(Status.INFO, "Warehouses:"+"List of Warehouses");
		List<String> WareHouse = new ArrayList<String>();
//		ArrayList<String> WareHouse = new ArrayList<>();
//		ArrayList<String> CheckWareHouse = new ArrayList<>(Arrays.asList(
//				"Bangalore",
//				"Guwahati",
//				"Bhiwandi",
//				"Ahmedabad",
//				"Gurgaon"
//		));
		List<String> CheckWareHouse = new ArrayList<String>(Arrays.asList(
				"Bangalore",
				"Guwahati",
				"Bhiwandi",
				"Ahmedabad",
				"Gurgaon"
		));
		
		for(int i = 0; i<WareHouses.size(); i++) {
			String wh = WareHouses.get(i).getText();
			WareHouse.add(wh);
		}
		
		Assert.assertEquals(WareHouse, CheckWareHouse);
	}
	

}
