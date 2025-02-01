package CurriculumTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import Hello_Bff_GenericUtility.AllureTestListeners;
import ObjectRepository_Appium.CurriculumPage;
//@Listeners(AllureTestListeners.class)
public class CurriculumTestCasesTest extends BaseClass_Appium {

	@Test
	public void checkThatUserAbloToDownloadTheCurriculumPageTest() throws Throwable {
		CurriculumPage cp = new CurriculumPage(androidDriver);

		cp.clickOnTheClickHereButton(androidDriver);
		cp.downloadTheCurriculum(androidDriver);
	}
}
