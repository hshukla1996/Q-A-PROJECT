package testCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BrowsersUtils;
import utils.DriverSetUp;

public class SampleTest {

	
	
	 WebDriver driver= DriverSetUp.getDriver();
		
	 
	 
	
	 
	 @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value"}, {"Second-Value"}};
     }
		  
		@Test
		public void login() throws InterruptedException, IOException {
			driver.get("https://staging.residencyexplorer.org/");
			driver.findElement(By.xpath("//a[text()='Login to Account']")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='IDToken1']")).sendKeys("username1");
			driver.findElement(By.xpath("//input[@name='IDToken2']")).sendKeys("password123");
			driver.findElement(By.id("login-btn")).click();
			System.out.println(" logged in");
			BrowsersUtils.getScreenShot(driver);
			
//			Date currentDate=new Date();
//	        String screenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
//	       
//	        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	        FileUtils.copyFile(screenShotFile,new File(".//screeenshots/"+screenShotFileName+".png"));
		}

		
}
