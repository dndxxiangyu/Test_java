package com.seu.beauty;

public class 字符串移位包含_3_1 {

	/**
	 * 给定两个字符串s1和s2，判断s2是否能被通过s1循环移位得到字符串包含
	 * s1=AABCD,s2=CDAA-->true
	 */
	public static void main(String[] args) {
		String s1="AABCD";
		String s2="CDAA";
		System.out.println(match(s1, s2));
	}
	public static boolean match(String s1, String s2){
		if(s1==null||s2==null)throw new RuntimeException();
		if(s2.length()>s1.length())return false;
		s1=s1+s1;
		System.out.println(s1);
		System.out.println(s2);
		for(int i=0;i<s1.length()/2;i++){
			if(s1.substring(i, i+s2.length()).equals(s2)){
				return true;
			}
		}
		return false;
	}
}
