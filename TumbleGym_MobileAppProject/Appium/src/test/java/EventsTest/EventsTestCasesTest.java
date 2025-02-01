package EventsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import ObjectRepository_Appium.EventsPage;

public class EventsTestCasesTest extends BaseClass_Appium {

	@Test
	public void checkThatUserAbleToVerifyTheEventDetailsTest() {
		String expectedResult = "Date: November 14, 2024";

		EventsPage ep = new EventsPage(androidDriver);

		ep.clickOnTheEvent(androidDriver);
		String actualEventDetails = ep.getTheDataFromEventaDetails(androidDriver);

		System.out.println("actualEventDetails    :- " + actualEventDetails);
		Assert.assertTrue(actualEventDetails.contains(expectedResult));
	}

}
