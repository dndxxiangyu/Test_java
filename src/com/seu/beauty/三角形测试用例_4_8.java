package com.seu.beauty;

import java.util.HashMap;

public class 三角形测试用例_4_8 {

	/**
	 * 测试必须具备从各个角度看问题，找出可能缺陷的能力。
	 * 输入三角形的三条边长，判断是否能构成一个三角形，是什么样的三角形
	 * 
	 */
	public static void main(String[] args){
		A a = new A();
//		a.get();
		A b = new B();
//		b.get();
		HashMap hash = new HashMap();
		for(int i=0;i<100;i++){
			hash.put(i, i);
		}
		System.out.println(hash);
	}
	public static boolean getTriangelType(int a, int b, int c){
		
		return false;
	}
	//如何写测试用例
	/**
	 * 作为测试者，要测试一个程序，具体的工作就是要分析程序可能出现的漏洞，
	 */
}
class A{
	void get(){
		System.out.println("A");
	}
}
class B extends A{
	public B(){
		this.get();
	}
	void get(){
		System.out.println("B");
	}
}