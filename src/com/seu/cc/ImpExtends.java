package com.seu.cc;


public abstract class ImpExtends {
	public static void main(String[] args) throws InterruptedException{
		Rubbish a;
		for(int i=0;i<10;i++){
			a = new Rubbish("cc");
		}
		System.gc();
		System.out.println("over");
		Ch c = new Ch(10);
		c.a=10;
		System.out.println(c.get());
	}
}
class Rubbish{
	String name;
	static int i;
	int age;
	public Rubbish(String name){
		i++;
		age = i;
		this.name = name;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Rubbish name :"+name+" is finialize: "+age);
	}
}
class Fa{
	int a;
	public Fa(int a){
		this.a = a;
	}
}
class Ch extends Fa{
	public Ch(int a) {
		super(a);
		this.a = a;
	}
	public int get(){
		System.out.println(super.a);
		return super.a;
	}
	int a;
}
