package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EventsPage extends AndroidDriverUtility {

	public EventsPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Children’s Day Event')]")
	private WebElement eventImageButton;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Date:') or contains(@content-desc, 'Venue:') or contains(@content-desc, 'Phone:')]")
	private WebElement eventDetailsData;

	public void clickOnTheEvent(AndroidDriver androidDriver) {
		explicitWaitElementToBeClickable(androidDriver, eventImageButton);
		eventImageButton.click();
	}

	public String getTheDataFromEventaDetails(AndroidDriver androidDriver) {
		return eventDetailsData.getAttribute("contentDescription");
	}

}
