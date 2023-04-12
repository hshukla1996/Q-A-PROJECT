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
	
	private static WebDriver webDriver;

    public DriverSetUp(){};

    public static WebDriver getDriver(){
        if (webDriver == null||((RemoteWebDriver)webDriver).getSessionId()==null){
            webDriver = createWebDriver();
        }
        return webDriver;
    }
    public static WebDriver createWebDriver(){
            //  String browser="chrome";
            switch (ConfigReader.getBrowser()){

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    webDriver=new ChromeDriver(options);
                    
                    break;
            }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webDriver;
    }
	
	
	

}
