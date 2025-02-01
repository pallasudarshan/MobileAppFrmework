package GenericUtility_Appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Hello_Bff_GenericUtility.ExcelUtility;
import Hello_Bff_GenericUtility.FileUtility;
import Hello_Bff_GenericUtility.JavaUtility;
import Hello_Bff_GenericUtility.WebDriverUtility;
import ObjectRepository_Appium.Android_LoginPage;
import ObjectRepository_Appium.Android_LogoutPage;
import java.lang.reflect.Method;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class BaseClass_Appium {
	public WebDriver driver;
	public AndroidDriver androidDriver;
	public AppiumDriverLocalService service;

	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface OpenBrowser {
	}

	@BeforeClass
	public void ConfigureAppium() throws Throwable {
		String AppiumServerURL = futil.getProperyKeyValue("AppiumServerURL");
		String DeviceName = futil.getProperyKeyValue("DeviceName");
		String IPAddress = futil.getProperyKeyValue("IPAddress");
		String portNum = futil.getProperyKeyValue("portNumber");
		int portNumber = Integer.parseInt(portNum);
		String wait = futil.getProperyKeyValue("wait");
		int wait1 = Integer.parseInt(wait);

		service = new AppiumServiceBuilder().withIPAddress(IPAddress).usingPort(portNumber).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(DeviceName);
		String appPath = IpathConstants.mobileAppPath;
		String absoluteFileAppPath = new File(appPath).getAbsolutePath();
		options.setApp(absoluteFileAppPath);

		androidDriver = new AndroidDriver(new URL(AppiumServerURL), options);
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait1));

		Android_LoginPage alp = new Android_LoginPage(androidDriver);
		String MobileUsername = futil.getProperyKeyValue("MobileUsername");
		alp.loginToTheApp(androidDriver, MobileUsername, "parent");
	}

	/**
	 * This method is used to open the chrome browser if we call it in
	 * the @openBrowser in the method and Login to the web
	 * 
	 * @param methodo
	 * @throws Throwable
	 */
	@BeforeMethod
	public void bmethod(Method method) throws Throwable {
		boolean openBrowser = shouldOpenBrowser(method);
		if (openBrowser) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
			String url = futil.getProperyKeyValue("url");
			String username = futil.getProperyKeyValue("username");
			String password = futil.getProperyKeyValue("password");
			// LoginPage p = new LoginPage(driver);
			// p.loginTheApplication(driver, url, username, password);

		}
//		Android_LoginPage alp = new Android_LoginPage(androidDriver);
//		String MobileUsername = futil.getProperyKeyValue("MobileUsername");
//		alp.loginToTheApp(androidDriver, MobileUsername, "parent");
	}

	/**
	 * This Annotation is used to Sign Out the Application
	 *
	 * @throws Throwable
	 */
	@AfterMethod
	public void amethod() throws Throwable {
		if (driver != null) {
			driver.quit();
		}
//		Android_LogoutPage logout = new Android_LogoutPage(androidDriver);
//		logout.logoutTheApp(androidDriver);
	}

	@AfterClass
	public void tearDown() {
		Android_LogoutPage logout = new Android_LogoutPage(androidDriver);
		// logout.logoutTheApp(androidDriver);
		androidDriver.quit();
		service.stop();
	}

	protected boolean shouldOpenBrowser(Method method) {
		return method.isAnnotationPresent(OpenBrowser.class);
	}

//	private boolean isEmulatorRunning() throws IOException {
//		process = Runtime.getRuntime().exec("adb devices");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//		String line;
//		while ((line = reader.readLine()) != null) {
//			if (line.contains("emulator")) {
//				return true;
//			}
//		}
//		return false;
//	}
	public static void startEmulator() {
		String emulatorFolderPath = "C:\\Users\\Sudarshan\\AppData\\Local\\Android\\Sdk\\emulator";
		String emulatorName = "6Pro";
		try {
			// Change the working directory
			String changeDirCommand = emulatorFolderPath;
			Runtime.getRuntime().exec(changeDirCommand);
			// Start the emulator
			String emulatorCommand = "emulator -avd " + emulatorName;
			Runtime.getRuntime().exec(emulatorCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AndroidDriver getAndroidDriver() {
		return androidDriver;
	}
}
