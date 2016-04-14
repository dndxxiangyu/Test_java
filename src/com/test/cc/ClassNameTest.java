package com.test.cc;

import java.util.HashMap;
import java.util.Locale;

public class ClassNameTest {
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.getClass().getName());
		HashMap<String, Object> hash = new HashMap<String, Object>();
		for(int i=0;i<10;i++){
			hash.put(i+"key", new Test());
		}
		System.out.println(hash);
		System.out.println("cc".equals(null));
		if("1".equals(1)){
			System.out.println("ccc");
		}
		String tc = null;
		String paramData = String.format(Locale.ENGLISH, "sessionID=%s&type=%s&number=%d", new Object[] { 1, tc, Integer.valueOf(1) });
		System.out.println(tc); 
		System.out.println(paramData); 
	}
}
