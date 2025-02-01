package ObjectRepository_Appium;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends AndroidDriverUtility {

	public SettingsPage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Tab 4 of 4']")
	private WebElement settingsButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Account']")
	private WebElement accountButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.View[4]")
	private WebElement editButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Help']")
	private WebElement helpButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Help Centre']")
	private WebElement helpCentreButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Help']/..//*[@class='android.widget.ImageView']")
	private WebElement backButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Legal']")
	private WebElement legalButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Refund and Cancellation Policy']")
	private WebElement RefundAndCancellationPolicy;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='FAQ']")
	private WebElement faqButton;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement searchTextFaq;

	@AndroidFindBy(xpath = "//*[contains(@text, 'What is the age range for Tumble Gym programs')]")
	private WebElement questionsButton;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Our programs are designed for kids aged 1-14years.')]")
	private WebElement AnswerText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Connect With Us']")
	private WebElement connectWithUsButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[1]")
	private WebElement facebookButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[2]")
	private WebElement instagranButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[3]")
	private WebElement youtubeButton;

	@AndroidFindBy(xpath = "//android.widget.ImageView[4]")
	private WebElement threadButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Manage Profiles']")
	private WebElement manageProfileButton;

	@AndroidFindBy(xpath = "//android.view.View[3]")
	private WebElement addButton;

	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	private WebElement enterYourNameText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Male']")
	private WebElement maleRadioButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Female']")
	private WebElement femaleRadioButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Enter Your Height?']/following-sibling::*[@class='android.widget.EditText']")
	private WebElement enterYourHeightText;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc='Enter Your Weight?']/following-sibling::*[@class='android.widget.EditText'])[1]")
	private WebElement enterWeightText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Continue']")
	private WebElement continueButton;

//	@AndroidFindBy(xpath = "")
//	private WebElement ;
//	
//	@AndroidFindBy(xpath = "")
//	private WebElement ;
//	
//	@AndroidFindBy(xpath = "")
//	private WebElement ;
//	
//	@AndroidFindBy(xpath = "")
//	private WebElement ;

	public void clickOnTheSeetingsButton(AndroidDriver androidDriver) {
		settingsButton.click();
	}

	public void clickOnTheHelpButton(AndroidDriver androidDriver) {
		helpButton.click();
	}

	public void clickOnTheHelpCentreButton(AndroidDriver androidDriver) {
		helpCentreButton.click();
		pressBackButton(androidDriver);
	}

	public void clickOnTheBackButton(AndroidDriver androidDriver) {
		backButton.click();
	}

	public void clickOnTheLegalButton(AndroidDriver androidDriver) {
		legalButton.click();
	}

	public void clickOnTherefundAndCancellationPolicyButton(AndroidDriver androidDriver) {
		RefundAndCancellationPolicy.click();
		pressBackButton(androidDriver);
	}

	public void clickOnTheFaqButton(AndroidDriver androidDriver) {
		faqButton.click();
	}

	public void enterDataInTheSearchFiledText(AndroidDriver androidDriver, String Question) {
		searchTextFaq.click();
		searchTextFaq.sendKeys(Question);
		androidDriver.hideKeyboard();
	}

	public String clickOnTheQuestionAndAnswerAndSeeTheAsnwer(AndroidDriver androidDriver) throws Throwable {
		questionsButton.click();
		Thread.sleep(3000);
		return AnswerText.getText();
	}

	public void clickOnTheConnectWithUs(AndroidDriver androidDriver) {
		connectWithUsButton.click();
	}

	public void clickOnTheFacebookButton(AndroidDriver androidDriver) {
		waitForElementToBeClick(androidDriver, facebookButton);
		facebookButton.click();
		pressBackButton(androidDriver);
	}

	public void clickOnTheInstgramButton(AndroidDriver androidDriver) {
		waitForElementToBeClick(androidDriver, instagranButton);
		instagranButton.click();
		pressBackButton(androidDriver);
	}

	public void clickOnTheYoutubeButton(AndroidDriver androidDriver) {
		waitForElementToBeClick(androidDriver, youtubeButton);
		youtubeButton.click();
		pressBackButton(androidDriver);
	}

	public void clickOnTheThreadButton(AndroidDriver androidDriver) {
		threadButton.click();
		pressBackButton(androidDriver);
	}

}
