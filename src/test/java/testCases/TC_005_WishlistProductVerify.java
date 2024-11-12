package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.VerifyFavoriteProduct;
import testBase.BaseClass;

public class TC_005_WishlistProductVerify extends BaseClass {
	@Test(groups = { "Sanity", "Master" })
	public void TestWishlistProductVerify() {
		// Home page
		HomePage HP = new HomePage(driver);
		HP.clickMyaccount();
		HP.Loginlnk();
		HP.clickMyaccount();

//		Account login
		AccountLoginPage LP = new AccountLoginPage(driver);
		LP.loginEmailId(p.getProperty("email"));
		LP.loginPassword(p.getProperty("password"));
		LP.accountLoginBtn();

//		Cart Verify page
		VerifyFavoriteProduct vp = new VerifyFavoriteProduct(driver);
		String productName = "iphone";
		vp.searchForProduct(productName);
		vp.productSearchBtn();
		vp.addToFavorites();
		vp.goToWishlist();
		vp.logoutWishlistPage();
	}
}
