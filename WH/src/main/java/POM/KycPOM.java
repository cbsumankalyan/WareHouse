package POM;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Pages.SuperTestNG;

public class KycPOM extends SuperTestNG{

	@FindBy(xpath = "//a[contains(@href, '/kycpage')]")
	private WebElement KycPage;

	@FindBy(xpath = "(//input[@id='kyc_dist_id'])[2]")
	private WebElement SerachDistID;

	@FindBy(id = "submission1")
	private WebElement Search;

	@FindBy(xpath = "//a[contains(@href, '/kycpage/create')]")
	private WebElement KycPageUpload;

	@FindBy(name = "kyc_uploader_dist_id")
	private WebElement DistID;

	@FindBy(name = "kyc_uploader_dist_email_address")
	private WebElement DistEmail;

	@FindBy(name = "kyc_dist_id")
	private WebElement KycDistID;

	@FindBy(name = "kyc_image_remarks")
	private WebElement KycRemarks;

	@FindBy(name = "kyc_file_path1")
	private WebElement File1;

	@FindBy(name = "kyc_file_path2")
	private WebElement File2;

	@FindBy(name = "kyc_file_path3")
	private WebElement File3;

	@FindBy(name = "kyc_file_path4")
	private WebElement File4;

	@FindBy(name = "kyc_file_path5")
	private WebElement File5;

	@FindBy(name = "kyc_file_path6")
	private WebElement File6;

	@FindBy(xpath = "//input[@id='submitbutton']")
	private WebElement Submit;

	@FindBy(xpath = "//em")
	private WebElement Kycuploadsuccessmsg;

	@FindBy(xpath = "//a[contains(@href, '/kycpage/11/edit')]")
	private WebElement Validate;

	@FindBy(xpath = "//a[contains(@href, '/kycpage/11')]")
	private WebElement View;

	@FindBy(id = "kyc_dist_id")
	private WebElement ViewID;

	@FindBy(id = "kyc_dist_name")
	private WebElement ViewName;

	@FindBy(xpath = "(//input[@id='kyc_modified_by'])[1]")
	private WebElement Modify;

	@FindBy(xpath = "(//input[@id='kyc_modified_by'])[2]")
	private WebElement ModifyName;

	@FindBy(id = "kyc_uploader_dist_id")
	private WebElement ModifyID;

	@FindBy(id = "kyc_uploader_dist_email_address")
	private WebElement ModifyEmail;

	@FindBy(xpath = "(//td//center)[1]")
	private WebElement DistributorID;

	@FindBy(xpath = "(//td[2]//center)[1]")
	private WebElement DistributorName;

	@FindBy(xpath = "(//td[4]//center)[1]")
	private WebElement UpdatedDate;

	@FindBy(xpath = "//tr[1]//td[5]")
	private WebElement ModifiedBy;

	@FindBy(xpath = "//tr[1]//td[6]")
	private WebElement Status;

	@FindBy(name = "kyc_dist_name")
	private WebElement KycDistributorName;

	@FindBy(name = "kyc_uploader_dist_name")
	private WebElement KycUploaderName;

	@FindBy(name = "kyc_uploader_dist_id")
	private WebElement KycUploaderId;

	@FindBy(name = "kyc_uploader_dist_email_address")
	private WebElement KycUploaderEmail;

	@FindBy(xpath = "//select[@name='kyc_status']")
	private WebElement CSStatus;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Update;

	@FindBy(xpath = "//button[text() = 'Send SMS']")
	private WebElement SendSMS;

	@FindBy(name = "Mobile")
	private WebElement MobileNumber;

	@FindBys(@FindBy(xpath = "//input[@type='checkbox']"))
	private List<WebElement> SMSTemplates;

	@FindBy(id = "submit")
	private WebElement send;

	@FindBy(xpath = "//div[contains(text(), 'SMS Sent')]")
	private WebElement SMSSent;

	@FindBy(xpath = "//div[contains(text(), 'SMS Failed')]")
	private WebElement SMSFailed;

	public KycPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Kyc() {
		KycPage.click();
		test.log(LogStatus.INFO, "Kyc Page:", "Search Dist ID 108639101: ");
		SerachDistID.sendKeys("108639101");
		Search.click();
		Assert.assertEquals(DistributorID.getText(), "108639101");
		Assert.assertEquals(DistributorName.getText(), "India Training");

		test.log(LogStatus.INFO, "", "Dist Name :" + DistributorName.getText());

		KycPageUpload.click();
		DistID.sendKeys("108639101");
		DistEmail.sendKeys("cbsumankalyan@gmail.com");
		KycDistID.sendKeys("108639101");
		KycRemarks.sendKeys("Uploading KYC Documents Remarks");
		test.log(LogStatus.INFO, "UploadKyc", "108639101");
		test.log(LogStatus.INFO, "", "cbsumankalyan@gmail.com");
		test.log(LogStatus.INFO, "", "Uploader Dist ID: 108639101");
		test.log(LogStatus.INFO, "", "Uploading KYC Documents Remarks");
	}

	public void KycUpload() {
		File1.sendKeys("D:\\India\\WH\\kyc\\aggrementfront.pdf");
		File2.sendKeys("D:\\India\\WH\\kyc\\aggrementback.png");
		File3.sendKeys("D:\\India\\WH\\kyc\\aggrementfront.pdf");
		File4.sendKeys("D:\\India\\WH\\kyc\\addressback.png");
		File5.sendKeys("D:\\India\\WH\\kyc\\pan.png");
		File6.sendKeys("D:\\India\\WH\\kyc\\cheque.pdf");
		Submit.click();
		test.log(LogStatus.INFO, "", "Uploading KYC 6 Documents");
		test.log(LogStatus.INFO, "", Kycuploadsuccessmsg.getText());
		Assert.assertEquals(Kycuploadsuccessmsg.getText(), "Dear Unicity Distributor Your KYC documents has been successfully submitted.");
	}

	public void KycView() {
		Assert.assertEquals(DistributorID.getText(), "108639101");
		Assert.assertEquals(DistributorName.getText(), "India Training");
		test.log(LogStatus.INFO, "", "After Uploading Docs the record should be in the 1st Queue ");
		test.log(LogStatus.INFO, "", DistributorID.getText());
		test.log(LogStatus.INFO, "", DistributorName.getText());

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Assert.assertEquals(UpdatedDate.getText(), formatter.format(date));
		Assert.assertEquals(ModifiedBy.getText(), "portaladmin"); 

		View.click();

		for (String handle1 : driver.getWindowHandles()) {

			driver.switchTo().window(handle1);
		}
		test.log(LogStatus.INFO, "Kyc View:", ViewID.getAttribute("placeholder"));
		test.log(LogStatus.INFO, "", ViewName.getAttribute("placeholder"));
		test.log(LogStatus.INFO, "", Modify.getAttribute("placeholder"));
		test.log(LogStatus.INFO, "", ModifyName.getAttribute("placeholder"));
		test.log(LogStatus.INFO, "", ModifyID.getAttribute("placeholder"));
		test.log(LogStatus.INFO, "", ModifyEmail.getAttribute("placeholder"));
		Assert.assertEquals(ViewID.getAttribute("placeholder"), "108639101");
		Assert.assertEquals(ViewName.getAttribute("placeholder"), "India Training");
		Assert.assertEquals(Modify.getAttribute("placeholder"), "portaladmin");
		Assert.assertEquals(ModifyName.getAttribute("placeholder"), "India Training");
		Assert.assertEquals(ModifyID.getAttribute("placeholder"), "108639101");
		Assert.assertEquals(ModifyEmail.getAttribute("placeholder"), "cbsumankalyan@gmail.com");
	}

	public void KycValidate() {

		Validate.click();

		for (String handle1 : driver.getWindowHandles()) {

			driver.switchTo().window(handle1);
		}
		test.log(LogStatus.INFO, "Kycvalidate", KycDistID.getAttribute("value"));
		test.log(LogStatus.INFO, "", KycDistributorName.getAttribute("value"));
		test.log(LogStatus.INFO, "", KycUploaderName.getAttribute("value"));
		test.log(LogStatus.INFO, "", KycUploaderId.getAttribute("value"));
		test.log(LogStatus.INFO, "", KycUploaderEmail.getAttribute("value"));
		Assert.assertEquals(KycDistID.getAttribute("value"), "108639101");
		Assert.assertEquals(KycDistributorName.getAttribute("value"), "India Training");
		Assert.assertEquals(KycUploaderName.getAttribute("value"), "India Training");
		Assert.assertEquals(KycUploaderId.getAttribute("value"), "108639101");
		Assert.assertEquals(KycUploaderEmail.getAttribute("value"), "cbsumankalyan@gmail.com");

		String status [] = {"Completed", "Incomplete", "Validation Pending", "Rejected"};
		String random = (status[new Random().nextInt(status.length)]);

		Select statustyps = new Select(CSStatus);
		statustyps.selectByVisibleText(random);
		Update.click();
		Assert.assertEquals(Status.getText(), random);
		test.log(LogStatus.INFO, "Kycstatus:" , Status.getText());
	}

	public void SendSMS() {

		SendSMS.click();
		MobileNumber.sendKeys("9019185440");
		KycDistID.sendKeys("108639101");
		test.log(LogStatus.INFO, "Sendsms:" , "Distributor");
		test.log(LogStatus.INFO, "" , "9019185440");
		test.log(LogStatus.INFO, "" , "108639101");

		for(int i = 0; i<SMSTemplates.size(); i++) {
			SMSTemplates.get(i).click();
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", send);
		send.click();
//		Assert.assertEquals(SMSSent.getText(), "✓ SMS Sent:- Active, Pan Card Pending, Distributor Agreement Form, Distributor Agreement Form first page pending, Distributor Agreement form second page pending, Address Proof Pending, Incorrect Enroller, Incorrect Sponsor, Bank Proof, No Attachments, Distributor Agreement 2nd Page Singnature missing, Incorrect Address proof, Received only Pan Ack, Distributor Agreement form not clear");
		//		Assert.assertEquals(SMSFailed.getText(), "âœ˜ SMS Failed:- sample SMS(Code=0 Template Matching Failed)");
		test.log(LogStatus.INFO, "" , SMSSent.getText());
		//		test.log(LogStatus.INFO, "" , SMSFailed.getText());
	}

	public static boolean verifyMail(String userName, String password, String message) {
		test.log(LogStatus.INFO, "Email:" , "User has to receive Kyc Upload email notification");
		Folder folder = null;
		Store store = null;
		try {
			Properties props = new Properties();
			props.put("mail.store.protocol", "imaps");
			Session session = Session.getInstance(props);
			store = session.getStore("imaps");
			store.connect("imap.gmail.com", userName, password);
			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message[] messages = folder.getMessages();

			for (int i = messages.length-1; i >= 0; i--) {
				Message msg = messages[i];
				String strMailSubject = "";
				String strMailBody ="";

				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");

				Object subject = msg.getSubject();
				Object content = msg.getContent();
				Object recdate = msg.getReceivedDate();


				strMailBody = (String) content;
				strMailSubject = (String) subject;
				String body = "Dear Unicity Distributor,\r\n" + 
						"\r\n" + 
						"	Thank you for uploading, Please be informed that KYC Documents for distributor ID 108639101  has been submitted Successfully. \r\n" + 
						"\r\n" + 
						"Thanks and Regards\r\n" + 
						"Team Unicity India\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"";
				test.log(LogStatus.INFO, "" , strMailSubject);
				test.log(LogStatus.INFO, "" , body);

				if (strMailSubject.equals(message)) {
					Assert.assertEquals(strMailSubject, "KYC Documents Uploaded Succesfully");
					Assert.assertEquals(strMailBody, body);
					Assert.assertEquals(formatter.format(date), formatter.format(recdate));
					break;
				}
			}
			return true;
		} catch (MessagingException messagingException) {
			messagingException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (folder != null) {
				try {
					folder.close(true);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			if (store != null) {
				try {
					store.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}	
}
