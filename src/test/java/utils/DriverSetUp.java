package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverSetUp {

	
	private static WebDriver driver;

    private DriverSetUp(){};  // constructor private constructor to not create an object from this class
    

    public static WebDriver getDriver(){
        if (driver == null||((RemoteWebDriver)driver).getSessionId()==null){
            driver = createWebDriver();
        }
        return driver;
    }
    private static WebDriver createWebDriver(){
            //  String browser="chrome";
            switch (ConfigReader.getBrowser()){

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");// for the new chrome update
                    driver=new ChromeDriver(options);
                   
                    break;
            }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
        return driver;
    }
}
