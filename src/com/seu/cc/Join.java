package com.seu.cc;

public class Join {
	public static void main(String[] args){
		System.out.println("start......."+Thread.currentThread().getName());
		Threa a = new Threa();
		a.start();
		try {
			a.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end......."+Thread.currentThread().getName());
	}
}
class Threa extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("aaaaaaa Thread"+Thread.currentThread().getName());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaa Thread is over :"+Thread.currentThread().getName());
	}
}