package com.test.cc;

import com.google.gson.Gson;

public class AbstractTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
	}

}

abstract class ab{
	//实现了的方法里面可以可以调用抽象未实现的方法。
	public abstract void fun();
	public void fun1(){
		System.out.println("fun1");
		fun();
	}
}