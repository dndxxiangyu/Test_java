package com.seu.cc;

class Person1{}
class Student1 extends Person1{}
class Postgraduate extends Student1{}
class Animal{} 
class Animal1 extends Animal{}
class Animal2 extends Animal{}
public class Casting {
	public static void main(String[] args) {
	  instanceofTest(new Postgraduate());
	  Animal a = new Animal1();
//	  Animal2 a1= (Animal2) a;
//	  if(a1 instanceof Animal2){
//		  System.out.println("game over");
//		  
//	  }
	  System.out.println(a.hashCode());
	}
	public static void instanceofTest(Person1 p){
	  // 判断p的真正类型
	  if (p instanceof Postgraduate){
		  System.out.println("p是类Postgraduate的实例");
	  }
	  if(p instanceof Student1){
		  System.out.println("p是类Student的实例");
	  }
	  if(p instanceof Person1){
		  System.out.println("p是类Person的实例");
	  }
	  if(p instanceof Object) {
		  System.out.println("p是类Object的实例");
	  }
	  
	}
}