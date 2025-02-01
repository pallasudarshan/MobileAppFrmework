package Hello_Bff_GenericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.github.javafaker.Faker;

/**
 * This class contains All WebDriver Actions
 * 
 * @author Sudarshan palla
 *
 */
public class WebDriverUtility extends JavaUtility {
	WebDriver driver;
	WebDriverWait wait;
	private Duration duration;
	static int wait1 = 30;

	/**
	 * This method is used to implicitly wait till page load
	 *
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI ,&check for specific element
	 * for every 500 milli seconds
	 *
	 * @throws Throwable
	 *
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime)
			throws Throwable {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(pollingTime))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to wait the control till the Particulr element in visible
	 * 
	 * @param element
	 */
	public void explictWaitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	/**
	 * Wait untill element to be clickable by refreshin page
	 * 
	 * @param driver
	 * @param element
	 */
	public static void explicitWaitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * Wait untill element to be clickable without refresh the page
	 * 
	 * @param driver
	 * @param element
	 */
	public static void explicitWaitElementToBeClickabl(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait untill element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void explicityWaitForElemenToBeClickable_ForSeconds(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		;
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * it is used to handle the scroll down/up Handling to pass the height
	 * 
	 * @param driver
	 * @param value
	 */
	public void scrollHandling(WebDriver driver, int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,value)", "");
	}

	/**
	 * This method used to scroll to the page full down
	 * 
	 * @param driver
	 */
	public void scrollDownTheStillEndOfThePage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * This method used to scroll the page full up
	 * 
	 * @param driver
	 */
	public void scrollUpFullPageUsingJavaScriprExecuter(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	/**
	 * This method is used to scroll by till the bottom of the page
	 */
	public void scrollByTheBottom(WebDriver driver) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/**
	 * Scrolll to the specified height
	 * 
	 * @param driver
	 * @param height
	 */
	public void scrollToSpecifiedHeight(WebDriver driver, int height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + height + ")");
	}

	/**
	 * This method is used to scroll till the element is aligned to top
	 * 
	 * @param element
	 */
	public void scrollIntoViewElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * scrollIntoViewIfNeededElement
	 * 
	 * @param driver
	 * @param element
	 */

	public void scrollIntoViewIfNeededElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoViewIfNeeded()", element);
	}

	/**
	 * scrollTo full pageTop
	 * 
	 * @param driver
	 */
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");
	}

	/**
	 * Scroll the page specified length
	 * 
	 * @param driver
	 */
	public void scrollDownByUsingJavascriptExecuter(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,420)", "");
	}

	/**
	 * This method is used to Switch Back to main Page
	 *
	 * @param driver
	 */
	public void switchBackToHomeWebPage() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is using to the Pass the data thorugh javascript executer
	 * 
	 * @param element
	 * @param data
	 */
	public void passTheDataUsingJavascriptExecuter(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	/**
	 * This method used to scroll to the page full down
	 *
	 * @param driver
	 */
	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * This method is using to double Click On The Element Used To
	 * JavascriptExecuter
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnTheElementUsedToJavascriptExecuter(WebDriver driver, WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].doubleClick();", element);
	}

	/**
	 * To Open a Page in New Tab
	 * 
	 * @param element
	 */

	/**
	 * This method is used to scroll till the element is aligned to top
	 *
	 * @param element
	 */
	public void scrollDownThePageUntilElementIsVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * it is used to take the Screen Shot of the Faield Test Scripts
	 *
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String dateandtime = Calendar.getInstance().getTime().toString().replace(":", "_");
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenshotName + dateandtime + ".PNG");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	/**
	 * This method is used to mouse over on the element
	 *
	 * @param driver
	 * @param element
	 */
	public void moveToTheParticularElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to move the mouse over action on Particular element
	 *
	 * @param driver
	 * @param element
	 */
	public void moveToTheParticularElementAndClick(WebDriver driver, WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).click(element).build().perform();
	}

	/**
	 * This method is used to click on the element through javascript executor
	 *
	 * @param driver
	 * @param element
	 */
	public void clickOnTheElementByUsingJavascriptExecuter(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * To Open a Page in New Tab
	 *
	 * @param element
	 */

	public void rightClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element);
		ac.build().perform();
	}

	/**
	 * To Perform Click and Hold Action
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnTheElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * To Switch To Frame By Index
	 * 
	 * @param index
	 * @throws Exception
	 */
	public void switchToFrameByIndex(int index) throws Exception {
		driver.switchTo().frame(index);
	}

	/**
	 * To Switch To Frame By Frame Name
	 * 
	 * @param frameName
	 * @throws Exception
	 */
	public void switchToFrameByFrameName(String frameName) throws Exception {
		driver.switchTo().frame(frameName);
	}

	/**
	 * To Switch To Frame By Web Element
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void switchToFrameByWebElement(WebElement element) throws Exception {
		driver.switchTo().frame(element);
	}

	/**
	 * To Switch out of a Frame
	 * 
	 * @throws Exception
	 */
	public void switchOutOfFrame() throws Exception {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method used to close the all child windos except the parent window
	 * 
	 * @param driver
	 */
	public void getWindowHandles(WebDriver driver) {
		String mainWindowHandle1 = driver.getWindowHandle();
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator2.hasNext()) {
			String ChildWindow2 = iterator2.next();
			if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow2)) {
				driver.switchTo().window(ChildWindow2);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle1);
	}

	public void select_DatePicker(WebDriver driver, WebElement element, String month, String date, String year)
			throws Throwable {
		element.click();
		for (int i = 0; i <= 12; i++) {

			if (!driver.findElements(By.xpath("//button[@aria-label='December 13, 2023']//span[1]")).isEmpty()
					|| !driver
							.findElements(By
									.xpath("//button[@aria-label='" + month + " " + date + ", " + year + "']//span[1]"))
							.isEmpty()) {
				try {
					element = driver.findElement(
							By.xpath("//button[@aria-label='" + month + " " + date + ", " + year + "']///span[1]"));
				} catch (Exception e) {
					element = driver.findElement(
							By.xpath("//button[@aria-label='" + month + " " + date + "," + year + "']//span[1]"));
				}
				element.click();
				break;
			} else {
				Thread.sleep(800);
				driver.findElement(By.xpath("(//button[@aria-label='Previous month']//span)[2]")).click();
			}
		}
	}

	public void selectDatePicker_MinusDate(int days, WebElement element) throws Throwable {
		String date = generateDateForDatePicker_MinusDate(days);
		String[] date1 = date.split(" ");
		String month = date1[0];
		String day = date1[1];
		String year = date1[2];
		select_DatePicker(driver, element, month, day, year);
	}

	public void clickOnOkBtn(WebDriver driver) {
		WebElement okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
		explicitWaitElementToBeClickabl(driver, okBtn);
		okBtn.click();
	}

	public String captureOkBtnText(WebDriver driver) throws Throwable {
		WebElement okBtnText = driver.findElement(By.xpath("//div[@id='swal2-html-container']"));
		Thread.sleep(600);
		String text = okBtnText.getText();
		return text;
	}

	public void invisibility_Of_SpinnerLoader(WebDriver driver) {
		try {
			WebElement loader = driver.findElement(By.xpath("//div[@class='spinner__loading']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(loader)));
		} catch (Exception e) {
		}
	}

	public byte[] takeScreenShotAllureReports(WebDriver driver) {
		byte[] screenshot = null;
		try {
			if (driver instanceof TakesScreenshot) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				screenshot = ts.getScreenshotAs(OutputType.BYTES);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenshot;
	}

	public void dropdown(WebDriver driver, WebElement element, WebElement dropdownText, String str) {
		explicitWaitElementToBeClickable(driver, element);
		element.click();
		dropdownText.sendKeys(str, Keys.ENTER);
	}

	public void selectDateFromCalender(WebDriver driver, String year, String month, String date) {
		driver.findElement(By.xpath("//button[@aria-label='Choose Year']")).click();
		WebElement yearBtn = null;
		try {
			yearBtn = driver.findElement(By.xpath("//span[text()='" + year + "']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
		if (yearBtn != null && yearBtn.isDisplayed()) {
			yearBtn.click();
		} else {
			while (true) {
				WebElement nextButton = driver.findElement(By.xpath("//button[@aria-label='Next Decade']"));
				nextButton.click();
				WebElement yearBtn1 = null;
				try {
					yearBtn1 = driver.findElement(By.xpath("//span[text()='" + year + "']"));
				} catch (org.openqa.selenium.NoSuchElementException e) {
				}
				if (yearBtn1 != null && yearBtn1.isDisplayed()) {
					yearBtn1.click();
					driver.findElement(By.xpath("//span[text()='" + month + "']")).click();
					driver.findElement(By.xpath("//span[text()='" + date + "']")).click();
					break;
				}
			}
		}
	}

	public void clearTheInputFieldsDataUsingTheJavascript(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", element);
	}

	public void checkTheElementIsPresentOrNot(WebDriver driver, WebElement element) {
		try {
			if (element.isDisplayed()) {
				Assert.fail("Line item is not deleted");
			} else {
				System.out.println("Line item is deleted");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
		}
	}

	public String generateRandomAmountsBelow1500Rupees() {
		Random random = new Random();
		int rupees = random.nextInt(1500);
		String amount = Integer.toString(rupees);
		return amount;
	}

	public String generateRandomQuantityBelowHundred() {
		Random random = new Random();
		int number = random.nextInt(100);
		String qty = Integer.toString(number);
		return qty;
	}

	public void clickOnSideMenuBtn(WebDriver driver) {
		WebElement sideMenuBtn = driver.findElement(By.xpath("//i[@class='pi pi-bars']"));
		scrollToTop(driver);
		explicitWaitElementToBeClickable(driver, sideMenuBtn);
		explicitWaitElementToBeClickabl(driver, sideMenuBtn);
		sideMenuBtn.click();
	}

	public String captureAlertText(WebDriver driver) throws Throwable {
		WebElement text = driver.findElement(By.xpath("(//div[@class='p-toast-detail'])[1]"));
		Thread.sleep(600);
		explictWaitForElementToBeVisible(driver, text);
		String text2 = text.getText();
		text.click();
		return text2;
	}

	public String captureAlertText_2(WebDriver driver) throws Throwable {
		WebElement text = driver.findElement(By.xpath("(//div[@class='p-toast-detail'])[1]"));
		Thread.sleep(600);
		explictWaitForElementToBeVisible(driver, text);
		String text2 = text.getText();
		return text2;
	}

	public String captureAlertText_last(WebDriver driver) throws Throwable {
		WebElement text = driver.findElement(By.xpath("(//div[@class='p-toast-detail'])[last()]"));
		Thread.sleep(600);
		explictWaitForElementToBeVisible(driver, text);
		String text2 = text.getText();
		return text2;
	}

	public void closeAlertPopup(WebDriver driver) throws Throwable {
		WebElement btn = driver.findElement(By.xpath("(//button[@class='p-toast-icon-close p-link'])[2]"));
		Thread.sleep(200);
		clickOnTheElementByUsingJavascriptExecuter(driver, btn);
	}

	public void clickOnNextButton(WebDriver driver) throws Throwable {
		WebElement nextButton = driver.findElement(By.xpath("//button[@aria-label='Next Page']"));
		scrollToBottom(driver);
		Thread.sleep(1500);
		explictWaitForElementToBeVisible(driver, nextButton);
		clickOnTheElementByUsingJavascriptExecuter(driver, nextButton);
	}

	public void clickOnPreviousButton(WebDriver driver) throws Throwable {
		WebElement previousBtn = driver.findElement(By.xpath("//button[@aria-label='Previous Page']"));
		scrollToBottom(driver);
		Thread.sleep(1500);
		explictWaitForElementToBeVisible(driver, previousBtn);
		clickOnTheElementByUsingJavascriptExecuter(driver, previousBtn);
	}

	public void clickOnLastButton(WebDriver driver) throws Throwable {
		WebElement lastBtn = driver.findElement(By.xpath("//button[@aria-label='Last Page']"));
		Thread.sleep(1000);
		scrollToBottom(driver);
		Thread.sleep(1500);
		explictWaitForElementToBeVisible(driver, lastBtn);
		clickOnTheElementByUsingJavascriptExecuter(driver, lastBtn);
	}

//	public void waitTillInvisiblityOfLoader(WebDriver driver) {
//	    try {
//	        WebElement llll = driver.findElement(By.xpath("//div[@class='spinner-overlay']//img[1]"));
//	        WebDriverWait wait = new WebDriverWait(driver, duration);
//	        wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(llll)));
//	    } catch (Exception e) {
//	    }
//	}

	public void waitTillInvisibilityOfLoader(WebDriver driver) {
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, duration);
//	        
//	            WebElement loader = d.findElement(By.xpath("//img[@alt='Icon']"));
//	            return !loader.isDisplayed();
//	        });
//	    } catch (Exception e) {
//	    }
	}

	public void clickOnFirstButton(WebDriver driver) throws Throwable {
		WebElement firstBtn = driver.findElement(By.xpath("//button[@aria-label='First Page']"));
		scrollToBottom(driver);
		Thread.sleep(1500);
		explictWaitForElementToBeVisible(driver, firstBtn);
		clickOnTheElementByUsingJavascriptExecuter(driver, firstBtn);
		scrollToBottom(driver);
	}

	public String captureSlNo_Table(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		WebElement slno_Lastrow = driver.findElement(By.xpath("(//table)[1]//tbody/tr[1]/td[1]"));
		scrollDownThePageUntilElementIsVisible(driver, slno_Lastrow);
		String text = slno_Lastrow.getText();
		return text;
	}

	public String captureSlNo_Table_Lastrow(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		WebElement slno_Lastrow = driver.findElement(By.xpath("(//table)[1]//tbody/tr[last()]/td[1]"));
		scrollDownThePageUntilElementIsVisible(driver, slno_Lastrow);
		String text = slno_Lastrow.getText();
		return text;
	}

	public String captureLastPageNumber(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		scrollToBottom(driver);
		WebElement pageNo = driver.findElement(By.xpath("(//span[@class='p-paginator-pages']//button)[last()]"));
		scrollDownThePageUntilElementIsVisible(driver, pageNo);
		String text = pageNo.getText();
		return text;
	}

	public String clickOnMiddlePageNumber(WebDriver driver) throws Throwable {
		String pageNumber = captureLastPageNumber(driver);
		int pageNo_Int = Integer.parseInt(pageNumber);
		int value = pageNo_Int / 2;
		String value2 = String.valueOf(value);
		WebElement button = driver.findElement(By.xpath("//button[@aria-label='" + value2 + "']"));
		button.click();
		return value2;
	}

	public String clickOnMiddlePageNumber2(WebDriver driver) throws Throwable {
		clickOnLastButton(driver);
		String pageNumber = captureLastPageNumber(driver);
		int pageNo_Int = Integer.parseInt(pageNumber);

		clickOnFirstButton(driver);
		int value = pageNo_Int / 2;
		String value2 = String.valueOf(value);
		WebElement button = driver.findElement(By.xpath("//button[@aria-label='" + value2 + "']"));

		int maxAttempts = pageNo_Int;
		int attempt = 0;

		try {
			if (button.isDisplayed()) {
				button.click();
			} else {
				while (!button.isDisplayed() && attempt < maxAttempts) {
					driver.findElement(By.xpath("(//span[@class='p-paginator-pages']//button)[last()]")).click();
					attempt++;
				}

				if (button.isDisplayed()) {
					button.click();
				} else {
					System.out.println("Button not found after max attempts");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Button element not found: " + e.getMessage());
		}

		return value2;
	}

//	public String clickOnMiddlePageNumber(WebDriver driver, int text) throws Throwable {
//		int value = text / 2;
////		String value_str = String.valueOf(value).substring(0, 1);
//		String value2 = String.valueOf(value);
//		System.out.println(value);
//		WebElement button = null;
//		try {
//			button = driver.findElement(By.xpath("//button[@aria-label='" + value2 + "']"));
//		} catch (org.openqa.selenium.NoSuchElementException e) {
//		}
//		if (button != null && button.isDisplayed()) {
//			scrollToBottom(driver);
//			button.click();
//		} else {
//			while (true) {
//				scrollToBottom(driver);
//				driver.findElement(By.xpath("(//span[@class='p-paginator-pages']//button)[last()]")).click();
//			}
//		}
//
//		return value2;
//	}

	@FindBy(xpath = "//span[text()='Today']")
	public WebElement todayBtn;

	public String captureLastPaginationNumber(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		WebElement paginationNumber = driver.findElement(By.xpath("(//button[@data-pc-section='pagebutton'])[last()]"));
		scrollDownThePageUntilElementIsVisible(driver, paginationNumber);
		String text = paginationNumber.getText();
		return text;
	}

	public String captureKeywordSearchField(WebDriver driver) {
		WebElement keywordSearchField = driver.findElement(By.xpath("//input[@placeholder='Keyword Search']"));
		return keywordSearchField.getAttribute("value");
	}

	public void clickOnClearBtn_KeywordSearch(WebDriver driver) {
		WebElement clearBtn = driver.findElement(By.xpath("//span[text()='Clear Filters']"));
		scrollToTop(driver);
		explicitWaitElementToBeClickable(driver, clearBtn);
		clearBtn.click();
	}

	public void enterKeywordSearch(WebDriver driver, String text) {
		WebElement keywordSearchField = driver.findElement(By.xpath("//input[@placeholder='Keyword Search']"));
		scrollToTop(driver);
		explictWaitForElementToBeVisible(driver, keywordSearchField);
		keywordSearchField.sendKeys(text);
	}

	public String WindowHandle(WebDriver driver) {
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		String mainWindowHandle1 = driver.getWindowHandle();

		Iterator<String> iterator2 = allWindowHandles2.iterator();
		while (iterator2.hasNext()) {
			String ChildWindow2 = iterator2.next();
			if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow2)) {
				driver.switchTo().window(ChildWindow2);
			}
		}
		return mainWindowHandle1;
	}

	
	public String captureUsername(WebDriver driver) throws Throwable {
		WebElement text = driver.findElement(By.xpath("//span//strong"));
		Thread.sleep(600);
		explictWaitForElementToBeVisible(driver, text);
		String text2 = text.getText();
		return text2;
	}

	
	
}