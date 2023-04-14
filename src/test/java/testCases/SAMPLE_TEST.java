package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.DriverSetUp;

public class SAMPLE_TEST {

	
	
	 WebDriver driver= DriverSetUp.getDriver();
		
		@Test
		public void login() throws InterruptedException {
			driver.get("https://staging.residencyexplorer.org/");
			driver.findElement(By.xpath("//a[text()='Login to Account']")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='IDToken1']")).sendKeys("username1");
			driver.findElement(By.xpath("//input[@name='IDToken2']")).sendKeys("password123");
			driver.findElement(By.id("login-btn")).click();
			System.out.println(" logged in");
	
		}
	
}
