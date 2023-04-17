package utils;

import org.testng.annotations.DataProvider;

public class DataProv {

	
	// new methods to pass data can be created as needed
	
			// this is a method to pass login info
			@DataProvider (name = "loginData")
		    public Object[][] loginData(){
			 return new Object[][] {{" USERNAME-VALUE "}, {"PASSWORD-VALUE"}};
		    }
}
