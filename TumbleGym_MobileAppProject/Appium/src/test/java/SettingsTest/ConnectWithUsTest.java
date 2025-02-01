package SettingsTest;

import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import ObjectRepository_Appium.SettingsPage;

public class ConnectWithUsTest extends BaseClass_Appium {

	@Test
	public void checkThatUserAbleToClickOnTheFaceBook_Youtube_InstagramTabsTest() {

		SettingsPage sp = new SettingsPage(androidDriver);

		sp.clickOnTheSeetingsButton(androidDriver);
		sp.clickOnTheConnectWithUs(androidDriver);
		sp.clickOnTheFacebookButton(androidDriver);
		sp.clickOnTheInstgramButton(androidDriver);
		sp.clickOnTheYoutubeButton(androidDriver);
		sp.clickOnTheThreadButton(androidDriver);
		System.out.println("User opened all tabs and came back");
	}
}
