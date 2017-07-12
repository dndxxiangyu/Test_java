package com;

import java.lang.reflect.Method;
import java.util.SortedSet;
import java.util.TreeSet;

public class Reflected {

	public static void main(String[] args) throws Exception {
//		Class c = Class.forName("DefaultTest");  
//		Method m = c.getDeclaredMethod("doSomething",null);
//		m.invoke(c.newInstance(), null);
//		int i=0;
//		i=++i;
//		System.out.println(i);
//		String a = new String("abc");
//		String b = "abc";
//		String d = "abc";
//		if(d==b){
//			System.out.println("xxxxxxxxxxxxx");
//		}
//		Class<?> c = Class.forName("com.ShowMethod");
//		c.newInstance();
//		Method[] methods  = c.getMethods();
//		Constructor[] ctors = c.getConstructors();
//		for(Method method : methods){
//			System.out.println(method.toString());
//		}
//		for(Constructor cc : ctors){
//			System.out.println(cc);
//		}
//		System.out.println("constructor length:"+ctors.length);
		
		Class clazz = ShowMethod.class;
		for (Method method : clazz.getDeclaredMethods()) {
			if ("get".equals(method.getName())) {
					method.setAccessible(true);//调用private方法
					method.invoke(clazz.newInstance(),null);
					break;
				}
		}
		SortedSet<Integer> st = new TreeSet<Integer>();
		st.add(1);
		st.add(5);
		st.add(4);
		st.add(3);
		System.out.println(st);
	}

}

class ShowMethod{
	public ShowMethod(){
		System.out.println("constructor");
	}
	private void get(){
		System.out.println("showmethod");
	}
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}
	
}