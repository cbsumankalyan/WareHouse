package POM;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Pages.SuperTestNG;
import junit.framework.Assert;

public class UPPPaymentsPOM extends SuperTestNG {

	@FindBy(xpath = "//a[contains(text(),'UPP Payments')]")
	private WebElement UPPPayments;

	@FindBy(xpath = "//a[contains(text(),'MAKE PAYMENT')]")
	private WebElement MakePayment;

	@FindBy(xpath = "//tr[@class='bg-info']")
	private WebElement Table;

	@FindBy(name = "upp_dist_id")
	private WebElement DistributorID;

	@FindBy(name = "upp_no")
	private WebElement UPPNumber;

	@FindBy(name = "upp_name")
	private WebElement UPPName;

	@FindBy(name = "upp_amount")
	private WebElement UPPAmount;

	@FindBy(name = "upp_dist_phone")
	private WebElement UPPPhone;

	@FindBy(name = "upp_dist_email")
	private WebElement UPPEmail;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Search;

	@FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
	private WebElement Error;

	@FindBy(xpath = "//span[@class='error']")
	private WebElement PriceError;

	@FindBy(xpath = "//a[contains(text(),'Clear')]")
	private WebElement Clear;

	@FindBys(@FindBy(xpath = "//tbody/tr/td[1]"))
	private List<WebElement> IDSearch;

	@FindBys(@FindBy(xpath = "//tbody/tr/td[2]"))
	private List<WebElement> UPPSearch;

	@FindBy(xpath = "//option[@value='AvenuesTest']")
	private WebElement KotakAvenuePayment;

	@FindBy(id = "SubmitBillShip")
	private WebElement KotakMakePayment;

	@FindBy(xpath = "//h1")
	private WebElement PaymentTransactionSuccessfull;

	@FindBy(xpath = "//h2")
	private WebElement PVInformation;

	@FindBys(@FindBy(xpath = "//label[@class='form-control']"))
	private List<WebElement> SuccessData;

	@FindBy(xpath = "//div[@class='input-group']/a")
	private WebElement BackToUPPPayment;

	@FindBy(xpath = "//input[@value='razorpay']")
	private WebElement RazorPayment;

	@FindBy(xpath = "//button[@method='netbanking']")
	private WebElement RazorPayNetBanking;

	@FindBy(id = "bank-item-SBIN")
	private WebElement SBIN;

	@FindBy(xpath = "//span[@id='footer-cta']")
	private WebElement Pay;

	@FindBy(xpath = "//button[@data-val='S']")
	private WebElement Success;
	
	@FindBy(xpath = "//button[@data-val='F']")
	private WebElement Failure;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	private WebElement Back;

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement TableDistributorID;

	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement TableUPPNumber;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	private WebElement TableUPPName;

	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	private WebElement TablePhone;

	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	private WebElement TableUPPOrderID;

	@FindBy(xpath = "//tbody/tr[1]/td[7]")
	private WebElement TableOrderStatus;

	@FindBy(xpath = "//tbody/tr[1]/td[8]")
	private WebElement TableOrderDate;
	
	@FindBy(xpath = "//a[contains(@class,'cancel')]")
	private WebElement Cancel;
	
	@FindBy(xpath = "//option[@value='N']")
	private WebElement TransactionStatusNO;

	public UPPPaymentsPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void KotakAborted() throws InterruptedException {
		UPPPayments.click();
		MakePayment.click();
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		Random rand = new Random();
		int upperbound = 300000;
		int amount = rand.nextInt(upperbound);

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();

			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				
				UPPName.sendKeys("India Testing");
				UPPNumber.sendKeys("UPP-818");
				DistributorID.sendKeys("108639102");
				UPPAmount.sendKeys(String.valueOf(amount));
				UPPPhone.sendKeys("9019185440");
				UPPEmail.sendKeys("cbsumankalyan@gmail.com");
				
				
				test.log(Status.INFO, "<b><font color=green>Aborted Transaction</font></b>");
				Search.click();
				KotakAvenuePayment.click();
				
				Cancel.click();
				Assert.assertEquals(PVInformation.getText(),
						"Your Payment Transaction Failed. Please Retry. Use the Reference No for any queries.");
				test.log(Status.INFO, "Your Payment Transaction was Aborted.");
				BackToUPPPayment.click();
				Back.click();
				test.log(Status.INFO, "Back To Payment Page");
				
				
				Assert.assertEquals(TableDistributorID.getText(), "108639102");
				Assert.assertEquals(TableUPPNumber.getText(), "UPP-818");
				Assert.assertEquals(TableUPPName.getText(), "India Testing");
				Assert.assertEquals(TablePhone.getText(), "9019185440");
				Assert.assertEquals(TableOrderStatus.getText(), "Aborted");
				
				driver.close();
				driver.switchTo().window(mainWindowHandle);
				test.log(Status.INFO, "Transaction Aborted");
			}
		}	
	}
	
	public void KotakCanelled() throws InterruptedException {
		
		UPPPayments.click();
		MakePayment.click();
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		Random rand = new Random();
		int upperbound = 300000;
		int amount = rand.nextInt(upperbound);

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();

			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				
				UPPName.sendKeys("India Testing");
				UPPNumber.sendKeys("UPP-818");
				DistributorID.sendKeys("108639102");
				UPPAmount.sendKeys(String.valueOf(amount));
				UPPPhone.sendKeys("9019185440");
				UPPEmail.sendKeys("cbsumankalyan@gmail.com");
				
				test.log(Status.INFO, "<b><font color=green>Failure Transaction</font></b>");
				
				Search.click();
				KotakAvenuePayment.click();
				KotakMakePayment.click();
				TransactionStatusNO.click();
				Search.click();
				test.log(Status.INFO, "Transaction Status NO");
				Assert.assertEquals(PVInformation.getText(),
						"Your Payment Transaction Failed. Please Retry. Use the Reference No for any queries.");
				test.log(Status.INFO, "Your Payment Transaction was Failure.");
				BackToUPPPayment.click();
				Back.click();
				test.log(Status.INFO, "Back To Payment Page");
				
				Assert.assertEquals(TableDistributorID.getText(), "108639102");
				Assert.assertEquals(TableUPPNumber.getText(), "UPP-818");
				Assert.assertEquals(TableUPPName.getText(), "India Testing");
				Assert.assertEquals(TablePhone.getText(), "9019185440");
				Assert.assertEquals(TableOrderStatus.getText(), "Failure");
				
				driver.close();
				driver.switchTo().window(mainWindowHandle);
				test.log(Status.INFO, "Transaction Failure");
			}
		}	
	}
	
	public void KotakSuccess() throws InterruptedException {
		
		UPPPayments.click();
		
		test.log(Status.INFO, "<b><font color=green>Success Transaction</font></b>");
		
		Assert.assertEquals(UPPPayments.getText(), "UPP Payments");
		Assert.assertTrue(MakePayment.isDisplayed());

		DistributorID.sendKeys("108639101");
		Search.click();
		for (int i = 0; i < IDSearch.size(); i++) {
			Assert.assertEquals(IDSearch.get(i).getText(), "108639101");
		}
		Clear.click();
		test.log(Status.INFO, "Searched With ID");

		UPPNumber.sendKeys("UPP-818");
		Search.click();
		for (int i = 0; i < UPPSearch.size(); i++) {
			Assert.assertEquals(UPPSearch.get(i).getText(), "UPP-818");
		}
		Clear.click();
		test.log(Status.INFO, "Searched With UPP-ID");

		Assert.assertEquals(Table.getText(),
				"Distributor ID UPP Number UPP Name Phone UPP Order ID UPP Order Amount UPP Order Status UPP Order Date Action");

		MakePayment.click();

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		Random rand = new Random();
		int upperbound = 300000;
		int amount = rand.nextInt(upperbound);

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();

			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				test.log(Status.INFO, "<b><font color=green>Checking with Different Dist ID, UPP No/UPP Name</font></b>");
				test.log(Status.INFO, "Kotak CC Avenue");
				UPPName.sendKeys("Testing");
				UPPNumber.sendKeys("1234567");
				DistributorID.sendKeys("108639102");
				UPPAmount.sendKeys("1");
				UPPPhone.sendKeys("9019185440");
				UPPEmail.sendKeys("cbsumankalyan@gmail.com");
				Search.click();
				Assert.assertEquals(Error.getText(),
						"Entered Distributor ID is not matching with entered UPP No/UPP Name. Please enter correct Upp No/UPP Name");
				test.log(Status.INFO, "Please Enter Correct ID, Upp No/UPP Name");

				UPPName.clear();
				UPPNumber.clear();
				UPPAmount.clear();

				test.log(Status.INFO, "<b><font color=green>Negative Amount</font></b>");
				UPPName.sendKeys("India Testing");
				UPPNumber.sendKeys("UPP-818");
				UPPAmount.sendKeys("-1");
				Search.click();
				Assert.assertEquals(PriceError.getText(), "Amount must be greater than 0");
				test.log(Status.INFO, "Checked with Negative Amount -1");
				
				test.log(Status.INFO, "<b><font color=green>Maximum Amount</font></b>");
				UPPAmount.clear();
				UPPAmount.sendKeys("300001");
				Search.click();
				Assert.assertEquals(PriceError.getText(), "Max Limit of Rs 3 lakh INR per transaction");
				test.log(Status.INFO, "Checked with Maximim Amount 300001");
				
				
				UPPAmount.clear();
				UPPAmount.sendKeys(String.valueOf(amount));
				
				Search.click();
				KotakAvenuePayment.click();
				KotakMakePayment.click();
				Search.click();
				test.log(Status.INFO, "Selected Kotak CC Avenue Option");

				Assert.assertEquals(PaymentTransactionSuccessfull.getText(),
						"Your Payment Transaction was successfull.");
				Assert.assertEquals(PVInformation.getText(),
						"PV will be assigned to your upp id and order will be dispatched soon.Please quote Reference No mentioned below for any enquiry");
				test.log(Status.INFO, "Your Payment Transaction was successfull.");

				/*
				 * String [] Data = {"UPP-818", "India Testing", String.valueOf(amount),
				 * "108639102-"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())};
				 * for(int i=0;i<SuccessData.size();i++) {
				 * Assert.assertEquals(SuccessData.get(i).getText(), Data[i]); }
				 */

				BackToUPPPayment.click();
				test.log(Status.INFO, "Back To Payment Page");

				/*driver.switchTo().window(mainWindowHandle);
				driver.close();
				driver.switchTo().window(ChildWindow);*/
				
				Back.click();

				Assert.assertEquals(TableDistributorID.getText(), "108639102");
				Assert.assertEquals(TableUPPNumber.getText(), "UPP-818");
				Assert.assertEquals(TableUPPName.getText(), "India Testing");
				Assert.assertEquals(TablePhone.getText(), "9019185440");
				Assert.assertEquals(TableOrderStatus.getText(), "Success");
				
				driver.close();
				driver.switchTo().window(mainWindowHandle);
				test.log(Status.INFO, "Transaction Success");

			}
		}

	}
	
	public void RazorPay() throws InterruptedException {
		UPPPayments.click();
		MakePayment.click();
		
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		Random rand = new Random();
		int upperbound = 300000;
		int amount = rand.nextInt(upperbound);

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();

			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				RazorPayment.click();
				test.log(Status.INFO, "Selected RazorPayment Option");
				
				DistributorID.sendKeys("108639102");
				UPPPhone.sendKeys("9019185440");
				UPPEmail.sendKeys("cbsumankalyan@gmail.com");
				UPPAmount.sendKeys(String.valueOf(amount));
				UPPName.sendKeys("India Testing");
				UPPNumber.sendKeys("UPP-818");
				Search.click();

				driver.switchTo().frame(0);
				Thread.sleep(3000);
				RazorPayNetBanking.click();
				SBIN.click();

				driver.findElement(By.id("footer")).click();

				Set<String> allWindowHandles1 = driver.getWindowHandles();
				for (String handle : allWindowHandles1) {
					driver.switchTo().window(handle);
					System.out.println("Window handle - > " + handle + driver.getTitle());
				}

				Success.click();
				driver.switchTo().window(ChildWindow);

				Assert.assertEquals(PaymentTransactionSuccessfull.getText(),
						"Your Payment Transaction was successfull.");
				Assert.assertEquals(PVInformation.getText(),
						"PV will be assigned to your upp id and order will be dispatched soon.Please quote Reference No mentioned below for any enquiry");
				test.log(Status.INFO, "Your Payment Transaction was successfull.");
				
				/*
				 * String [] Data = {"UPP-818", "India Testing", String.valueOf(amount),
				 * "108639102-"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())};
				 * for(int i=0;i<SuccessData.size();i++) {
				 * Assert.assertEquals(SuccessData.get(i).getText(), Data[i]); }
				 */
				Thread.sleep(3000);
				System.out.println("Window handle - > " + driver.getTitle());
				BackToUPPPayment.click();
				test.log(Status.INFO, "Back To Payment Page");
				Back.click();

				Assert.assertEquals(TableDistributorID.getText(), "108639102");
				Assert.assertEquals(TableUPPNumber.getText(), "UPP-818");
				Assert.assertEquals(TableUPPName.getText(), "India Testing");
				Assert.assertEquals(TablePhone.getText(), "9019185440");
				Assert.assertEquals(TableOrderStatus.getText(), "Success");
//				Assert.assertEquals(TableUPPOrderID.getText(), "");

			}
		}
	}
		
}
