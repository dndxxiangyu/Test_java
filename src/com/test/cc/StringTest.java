package com.test.cc;

import java.lang.reflect.Field;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-11-6 下午12:43:59
 */
public class StringTest {
	public static void main(String[] args) {
		Field[] f = F.class.getDeclaredFields();
		for(Field field : f){
			System.out.println(field.getName());
			String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			System.out.println(name);
		}
		String b = null;
		String str = "a " + b +" c";
		System.out.println(str+"-------------------------------------");
		b = "abcdefg";
		System.out.println(b.substring(0, 2));
		
		
		String string = "我cc";
		System.out.println(string.length());
		System.out.println(string.toCharArray().length);
		char zh = '我';
		char[] zhs = {'我','你','他','c'};
		System.out.println(zhs.length);
		System.out.println(zhs.toString().getBytes().length);
		
	}
}
class F{
	String name;
	Integer age;
	
}