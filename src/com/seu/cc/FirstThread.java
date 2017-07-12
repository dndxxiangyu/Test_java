package com.seu.cc;

public class FirstThread extends Thread{
	private int i;
	public FirstThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void run() {
		for(;i<100;i++){
			if(i==20){
				Thread.yield();
			}
			System.out.println(getName()+" "+ i);
		}
	}
	
	public static void main(String[] args) throws Exception{
//		FirstThread ft1 = new FirstThread("第一个线程");
//		ft1.start();
//		new FirstThread("第二个线程").start();
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if( i == 10){
				FirstThread ft = new FirstThread("加入的线程");
			//	ft.setDaemon(true);
				ft.start();
				//ft.join();
				
				
			}
		}
	}

}
