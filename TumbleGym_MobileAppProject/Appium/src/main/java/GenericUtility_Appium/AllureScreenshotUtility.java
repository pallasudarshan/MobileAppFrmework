package GenericUtility_Appium;

//import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;

public class AllureScreenshotUtility {

	//@Attachment(value = "Failure Screenshot", type = "image/png")
	public static byte[] takeScreenshot(AndroidDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			return FileUtils.readFileToByteArray(srcFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
}
