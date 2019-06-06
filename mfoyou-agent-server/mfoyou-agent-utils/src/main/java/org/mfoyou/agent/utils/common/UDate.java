package org.mfoyou.agent.utils.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类
 * @author yp-tc-m-2681
 *
 */
public class UDate {

	public final static String timeformat = "yyyy/MM/dd";
	public static int ONE_DAY = 24 * 60 * 60 * 1000;

	/**
	 * 获取当前时间
	 * @return 当前日期 时分秒都是0
	 */
	public static Date getCurDateZero(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get( Calendar.DATE), 0, 0,0);
		return cal.getTime();
	}

	/**
	 * 获取当前时间
	 * @return 当前日期 时分秒是当前值，而不是0
	 */
	public static Date getCurDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	/**
	 * 此方法用于获取从当前时间开始，往前往后的任意日期值
	 * @param now 当前日期
	 * @param diff 时间偏移量，如果type是day，该值是2，表示从当前日期往前推两天，如果今天是2015-08-20，那么得到的值就是2015-08-22
	 * 如果type是hour，该值是2，表示从当前日期往前推两小时，如果今天是2015-08-20 00：00：00，那么得到的值就是2015-08-22 02：00：00
	 * @param type 日期类型，比如天对应值是day，时对应是hour，分对应是minute，月对应是month
	 * @return
	 */
	public static Date dateAdd(Date now,long diff,String type){
		if(type.equals("day")){
			return new Date(now.getTime()+diff*1000*60*60*24);
		}
		else if(type.equals("hour")){
			return new Date(now.getTime()+diff*1000*60*60);
		}
		else if (type.equals("minute")){
			return new Date(now.getTime()+diff*1000*60);
		}
		else if(type.equals("month")){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(now);
			calendar.add(Calendar.MONTH, (int)diff);
			return calendar.getTime();
		}
		else if(type.equals("second")){
			return new Date(now.getTime()+diff*1000);
		}
		return now;
	}

	/**
	 * 获取指定日期
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 指定到日期 时分秒都是0
	 */
	public static Date getPointDay(int year, int month , int day){
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day,0,0,0);
		return cal.getTime();
	}

	/**
	 * 此方法用于格式化日期类
	 * @param date 需要格式的日期
	 * @param formatStr 设置日期格式的参数，比如yyyy-MM-dd HH:mm:ss,如果为null则按默认yyyy/MM/dd 格式显示
	 * @return 当前日期 默认格式是2015/08/21 
	 */
	public static String formatDate(Date date,String formatStr)
	{
		if(date == null){
			return null;
		}
		SimpleDateFormat df  = null;
		if(formatStr!=null){
			df = new SimpleDateFormat(formatStr);
		}else{
			df = new SimpleDateFormat(timeformat);
		}
		String str = df.format(date);
		return str;
	}

	/**
	 * 此方法用于获取该日期是该年的第几周
	 * @param date 日期
	 * @return 该日期是该年的第几周
	 */
	public static int getWeekOfYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 此方法用于将一个时间段处理，返回该时间段的字符串形式
	 * 比如2015/05/24~2015/05/22
	 * @param fDate 开始时间
	 * @param sDate 结束时间
	 * @return
	 */
	public static String getTimeRange(Date fDate,Date sDate){
		return UDate.formatDate(fDate, null)+"~"+UDate.formatDate(sDate, null);
	}

	/**
	 * 此方法将毫秒数转化为00:00:00格式
	 * @param msecs 毫秒数
	 * @return00：00：00格式的字符串
	 */
	public static String msecsFormat(long msecs){
		long hour = 0;
		long minute = 0;
		long second = 0;
		second = msecs / 1000;
		if (second > 60) {
			minute = second / 60;
			second = second % 60;
		}
		if (minute > 60) {
			hour = minute / 60;
			minute = minute % 60;
		}
		return (getTwoLength(hour) + ":" + getTwoLength(minute)  + ":"  + getTwoLength(second));
	}

	private static String getTwoLength(long data) {
		if(data < 10) {
			return "0" + data;
		} else {
			return "" + data;
		}
	}

	public static String currYear(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}


	public void test(){
		System.out.println(formatDate(dateAdd(getCurDate(), 2, "day"),null));
		System.out.println((getPointDay(2015, 8, 21).getTime()-getPointDay(2015, 8, 1).getTime())/(24*60*60*1000));
		System.out.println(getPointDay(2015, 8, 21).getTime());
		System.out.println(msecsFormat(100430454));
	}
	
}
