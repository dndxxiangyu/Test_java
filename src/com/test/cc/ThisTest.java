package com.test.cc;

import java.util.ArrayList;
import java.util.Arrays;

public class ThisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Father a =new Father();
//		Child b = new Child();
		Factory.print();
		ThisTest tt = new ThisTest();
		String[] te = {"a","b","c"};
		te=null;
		tt.put(te);
		System.out.println(ThisTest.class.getSimpleName());
	}
	public void put(String... s){
		System.out.println(Arrays.toString(s));
	}
}
class Factory{
	static ArrayList<Father> arr = new ArrayList<Father>();
	static void put(Father s){
		arr.add(s);
	}
	static void print(){
		if(arr != null){
			System.out.println(arr);
		}
	}
}
class Father{
	public Father(){
		Factory.put(this);//test the object of this
	}
}
class Child extends Father{
	
}
interface te {
	void put();
}