package com.seu.cc;

import java.util.Arrays;

import com.TestClass;

public class ComparaterSelf extends TestClass{

	public ComparaterSelf(String name) {
		super(name);
	}

	/**
	 * 实现comparable接口才能比较。
	 */
	public static void main(String[] args) {
		Student[] ss = new Student[]{new Student(18,"zhangsan"),new Student(20,"lisi"),new Student(21,"wangwu")};
		Arrays.sort(ss);
		System.out.println(Arrays.toString(ss));
		Student a = new Student(13,"zhdf");
		a.get();
	}

}
class Student implements Comparable{
	
	int num;
	String name;
	
	Student(int num,String name){
		this.num = num;
		this.name = name;
	}
	public int compareTo(Object o) {
		Student s = (Student)o;
		return this.num>s.num ? 1 : (num==0?0:-1);
	}
	public String toString(){
		return "info:"+name+","+num;
	}
	protected void get(){
		System.out.println("get the student");
	}
}