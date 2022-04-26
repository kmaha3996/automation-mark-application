/**
 * 
 */
package common;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author avanish.bandekar
 *
 */
public class BaseTestCase {

	protected WebDriver driver;
	protected String siteUri;
	protected WebDriverWait wait;
	static String currentRunningMethod = "config method";
	private ScreenshotFunctions scrShtFuncs;

	public void setSiteUri() {
		this.siteUri = "https://my.risingstarsassessment.co.uk/";
	}

	@BeforeClass
	public void initProcess() throws InterruptedException {
		initDriver();
		scrShtFuncs = new ScreenshotFunctions(driver);
		setSiteUri();
		driver.get(siteUri);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethodActions(Method methodObj) {
		currentRunningMethod = methodObj.getName();
	}

	private void initDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opts = new ChromeOptions();
		boolean isHeadless = "headless".equalsIgnoreCase(System.getProperty("mode"));
		opts.setHeadless(isHeadless);
		opts.addArguments("--no-sandbox", "--disable-dev-shm-usage");
		driver = new ChromeDriver(opts);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		if (isHeadless) {
			Dimension dimension = new Dimension(1920, 1080);
			driver.manage().window().setSize(dimension);
		} else {
			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void afterMethodActions(ITestResult result, ITestContext context) {
		screenShot(result);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	/************************ Functions ************************/
	private void screenShot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			// can be used as an attachment in the test case
//             String imgBase64 = 
			scrShtFuncs.saveAndReturnScreenshot();
		}
	}
}