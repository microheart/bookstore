package xushun.bookstore.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTimeFormatTag extends SimpleTagSupport {
	
	// ��Ҫ��ת��������ֵ
	private String value;
	
	// ��ʽ����ģʽ�ַ���
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	
	// ����ֵ�����ͣ�long,date)
	private String type = "long";
	
	@Override
	public void doTag() throws JspException, IOException {
		
//		System.out.println(value);
//		System.out.println(pattern);
//		System.out.println(type);
		
		if(value == null)
			value = System.currentTimeMillis() + "";
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		if("long".equals(type)){
			date = new Date(Long.parseLong(value));
		}
		else {
			/** ע�� ��ֻ��ȡ����java.util.Date���͵��ַ��� , �������ڸ�ʽ���ַ��� ���ᱨ��*/
			date = new Date(value);
			/*try{
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
				date = sdf.parse(value);
			}
			catch(Exception e){
				e.printStackTrace();
			}*/
			
		}
		String dateStr = format.format(date);
		getJspContext().getOut().write(dateStr);
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
