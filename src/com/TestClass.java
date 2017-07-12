package com;

public class TestClass {
	private String name;
	public TestClass(String name){
		this.name  = name;
	}
	protected void get(){
		System.out.println(this.name+"get method");
	}
}
