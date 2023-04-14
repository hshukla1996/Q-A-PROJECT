package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.gherkin.model.Scenario;

public class BrowsersUtils {

	
	
	// getText method without trailing and leading spaces
	 public static String getText(WebElement element) {
	        return element.getText().trim();
	    }
	 
	 // getTitle using JS 
	 public static String getTitleWithJS(WebDriver driver) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        return js.executeScript("return document.title").toString();
	    }
	 
	 //getTtile using selenium
	 public static String getTitleWithSel(WebDriver driver) {
	     return  driver.getTitle();
	    }
	 // click using JS
	 public static void clickWithJS(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click()", element);
	    }
	 
	 //Scrolling using JS
	  public static void scrollIntoView(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true)", element);
	    }
	  
	  // Takes a screenshot 
	  public static void getScreenShot(WebDriver driver) throws IOException{
	        Date currentDate=new Date();
	        String screenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
	       
	        File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(screenShotFile,new File(".//screenshots/"+screenShotFileName+".png"));
	        }
	  
	  // switch windows using window handle
	  public static void switchById(WebDriver driver) {
	        String mainPageId = driver.getWindowHandle();
	        Set<String> allPagesId = driver.getWindowHandles();
	        for (String id : allPagesId) {
	            if (!id.equals(mainPageId)) {
	                driver.switchTo().window(id);
	            }
	        }
	    }
	  
	  //switch window using title
	    public static void switchByTitle(WebDriver driver,String title){
	        Set<String> allPagesId=driver.getWindowHandles();
	        for(String id:allPagesId){
	            driver.switchTo().window(id);
	            if(driver.getTitle().contains(title)){
	                break;
	            }
	        }
	    }
	  
	  
	  
	    }
	 

