package com.seu.cc;

public class SellTicket {

	
	public static void main(String[] args) {
		SellThread st = new SellThread();//开启四个窗口
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);
		Thread t4 = new Thread(st);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		short a = 1;
		a += 1;
		a = (short) (a+1);
	}

}
class SellThread implements Runnable{
	int tickets=100;
	Object obj = new Object();
	public void run() {
		while(true){
			synchronized(obj){
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(tickets>0){
					
					System.out.println(Thread.currentThread().getName()+"sell tickets:"+tickets);
					tickets--;
				}else{
					return;
				}
			}
		}
		
	}
}