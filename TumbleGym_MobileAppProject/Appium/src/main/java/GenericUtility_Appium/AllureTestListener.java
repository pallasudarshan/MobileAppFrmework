package GenericUtility_Appium;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureTestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Allure.attachment("Test failed", "Oops, test failed!");

		Object testInstance = iTestResult.getInstance();
		if (testInstance instanceof BaseClass_Appium) {
			AndroidDriver driver = ((BaseClass_Appium) testInstance).getAndroidDriver();
			if (driver != null) {
				byte[] screenshot = takeScreenshot(driver);
				if (screenshot != null) {
					Allure.attachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
				}
			}
		}
	}

	@Attachment(value = "Screenshot on Failure", type = "image/png")
	public byte[] takeScreenshot(AndroidDriver driver) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			return FileUtils.readFileToByteArray(srcFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0]; // Return empty array if screenshot fails
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
	}

	@Override
	public void onStart(ITestContext iTestContext) {
	}
}
