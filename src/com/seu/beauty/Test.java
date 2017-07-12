package com.seu.beauty;

public class Test {

	
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.hashCode());
		B b = (B) a;
		System.out.println(b.hashCode());
		
		
	}

}
