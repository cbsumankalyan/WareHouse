package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Pages.SuperTestNG;

public class LoginPOM extends SuperTestNG{
	
	@FindBy(name="email")
	private WebElement UserName;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Login;
	
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void UserLogin(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		Login.click();
		
		test.log(Status.INFO, "<a> http://india.unicityportal.com/test_warehouseorder/auth/login</a>");
		test.log(Status.INFO, "<b><font color=green>Login as Admin</font></b>");
		test.log(Status.INFO, "Login:  "+"Username: " + username);
		test.log(Status.INFO, "Password:  " + password);
	}
}
