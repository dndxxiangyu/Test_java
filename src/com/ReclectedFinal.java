package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReclectedFinal {
	//反射详解
	public static void main(String[] args) {
		//两者的区别，会不会初始化该class对象。
//		Class c = Class.forName("com.Re");
		Class c = Re.class;
		//得到全部的构造函数
		System.out.println("①得到全部（public和非public）构造函数");
		Constructor[] con = c.getDeclaredConstructors();
		for(Constructor tor:con){
			System.out.println(tor);
		}
		System.out.println("②根据指定参数获得public构造器");
		try {
			//不能为getConstructor(String.class,String.class)，因为这个是得到的public的
			Constructor cont = c.getDeclaredConstructor(String.class,String.class);
			cont.setAccessible(true);
			Re re = (Re) cont.newInstance("wxy","14"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("③得到public的构造函数");
		//得到public的全部构造函数
		Constructor[] con1 = c.getConstructors();
		for(Constructor tor:con1){
			System.out.println(tor);
		}
		System.out.println("④得到全部函数");
		Method[] method = c.getDeclaredMethods();//只有自己的类的方法
		for(Method m:method){
			System.out.println(m);
		}
		System.out.println("⑤得到全部public的函数");
		Method[] method1 = c.getMethods();//包括父类的方法
		for(Method m:method1){
			System.out.println(m);
		}
		System.out.println("⑥得到全部public属性");
		Field[] field = c.getFields();
		for(Field m:field){
			System.out.println(m);
		}
		System.out.println("得到全部属性");
		Field[] field1 = c.getDeclaredFields();
		for(Field m:field1){
			System.out.println(m);
		}
	}

}
class Re{
	static{
		System.out.println("Re");
	}
	private String name;
	private String age;
	public String sex;
	public Re(){
		
	}
	private Re(String name,String age){
		this.name = name;
		this.age = age;
		System.out.println("name:"+name+",age:"+age);
	}
	private Re(String name,String age,String sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("name:"+name+",age:"+age+",sex:"+sex);
	}
	public String getName(){
		return this.name;
	}
	private String getAge(){
		return this.age;
	}
	private String getSex(){
		return this.sex;
	}
	private static void getInf(){
		//访问这个方法不需要实例。所以invoke第一个参数可以为null
		System.out.println("个人信息："+"name:age:sex:");
	}
}