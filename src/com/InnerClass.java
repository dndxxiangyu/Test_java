package com;

import java.math.BigInteger;


public class InnerClass {
	public static void main(String[] args){
		String a = "ab"; 
		final String bb = "b"; 
		String b = "a" + bb; 
		System.out.println((a == b)); 
		//result = true
		StringBuilder sb = new StringBuilder();
		sb.append("dsf");
		try {
//			Class.forName("com.B");
			Class c = D.class;
			c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class C{
	String cc;
	public C(String cc){
		this.cc = cc;
		System.out.println("C constructor"+cc);
	}
}
class AA{
	static{
		System.out.println("A"); //①
	}
	static C cc = new C("cc");//2
	C c = new C("Aa");//③
	public   void get(){
		System.out.println("get");
	}
	public AA(){
		System.out.println("A constructor"); //④
	}
}
class B extends AA{
	static{
		System.out.println("B"); //②
	}
	C c = new C("Bb");//⑥
	public void get(){
		System.out.println("get");
	}
	public B(){
		System.out.println("B constructor");//⑦
	}
}
class D{
	static C cc = new C("cc");//2
	static{
		System.out.println("A"); //①
	}
	static void get(){
		System.out.println("d--->get");
	}
}