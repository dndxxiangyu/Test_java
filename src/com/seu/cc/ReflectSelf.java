package com.seu.cc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectSelf {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int[] num1 = new int[]{1,2,3};
		int[] num2 = new int[3];
		System.arraycopy(num1, 0, num2, 0, num1.length);//拷贝,拷贝的是引用，不是对象
		System.out.println(Arrays.toString(num2));
		//排序
		Arrays.sort(num1);
		
		int[] cc = {5,4,6,8,3,4,7};
		int j = Arrays.binarySearch(cc, 5);
		System.out.println(j);
		String string = "wuxiangyulicai";
		Point pt = new Point();
		Class c1 = pt.getClass();
		System.out.println(c1.getName());
//		Class c2 = Class.forName("com.seu.cc.Point");
//		System.out.println(c2.getName());
//		Class c3 = Point.class;
//		System.out.println(c3.getName());
//		Class c4 = int.class;
//		System.out.println(c4.getName());
//		Class c5 = Integer.TYPE;
//		System.out.println(c5.getName());
		c1.newInstance();//要有默认的构造函数
		Constructor[] cons = c1.getDeclaredConstructors();//返回全部构造函数
		for(int i=0;i<cons.length;i++){
			System.out.println(cons[i]);
		}
		Constructor[] cons1 = c1.getConstructors();//返回public的构造函数
		for(int i=0;i<cons1.length;i++){
			System.out.println(cons1[i]);
		}
		Class[] params =cons[0].getParameterTypes();//使用这个构造函数的参数
		Object[] paramValues = new Object[params.length];
		for(int i=0;i<params.length;i++){
			//判断是不是基本数据类型
			if(params[i].isPrimitive()){
				paramValues[i] = new Integer(i+3);
			}
		}
		Object o =  cons[0].newInstance(paramValues);
		Method[] m = c1.getDeclaredMethods();
		for(int i=0;i<m.length;i++){
			System.out.println(m[i]);
		}
		m[0].invoke(o, null);
		Runtime rt  = Runtime.getRuntime();
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
//		rt.exec("notepad");//执行windows的一个程序
//		rt.exec("javac ArrayTest.java");
//		MyThread my =  new MyThread();
//		my.setPriority(1);
//		my.start();
//		int index=0;
//		while(true){
//			System.out.println("main:"+Thread.currentThread().getName());
//		}
		
	}


}

class Point{
	static{
		System.out.println("class");
	}
	int x,y;
	public Point(int i, int j){
		
	}
	public Point(){
		
	}
	void get(){
		System.out.println("x= "+x+" y= "+y);
	}
}


class Test1{
	
}
class Test22 extends Test1{
	
}
class MyThread extends Thread{
	int tickets=100;
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName());
			this.get();
		}
	}
	public synchronized void get(){
		if(tickets>0){
			System.out.println("sell:"+tickets);
			tickets--;
		}
	}
}