package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
		@FindBy(xpath = "//span[normalize-space()='My Account']")
		WebElement linkMyaccount;

		//Register
		@FindBy(linkText = "Register")
		WebElement linkRegister;
		
		@FindBy(xpath = "//a[normalize-space()='Login']")
		WebElement linkLogin;

		// Action Methods
		public void clickMyAccount() {
			linkMyaccount.click();
		}

		public void clickRegister() {
			linkRegister.click();
		}
		
		public void clickLogin()
		{
			linkLogin.click();
		}
	

}
