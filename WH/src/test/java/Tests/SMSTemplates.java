package Tests;

import Pages.LoginPage;
import Pages.SMSTemplate;
import Pages.SuperTestNG;
import org.testng.annotations.Test;

public class SMSTemplates extends SuperTestNG {
	
	LoginPage LP = new LoginPage();
	SMSTemplate smstemplate = new SMSTemplate();
	
	@Test
	public void Template () throws InterruptedException {
		
		test=SMSTemplate.createNode("<b><font color=407899>"+"SMS Template" + "</font></b>");
		LP.login();
		smstemplate.Template();
	}
}
