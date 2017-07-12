package com.seu.suanfa;

import java.util.HashMap;
import java.util.Map;
//求数组中出现字符的最大个数
public class MaxCharLen {

	public static void main(String[] args) {
		String input = "aavzcadfdsfsdhshgWasdfasdfdddaaa";
		System.out.println(doString(input));

	}
	public static Map doString(String input){
		int x=0;
		if(input==null)return null;
		char[] chars = input.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i<chars.length; i++){
			Integer freq = map.get(chars[i]);
			map.put(chars[i], freq==null?1:freq+1);
			if(map.get(chars[i])>x)x=map.get(chars[i]);
		}
		System.out.println("max："+x);
		return map;
	}
}
