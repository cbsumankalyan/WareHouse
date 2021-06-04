package Pages;

import java.io.IOException;
import java.net.ProtocolException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuperTestNG {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest WarehouseOrders;
	public static ExtentTest KycPortal;
	public static ExtentTest Uppdistributor;
	public static ExtentTest UppPayment;
	public static ExtentTest SMSTemplate;
	
	public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
	public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@BeforeTest
	public void StartReport() throws IOException {
		htmlReporter = new ExtentSparkReporter("C://xampp//htdocs//WHReport//WareHouse"+date.format(timestamp)+".html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/Config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		Uppdistributor = extent.createTest("<b><font color=DE6449>"+"UPP Distributors" + "</font></b>");
		UppPayment = extent.createTest("<b><font color=DE6449>"+"UPP Payments" + "</font></b>");
		WarehouseOrders = extent.createTest("<b><font color=DE6449>"+"WareHouse" + "</font></b>");
		SMSTemplate = extent.createTest("<b><font color=DE6449>"+"SMS Template" + "</font></b>");
		KycPortal = extent.createTest("<b><font color=DE6449>"+"KYC Portal" + "</font></b>");
	}

	@BeforeMethod
	public void PreConditon() throws ParseException, ProtocolException, JSONException, Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://india.unicityportal.com/test_warehouseorder/auth/login");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void PostCondition(ITestResult testResult) throws IOException {

		if (testResult.isSuccess()) {
			String logText = "<b>Test Method Successfull</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.log(Status.PASS, m);
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String exceptionMessage = testResult.getThrowable().getMessage();
			
			test.fail("<details><summary><b><font color=red>Exception Occured click to see details:"
					+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
			test.fail(
					"<b><font color=red>"+"Screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
			test.log(Status.FAIL, "Test Failed");

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped");
		}
		
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite() throws Exception {
		
		extent.flush();
		NoAttach.Sendmail();
	}
}