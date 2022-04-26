package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HamburgerLocator {

	WebDriver driver;
	WebDriverWait wait;
	
	public HamburgerLocator(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	static final By hamburgerBtn = By.xpath("//div[@id='banner-menu-button']");
	static final By hamburgerMenu= By.xpath("//div/ul[@class = 'nav-left']//li"); // For List
	
	static final By hamburgerHome = By.linkText("Home");
	static final By homePageText = By.xpath("//div[@class = 'headingone']");
	
	
	public void hamburgerClick() {
		wait.until(ExpectedConditions.elementToBeClickable(hamburgerBtn));
		driver.findElement(hamburgerBtn).click();
	}
	

}
