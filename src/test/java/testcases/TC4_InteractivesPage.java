package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.AppearTestLocators;
import pages.HamburgerLocator;
import pages.InteractiveTestLocators;
import pages.LoginLocators;

public class TC4_InteractivesPage extends BaseTestCase {

	LoginLocators login; 
	AppearTestLocators homepage;
	HamburgerLocator hamburger;
	InteractiveTestLocators interactive;
		
	@Test (description="To verify whether the teacher admin is able to assign test to student.")
	public void  assignTestVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		interactive = new InteractiveTestLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		interactive.interactivePageLoad();
		interactive.choosePaperInteractives();
		interactive.assignTestDialogBox();
	}
	
	@Test (description="To verify whether the student is able to appear the interactive test and submit the test.")
	public void appearInteractiveTestVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		interactive = new InteractiveTestLocators(driver, wait);
		
		//Assign test 
		login.loginTeacher();
		hamburger.hamburgerClick();
		interactive.interactivePageLoad();
//		interactive.choosePaperInteractives();
//		interactive.assignTestDialogBox();
		Thread.sleep(3000);
		interactive.enterCalendar();
		interactive.testcode();
		interactive.clickTestLink();
		interactive.enterTestCode();
		interactive.enterTestPlayer();
		interactive.testAttempt();
		wait.until(ExpectedConditions.visibilityOfElementLocated(InteractiveTestLocators.testFinishedText));
		
		
	}
	
	@Test (description="To verify whether the student is able to appear the interactive test and submit the test.")
	public void appearInteractiveTestNewVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		interactive = new InteractiveTestLocators(driver, wait);
		
		//Assign test 
		login.loginTeacher();
		hamburger.hamburgerClick();
		interactive.interactivePageLoad();
		interactive.choosePaperInteractives();
		interactive.assignTestDialogBox();
		Thread.sleep(3000);
		hamburger.hamburgerClick();
		interactive.interactivePageLoad();
		interactive.enterCalendar();
		interactive.testcode();
		interactive.clickTestLink();
		interactive.enterTestCode();
		interactive.enterTestPlayer();
		interactive.testAttempt();
		wait.until(ExpectedConditions.visibilityOfElementLocated(InteractiveTestLocators.testFinishedText));
		
		
	}
}