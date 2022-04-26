package testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.AppearTestLocators;

public class TC2_AppearTestPage extends BaseTestCase {
	
	@Override
	public void setSiteUri() {
		this.siteUri = "https://my.risingstarsassessment.co.uk/Test/Centre/25292";
	}

	@Test(description = "To verify whether the student is able to appear the interactive test and submit the test.")
	public void appearTestVerify() throws InterruptedException {
		AppearTestLocators appear = new AppearTestLocators(driver, wait);
		
		appear.enterTestCode();
		appear.enterTestPlayer();
		appear.testAttempt();
		WebElement endPageP = driver.findElement(By.xpath("//p[text()=\"Tell your teacher you have finished\"]"));
		assertTrue(endPageP.isDisplayed());
	}
	
	@Test(description = "To verify whether the student is able to appear the interactive test and submit the test.")
	public void appearTestVerifyTrial() throws InterruptedException {
		AppearTestLocators appear = new AppearTestLocators(driver, wait);
		appear.enterTestCode();
		appear.enterTestPlayer();
		appear.testAttemptTrial();
//		appear.testAttempt();
//		WebElement endPageP = driver.findElement(By.xpath("//p[text()=\"Tell your teacher you have finished\"]"));
//		assertTrue(endPageP.isDisplayed());
		
		
	}

}
