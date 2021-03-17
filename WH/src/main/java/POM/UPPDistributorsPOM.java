package POM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Pages.SuperTestNG;
import junit.framework.Assert;

public class UPPDistributorsPOM extends SuperTestNG {

	@FindBy(xpath = "//a[contains(text(),'UPP Distributors')]")
	private WebElement UPPDistributors;

	@FindBy(xpath = "//h1")
	private WebElement UPPDISTRIBUTORS;

	@FindBy(xpath = "//a[contains(text(),'CREATE UPP DISTRIBUTOR')]")
	private WebElement CreateUPPDistributors;

	@FindBy(xpath = "//tr[@class='bg-info']")
	private WebElement Table;

	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement View;

	@FindBys(@FindBy(xpath = "//label"))
	private List<WebElement> ViewData;

	@FindBy(xpath = "//a[contains(text(),'Update')]")
	private WebElement Update;
	
	@FindBys(@FindBy(xpath = "//input[contains(@id, 'upp_dist_')]"))
	private List<WebElement> UpdateData;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement Delete;

	@FindBy(xpath = "//h1")
	private WebElement CreateUPPDistributor;

	@FindBy(name = "upp_dist_name")
	private WebElement DistributorName;

	@FindBy(name = "upp_dist_upp_no")
	private WebElement DistributorUPPNumber;

	@FindBy(name = "upp_dist_a_date")
	private WebElement ADate;

	@FindBy(name = "upp_dist_upp_name")
	private WebElement DistributorUPPName;

	@FindBy(name = "upp_dist_ds_id")
	private WebElement DistributorID;

	@FindBy(name = "upp_dist_place")
	private WebElement DistributorPlace;

	@FindBy(name = "upp_dist_state")
	private WebElement DistributorState;

	@FindBy(name = "upp_dist_phone")
	private WebElement DistributorPhone;

	@FindBy(name = "upp_dist_email_id")
	private WebElement DistributorEmail;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Save;

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	private WebElement Cancel;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement UPPDistributorCreatedSuccessfully;
	
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement Back;
	
	@FindBy(xpath = "//tbody/tr[1]")
	private WebElement TableData;

	public UPPDistributorsPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Distributors() {
		UPPDistributors.click();
		Assert.assertEquals(UPPDISTRIBUTORS.getText(), "UPP DISTRIBUTORS");
		Assert.assertTrue(CreateUPPDistributors.isDisplayed());
		Assert.assertEquals(Table.getText(),
				"SL NO DS ID Distributor Name UPP No A DATE UPP Name Place State Status Contact No ACTIONS");
		Assert.assertTrue(View.isDisplayed());
		Assert.assertTrue(Update.isDisplayed());
		Assert.assertTrue(Delete.isDisplayed());

		DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		DateTimeFormatter Adate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		test.log(Status.INFO, "Create UPP Distributor");

		CreateUPPDistributors.click();

		DistributorName.sendKeys("Test");
		DistributorUPPNumber.sendKeys("UPP-818");
		ADate.sendKeys(date.format(now));
		DistributorUPPName.sendKeys("India Testing");
		DistributorID.sendKeys("108639102");
		DistributorPlace.sendKeys("Bengaluru");
		DistributorState.sendKeys("Karnataka");
		DistributorPhone.sendKeys("9019185440");
		DistributorEmail.sendKeys("cbsumankalyan@gmail.com");
		Cancel.click();

		CreateUPPDistributors.click();

		Assert.assertEquals(CreateUPPDistributor.getText(), "Create UPP Distributor");
		DistributorName.sendKeys("Test");
		DistributorUPPNumber.sendKeys("UPP-818");
		ADate.sendKeys(date.format(now));
		DistributorUPPName.sendKeys("India Testing");
		DistributorID.sendKeys("108639102");
		DistributorPlace.sendKeys("Bengaluru");
		DistributorState.sendKeys("Karnataka");
		DistributorPhone.sendKeys("9019185440");
		DistributorEmail.sendKeys("cbsumankalyan@gmail.com");
		Save.click();

		Assert.assertTrue(UPPDistributorCreatedSuccessfully.isDisplayed());
		Assert.assertEquals(TableData.getText(), "1 108639102 Test UPP-818 "+Adate.format(now)+" India Testing Bengaluru Karnataka Active 9019185440 View Update Delete");
		test.log(Status.INFO, TableData.getText());
		test.log(Status.INFO, "Create UPP Distributor Record is in the Table's 1st Place ");
		
		String[] uppdistributor = { "Test", "UPP-818", Adate.format(now), "India Testing", "108639102", "Bengaluru",
				"Karnataka", "Active", "9019185440", "cbsumankalyan@gmail.com", "Super Admin", "", ""};

		View.click();
		for (int i = 0; i < uppdistributor.length; i++) {
			Assert.assertEquals(uppdistributor[i], ViewData.get(i).getText());
		}
		Back.click();
		
		String[] updatedistributor = { "Test", "UPP-818", date.format(now), "India Testing", "108639102", "Bengaluru",
				"Karnataka", "9019185440", "cbsumankalyan@gmail.com"};
		Update.click();
		for (int i = 0; i < updatedistributor.length; i++) {
			Assert.assertEquals(updatedistributor[i], UpdateData.get(i).getAttribute("value"));
		}
		DistributorPhone.clear();
		DistributorPhone.sendKeys("9019185441");
		Save.click();
		Assert.assertTrue(UPPDistributorCreatedSuccessfully.isDisplayed());
		Assert.assertEquals(UPPDistributorCreatedSuccessfully.getText(), "�\nUPP Distributor updated successfully");
		Assert.assertEquals(TableData.getText(), "1 108639102 Test UPP-818 "+Adate.format(now)+" India Testing Bengaluru Karnataka Active 9019185441 View Update Delete");
		test.log(Status.INFO, "Updated UPP Distributor Record is in the Table's 1st Place ");
	}

}
