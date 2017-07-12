package com;

import java.util.Hashtable;
import java.util.Random;



public class Testc {
	static void pringInfo(Class cc){
		System.out.println("Class name:"+cc.getName()+" is interface? ["+cc.isInterface()+"]");
		
	}
	public static void main(String[] args) throws Exception{
//		Class c = null;
//		try {
//			c = Class.forName("com.Gum");  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		pringInfo(c);
//		Class[] in = c.getInterfaces();
//		for(int i=0;i<in.length;i++){
//			pringInfo(in[i]);
//		}
//		Class up = c.getSuperclass();
//		Object obj = null;
//		obj=up.newInstance();
//		pringInfo(obj.getClass());
//		System.out.println(Gum.j);
//		Class<Candy> c = Candy.class;
//		c.newInstance();
//		Class<? extends Number> n = int.class;
//		Class<? super Gum> d = c.getSuperclass();
//		d.newInstance();
		
//		Candy c = new Gum();
//		Class cc = c.getClass();
//		System.out.println(c.getClass().getName());
//		if(c instanceof Gum){
//			System.out.println("c is the class of candy");
//		}
//		if(Candy.class.isInstance(c)){
//			System.out.println("c is the class of candy");
//		}
//		if(Candy.class.isInstance(new Candy())){
//			System.out.println("xxxx");
//		}
//		int i=0;
//		while(i<10){
//			try{
//				int j=1/0;
//			}catch(Exception e){
//				System.out.println(e.getMessage());
//			}
//			i++;
//			System.out.println(i);
//		}
		new t2("cc",1);
		System.out.println(4^3);
	}

}
class Candy{
	int i;
	static{
		System.out.println("loading candy");
	}
	public Candy(){
		System.out.println("constructor Candy");
	}
	public Candy(int i){
		this.i = i;
		System.out.println("constructor Candy");
	}
}

interface A1{}
interface A2{}
interface A3{}

class Gum extends Candy implements A1,A2,A3{
	static final int i = new Random().nextInt(4);
	static final int j = 1;
	static{
		System.out.println("loading gum");
	}
	public void get(){
		System.out.println("Gum get method");
	}
	public Gum(){
		super(1);
		System.out.println("Gum");
	}
}
class Cookie extends Candy{
	static{
		System.out.println("loading cookie");
	}
	public void get(){
		System.out.println("get Cookie");
	}
}
class t1{
	public t1(String name){
		System.out.println("t1(String name)");
	}
	public t1(){
		System.out.println("t1()");
	}
}
class t2 extends t1{

	public t2(String name,int i) {
		super(name);
	}
	public t2(){
		
	}
}