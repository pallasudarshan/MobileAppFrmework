package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Android_LogoutPage {

	public Android_LogoutPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Tab 4 of 4']")
	private WebElement settingButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Sign Out']")
	private WebElement signoutButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Yes, Sign Out']")
	private WebElement yesSignoutButton;

	public void logoutTheApp(AndroidDriver driver) {
		settingButton.click();
		signoutButton.click();
		yesSignoutButton.click();
	}

}
