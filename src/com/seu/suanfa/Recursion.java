package com.seu.suanfa;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Recursion {

	//递归
	public static void main(String[] args) {
//		String[] array = new String[]{"1","2","3","4"};
//		listAll(Arrays.asList(array),"");
//		String input = "aavzcadfdsfsdhshgWasdfasdfdddaaa";
//		System.out.println(doString(input));
			for(int i=0;i<=10;i++)
				System.out.println(i);
			
	}
	public static void listAll(List candidate, String prefix){
		if(candidate.isEmpty())
			System.out.println(prefix);
		for(int i = 0; i<candidate.size(); i++){
			List temp = new LinkedList(candidate);
			listAll(temp, prefix+temp.remove(i));
		}
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
