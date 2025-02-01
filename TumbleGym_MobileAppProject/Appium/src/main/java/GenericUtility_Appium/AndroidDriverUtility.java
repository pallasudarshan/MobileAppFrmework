package GenericUtility_Appium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileBrowserType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;

import Hello_Bff_GenericUtility.JavaUtility;
import io.appium.java_client.Location;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidDriverUtility {

	public AndroidDriver driver;
	public JavaUtility jutil = new JavaUtility();

	/*
	 * Handling Swipes, Swipe Action
	 * 
	 */
	public void swipe(int startX, int startY, int endX, int endY) {
		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endX, endY))
				.release().perform();
	}

	/*
	 * Handling Alerts & Popups Accept Alert
	 * 
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	/*
	 * Handling Alerts & Popups, Dismiss Alert
	 * 
	 */
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	/*
	 * Hide Keyboard
	 * 
	 */
	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	/*
	 * Handling App Interactions,Open Another App
	 * 
	 */
	public void openApp(String packageName) {
		driver.activateApp(packageName);
	}

	/*
	 * Handling App Interactions, Close an App
	 * 
	 */
	public void closeApp(String packageName) {
		driver.terminateApp(packageName);
	}

	/*
	 * Handling Drag & Drop
	 * 
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		new TouchAction<>(driver)
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
				.moveTo(ElementOption.element(target)).release().perform();
	}

	/*
	 * Handling Gesture, Pinch (Zoom Out)
	 * 
	 */
	public void pinch(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpen",
				ImmutableMap.of("element", ((RemoteWebElement) element).getId()));
	}

	/*
	 * Handling Gesture, Zoom (Zoom In)
	 * 
	 */

	public void zoom(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchClose",
				ImmutableMap.of("element", ((RemoteWebElement) element).getId()));
	}

	/*
	 * Handling Gesture, Long Press
	 * 
	 */
	public void longPress(WebElement element) {
		new TouchAction<>(driver)
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))).release()
				.perform();
	}

	/*
	 * Handling Biometric Authentication (Face ID, Fingerprint)
	 */
	public void simulateFingerprint(int fingerId) {
		((AndroidDriver) driver).fingerPrint(fingerId);
	}

	/*
	 * 
	 * Handling Device Orientation
	 * 
	 */
	public void rotateDevice(String orientation) {
		if (orientation.equalsIgnoreCase("landscape")) {
			driver.rotate(ScreenOrientation.LANDSCAPE);
		} else if (orientation.equalsIgnoreCase("portrait")) {
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
	}

	/*
	 * Handling Device Location
	 * 
	 */
	public void setDeviceLocation(double latitude, double longitude, double altitude) {
		Location location = new Location(latitude, longitude, altitude);
		((AndroidDriver) driver).setLocation(location);
	}

	/*
	 * Handling Context Switching (WebView & Native)
	 */
	public void switchToWebView() {
		Set<String> contextHandles = driver.getContextHandles();
		for (String contextName : contextHandles) {
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			}
		}
	}

	/*
	 * Handling App Notifications
	 * 
	 */

	public void openNotifications() {
		driver.openNotifications();
	}

	/*
	 * Handling Slider (Range)
	 */

	public void moveSlider(WebElement slider, int value) {
		new TouchAction<>(driver).press(PointOption.point(slider.getLocation()))
				.moveTo(PointOption.point(slider.getLocation().x + value, slider.getLocation().y)).release().perform();
	}

	/*
	 * Handling Spinner (Dropdown)
	 */

	public void selectFromSpinner(WebElement spinner, String option) {
		spinner.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + option + "']")).click();
	}

	/*
	 * Handling Permissions (Grant or Deny)
	 */
	public void grantPermission(String permission) {
		((AndroidDriver) driver).openNotifications();
		// Implement logic to interact with permission pop-up (e.g., grant permission)
	}

	/*
	 * Handling Date and Time Pickers
	 */
//	public void setDateTime(WebElement dateTimePicker, String dateTime) {
//	    dateTimePicker.click();
//	    driver.findElement(MobileBrowserType.xpath("//android.widget.DatePicker//android.widget.Button[@text='" + dateTime + "']")).click();
//	}

	/*
	 * Handling Mobile File Uploads & Downloads
	 */

	public void pushFile(String devicePath, File localFile) {
		try {
			((AndroidDriver) driver).pushFile(devicePath, localFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] pullFile(String devicePath) {
		return ((AndroidDriver) driver).pullFile(devicePath);
	}

	/*
	 * Handling App Installation
	 */
	public void installApp(String apkPath) {
		driver.installApp(apkPath);
	}

	/*
	 * Handling App Uninstallation installApp("/path/to/app.apk");
	 * uninstallApp("com.example.app");
	 */

	public void uninstallApp(String packageName) {
		driver.removeApp(packageName);
	}

	public static void waitForElementVisibility(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void explicitWaitElementToBeClickable(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	/**
	 * Simulate pressing the Back button.
	 */
	public void pressBackButton(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	/**
	 * Simulate pressing the Home button.
	 */
	public void pressHomeButton(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	/**
	 * Simulate pressing the Recents/Overview button.
	 */
	public void pressRecentsButton(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

	/**
	 * Simulate pressing the Volume Up button.
	 */
	public void pressVolumeUp(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
	}

	/**
	 * Simulate pressing the Volume Down button.
	 */
	public void pressVolumeDown(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
	}

	/**
	 * Simulate pressing the Power button.
	 */
	public void pressPowerButton(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.POWER));
	}

	/**
	 * Rotate the screen to Landscape.
	 */
	public void rotateToLandscape(AndroidDriver driver) {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}

	/**
	 * Rotate the screen to Portrait.
	 */
	public void rotateToPortrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	/**
	 * Take a screenshot of the current screen.
	 * 
	 * @param filePath The file path where the screenshot will be saved.
	 */
	public void takeScreenshot(String filePath) {
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait for a WebElement to be clickable and click it.
	 * 
	 * @param driver  AndroidDriver instance
	 * @param element WebElement to interact with
	 * @param timeout Maximum time to wait for the element (in seconds)
	 * @return boolean True if the element was successfully clicked, false otherwise
	 */
	public static boolean waitForElementToBeClick(AndroidDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true; // Successfully clicked
		} catch (Exception e) {
			System.out.println("Error: Unable to click the element. " + e.getMessage());
			return false; // Failed to click
		}
	}
}
