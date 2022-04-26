package pages;

import static org.testng.Assert.*;

import java.util.List;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractiveTestLocators {

	WebDriver driver;
	HamburgerLocator hamburger;
	WebDriverWait wait;
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	String testcodeCode;
	
	public InteractiveTestLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
	}
	

	static final By hamburgerInteractiveTests = By.linkText("Interactive Tests");
	static final By newPumaTest = By.xpath("//*[@class='title-card cp' and @id='20']");
	static final By assignATestTitle = By.xpath("//*[@class='student-list']//option[text()='Please select a product']/parent::select");
	static final By assignATestTitleNewPuma = By.xpath("//*[@class='student-list']//option[text()='Please select a product']/following-sibling::option [text()= 'New PUMA']");
	static final By assignATestPaper = By.xpath("//*[@class='all-papers']");
	static final By assignATestPaperNewPumaYear1Spring = By.xpath("//*[@class='all-papers']/option[@value='840' and text()= 'New PUMA Year 1 Spring']"); 
	static final By assignATestClass = By.xpath("//*[@id='AllClasses']");
	static final By assignATestClassMLClass = By.xpath("//*[@class='student-list']/option[@value='92846' and text()= 'ML class']");
	static final By assignATestStudentBonnie = By.xpath("//label[@for=\"4970869\"]");
	static final By assignATestAssignTestBtn = By.xpath("//button[@class='button blue-button tad-finish-button' and text()='Assign Test']");
	static final By assignATestAddAllofTheAbove = By.xpath("//button[@id='selectAll']");
	static final By interactiveCalendarBtn = By.id("list-button");
	static final By testLink = By.xpath("//a[@class='test-link' and (contains(text(),\" your school's MARK page (please bookmark this link)\"))]");
	
	public static final By testcodeBtn = By.id("testCode");
	public static final By testcodeNextBtn = By.xpath("//button[@class='student-validation-button']");
	public static final By testcodeDayDropDown = By.id("dobDay");
	public static final By testcodeDay = By.xpath("//option[text()='9']");
	public static final By testcodeMonthDropDown = By.id("dobMonth");
	public static final By testcodeMonth = By.xpath("//option[text()='July']");
	public static final By testcodeDayMonNextBtn = By.xpath("//button[@class='student-validation-button student-validation-next']");
	public static final By testcodeSelectStudent = By.xpath("//button[@data-userid='1904164']");
	//public static final By startTestBtn = By.xpath("//ic-button[@class='ict-button ict-button-next'][2]");
	public static final By startTestBtn = By.xpath("//ic-button[@style='line-height:1.4;border-radius:1em;margin:0;' and @ic-button='next']");
	public static final By endTestBtn = By.xpath("//ic-button[(@ic-button='toggle') and (@style='line-height:1.2;border-radius:1em;')]");
	public static final By continueTestBtn = By.xpath("//ic-button[(@ic-button='resume') and (@style='line-height:1.2;border-radius:1em;position:relative;margin:1em auto;display:block;width:10em;')]");
	public static final By finishTestBtn = By.xpath("//ic-button[@ic-button='end']");
	
	
	
	public static final By testQ1a = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-1 ict-toggle-multiple ict-toggle-count ict-toggle-count-2 ict-toggle-display ict-toggle-display-box']");
	public static final By testQ1b = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-4 ict-toggle-multiple ict-toggle-count ict-toggle-count-2 ict-toggle-display ict-toggle-display-box']");
	public static final By testQnext = By.xpath("//ic-button[@class='ict-button ict-button-next ict-state-pulse']");
	public static final By testQ2 = By.xpath("//input[@style='text-align:left;padding:0.1em 0 0 0.2em;font-size:150%;']");
	public static final By testQ3 = By.xpath("//input[@style='padding:0.1em 0 0 0.2em;font-size:150%;']");
	public static final By testQ6a = By.xpath("//ic-text[@ic-group='1']/input");
	public static final By testQ6b = By.xpath("//ic-text[@ic-group='2']/input");
	public static final By testQ7a = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-2 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ7b = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-3 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ7c = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-5 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ8 = By.xpath("//input[@style='text-align:right;']");
	public static final By testQ9 = By.xpath("//input[@style='padding:0;text-align:center;font-size:150%;']");
	public static final By testFinishedText = By.cssSelector(".test-complete-information");
	
	
	
	
	
	public void interactivePageLoad() throws InterruptedException {
		//To select Test from Hamburger menu
		
		/*
		hamburger = new HamburgerLocator(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		hamburger.hamburgerClick();
		Thread.sleep(1000);
		*/		
		

		wait.until(ExpectedConditions.elementToBeClickable(hamburgerInteractiveTests));
		driver.findElement(hamburgerInteractiveTests).click();
				
		//Check the Interactive Page Title 
		String actualInteractiveTestTitle = driver.getTitle();
		String expectedInteractiveTestTitle = "Test Assignment - Rising Stars Assessment";
		System.out.println("INTERACTIVE TESTS PAGE:");
		System.out.println("1. Title:");
		System.out.println("The Expected Title is: " + expectedInteractiveTestTitle); 
		System.out.println("And the Actual Title is: " + actualInteractiveTestTitle);	
		assertEquals(expectedInteractiveTestTitle,actualInteractiveTestTitle);
	}
	
	
	public void choosePaperInteractives() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(newPumaTest));
		driver.findElement(newPumaTest).click();
	}
	
	
	public void assignTestDialogBox() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(assignATestTitle));
		driver.findElement(assignATestTitle).click();
		driver.findElement(assignATestTitleNewPuma).click();
		driver.findElement(assignATestPaper).click();
		wait.until(ExpectedConditions.elementToBeClickable(assignATestPaperNewPumaYear1Spring));
		driver.findElement(assignATestPaperNewPumaYear1Spring).click();
		driver.findElement(assignATestClass).click();
		driver.findElement(assignATestClassMLClass).click();
		driver.findElement(assignATestClass).click();
		wait.until(ExpectedConditions.elementToBeClickable(assignATestStudentBonnie));
		driver.findElement(assignATestStudentBonnie).click();
		
		driver.findElement(assignATestAddAllofTheAbove).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB);  

		wait.until(ExpectedConditions.elementToBeClickable(assignATestAssignTestBtn));
		driver.findElement(assignATestAssignTestBtn).click();
		
		
	}
	
	
	public void enterCalendar() throws InterruptedException {
		
		WebElement intCal = driver.findElement(interactiveCalendarBtn);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", intCal);
		jse.executeScript("window.scrollBy(0,5000)", "");
	}
	
	public String testcode() {
		List<WebElement> elements1 = driver.findElements(By.xpath("//*[(@class=\"test-status\")  and (contains( text(), \"Miss Mark assigned \"))]/*[(@class=\"student-names\")  and (contains( text(), \"Bonnie Bennett\"))]/parent::p//following-sibling::p[@class='test-code']"));
		testcodeCode = elements1.get(8).getText();
		return testcodeCode;
		//System.out.println(testcodeCode);
		
	}		
	
	public void testcodeTrial() {
		List<WebElement> elements1 = driver.findElements(By.xpath("//*[(@class=\"test-status\")  and (contains( text(), \"Miss Mark assigned \"))]/*[(@class=\"student-names\")  and (contains( text(), \"Bonnie Bennett\"))]/parent::p//following-sibling::p[@class='test-code']"));
		testcodeCode = elements1.get(10).getText();
	
		//System.out.println(testcodeCode);
		
	}	
	
	public void clickTestLink() {
		
		driver.findElement(testLink).click();
		
	}
	
	public void enterTestCode() {
		
//		interactive = new InteractiveTestLocators(driver, wait);
//		String tCode = interactive.testcode();
		WebElement testcode = driver.findElement(testcodeBtn);
		testcode.click();
		testcode.sendKeys(testcodeCode); 
	}
	
	
	
	
	
	public void enterTestPlayer() throws InterruptedException {
		
		driver.findElement(testcodeNextBtn).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(testcodeDayDropDown));
		driver.findElement(testcodeDayDropDown).click();
		Thread.sleep(500);
		driver.findElement(testcodeDay).click();
		
		Thread.sleep(500);
		driver.findElement(testcodeMonthDropDown).click();
		Thread.sleep(500);
		driver.findElement(testcodeMonth).click();

		Thread.sleep(1000);
		driver.findElement(testcodeDayMonNextBtn).click();
		Thread.sleep(5000);	
		driver.findElement(testcodeSelectStudent).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifm")));
		WebElement fr = driver.findElement(By.id("ifm"));
		driver.switchTo().frame(fr);
		
		if(driver.findElement(continueTestBtn).isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(continueTestBtn));	
			driver.findElement(continueTestBtn).click();
		}
		else if(driver.findElement(startTestBtn).isDisplayed()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(startTestBtn));	
			driver.findElement(startTestBtn).click();
		}
		else
        {
            System.out.println("No such button found");
        }
		
		//Decomment the below line if above if else is commented
		//start.click();
	}

	public void testAttempt() throws InterruptedException {

		driver.findElement(testQ1a).click(); //Q1
		driver.findElement(testQ1b).click(); //Q1
		wait.until(ExpectedConditions.elementToBeClickable(testQnext));	
		WebElement nextBtnElement = driver.findElement(testQnext);
		
		for(int i = 0; i <= 27; i++) {
			nextBtnElement.click();
		}
		driver.findElement(endTestBtn).click();
		driver.findElement(finishTestBtn).click();
	}
	
	
	public void testAttemptTrial() throws InterruptedException {
		driver.findElement(testQ1a).click(); //Q1
		driver.findElement(testQ1b).click(); //Q1
		driver.findElement(testQnext).click();
		driver.findElement(testQ2).sendKeys("5"); //Q2
		driver.findElement(testQnext).click();
		driver.findElement(testQ3).sendKeys("7");  //Q3
		driver.findElement(testQnext).click();
		driver.findElement(testQ1a).click(); //Q4
		driver.findElement(testQ1b).click(); //Q4
		driver.findElement(testQnext).click(); 
		driver.findElement(testQ3).sendKeys("5"); // Q5
		driver.findElement(testQnext).click(); 
		driver.findElement(testQ6a).sendKeys("18"); //Q6
		driver.findElement(testQ6b).sendKeys("7"); //Q6
		driver.findElement(testQnext).click(); 
		driver.findElement(testQ7a).click(); //Q7
		driver.findElement(testQ7b).click(); //Q7
		driver.findElement(testQ7c).click(); //Q7
		driver.findElement(testQnext).click(); 
		driver.findElement(testQ8).sendKeys("5");
		driver.findElement(testQnext).click(); 
		driver.findElement(testQ9).sendKeys("50");
		driver.findElement(testQnext).click(); 
	}
	
}
		

