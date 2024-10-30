package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement loginEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement loginPass;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement acntloginBtn;

	public void loginEmailId(String emailId) {
		loginEmail.sendKeys(emailId);
	}

	public void loginPassword(String lPssword) {
		loginPass.sendKeys(lPssword);
	}

	public void accountLoginBtn() {
		acntloginBtn.click();
	}
}
