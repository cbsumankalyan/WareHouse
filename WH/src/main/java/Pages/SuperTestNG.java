package Pages;

import java.net.ProtocolException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SuperTestNG {

	public static WebDriver driver;    
	public static ExtentReports extent;
	public static ExtentTest test;

	public static String[] names = { "Kalyan", "Suman" };

	@BeforeTest
	public void StartReport() {
		for (int i = 0; i < names.length; i++) {
			extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/Extent.html");
			test = extent.startTest(names[i]);
		}
	}

	@BeforeMethod
	public void PreConditon() throws ParseException, ProtocolException, JSONException, Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://india.unicityportal.com/test_warehouseorder/auth/login");
//		driver.get("http://162.243.115.37/tools/test_warehouseorder/auth/login");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void PostCondition(ITestResult testResult) {

		if (testResult.isSuccess()) {
			test.log(LogStatus.PASS, "", "Test Passed");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {

			test.log(LogStatus.FAIL, "", "Test Failed");
			test.log(LogStatus.INFO, "", testResult.getThrowable().getMessage());

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "", "Test Skipped");
		}
//		driver.quit();
		extent.endTest(test);
		extent.flush();
//		extent.close();
	}
}
