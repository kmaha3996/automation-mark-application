package pages;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestResourceLocators {

	WebDriver driver;
	WebDriverWait wait;
	
	public TestResourceLocators(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	static final By hamburgerTestResources = By.linkText("Test Resources");
	//static final By launchResourcePickerBtn = By.linkText("Launch the Test Resource picker");
	static final By launchResourcePickerBtn = By.xpath("//button[@class='res-group button default']");
	static final By chooseFirstGapsResource = By.xpath("//li[@data-resourceid='108452']");
	static final By openResourceInNewWindow = By.xpath("//button[@class='button right default markButton res-download']");
	static final By closeResourceDialogBox = By.xpath("//span[text()='Cancel']");
	
	
	public void resourcesPageLoad() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerTestResources));	
		driver.findElement(hamburgerTestResources).click();
		
		//Check TestResource Page Title
		String actualTestResourceTitle = driver.getTitle();
		String expectedTestResourceTitle = "Assessment Plus: Resources Picker - Rising Stars Assessment - Rising Stars Assessment";
		assertEquals(expectedTestResourceTitle,actualTestResourceTitle);
		
	}
	
	public void resourceDialogBox() throws InterruptedException {
		driver.findElement(launchResourcePickerBtn).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(chooseFirstGapsResource));
		driver.findElement(chooseFirstGapsResource).click();
	}
		
		
		
	public void openResourcePdf() throws InterruptedException {
		driver.findElement(openResourceInNewWindow).click();
		
		
		/*
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
	}
	
	public void returnResourcePage() {
		//String parentWindow = driver.getWindowHandle();
		 //driver.switchTo().window(parentWindow);
		driver.findElement(closeResourceDialogBox).click();
		
		*/
	}
}
