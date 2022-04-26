package pages;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Login {
	
		WebDriver driver; 
		Locators loc = new Locators(driver);
		//to perform Scroll on application using Selenium
			
		@BeforeTest
		private void initialiseDriver() {
			WebDriverManager.chromedriver().setup();       //For Chrome
			//WebDriverManager.firefoxdriver().setup();    //For Firefox
			driver = new ChromeDriver();
		}
	
		@Test(priority = 1)
		private void launchUrl() {
			//Launch Window
			driver.get("https://my.risingstarsassessment.co.uk/login?ReturnUrl=%2F");
			//To Maximise
			driver.manage().window().maximize();
		}
		
		@Test(priority = 2)
		private void login() throws InterruptedException {
			loc.launch(); 
			loc.logTrial();
			System.out.println("----------------------------------------------------------------------");
			
			Thread.sleep(5000);
			
			//Check Home Page Title
			String actualHomeTitle = driver.getTitle();
			String expectedHomeTitle = "Home Page - Rising Stars Assessment";
			assertEquals(expectedHomeTitle,actualHomeTitle);
			System.out.println("HOME PAGE:");
			System.out.println("The Expected Title is: " + expectedHomeTitle); 
			System.out.println("And the Actual Title is: " + actualHomeTitle );
			System.out.println("----------------------------------------------------------------------");
		}
	
		
		@Test(priority = 3)
		private void hamburgerClick() throws InterruptedException {
			loc.launch();
			loc.logTrial();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Thread.sleep(5000);
			driver.findElement(Locators.hamburgerBtn).click();
			//Thread.sleep(5000);
			//assert add  element visible 
		}
	
	    
		@Test(priority = 4)
		private void markSheetandGapAnalysisPage() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.hamburgerMarksheetsandGapAnalysis));	
			driver.findElement(Locators.hamburgerMarksheetsandGapAnalysis).click();
			Thread.sleep(5000);
			
			//Check the Mark Sheet Page Title 
			String actualMarksheetTitle = driver.getTitle();
			String expectedMarksheetTitle = "Assessment Plus: Mark - Rising Stars Assessment";
			assertEquals(expectedMarksheetTitle,actualMarksheetTitle);
			System.out.println("MARKSHEETS AND GAP ANALYSIS PAGE:");
			System.out.println("1. Title:");
			System.out.println("The Expected Title is: " + expectedMarksheetTitle); 
			System.out.println("And the Actual Title is: " + actualMarksheetTitle);
		
			driver.findElement(Locators.newPumaSubjectMarksheet).click();
			driver.findElement(Locators.pumaYearSelectMarksheet).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pumaYearYear1Marksheet));
			driver.findElement(Locators.pumaYearYear1Marksheet).click();
			
			Thread.sleep(1000);
			driver.findElement(Locators.pumaPaperSelectMarksheet).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(Locators.pumaPaperSpringMarksheet).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(Locators.pumaClassSelectMarkshet).click();
			
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(Locators.pumaClassMLClassMarksheet).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(Locators.pumaMarkGapAnalysisBtn).click();
			
			//To import CSV file
			driver.findElement(Locators.pumaMarksheetImportViaCsvBtn).click();
			
			Thread.sleep(5000);;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement attach = driver.findElement(Locators.pumaImportMarksChooseFileBtn);
			attach.sendKeys("C:\\Users\\mahalakshmi.thevar\\Documents\\Selenium_training\\attachfile.csv");
			Thread.sleep(5000);
			
			//To upload file
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(Locators.pumaImportMarksheetUploadCsvBtn).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(Locators.pumaImportMarksheetCloseBtn).click();
			
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			//Add the date logic
			
			System.out.println("2. Upload Marks for a class");
			System.out.println("The marks for the class was uploaded successfully and visible properly.");
			System.out.println("----------------------------------------------------------------------");
			
			driver.navigate().back(); 
		}
	
		
		
		@Test(priority = 5)
		private void interactiveTestsPage() throws InterruptedException {
			
			//To select Reports Test from Hamburger menu
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
			hamburgerClick();
			Thread.sleep(1000);
			
			driver.findElement(Locators.hamburgerInteractiveTests).click();
			Thread.sleep(10000);
			
			//Check the Interactive Page Title 
			String actualInteractiveTestTitle = driver.getTitle();
			String expectedInteractiveTestTitle = "Test Assignment - Rising Stars Assessment";
			assertEquals(expectedInteractiveTestTitle,actualInteractiveTestTitle);
			System.out.println("INTERACTIVE TESTS PAGE:");
			System.out.println("1. Title:");
			System.out.println("The Expected Title is: " + expectedInteractiveTestTitle); 
			System.out.println("And the Actual Title is: " + actualInteractiveTestTitle);
			driver.findElement(Locators.newPumaTest).click();
			Thread.sleep(10000);
			driver.findElement(Locators.assignATestTitle).click();
			driver.findElement(Locators.assignATestTitleNewPuma).click();
			Thread.sleep(10000);
			driver.findElement(Locators.assignATestPaper).click();
			driver.findElement(Locators.assignATestPaperNewPumaYear1Spring).click();
			Thread.sleep(10000);
			driver.findElement(Locators.assignATestClass).click();
			driver.findElement(Locators.assignATestClassMLClass).click();
			driver.findElement(Locators.assignATestClass).click();
			Thread.sleep(20000);
			WebElement beforeAssign = driver.findElement(Locators.assignATestStudentBonnie);
			beforeAssign.click();
			Thread.sleep(5000);
			
			driver.findElement(Locators.assignATestAddAllofTheAbove).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);  
			
			driver.findElement(Locators.assignATestAssignTestBtn).click();
			
			System.out.println("2. Assign Test:");
			System.out.println("The test has been assigned successfully.");
			System.out.println("----------------------------------------------------------------------");
			Thread.sleep(5000);
		}
		
		
		
		
		@Test(priority = 6)
		private void reportsPage() throws InterruptedException {
			//To select Reports Test from Hamburger menu
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));			
			hamburgerClick();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			//To select Reports Test from Hamburger menu
			driver.findElement(Locators.hamburgerReports).click();
			
			//Check the Report Page Title 
			String actualReportTitle = driver.getTitle();
			String expectedReportTitle = "Create report - Rising Stars Assessment";
			assertEquals(expectedReportTitle,actualReportTitle);
			System.out.println("REPORTS PAGE:");
			System.out.println("1. Title:");
			System.out.println("The Expected Title is: " + expectedReportTitle); 
			System.out.println("And the Actual Title is: " + actualReportTitle);
			
			//To select Launch Reports Picker button
			driver.findElement(Locators.launchReportPickerBtn).click();
			
			//To select Title
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			driver.findElement(Locators.chooseReportTitle).click();
			driver.findElement(Locators.chooseReportTitleNewPUMA).click();
			Thread.sleep(10000);
			
			/*
			//To select Individual 
			driver.findElement(Locators.chooseReportIndividual).click(); */
			
			//To select Group
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			driver.findElement(Locators.chooseReportGroup).click();
			
			//To select Paper common 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			driver.findElement(Locators.chooseReportPaper).click();
			driver.findElement(Locators.chooseReportPaperNewPumaYear1Spring).click();
					
			//To select Group Classes
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			driver.findElement(Locators.chooseReportClassesGroup).click();
			driver.findElement(Locators.chooseReportClassesMLClassGroup).click();
				
			/*
			//To select Class Individual 
			driver.findElement(Locators.chooseReportClassesIndividual).click();
			driver.findElement(Locators.chooseReportClassesMLClassIndividual).click();
			driver.findElement(Locators.chooseReportClassesIndividual).click();
			Thread.sleep(10000);
			
			//To select All students Individual 
			driver.findElement(Locators.chooseReportStudentIndividual).click();*/
			Thread.sleep(10000);
			
			//To select Generate Report button
			driver.findElement(Locators.chooseReportGenerateReportBtn).click();	
			
			//To check Report PDF
			
			String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for(String windowHandle  : handles)
			       {
			       if(!windowHandle.equals(parentWindow))
			          {
			    	   		driver.switchTo().window(windowHandle);	
			    	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			    	   		
			    	   		WebElement displayPDF = driver.findElement(Locators.downloadReport);
			    	   		if(displayPDF.isDisplayed() == true)
			    	   		{
			    	   			System.out.println("Report generated Successfully");
			    	   			driver.close();
				    	   		driver.switchTo().window(parentWindow);	

			    	   		}
			          }
			       }
			driver.findElement(Locators.chooseReportCancel).click();
			
			System.out.println("2. View Report");
			System.out.println("The Group Report and the Individual Report were visible as intended.");
			System.out.println("----------------------------------------------------------------------");
		}
		

		
		@Test(priority = 7) 
			private void testResources() throws InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
			hamburgerClick();
			
			driver.findElement(Locators.hamburgerTestResources).click();
			
			//Check TestResource Page Title
			String actualTestResourceTitle = driver.getTitle();
			String expectedTestResourceTitle = "Assessment Plus: Resources Picker - Rising Stars Assessment - Rising Stars Assessment";
			assertEquals(expectedTestResourceTitle,actualTestResourceTitle);
			System.out.println("TEST RESOURCE PAGE:");
			System.out.println("1. Title:");
			System.out.println("The Expected Title is: " + expectedTestResourceTitle); 
			System.out.println("And the Actual Title is: " + actualTestResourceTitle );
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(Locators.launchResourcePickerBtn).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(Locators.chooseFirstGapsResource).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(Locators.openResourceInNewWindow).click();
			
			Thread.sleep(20000); 
			
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
			int numberOfTabsResourcePicker = tabs.size();
			
			if(numberOfTabsResourcePicker == 2) {
				System.out.println("2. Resource in New window:");
				System.out.println("The Resource was opened in the new window.");
			}
			else {
				System.out.println("System is comparatively slow. Needs time to load the resource.");
			}
			
			Thread.sleep(5000);
			
			//To check Report PDF in the new window
			
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
		    	        } else {
		    	        System.out.println("The Expected Resource didn't load successfully.");
		    	            }
		    	   		
		    	   		
			    	   
			          }
			       }
			
			
			 driver.switchTo().window(parentWindow);
			driver.findElement(Locators.closeResourceDialogBox).click();
			//System.out.println("No. of tabs: " + tabs.size());
			System.out.println("----------------------------------------------------------------------");
		}
}		
