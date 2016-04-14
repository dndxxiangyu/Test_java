package com.test.cc;

public class InnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Outter{
	int a=10;
	static int b =0;
	static class Inner{
		void fun(){
			System.out.println("inner fun ");
			System.out.println(b);
		}
	}
	public void fun(){
		new Inner().fun();
	}
}