package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Android_LoginPage {

	public AndroidDriver androidDriver;

	public Android_LoginPage(AndroidDriver androidDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Skip']")
	private WebElement skipButton;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement phoneNumberText;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Generate Otp']")
	private WebElement generateOtpButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Parent']")
	private WebElement parentBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Trainer']")
	private WebElement trainerBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Start']")
	private WebElement startButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sanjay s']")
	private WebElement firstChildProfileBtn;

	public void loginToTheApp(AndroidDriver androidDriver, String MobileUsername, String userType) throws Throwable {

		Thread.sleep(2000);
		skipButton.click();

		phoneNumberText.click();
		phoneNumberText.sendKeys("1221121212");
		androidDriver.hideKeyboard();
		generateOtpButton.click();

		Thread.sleep(12000);

		if (userType.equalsIgnoreCase("parent")) {
			parentBtn.click();
		} else {
			trainerBtn.click();
		}
		startButton.click();
		firstChildProfileBtn.click();
	}

}
