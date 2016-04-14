package com.test.cc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest {
	
	public static void main(String[] args) {
		long times = 1441764496128l;
		Calendar currentTimeCalendar = Calendar.getInstance();
		System.out.println(currentTimeCalendar.get(1));
        currentTimeCalendar.setTimeInMillis(times);
        currentTimeCalendar.set(Calendar.MINUTE, 0);
        currentTimeCalendar.set(Calendar.SECOND, 0);
        currentTimeCalendar.set(Calendar.MILLISECOND, 0);
        System.out.println(currentTimeCalendar.getTimeInMillis());
        currentTimeCalendar.set(Calendar.HOUR_OF_DAY, 0);
        System.out.println(currentTimeCalendar.getTimeInMillis());
        System.out.println(currentTimeCalendar);
        
        
        
        Calendar cale = Calendar.getInstance();
		cale.setTimeInMillis(times);
		int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DAY_OF_MONTH);
        int hour = cale.get(Calendar.HOUR_OF_DAY);
        int minute = cale.get(Calendar.MINUTE);
        int second = cale.get(Calendar.SECOND);
        String time = String.format(Locale.ENGLISH, "%d-%02d-%02d %02d:%02d:%02d",  year, month, day, hour, minute, second);
        System.out.println(time);
        
        SimpleDateFormat  sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sm.format(new Date()));
        
	}
}
