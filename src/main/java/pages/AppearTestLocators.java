package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppearTestLocators {
	WebDriver driver;
	InteractiveTestLocators interactive;
	WebDriverWait wait;
	

	public AppearTestLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

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
	//public static final By testQ2 = By.xpath("//ic-text[@class='ict-text ict-text-1 ict-group ict-group-1 ict-state-empty ict-state-active']");
	public static final By testQ2 = By.xpath("//input[@style='text-align:left;padding:0.1em 0 0 0.2em;font-size:150%;']");
	
	public static final By testQ3 = By.xpath("//input[@style='padding:0.1em 0 0 0.2em;font-size:150%;']");
	//public static final By testQ5 = By.xpath("//input[@style='padding:0.1em 0 0 0.2em;font-size:150%;']");
	public static final By testQ6a = By.xpath("//ic-text[@ic-group='1']/input");
	public static final By testQ6b = By.xpath("//ic-text[@ic-group='2']/input");
	public static final By testQ7a = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-2 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ7b = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-3 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ7c = By.xpath("//ic-toggle[@class='ict-toggle ict-toggle-5 ict-toggle-multiple ict-toggle-count ict-toggle-count-3 ict-toggle-display ict-toggle-display-tick-shade']");
	public static final By testQ8 = By.xpath("//input[@style='text-align:right;']");
	public static final By testQ9 = By.xpath("//input[@style='padding:0;text-align:center;font-size:150%;']");
	
	
	
	public void enterTestCode() {
		
//		interactive = new InteractiveTestLocators(driver, wait);
//		String trialTestcode = interactive.testcode();
//		
		
		
		
		
//		//String tCode = interactive.testcode();
//		WebElement testcode = driver.findElement(testcodeBtn);
//		testcode.click();
//		//testcode.sendKeys(tCode);  //unused
//		testcode.sendKeys("PZDT5");  //unused
		
		String tCode = interactive.testcode();
		WebElement testcode = driver.findElement(testcodeBtn);
		testcode.click();
		testcode.sendKeys(tCode);  //unused
		//testcode.sendKeys("PZDT5");  //unused
	}
	
	
	public void enterTestcodeTrial() {
		interactive = new InteractiveTestLocators(driver, wait);
		String trialTestcode = interactive.testcode();
		
	}
	
	
	public void enterTestPlayer() throws InterruptedException {
		
		driver.findElement(testcodeNextBtn).click();
		Thread.sleep(2000);

		driver.findElement(testcodeDayDropDown).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(testcodeDay).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(testcodeMonthDropDown).click();
		driver.findElement(testcodeMonth).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(testcodeDayMonNextBtn).click();
		driver.findElement(testcodeSelectStudent).click();
		Thread.sleep(5000);
		
		WebElement fr = driver.findElement(By.id("ifm"));
		driver.switchTo().frame(fr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
		
		
		
		if(driver.findElement(continueTestBtn).isDisplayed()) {
			WebElement continueBtn = driver.findElement(continueTestBtn);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(continueTestBtn));	
			continueBtn.click();
		}
		else if(driver.findElement(startTestBtn).isDisplayed()){
			WebElement start = driver.findElement(startTestBtn);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(startTestBtn));	
			start.click();
		}
		else
        {
            System.out.println("No such button found");
        }
		
		//Decomment the below line if above if else is commented
		//start.click();
		Thread.sleep(2000);
	}

	public void testAttempt() throws InterruptedException {

		driver.findElement(testQ1a).click(); //Q1
		driver.findElement(testQ1b).click(); //Q1
		
		
		
	
		
		WebElement nextBtnElement = driver.findElement(testQnext);
		int i;
		for(i=0;i<=27;i++) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		nextBtnElement.click();
		}
		
		Thread.sleep(2000);
		
		//WebElement fr = driver.findElement(By.id("ifm"));
		//driver.switchTo().frame(fr);
		driver.findElement(endTestBtn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		
		Thread.sleep(2000);
	}
	
}