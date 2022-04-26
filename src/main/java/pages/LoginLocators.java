package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLocators {
	WebDriver driver;
	WebElement signIn ;	
	WebElement username ;	
	WebElement password ;	
	WebElement loginBtn ;	
	WebElement radioDebugging ;	
	WebElement continueLoginBtn ;
	
	public LoginLocators(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	public void loginlocators() {
		signIn = driver.findElement(By.linkText("Sign in"));	
		username = driver.findElement(By.id("Username"));	
		password = driver.findElement(By.id("Password"));	
		loginBtn = driver.findElement(By.xpath("//input[@value='Log in']"));	
		radioDebugging = driver.findElement(By.xpath("//input[@value='5']"));	
		continueLoginBtn = driver.findElement(By.xpath("//input[@value='Continue to MARK']"));
	}	
	*/
	
	public void loginTeacher() throws InterruptedException {
//		signIn.click();
//		username.sendKeys("zeusmark@mailinator.com");
//		password.sendKeys("zeus@123");
//		loginBtn.click();
//		radioDebugging.click();
//		continueLoginBtn.click();
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("Username")).sendKeys("zeusmark@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("zeus@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		//driver.findElement(By.xpath("//input[@value='5']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue to MARK']")).click();
	}
	
	public void loginTeacherAdmin() throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("Username")).sendKeys("zeusmaa@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("zeus@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	//Find teacher
	public void loginNonSubTeacherAdmin() throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("Username")).sendKeys("zeusnoddy@mailinator.com");
		driver.findElement(By.id("Password")).sendKeys("zeus@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(10000);
	}
	
	
	
}