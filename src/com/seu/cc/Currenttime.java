package com.seu.cc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Currenttime {
	public static void main(String[] args){
		long time=System.currentTimeMillis();
		System.out.println(time);
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		System.out.println(sdf.format(date));
		System.out.println(sdf.format(time));
		
	}
}
