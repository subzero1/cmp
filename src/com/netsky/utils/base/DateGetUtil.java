package com.netsky.utils.base;
import java.util.Calendar;

import com.netsky.utils.base.StringFormatUtil;

import java.util.Date;

/**
 * @description:
 * 
 * @class name:com.netsky.base.utils.DateGetUtil
 *
 * @author lee.xiangyu 2010-1-21
 */
public class DateGetUtil {

	/**
	 * @param args
	 */
	private static int year;

	private static int month;

	private static int day;

	private static int week;

	private static int hour;

	private static int minute;

	private static int second;

	/**
	 * @return current year;
	 */
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.YEAR);
	}

	/**
	 * @return current month;
	 */
	public static int getMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.MONTH) + 1;
	}

	/**
	 * @return current day;
	 */
	public static int getDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.DAY_OF_MONTH);
	}

	/**
	 * @return current hour;
	 */
	public static int getHour() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.HOUR_OF_DAY);
	}

	/**
	 * @return current minute;
	 */
	public static int getMinute() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.MINUTE);
	}

	public int getSecond() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.SECOND);
	}

	/**
	 * @return current week;
	 */
	public static int getWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.DAY_OF_WEEK);
	}

	/**
	 * @return current date;
	 */
	public static String getCurDate() {
		year = getYear();
		month = getMonth();
		day = getDay();
		return year + "-" + StringFormatUtil.getCompleteString(""+month,2) + "-" + StringFormatUtil.getCompleteString(""+day,2);
	}

	/**
	 * @return current date;
	 */
	public static String getCurTime() {
		year = getYear();
		month = getMonth();
		day = getDay();
		hour = getHour();
		minute = getMinute();
		return year + "-" + StringFormatUtil.getCompleteString(""+month,2) + "-" + StringFormatUtil.getCompleteString(""+day,2) + " " + StringFormatUtil.getCompleteString(""+hour,2) + ":" + StringFormatUtil.getCompleteString(""+minute,2);
	}
	
	/**
	 * @return current date;
	 */
	public static Date getCurDate2() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * method:addDay
	 * @param sourceDate Դ����
	 * @param days ���ӵ�����
	 * @return Date
	 */
	public static Date addDay(Date sourceDate,int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(sourceDate);
		cal.add(5, days);
		return cal.getTime();
	}
	
	/**
	 * @param smallDate ��С����
	 * @param bigDate �ϴ�����
	 * @param pattern ����ģʽ year|month|day|hour|minute Ĭ����day
	 * @return ʱ����
	 */
	public static Long dateDiff(Date smallDate,Date bigDate,String pattern) {
		
		Calendar s_cal = Calendar.getInstance();
		Calendar e_cal = Calendar.getInstance();
		Long interval = new Long(0);
		if(smallDate == null || bigDate == null)
			return new Long(0);
			
		s_cal.setTime(smallDate);
		e_cal.setTime(bigDate);
		
		if(pattern == null)
			pattern = "DAY";
		
		if(pattern.toUpperCase().equals("MINUTE")){
			interval = (e_cal.getTimeInMillis() - s_cal.getTimeInMillis()) / (1000 * 60) ;
		}
		else if(pattern.toUpperCase().equals("HOUR")){
			interval = (e_cal.getTimeInMillis() - s_cal.getTimeInMillis()) / (1000 * 60 * 60) ;
		}
		else if(pattern.toUpperCase().equals("DAY")){
			interval = (e_cal.getTimeInMillis() - s_cal.getTimeInMillis()) / (1000 * 60 * 60 * 24) ;
		}
		else if(pattern.toUpperCase().equals("MONTH")){
			interval = (e_cal.getTimeInMillis() - s_cal.getTimeInMillis()) / (1000 * 60 * 60 * 24 * 30) ;
		}
		else if(pattern.toUpperCase().equals("YEAR")){
			interval = (e_cal.getTimeInMillis() - s_cal.getTimeInMillis()) / (1000 * 60 * 60 * 24 * 30 * 365) ;
		}	
		return interval;
	}


	/**
	 * @return current jd;
	 */
	public static String getCurQuarter() {

		month = getMonth();
		if (month == 1 || month == 2 || month == 3)
			return "1";

		if (month == 4 || month == 5 || month == 6)
			return "2";

		if (month == 7 || month == 8 || month == 9)
			return "3";

		if (month == 10 || month == 11 || month == 12)
			return "4";
		return "-1";
	}
	
	public static void main(String[] args){
		System.out.println(addDay(new Date(),2));
		//Object o = null;
		System.out.println(getCurTime());
		//o.toString();
	}
}
