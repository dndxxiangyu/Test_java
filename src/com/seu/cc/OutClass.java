package com.seu.cc;

class OutClass { 
	private int num; 
	public OutClass(int i){ 
		num = i; 
	} 
	public void test() {
		System.out.println("num is " + getNum() + " from Out Class"); 
	} 
	public int getNum() {
		return num; 
	}
	public class Test { 
		
		public void show() { 
			OutClass a = new OutClass(356){ 
				public void test() { 
					System.out.println("num is " + getNum() + " from Inner Class"); 
				} 
			}; a.test(); } }
	}
