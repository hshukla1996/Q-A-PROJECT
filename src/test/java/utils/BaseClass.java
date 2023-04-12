package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {

	
	
	public static WebDriver driver;

    @BeforeClass
    public void setup() {
     //   driver = DriverSetUp.getDriver();
    	driver = DriverSetUp.getDriver();
    }

    @AfterClass
    public void tearDown() {
        
        driver.quit();
    }
}
