package Hello_Bff_GenericUtility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains Implementation of all Basic configuration Annotations
 * 
 * @author Sudarshan
 *
 */
public class BaseClass extends WebDriverUtility {
	public WebDriver driver = null;
	public static WebDriver sdriver;
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();

	@BeforeSuite
	public void bsuite() {

	}

	@BeforeTest
	public void btest() {

	}

	@BeforeClass
	public void bclass() throws Throwable {
		String browserName = futil.getProperyKeyValue("browser");
		String url = futil.getProperyKeyValue("url");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();

			WebDriverManager.chromedriver().setup();

			DesiredCapabilities caps = new DesiredCapabilities();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			Map<String, Object> prefs = new HashMap<>();
			Map<String, Object> profile = new HashMap<>();
			Map<String, Object> contentSettings = new HashMap<>();
			contentSettings.put("notifications", 1);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("use-fake-ui-for-media-stream");
//			options.addArguments("--headless");
//			options.setHeadless(true);
//			options.addArguments("--disable-autofill");
//			options.addArguments("disable-infobars");

			// Used to close the Save Address popup
			Map<String, Object> prefs1 = new HashMap<String, Object>();
			prefs1.put("autofill.profile_enabled", false);
			options.setExperimentalOption("prefs", prefs1);

			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.disable_beforeunload", false);
			options.setProfile(profile);

			driver = new FirefoxDriver();
			System.out.println("launch browser is " + browserName);
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();

			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);

			driver = new EdgeDriver();
			System.out.println("launch browser is " + browserName);
		} else {
			System.out.println("Specify Valid broswer");
		}
		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sdriver = driver;
	}

	/**
	 * This Annotation is used to Login to the Application
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod
	public void bmethod() throws Throwable {
		String url = futil.getProperyKeyValue("url");
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		//LoginPage page = new LoginPage(driver);
		//page.loginTheApplication(driver, url, username, password);
	}

	/**
	 * 
	 * This Annotation is used to Sign Out the Application
	 * 
	 * @throws Throwable
	 * 
	 */
	@AfterMethod
	public void amethod() throws Throwable {
		//LogoutPage ip = new LogoutPage(driver);
		//ip.logoutTheApplication(driver);
	}

	/**
	 * This Annotation is used to Close the Browser
	 */
	@AfterClass
	public void aclass() {
		driver.quit();
		System.out.println("Close the Browser");
	}

	@AfterTest
	public void atest() {

	}

	@AfterSuite
	public void asuite() {

	}

}
