package com.seu.cc;
/**
 * 一个对象就只有一个锁
 *
 */
public class DeadLock {

	public static void main(String[] args) throws Exception{
		Object b = new Object();
		Object c = new Object();
		Thread a1 = new Thread(new A1(b,c));
		Thread a2 = new Thread(new A2(b,c));
		a1.start();
		a2.start();

	}
	
}
class A1 implements Runnable{
	private Object b,c;
	public A1(Object b,Object c){
		this.b=b;
		this.c=c;
		Thread.currentThread().setName("吴向禹线程----->1");
	}
	public void run() {
		synchronized (b) {
			System.out.println("A1得到b的锁等待c的锁");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (c) {
				System.out.println("A1得到b的锁也得到c的锁");
			}
		}
		
	}
}
class A2 implements Runnable{
	private Object b,c;
	public A2(Object b,Object c){
		this.b=b;
		this.c=c;
		Thread.currentThread().setName("吴向禹线程----->2");
	}

	public void run() {
		synchronized (c) {
			System.out.println("A2得到c的锁等待b的锁");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (b) {
				System.out.println("A2得到c的锁也得到b的锁");
			}
		}
		
	}
}