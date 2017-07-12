package com.seu.cc;

import java.util.HashSet;

public class Hashcode {

	public static void main(String[] args) {

		HashSet<Man> h = new HashSet<Man>();
		h.add(new Man("a",1));
		System.out.println(":********************");
		h.add(new Man("b",1));
		h.add(new Man("b",2));
		System.out.println(h);
		System.out.println(new Man("c",100));
		Cat c = new Cat();
		System.out.println(c.hashCode());
		System.out.println(Integer.toHexString(c.hashCode()));
		System.out.println(c);
	}
}
class Man{
	public int age;
	public String name;
	public Man(String name,int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println(this.name +":equals");
		Man m = (Man)obj;
		//名字和年纪都相同表示同一个人
		return this.name==m.name&&this.age==m.age?true:false;
	}
	@Override
	public int hashCode() {
		System.out.println(this.name+":hashCode");
		return age;
	}
}


//取消重复的自定义函数
//hashset在存取对象的时候，根据对象的散列码来来计算他的存储位置，而散列码是根据Object对象中的hashcode函数来获取的
//而Object的hashCode是通过对象的内存地址来产生一个散列码
//所以两个不同的对象，是不同的内存地址，所以两个对象的散列码也不同。
class Studuo{
	int num;
	String name;
	Studuo(int num,String name){
		this.name=name;
		this.num=num;
	}
	public String toString(){
		return num+":"+name;
	}
	
	public int hashCode() {
		return num*name.hashCode();
	}
	public boolean equals(Object obj){
		Studuo s = (Studuo)obj;
		return this.name==s.name&&this.num==s.num;
	}
}