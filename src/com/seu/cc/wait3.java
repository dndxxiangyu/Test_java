package com.seu.cc;

public class wait3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		T1 t1 = new T1(o3,o1);
		T2 t2 = new T2(o1,o2);
		T3 t3 = new T3(o2,o3);
		t1.start();
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);
		t3.start();
	}

}
class T1 extends Thread{
	Object a1;Object a2;
	public T1(Object a1,Object a2){
		this.a1 = a1;
		this.a2 = a2;
	}
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("输出：->1");
			synchronized (a1) {
				synchronized(a2){
					a2.notify();
				}
				try {
					a1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class T2 extends Thread{
	Object a1;Object a2;
	public T2(Object a1,Object a2){
		this.a1 = a1;
		this.a2 = a2;
	}
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("输出：->2");
			synchronized (a1) {
				synchronized(a2){
					a2.notify();
				}
				try {
					a1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class T3 extends Thread{
	Object a1;Object a2;
	public T3(Object a1,Object a2){
		this.a1 = a1;
		this.a2 = a2;
	}
	public void run() {
		for(int i=0;i<3;i++){
			System.out.println("输出：->3");
			synchronized (a1) {
				synchronized(a2){
					a2.notify();
				}
				try {
					a1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}