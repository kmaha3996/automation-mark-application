package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarksheetLocators {

	WebDriver driver;
	WebDriverWait wait;

	public MarksheetLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	static final By loader = By.cssSelector(".spinner");
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
	static final By pumaImportMarksheetCloseBtn = By
			.xpath("//div[@id='ExportTestCsvLandingDialog']/div[3]/span[text()='Close']");

	// SchoolGaps- Export
	public static final By schoolGapsBtn = By.id("exportSchoolGapAnalysis");
	// public static final By schoolGapsProduct =
	// By.xpath("//select[@id='ProductId']");
	public static final By schoolGapsProduct = By.xpath("//div[@class='chosen-container chosen-container-single']");

	// public static final By schoolGapsProduct =
	// By.xpath("//a[@class='chosen-single']/following-sibling::div[1]");

	public static final By schoolGapsProductPuma = By.xpath("//li[text()='PUMA']");
	public static final By schoolGapsYear = By.xpath("//select[@id='Year']");
	public static final By schoolGapsYear2021 = By.xpath("//option[text()='2021 - 2022']");
	public static final By schoolGapsTerm = By.xpath("//select[@id='TermId']");
	public static final By schoolGapsTermSpring = By.xpath("//option[text()='Spring']");
	public static final By generateBtn = By.id("generateButton");
	public static final By messageBoxAfterGenerate = By.xpath("//div[@class='modalDialog messageBox']");

	public void marksheetPageLoad() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerMarksheetsandGapAnalysis));
		driver.findElement(hamburgerMarksheetsandGapAnalysis).click();
	}

	public void schoolGapExport() throws InterruptedException {
		driver.findElement(schoolGapsBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(schoolGapsProduct));
		driver.findElement(schoolGapsProduct).click();
		driver.findElement(schoolGapsProductPuma).click();
		Thread.sleep(1000);
		driver.findElement(generateBtn).click();
		WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(200));
		longWait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		wait.until(ExpectedConditions.visibilityOfElementLocated(messageBoxAfterGenerate));
		
		longWait.until(ExpectedConditions.invisibilityOfElementLocated(messageBoxAfterGenerate));
	}

	public void markSheetDialogBox() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMarksheetsandGapAnalysis));
		driver.findElement(newPumaSubjectMarksheet).click();

		wait.until(ExpectedConditions.elementToBeClickable(pumaYearSelectMarksheet));
		driver.findElement(pumaYearSelectMarksheet).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(pumaYearYear1Marksheet));
		driver.findElement(pumaYearYear1Marksheet).click();

		Thread.sleep(1000);
		driver.findElement(pumaPaperSelectMarksheet).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(pumaPaperSpringMarksheet));
		driver.findElement(pumaPaperSpringMarksheet).click();

		driver.findElement(pumaClassSelectMarkshet).click();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(pumaClassMLClassMarksheet).click();

		driver.findElement(pumaMarkGapAnalysisBtn).click();
	}

	public void importCsvMarksheet() throws InterruptedException {

		// To import CSV file
		wait.until(ExpectedConditions.elementToBeClickable(pumaMarksheetImportViaCsvBtn));
		driver.findElement(pumaMarksheetImportViaCsvBtn).click();

		Thread.sleep(2000);
		;
		WebElement attach = driver.findElement(pumaImportMarksChooseFileBtn);
		// attach.sendKeys("C:\\Users\\mahalakshmi.thevar\\Documents\\Selenium_training\\attachfile.csv");
		attach.sendKeys(System.getProperty("user.dir") + "/src/main/resources/attachfile.csv");

	}

	public void uploadCsvMarsksheet() throws InterruptedException {
		// To upload file
		driver.findElement(pumaImportMarksheetUploadCsvBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(pumaImportMarksheetCloseBtn));
		driver.findElement(pumaImportMarksheetCloseBtn).click();

		driver.navigate().refresh();

		driver.navigate().back();
	}
}