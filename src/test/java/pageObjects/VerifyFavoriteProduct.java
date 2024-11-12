package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyFavoriteProduct extends BasePage {
	public VerifyFavoriteProduct(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchPdct;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchBtn;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	WebElement addFvrt;

	@FindBy(xpath = "//a[@id='wishlist-total']")
	WebElement wishlist;

	@FindBy(xpath = "//a[normalize-space()='iPhone']")
	WebElement productInWishlist;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement wishlistLogout;

	public void searchForProduct(String productName) {
		searchPdct.sendKeys(productName);
		System.out.println(productName);
	}

	public void productSearchBtn() {
		searchBtn.click();
	}

	public void addToFavorites() {
		addFvrt.click();
	}

	public void goToWishlist() {
		wishlist.click();

	}

	public void logoutWishlistPage() {
		wishlistLogout.click();
	}

	public boolean isproductInWishlist(String productName) {
		try {
			return productInWishlist.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
