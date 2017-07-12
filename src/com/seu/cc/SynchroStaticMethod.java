package com.seu.cc;

import java.lang.reflect.Method;

public class SynchroStaticMethod {
//检查同步静态方法的看门狗是不是对象的class，因为一个类就只有一个class对象。
	public static void main(String[] args){
		B b1 = new B();
		B b2 = new B();
		b1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		b2.a=true;
		b2.start();
		BB bb = new BB();
		AA aa = new AA();
		Th a = new Th(bb);
		Th b = new Th(bb);
		a.start();
		b.start();
		Class cl = AA.class;
		Method[] method=cl.getMethods();
		System.out.println(method.length);
		for(int i=0;i<method.length;i++){
			System.out.println(method[i]);
		}
		CanFighta c = new CanFighta();
		int x=CanFighta.a;
	}
	public void doSomething(){  
        System.out.println("I am in default package.");  
    }  

}
class A{
	public synchronized static void get(){
		System.out.println("start the  get......");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("get method is overed");
	}
	public synchronized static void put(){
		System.out.println("start the  put......");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("put method is overed");
	}
}
class B extends Thread{
	boolean a = false;
	public void run() {
		if(a){
			A.get();
		}else{
			A.put();
		}
	}
}
class AA{
	public synchronized void get(){
		System.out.println("get");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("get-over");
	}
}
class BB extends AA{
	@Override
	public  void get() {
		super.get();
	}
}
class Th extends Thread{
	BB b;
	public Th(BB b){
		this.b = b;
	}
	@Override
	public void run() {
		b.get();
	}
}
interface CanFight {
	void fight();
	int a=10;
}  
class CanFighta implements CanFight{
	public void fight() {
		
	}
}