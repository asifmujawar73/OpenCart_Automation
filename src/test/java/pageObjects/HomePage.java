package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Find elements on the page
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement regMyaccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;

	// Method to click 'My Account'
	public void clickMyaccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(lnkMyaccount)); // Wait until the 'My Account' link is visible
		lnkMyaccount.click(); // Then click on the 'My Account' link
	}

	// Method to click 'Register'
	public void registerMyaccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(regMyaccount)); // Wait until the 'Register' link is visible
		regMyaccount.click(); // Then click on the 'Register' link
	}

	public void Loginlnk() {
		lnkLogin.click();
	}

}
