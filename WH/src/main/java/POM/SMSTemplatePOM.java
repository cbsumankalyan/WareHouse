package POM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Pages.SuperTestNG;

public class SMSTemplatePOM extends SuperTestNG{
	@FindBy(xpath = "//a[contains(@href, '/smstemplates')]")
	private WebElement SMSTemplage;
	
	@FindBys(@FindBy(xpath = "//tr"))
	List <WebElement> Templates;
	
	@FindBy(xpath = "//a[text() = 'Create SMS Templates']")
	private WebElement CreateTemplate;
	
	@FindBy(name = "sms_title")
	private WebElement SMSTitle;
	
	@FindBy(name = "sms_template")
	private WebElement SMSTemplate;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement Save;
	
	@FindBy(xpath = "//tr//td[text() = 'Creating SMS Title']")
	private WebElement CheckTemplate;
	
	@FindBy(xpath = "//tr//td[text() = 'Creating SMS Title']/../td/a[text() = 'Update']")
	private WebElement UpdateTemplate;
	
	@FindBy(xpath = "//tr//td[text() = 'Create SMS Template Updated']/../td/button[text() = 'Delete']")
	private WebElement DeleteTemplate;
	
	@FindBy(xpath = "//button[text() = 'Ok']")
	private WebElement DeleteOK;
	
	public SMSTemplatePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Template() {
		SMSTemplage.click();
		CreateTemplate.click();
		SMSTitle.sendKeys("Creating SMS Title");
		SMSTemplate.sendKeys("Create SMS Template");
		Save.click();
		Assert.assertTrue(CheckTemplate.isDisplayed());
		test.log(LogStatus.INFO, "SMS", "SMS Templates");
		test.log(LogStatus.INFO, "", "Template Created");
		
		UpdateTemplate.click();
		SMSTitle.sendKeys(" Updated");
		SMSTemplate.sendKeys(" Updated");
		Save.click();
		test.log(LogStatus.INFO, "", "Template Updated");
		
		DeleteTemplate.click();
		DeleteOK.click();
		test.log(LogStatus.INFO, "", "Template Deleted");
	}

}
