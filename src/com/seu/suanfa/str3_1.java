package com.seu.suanfa;

public class str3_1 {

	/**
	 * s1能否循环移位得到s2
	 * 用空间换取时间
	 */
	public static void main(String[] args) {
		String s1 = "aabbcd";
		String s2 = "cdaa";
		System.out.println("s1,s2是否循环可得到："+get(s1,s2));
		System.out.println(7^5);
		System.out.println(7&5);
		System.out.println(7|5);
		System.out.println(true||false);
	}
	public static boolean get(String s1,String s2){
		s1 = s1+s1;
		System.out.println(s1);
		return s1.contains(s2);
	}
}
