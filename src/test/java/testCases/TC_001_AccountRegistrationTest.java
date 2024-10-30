package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		logger.debug("This is a debug log message");

		try {
			HomePage HP = new HomePage(driver);
			HP.clickMyaccount();
			HP.registerMyaccount();
			logger.info("Clicked on Register Link.");

			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			regPage.setFirstName(randomeString().toUpperCase());
			regPage.setLastName(randomeString().toUpperCase());
			regPage.setEmail(randomeString() + "@gmail.com");
			regPage.setTelephone(randomeNumber());

			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			logger.info("Validating expected message...");

			regPage.setPrivacyPolicy();
			regPage.clickContinue();

			logger.info("Validating expected message..");

			String confmsg = regPage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

			logger.info("Test passed");
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

	}
}
