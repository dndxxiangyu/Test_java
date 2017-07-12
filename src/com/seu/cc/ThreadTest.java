package com.seu.cc;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadT[] a = new ThreadT[10];
		for(int i=0;i<10;i++){
			a[i] = new ThreadT();
		}
		for(int i=0;i<10;i++){
			a[i].start();
		}

	}

}
class ThreadT extends Thread{
	@Override
	public void run() {
		System.out.println("in run method:"+Thread.currentThread().getName());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dog d = new Dog();
		System.out.println(d.toString()+"   "+d.hashCode());
	}
}
class Dog{
	static int id;
	public Dog(){
		id++;
	}
	public String toString(){
		return "Dog:"+id;
	}
}