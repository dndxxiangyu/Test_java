package com.test.cc;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>(2);
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "3");
		map.put("5", "3");
		map.put("6", "3");
		map.put("7", "3");
		map.put("8", "3");
		System.out.println(map);
	}
}
