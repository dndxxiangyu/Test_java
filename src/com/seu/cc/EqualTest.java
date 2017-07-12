package com.seu.cc;

import java.util.ArrayList;


public class EqualTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new T().equals(new Object()));
		String string = "aaaa";
		Object object = string;
		//说明会检查object的真实类型
		if(object instanceof String){
			System.out.println("tes");
		}
		if(new ArrayList<String>().getClass()==new ArrayList<Integer>().getClass()){
			System.out.println("ok");
		}
	}

}
class T{
	String string;
	
	public boolean equals(Object obj) {
		if(obj instanceof T){
			return true;
		}
		return false;
	}
}