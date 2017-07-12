package com.seu.cc;

public class Exception2 extends RuntimeException{
	
	public Exception2(String msg){
		super(msg);
	}
	public static void main(String[] args) {
		Exception2 x = new Exception2("error");
			throw x;
	}
}
