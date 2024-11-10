package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_004_AddCart extends BaseClass {
	@Test(groups = { "Regression", "Master" })
	public void TestAddToCart() {
		logger.info("***** Starting TC004_AccountRegistrationTest *****");
		logger.debug("This is a debug log message");
//		Home Page
		HomePage HP = new HomePage(driver);
		HP.clickMyaccount();
		HP.Loginlnk();
//		HP.myAccountLogout();
		logger.info("Clicked on Register Link.");

//		Account Login Page
		AccountLoginPage LP = new AccountLoginPage(driver);
		logger.info("Providing customer details...");
		LP.loginEmailId(p.getProperty("email"));
		LP.loginPassword(p.getProperty("password"));
		LP.accountLoginBtn();

//		Shopping Cart Page
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.clickItemsToNavigateToCart();
		sc.clickViewCart();
		sc.getTotalPrice();
		sc.clickOnCheckout();
	}

}
