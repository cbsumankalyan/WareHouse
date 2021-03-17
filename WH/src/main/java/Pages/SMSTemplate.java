package Pages;

import POM.SMSTemplatePOM;

public class SMSTemplate extends SuperTestNG{
	public void Template() throws InterruptedException {
		
		SMSTemplatePOM SMSTemplatePOM = new SMSTemplatePOM(driver);
		SMSTemplatePOM.Template();
	}
}
