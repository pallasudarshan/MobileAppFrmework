package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CurriculumPage extends AndroidDriverUtility {

	public CurriculumPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Click Here']")
	private WebElement clickHere;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Gymnastic Course') and contains(@content-desc, 'Little Tumbler')]")
	private WebElement course;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Download']")
	private WebElement downloadButton;

	public void clickOnTheClickHereButton(AndroidDriver androidDriver) {
		clickHere.click();
	}

	public void downloadTheCurriculum(AndroidDriver androidDriver) throws Throwable {
		explicitWaitElementToBeClickable(androidDriver, course);
		course.click();
		Thread.sleep(2000);
		downloadButton.click();
	}

}
