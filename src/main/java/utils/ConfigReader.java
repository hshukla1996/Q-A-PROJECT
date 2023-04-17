package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	
	private static String readProperty(String key)  {
	
   
        Properties prop = new Properties();  // object to red from properties file
        try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src/main/java/resources/GlobalData.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return prop.getProperty(key);
    }

    public static long getGlobalWaitInSeconds() {
        return Long.parseLong(readProperty("global.wait"));
    }

    public static String getBrowser() {
        return readProperty("browser");
    }

    public static String getTimeZone() {
        return readProperty("timezone");
    }

    public static String getEnvironment() {
        return readProperty("environment");
    }

    public static String getUsername() {
        return readProperty("username");
    }

    public static String getPassword() {
        return readProperty("password");
    }

}
