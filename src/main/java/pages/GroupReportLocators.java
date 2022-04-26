package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupReportLocators {

	WebDriver driver; 
	WebDriverWait wait;
	
	public GroupReportLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	

	static final By hamburgerReports = By.linkText("Reports");
	static final By launchReportPickerBtn = By.linkText("Launch the report picker");
	static final By chooseReportTitle =By.xpath("//select[@id='ProductId']");
	static final By chooseReportTitleNewPUMA =By.xpath("//select[@id='ProductId']/option[text()='New PUMA']");
	static final By chooseReportGroupComparison =By.xpath("//span[@class='GroupComparison']");
	static final By chooseReportGroup =By.xpath("//span[@class='GroupListing']");
	static final By chooseReportGroupShine =By.xpath("//span[@class='GroupInterventionMaths']");
	
	
	static final By classGroupComp = By.xpath("//ul[@class='chosen-choices']");
	static final By chooseGroupCompReportClassesMLClassGroup =By.xpath("//li[text()='ML class']");
	
	static final By chooseReportPaper =By.xpath("//select[@class='all-papers']");
	static final By chooseReportPaperNewPumaYear1Spring =By.xpath("//select[@class='all-papers']/option[text()='New PUMA Year 1 Spring']");
	
	
	/*Report Page*/
	//Groups
	static final By chooseReportClassesGroup =By.xpath("//select[@class='all-classes']");
	static final By chooseReportClassesMLClassGroup =By.xpath("//option[text()='Hiral Class']");
	
	
	/*Report Page*/
	//static final By chooseReportGenerateReportBtn = By.linkText("Generate report");
	static final By chooseReportGenerateReportBtn = By.xpath("//a[@class='button right default']");
	
	static final By chooseReportCancel = By.xpath("//span[@class='button left noDefault cancelButton' and text()='Cancel']");
	//Download PDF Page
	static final By downloadReport = By.xpath("//button[text()='Save as PDF']");
	
	
	
	public void groupLaunch() throws InterruptedException {
		//To select Group
		wait.until(ExpectedConditions.elementToBeClickable(chooseReportGroup));	
		driver.findElement(chooseReportGroup).click();
		
		
		//To select Paper common 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(chooseReportPaper).click();
		Thread.sleep(500);	
		driver.findElement(chooseReportPaperNewPumaYear1Spring).click();
		Thread.sleep(500);		
		
		//To select Group Classes
		wait.until(ExpectedConditions.elementToBeClickable(chooseReportClassesGroup));			
		driver.findElement(chooseReportClassesGroup).click();
		driver.findElement(chooseReportClassesMLClassGroup).click();
		Thread.sleep(500);	
		
		//To select Generate Report button
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		
		
		WebElement gen = driver.findElement(chooseReportGenerateReportBtn);
		
		//gen.click();
		
		Actions act = new Actions(driver);
		act.doubleClick(gen).perform();
	}
	
	
	
	
	public void groupComparisonLaunch() throws InterruptedException {
		//To select Group
		wait.until(ExpectedConditions.elementToBeClickable(chooseReportGroupComparison));	
		driver.findElement(chooseReportGroupComparison).click();
		
		
		//To select Paper common 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(chooseReportPaper).click();
		Thread.sleep(500);	
		driver.findElement(chooseReportPaperNewPumaYear1Spring).click();
		Thread.sleep(500);		
		
		wait.until(ExpectedConditions.elementToBeClickable(classGroupComp));			
		driver.findElement(classGroupComp).click();
		wait.until(ExpectedConditions.elementToBeClickable(chooseGroupCompReportClassesMLClassGroup));			
		driver.findElement(chooseGroupCompReportClassesMLClassGroup).click();
		
		//To select Generate Report button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		WebElement gen = driver.findElement(chooseReportGenerateReportBtn);
	
		Actions act = new Actions(driver);
		act.doubleClick(gen).perform();
	}
	
	
	
}




