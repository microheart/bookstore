package xushun.bookstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static long parseDate(String dateStr,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try {
			return sdf.parse(dateStr).getTime();
		}
		catch(ParseException e) {
			return new Date().getTime();
		}
	}

}
