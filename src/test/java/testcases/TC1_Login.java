package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.LoginLocators;

public class TC1_Login extends BaseTestCase{
	LoginLocators login; 
	
	@Test(description="To verify whether the teacher admin is able to login into MARK.")
	public void loginVerifyTeacherAdmin() throws InterruptedException {
		login = new LoginLocators(driver);
		login.loginTeacherAdmin();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='notificationsbuttontitle']")));
	}
	
	@Test(description="To verify whether the teacher is able to login into MARK.")
	public void loginVerifyTeacher() throws InterruptedException {
		login = new LoginLocators(driver);

		login.loginTeacher();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='notificationsbuttontitle']")));
	}
	
//	
//	@Test
//	public void loginVerifyMarkNonSubTeacher() throws InterruptedException {
//		login = new LoginLocators(driver);
//
//		login.loginNonSubTeacherAdmin();
//		Thread.sleep(20000);
//		
//		WebElement markPlusBtn = driver.findElement(By.xpath("//img[@title='Upgrade to MARK Plus']"));
//		assertTrue(markPlusBtn.isDisplayed());
//		
//		
//		
//	}
}