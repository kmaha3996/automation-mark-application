package testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseTestCase;
import pages.GroupReportLocators;
import pages.HamburgerLocator;
import pages.IndividualReportLocators;
import pages.LoginLocators;

public class TC5_ReportsPage extends BaseTestCase {

	LoginLocators login; 
	HamburgerLocator hamburger;
	IndividualReportLocators individualReport;
	GroupReportLocators groupReport;

	@Test (description="To verify whether the teacher admin is able to generate individual Report")
	public void individualReportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		individualReport = new IndividualReportLocators(driver, wait);
		groupReport = new GroupReportLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		individualReport.reportPageLoad();
		individualReport.reportDialogBox();
		individualReport.individualLaunch();
		
		//To check Report PDF
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   		driver.switchTo().window(windowHandle);	
		    	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		    	   		
		    	   		
		    	   		
		    	   		WebElement displayPDF = driver.findElement(IndividualReportLocators.downloadReport);
		    	   		if(displayPDF.isDisplayed() == true)
		    	   		{
		    	   			System.out.println("Report generated Successfully");
		    	   			//driver.close();
			    	   		//driver.switchTo().window(parentWindow);	
		    	   		}
		          }
		       }
	}
		
	
	@Test (description="To verify whether the teacher admin is able to generate individual Report")
	public void individualShineReportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		individualReport = new IndividualReportLocators(driver, wait);
		groupReport = new GroupReportLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		individualReport.reportPageLoad();
		individualReport.reportDialogBox();
		individualReport.individualLaunch();
		
		//To check Report PDF
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   		driver.switchTo().window(windowHandle);	
		    	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		    	   		
		    	   		
		    	   		
		    	   		WebElement displayPDF = driver.findElement(IndividualReportLocators.downloadReport);
		    	   		if(displayPDF.isDisplayed() == true)
		    	   		{
		    	   			System.out.println("Report generated Successfully");
		    	   			//driver.close();
			    	   		//driver.switchTo().window(parentWindow);	
		    	   		}
		          }
		       }
	}
	
	
	
	@Test (description="To verify whether the teacher admin is able to generate individual Report")
	public void pupilProgressReportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		individualReport = new IndividualReportLocators(driver, wait);
		groupReport = new GroupReportLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		individualReport.reportPageLoad();
		individualReport.reportDialogBox();
		individualReport.pupilProgressReportLaunch();
		
		//To check Report PDF
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   		driver.switchTo().window(windowHandle);	
		    	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		    	   		
		    	   		
		    	   		
		    	   		WebElement displayPDF = driver.findElement(IndividualReportLocators.downloadReport);
		    	   		if(displayPDF.isDisplayed() == true)
		    	   		{
		    	   			System.out.println("Report generated Successfully");
		    	   			//driver.close();
			    	   		//driver.switchTo().window(parentWindow);	
		    	   		}
		          }
		       }
	}
	
	@Test (description="To verify whether the teacher admin is able to generate group report.")
	public void groupReportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		individualReport = new IndividualReportLocators(driver, wait);
		groupReport = new GroupReportLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		individualReport.reportPageLoad();
		individualReport.reportDialogBox();
		groupReport.groupLaunch();
		
		//To check Report PDF
				String parentWindow = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();
				for(String windowHandle  : handles)
				       {
				       if(!windowHandle.equals(parentWindow))
				          {
				    	   		driver.switchTo().window(windowHandle);	
				    	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
				    	   		
				    	   		WebElement displayPDF = driver.findElement(IndividualReportLocators.downloadReport);
				    	   		if(displayPDF.isDisplayed() == true)
				    	   		{
				    	   			System.out.println("Report generated Successfully");
				    	   			//driver.close();
					    	   		//driver.switchTo().window(parentWindow);	
				    	   		}
				          }
				       }
		//driver.findElement(IndividualReportLocators.chooseReportCancel).click();	
		 
	}
	
	
	@Test (description="To verify whether the teacher admin is able to generate group report.")
	public void groupComparisonReportVerify() throws InterruptedException {
		login = new LoginLocators(driver);
		hamburger = new HamburgerLocator(driver, wait);
		individualReport = new IndividualReportLocators(driver, wait);
		groupReport = new GroupReportLocators(driver, wait);
		
		login.loginTeacher();
		hamburger.hamburgerClick();
		individualReport.reportPageLoad();
		individualReport.reportDialogBox();
		groupReport.groupComparisonLaunch();
		
		//utilities.chooseFromDropdown(chooseReportTitle, "New Puma");
		//utilities-> Calendar, dropdown
		
		
	
}	
	
	
	
}	
	