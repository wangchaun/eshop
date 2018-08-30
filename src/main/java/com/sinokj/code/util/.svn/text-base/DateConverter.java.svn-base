package com.sinokj.code.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	private static final Logger logger = Logger.getLogger(DateConverter.class);
	private static SimpleDateFormat df = new SimpleDateFormat();
	private static final String FMT_A = "yyyy-MM-dd HH:mm:ss";
	private static final String FMT_C = "yyyy-MM-dd HH:mm";
	private static final String FMT_B = "yyyy-MM-dd";
	private static final String FMT_D = "yyyy/MM/dd HH:mm:ss";
	private static List<String> patterns = new ArrayList();

	static {
		patterns.add("yyyy-MM-dd HH:mm:ss");
	    patterns.add("yyyy-MM-dd");
		patterns.add("yyyy-MM-dd HH:mm");
		patterns.add("yyyy/MM/dd HH:mm:ss");
	}

	public Object convertFromString(Map context, String[] values, Class toClass) {
		Date date = null;
		if ((values != null) && (values.length > 0)) {
			String dateString = values[0];
			System.out.println("==================================");
			System.out.println(dateString);
			if (dateString != null) {
				for (String pattern : patterns) {
					try {
						df.applyPattern(pattern);
						date = df.parse(dateString);
					} catch (ParseException ex) {
						logger.debug("string 2 Date error,pattern:" + pattern,
								ex);
					}
				}
			}
		}
		return date;
	}

	public String convertToString(Map context, Object o) {
		String dateString = null;

		Date date = (Date) o;
		df.applyPattern("yyyy-MM-dd HH:mm:ss");
		dateString = df.format(date);

		return dateString;
	}

	public static String viewDate() {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String year = df.format(cal.getTime());
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期

		return year + " " + weekDays[w];
	}
	 
 
}
