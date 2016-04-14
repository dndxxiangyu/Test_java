package com.test.cc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	private static long DAY_LONG = 24*60*60*1000;
	private static long HOUR_LONG = 60*60*1000;
	private static final long MINUTE_LONG = 60 * 1000;
	private static SimpleDateFormat YMD = new SimpleDateFormat("MM月dd日");
	private static SimpleDateFormat MDHM = new SimpleDateFormat("MM-dd HH:mm");
	private static SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat YMDHM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static SimpleDateFormat HM = new SimpleDateFormat("HH:mm");
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
		System.out.println(System.currentTimeMillis());
		long start = date.getTime() - 11*60*60*1000;
		System.out.println(formatDate(start+""));
	}

	public static String formatDate(String date) {
		try {
			long start = Long.parseLong(date);
			long now = System.currentTimeMillis();
			long between = now - start;
			
			if (between >= DAY_LONG) {
				return YMD.format(new Date(start));
			} else if (between >= HOUR_LONG) {// day
				int hours = (int) (between / HOUR_LONG);
				return HM.format(new Date(start));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
