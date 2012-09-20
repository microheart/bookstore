package xushun.bookstore.util;

public class StringUtil {
	
	public static boolean isNull(String str) {
		if(str == null)
			return true;
		
		if(str.trim().equals(""))
			return true;
		
		return false;
	}

}
