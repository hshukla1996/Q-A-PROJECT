package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeUtils {

	
	// a method to get current date
	
	public static String getCurrentDate(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        format.withZone(TimeZone.getTimeZone(ConfigReader.getTimeZone()).toZoneId());
        return format.format(now);
    }
}
