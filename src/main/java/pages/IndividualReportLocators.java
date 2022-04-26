package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndividualReportLocators {
	
	WebDriver driver;
	WebDriverWait wait;

	public IndividualReportLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	static final By hamburgerReports = By.linkText("Reports");
	public static final By launchReportPickerBtn = By.linkText("Launch the report picker");
	static final By chooseReportTitle =By.xpath("//select[@id='ProductId']");
	static final By chooseReportTitleNewPUMA =By.xpath("//select[@id='ProductId']/option[text()='New PUMA']");
	static final By chooseReportIndividual =By.xpath("//span[@class='Individual']");
	static final By chooseReportPupilProgress =By.xpath("//span[@class='PupilProgress']");
	static final By chooseReportIndividualShine =By.xpath("//span[@class='IndividualInterventionMaths']");

	static final By chooseReportPaper =By.xpath("//select[@class='all-papers']");
	static final By chooseReportPaperNewPumaYear1Spring =By.xpath("//select[@class='all-papers']/option[text()='New PUMA Year 1 Spring']");
	
	/*Report Page*/
	//Individual User
	static final By chooseReportClassesIndividual =By.xpath("//select[@class='all-classes']");
	static final By chooseReportClassesMLClassIndividual =By.xpath("//select[@class='all-classes']/option[text()='ML class']");
	static final By chooseReportStudentIndividual = By.xpath("//input[@id='selectAll']");
	
	
	/*Report Page*/
	static final By chooseReportGenerateReportBtn = By.linkText("Generate report");
	public static final By chooseReportCancel = By.xpath("//span[@class='button left noDefault cancelButton' and text()='Cancel']");
	//Download PDF Page
	public static final By downloadReport = By.xpath("//button[text()='Save as PDF']");
	
	
	
	public void reportPageLoad() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerReports));
		driver.findElement(hamburgerReports).click();
	}
	
	public void reportDialogBox() throws InterruptedException {
		//To select Launch Reports Picker button
		driver.findElement(launchReportPickerBtn).click();
		
		//To select Title
		wait.until(ExpectedConditions.elementToBeClickable(chooseReportTitle));
		driver.findElement(chooseReportTitle).click();
		
		
		driver.findElement(chooseReportTitleNewPUMA).click();
		
	}
	
	
	public void individualLaunch() throws InterruptedException {
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportIndividual));	
		
		//To select Individual 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(chooseReportIndividual).click();
		
		//To select Paper common 
		driver.findElement(chooseReportPaper).click();
		driver.findElement(chooseReportPaperNewPumaYear1Spring).click();
		
		
		
		//To select Class Individual 
		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportClassesIndividual));	
		driver.findElement(chooseReportClassesIndividual).click();
		driver.findElement(chooseReportClassesMLClassIndividual).click();
		driver.findElement(chooseReportClassesIndividual).click();
		
		//To select All students Individual 
		driver.findElement(chooseReportStudentIndividual).click();
		
		//To select Generate Report button
		driver.findElement(chooseReportGenerateReportBtn).click();	
		
		
	}
	

		public void individualShineReportLaunch() throws InterruptedException {
		
		//use wait for expected conditions
		//remove thread.sleep, implicit wait

		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportIndividualShine));	
		
		//To select Individual 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(chooseReportIndividualShine).click();
		
		//To select Paper common 
		driver.findElement(chooseReportPaper).click();
		driver.findElement(chooseReportPaperNewPumaYear1Spring).click();
		
		
		
		//To select Class Individual 
		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportClassesIndividual));	
		driver.findElement(chooseReportClassesIndividual).click();
		driver.findElement(chooseReportClassesMLClassIndividual).click();
		driver.findElement(chooseReportClassesIndividual).click();
		
		//To select All students Individual 
		driver.findElement(chooseReportStudentIndividual).click();
		
		//To select Generate Report button
		driver.findElement(chooseReportGenerateReportBtn).click();	
		
		
	}
		
		public void pupilProgressReportLaunch() throws InterruptedException {
			
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportPupilProgress));	
			
			//To select Individual 
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
			driver.findElement(chooseReportPupilProgress).click();
			
			
			
			//To select Class Individual 
			wait.until(ExpectedConditions.visibilityOfElementLocated(chooseReportClassesIndividual));	
			driver.findElement(chooseReportClassesIndividual).click();
			driver.findElement(chooseReportClassesMLClassIndividual).click();
			driver.findElement(chooseReportClassesIndividual).click();
			
			//To select All students Individual 
			driver.findElement(chooseReportStudentIndividual).click();
			
			//To select Generate Report button
			driver.findElement(chooseReportGenerateReportBtn).click();	
			
			
		}
		
}
