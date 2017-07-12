package com.seu.suanfa;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.WeakHashMap;

public class NetEase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
		System.out.println(Arrays.toString("a  b c  d".split(" ")));
		Class c = C.class;
		Constructor[] a=c.getDeclaredConstructors();
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		String x = "xx";
		WeakReference s = new WeakReference<String>(x);
		System.out.println(s.get());
		System.out.println(s.get());
	}
	/*
	 * 网易：题意很简单，写一个程序，打印出以下的序列。
	(a),(b),(c),(d),(e)........(z)
	(a,b),(a,c),(a,d),(a,e)......(a,z),(b,c),(b,d).....(b,z),(c,d).....(y,z)
	(a,b,c),(a,b,d)....(a,b,z),(a,c,d)....(x,y,z)
	....
	(a,b,c,d,.....x,y,z)（思路：全排列问题）
	 */
	public void get(char[] table){
		long a=10;
		switch(1){
		case 1:
			break;
		default:
			break;
		}
	}
}
abstract class F{
//	public F(){
//		System.out.println("father");
//	}
}
class C extends F{
	void get() {
		
	}
}