package SettingsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility_Appium.BaseClass_Appium;
import ObjectRepository_Appium.SettingsPage;

public class HelpTest extends BaseClass_Appium {

	@Test
	public void checkThatUserAbleToGoToTheHelpCentreTest() {
		SettingsPage sp = new SettingsPage(androidDriver);

		sp.clickOnTheSeetingsButton(androidDriver);
		sp.clickOnTheHelpButton(androidDriver);
		sp.clickOnTheHelpCentreButton(androidDriver);
		sp.clickOnTheBackButton(androidDriver);
	}

	@Test
	public void checkThatUserAbleToGoToTheLegalPageTest() {
		SettingsPage sp = new SettingsPage(androidDriver);

		sp.clickOnTheSeetingsButton(androidDriver);
		sp.clickOnTheLegalButton(androidDriver);
		sp.clickOnTherefundAndCancellationPolicyButton(androidDriver);
	}

	@Test
	public void checkThatUserAbleToSearchTheQuestionsAndVerifyTheAnswerTest() throws Throwable {

		String question = "What is the age range for Tumble Gym programs";
		String expectedAnswer = "Our programs are designed for kids aged 1-14years.";

		SettingsPage sp = new SettingsPage(androidDriver);

		sp.clickOnTheSeetingsButton(androidDriver);

		sp.clickOnTheFaqButton(androidDriver);
		sp.enterDataInTheSearchFiledText(androidDriver, question);
		String actualAnswer = sp.clickOnTheQuestionAndAnswerAndSeeTheAsnwer(androidDriver);

		System.out.println("ActualAnswer  :- " + actualAnswer);
		Assert.assertEquals(actualAnswer, expectedAnswer);

	}
	
	
	
}
