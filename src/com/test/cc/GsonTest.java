package com.test.cc;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-14 下午4:15:40
 */
public class GsonTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Type type = new TypeToken<Foo<String>>(){}.getType();
		System.out.println(type);
		Foo<String> foo = new Foo<>(String.class);
		String[] strArray = foo.getInstance();
		System.out.println(strArray);
	}
}
class Foo<T>{
	T value;
	Class<T> kind;
	public Foo(Class<T> clazz){
		this.kind = clazz;
	}
	public T[] getInstance(){
		return (T[])Array.newInstance(kind, 5);
	}
}
