/**
 * 计算两个日期相差的天数；
 * @author hp
 *
 */
package com.seu.cc;
import java.text.*;
import java.util.Date;

public class BetweenDay {

	public static void main(String[] args) {
		BetweenDay bt = new BetweenDay();
		String time1 = bt.getDate();
		System.out.println("现在的时间："+time1);
		String time2 = "2013/5/8";
		System.out.println("以前的时间："+time2);
		long day = bt.getDay(time1, time2);
		System.out.println("相差的天数："+day);
	}
	
	public BetweenDay(){
		
	}
	
	//返回现在的时间；
	public String getDate(){
		SimpleDateFormat ft=new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return ft.format(date);
	}
	
	public long getDay(String date1,String date2){
		long quot = 0;
		SimpleDateFormat ft=new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date time1 = ft.parse(date1);
			Date time2 = ft.parse(date2);
			quot = time1.getTime()-time2.getTime();
			quot = quot/1000/60/60/24;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quot;
	}
	
	
}
