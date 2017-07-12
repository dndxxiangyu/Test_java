package com.seu.cc;

import java.util.ArrayList;

public class Customer2Productor {

	
	public static void main(String[] args) throws Exception{
		Queue q = new Queue();
		Consumer c = new Consumer(q);
		Producer d = new Producer(q);
		d.start();
		Thread.sleep(1);
		c.start();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(null);
		System.out.println(a.isEmpty());
	}

}
class  Consumer extends Thread{
	Queue q;
	Consumer(Queue q){
		this.q = q;
	}
	public void run(){
		while(true){
			System.out.println("Consumer get "+q.get());
		}
	}
}
class Producer extends Thread{
	Queue q;
	Producer(Queue q){
		this.q = q;
	}
	public void run(){
		for(int i=1;i<=10;i++){
			q.put(i);
			System.out.println("Producer put "+i);
		}
	}
}
class Queue{
	int value;
	boolean full=false;
	public synchronized void put(int i){
		if(!full){
			value=i;
			full=true;
			notify();
		}
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized int get(){
		if(!full){
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		full=false;
		notify();
		return value;
	}
}