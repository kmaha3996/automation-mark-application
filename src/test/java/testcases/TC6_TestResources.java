package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.HamburgerLocator;
import pages.LoginLocators;
import pages.TestResourceLocators;

public class TC6_TestResources extends BaseTestCase {

	LoginLocators login; 
	HamburgerLocator hamburger;
	TestResourceLocators resource;
	
	@Test(priority = 1)
	public void testResourcePageVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		resource = new TestResourceLocators(driver, wait);
		
		login.loginTeacher();
		Thread.sleep(20000);
		hamburger.hamburgerClick();
		resource.resourcesPageLoad();
		
		//Check TestResource Page Title
		String actualTestResourceTitle = driver.getTitle();
		String expectedTestResourceTitle = "Assessment Plus: Resources Picker - Rising Stars Assessment - Rising Stars Assessment";
		assertEquals(expectedTestResourceTitle,actualTestResourceTitle);
		
		//Button visible
		WebElement launchResourcePickerBtn = driver.findElement(By.xpath("//button[@class='res-group button default']"));
		assertTrue(launchResourcePickerBtn.isDisplayed());
		
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test(description="To verify whether the teacher admin is able to download test resources.")
	public void testResourceNewWindowVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		//homepage = new HomePageLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		resource = new TestResourceLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		resource.resourcesPageLoad();
		resource.resourceDialogBox();
		resource.openResourcePdf();
		
		/*
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		if(handles.size()==2)
		{
			System.out.println("No. of tabs: " + handles.size());
		}
		for(String windowHandle  : handles)
		  {
		    if(!windowHandle.equals(parentWindow))
		      {
		    	driver.switchTo().window(windowHandle);	
	    	   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	    	   		
	    	   	String currentURLResourceNewWindow;
	    	   	String expectedURLResourceNewWindow = "https://my.risingstarsassessment.co.uk/api/resourcepicker/download-resource?ResGUID=16dde30a-2433-4ba1-b005-e3725169b2f7&Version=4&Filename=GaPS%20Stage%201%20Mark%20Scheme.pdf"; 
	    	   	currentURLResourceNewWindow = driver.getCurrentUrl();
	    	    if (currentURLResourceNewWindow.equalsIgnoreCase(expectedURLResourceNewWindow)) {
	    	        System.out.println("The Expected Resource loaded successfully.");
	    	     } 
	    	    else {
	    	        System.out.println("The Expected Resource didn't load successfully.");
	    	      }
		          }
		       }
		driver.switchTo().window(parentWindow);
		resource.returnResourcePage();
		
		System.out.println(Thread.currentThread().getId());
		
		
		*/
	}
}