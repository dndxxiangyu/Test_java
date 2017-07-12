package com.seu.structure;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		A ca = new A();
		System.out.println(ca);
		System.out.println(ca.hashCode());
		String b=new String("dd");
		String a="dd";
		String c="dd";
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if(a==b)
		System.out.println(a.hashCode());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if(a==c)
		System.out.println(b.hashCode());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if(b==c)
		System.out.println(c.hashCode());
		ca.c=10;
		System.out.println();A.get(ca);
	}

}
class A{
	int c;
	public static void get(A a){
		System.out.println("A:get()"+a.c);
	}
}class B{
	int x;
	public static void get(){
		System.out.println("B:get()");
	}
}