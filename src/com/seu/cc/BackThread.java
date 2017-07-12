package com.seu.cc;

public class BackThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start------------>"+Thread.currentThread().getName());
		BThread b = new BThread();
		b.setDaemon(true);
		b.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end------------>"+Thread.currentThread().getName());

	}

}
class BThread extends Thread{
	@Override
	public void run() {
		System.out.println("start------------>"+this.getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end------------>"+this.getName());
		
	}
}