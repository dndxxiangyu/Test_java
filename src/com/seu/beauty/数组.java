package com.seu.beauty;

import java.util.Arrays;


public class 数组 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String s = "209.242.1.1";
		String[] string = s.split("\\.");
		System.out.println(Arrays.toString(string));
	}

}
class W{
	static{
		System.out.print("static ");
	}
	public void get(){
		
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("paochuyichang");
		try {
			
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

