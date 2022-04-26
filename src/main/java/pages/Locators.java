package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Locators {
	private WebDriver _driver;
	
	public Locators(WebDriver driver) {
		_driver = driver;
	}

	//public final By signIn = By.linkText("Sign in");
	public WebElement signIn = _driver.findElement(By.linkText("Sign in"));	
	public WebElement userName = _driver.findElement(By.id("Username"));	
	public WebElement password = _driver.findElement(By.id("Password"));	
	public WebElement loginBtn = _driver.findElement(By.xpath("//input[@value='Log in']"));	
	public WebElement radioDebugging = _driver.findElement(By.xpath("//input[@value='5']"));	
	public WebElement continueLoginBtn = _driver.findElement(By.xpath("//input[@value='Continue to MARK']"));	
	
	
	//static final By userName = By.id("Username");
	//static final By password = By.id("Password");
	//static final By loginBtn = By.xpath("//input[@value='Log in']");
	//static final By radioDebugging = By.xpath("//input[@value='5']");
	//static final By continueLoginBtn = By.xpath("//input[@value='Continue to MARK']");
	static final By hamburgerBtn = By.xpath("//div[@id='banner-menu-button']//descendant::div[1]");
	static final By hamburgerMenu= By.xpath("//div/ul[@class = 'nav-left']//li"); // For List
	static final By hamburgerHome = By.linkText("Home");
	static final By homePageText = By.xpath("//div[@class = 'headingone']");
	static final By hamburgerMarksheetsandGapAnalysis = By.linkText("Marksheets and Gap Analysis");
	static final By newPumaSubjectMarksheet = By.xpath("//a[@data-testgroup-id = '22']");
	static final By pumaYearSelectMarksheet = By.xpath("//div/label[@for='Select_year']/following-sibling::div");
	static final By pumaYearYear1Marksheet = By.xpath("//li[text()='Year 1']");
	static final By pumaPaperSelectMarksheet = By.xpath("//div/label[@for='Select_paper']/following-sibling::div");
	static final By pumaPaperSpringMarksheet = By.xpath("//li[text()='New PUMA Year 1 Spring']");
	static final By pumaClassSelectMarkshet = By.xpath("//div/label[@for='Select_class']/following-sibling::div");
	static final By pumaClassMLClassMarksheet = By.xpath("//li[text()='ML class']");
	static final By pumaMarkGapAnalysisBtn = By.xpath("//input[@type = 'submit' and @value = 'Mark/Gap Analysis']");
	static final By pumaMarksheetImportViaCsvBtn = By.id("exportTestMarkSession");
	static final By pumaImportMarksChooseFileBtn = By.xpath("//input[@id='fileUpload']");
	static final By pumaImportMarksheetUploadCsvBtn = By.xpath("//a[@class=\"button export-button\"]");
	static final By pumaImportMarksheetCloseBtn = By.xpath("//div[@id='ExportTestCsvLandingDialog']/div[3]/span[text()='Close']");
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
	static final By hamburgerReports = By.linkText("Reports");
	static final By launchReportPickerBtn = By.linkText("Launch the report picker");
	static final By chooseReportTitle =By.xpath("//select[@id='ProductId']");
	static final By chooseReportTitleNewPUMA =By.xpath("//select[@id='ProductId']/option[text()='New PUMA']");
	static final By chooseReportIndividual =By.xpath("//span[@class='Individual']");
	static final By chooseReportGroup =By.xpath("//span[@class='GroupListing']");
	static final By chooseReportPaper =By.xpath("//select[@class='all-papers']");
	static final By chooseReportPaperNewPumaYear1Spring =By.xpath("//select[@class='all-papers']/option[text()='New PUMA Year 1 Spring']");
	
	/*Report Page*/
	//Individual User
	static final By chooseReportClassesIndividual =By.xpath("//select[@class='all-classes']");
	static final By chooseReportClassesMLClassIndividual =By.xpath("//select[@class='all-classes']/option[text()='ML class']");
	static final By chooseReportStudentIndividual = By.xpath("//input[@id='selectAll']");
	
	/*Report Page*/
	//Groups
	static final By chooseReportClassesGroup =By.xpath("//select[@class='all-classes']");
	static final By chooseReportClassesMLClassGroup =By.xpath("//option[text()='ML class']");

	/*Report Page*/
	static final By chooseReportGenerateReportBtn = By.linkText("Generate report");
	static final By chooseReportCancel = By.xpath("//span[@class='button left noDefault cancelButton' and text()='Cancel']");
	//Download PDF Page
	static final By downloadReport = By.xpath("//button[text()='Save as PDF']");
	static final By hamburgerTestResources = By.linkText("Test Resources");
	//static final By launchResourcePickerBtn = By.linkText("Launch the Test Resource picker");
	static final By launchResourcePickerBtn = By.xpath("//button[@class='res-group button default']");
	static final By chooseFirstGapsResource = By.xpath("//li[@data-resourceid='108452']");
	static final By openResourceInNewWindow = By.xpath("//button[@class='button right default markButton res-download']");
	static final By closeResourceDialogBox = By.xpath("//span[text()='Cancel']");
	static final By hamburgerMARKPlus = By.linkText("MARK Plus");
	static final By hamburgerShineInterventions = By.linkText("Shine Interventions");
	
	

	public void launch() {
		//Launch Window
		_driver.get("https://my.risingstarsassessment.co.uk/login?ReturnUrl=%2F");
		//To Maximise
		_driver.manage().window().maximize();
	}
	
	public void logTrial() {
		//driver.findElement(signIn).click();	
		signIn.click();
		userName.sendKeys("zeusmark@mailinator.com");
		password.sendKeys("zeus@123");
		loginBtn.click();
	}
}
