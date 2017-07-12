package com.seu.cc;

public class ChangeDate {

	public static void main(String[] args) {
		Integer a=1;
		Integer b=2;
		changeInteger(a,b);
		System.out.println("a:"+a+", b:"+b);
	}
	
	public static void change(int a,int b){
		int j=a;
		a=b;
		b=j;
	}
	public static void changeInteger(Integer a,Integer b){
		Integer j=a;
		a=b;
		b=j;
	}
}
