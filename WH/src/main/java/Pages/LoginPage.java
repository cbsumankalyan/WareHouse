package Pages;

import POM.LoginPOM;

public class LoginPage extends SuperTestNG{
	
	public void login() {
		LoginPOM login = new LoginPOM(driver);
		login.UserLogin("admin@unicity.com", "vijay123");
	}
}
