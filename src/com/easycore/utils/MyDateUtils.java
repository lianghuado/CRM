package com.easycore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {
	// 获得指定日期的fmt字符串
	public static String getDateStr(String datestr) {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			String fmtdate = fmt.format(fmt.parse(datestr));
			return fmtdate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String getDate(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(date);
	}

	// 根据Date获得String
	public static String DateToStr(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}

	// 根据String获得Date
	public static Date StrToDate(String date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获得指定日的前1日
	public static String getDayBefore(String oneday) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(oneday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	// 获得指定日的后1日
	public static String getDayAfter(String oneday) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(oneday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

	// 比较两个日期相差的天数/date1较小/date2较大
	public static int daysBetween(Date date1, Date date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date1 = sdf.parse(sdf.format(date1));
		date2 = sdf.parse(sdf.format(date2));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	// 比较两个日期相差的天数/date1较小/date2较大
	public static int daysBetween(String date1, String date2)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(date1));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(date2));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

}
