package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_AccountLogin extends BaseClass {
	@Test(groups = { "Sanity", "Master" })
	public void verify_account_login() {
		logger.info("**** TC_002 Account Login Test - started ****");
		try {
//		Home Page
			HomePage HP = new HomePage(driver);
			HP.clickMyaccount();
			HP.Loginlnk();
//			HP.myAccountLogout();

//		Account Login Page
			AccountLoginPage LP = new AccountLoginPage(driver);
			LP.loginEmailId(p.getProperty("email"));
			LP.loginPassword(p.getProperty("password"));
			LP.accountLoginBtn();

//		My Account Page
			MyAccountPage AP = new MyAccountPage(driver);
			boolean targetPage = AP.isMyAccountPageExists();
//		Assert.assertEquals(targetPage, true, "Login Filled");
			System.out.println(targetPage);
			System.out.println("Hello");
			Thread.sleep(5000);
			Assert.assertTrue(targetPage);
			AP.myAccountLogout();
		} catch (Exception e) {
			Assert.fail();

		}
		logger.info("**** TC_002_AccountLoginTest Finished ****");
	}
}
