package prov;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class TimeHelper {
	private static final DateTimeFormatter XML_DATE_TIME_FORMAT =
			ISODateTimeFormat.dateTimeNoMillis();
	public TimeHelper() {
		 
	}
	
	public String now(){
		MutableDateTime dNow = new MutableDateTime(DateTimeZone.UTC);
		 DateTimeFormatter ft =  DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
		   return ft.print(dNow);
	  //2012-03-02T10:30:00
	}
	public String before(int days){
			MutableDateTime now = new MutableDateTime(DateTimeZone.UTC);
			DateTime daysAgo = now.toDateTime();
			daysAgo=daysAgo.minusDays(days);
		 
	   DateTimeFormatter ft =  DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
	   return ft.print(daysAgo);
	 //2012-03-02T10:30:00

	}
	
	public String parseCIS(String text){
	    DateTime dt = XML_DATE_TIME_FORMAT.parseDateTime(text);
	    DateTimeFormatter ft =  DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
		return ft.print(dt);
	   
	}
	
	public String nowCIS(){
		MutableDateTime dNow = new MutableDateTime(DateTimeZone.UTC);
		 DateTimeFormatter ft =  DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
		   return ft.print(dNow);
		}
	
	public String getDateCIS(String text){
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
		DateTime dt = formatter.parseDateTime(text); 
		DateTimeFormatter ft =  DateTimeFormat.forPattern("dd-MM-yyyy hh:mm:ss");
		return ft.print(dt); 
	}

	
//yyyyMMddHHmm
	//"createTime":"201503011826","lastTime":"2015-03-01 18:07:35.735" "timestamp":"2015-03-03 12:44:40.4440"
	
	
	
	
}
