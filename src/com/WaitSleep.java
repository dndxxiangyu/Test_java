package com;

import java.util.HashMap;
import java.util.Hashtable;

public class WaitSleep {

	
	public static void main(String[] args) {
		Th thread = new Th();
		Thread a = new Thread(thread);
		Thread b = new Thread(thread);
		Thread c = new Thread(thread);
		a.start();
		b.start();
		c.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		thread.b = false;
		Thread e = new Thread(thread);
		e.start();
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put(null, null);
		
	}

}
class Th implements Runnable{
	static Object obj = new Object();
	static int i = 0;
	boolean b = true;
	public void run() {
		if(b){
			synchronized (obj) {
				System.out.println("get the obj lock--->:   "+i++);
				try {
					Thread.sleep(1000);
					obj.wait();
					System.out.println("end--->:  "+i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}else{
			synchronized (obj) {
				try {
					obj.notify();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}