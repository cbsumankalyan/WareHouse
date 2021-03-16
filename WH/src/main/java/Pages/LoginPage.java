package Pages;

import POM.LoginPOM;

public class LoginPage extends SuperTestNG{
	
	public void login() {
		LoginPOM login = new LoginPOM(driver);
		login.UserLogin("superadmin@unicity.com", "unicity@789");
	}
}
