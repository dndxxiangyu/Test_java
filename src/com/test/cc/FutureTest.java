package com.test.cc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newCachedThreadPool();
		int a = 11;
		MyCall res = new MyCall();
		Future<?> future = es.submit(res);
//		res.setFuture(future);
		try {
			future.get(1500, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		future.cancel(true);
		es.shutdown();
	}
}

class MyCall implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		for(int i=0; i<10; i++){
			Thread.sleep(500);
			System.out.println("Callable schedule: "+i);
		}
		return 10;
	}
	
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++){
					Thread.sleep(500);
				System.out.println("Callable schedule: "+i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
}
class Res implements Runnable{
	public Future<?> future;
	
	public void setFuture(Future<?> future){
		this.future = future;
	}
	public Future<?> getFuture(){
		return this.future;
	}
	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++){
				System.out.println("Callable schedule: "+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			if(this.future!=null){
				this.future.cancel(true);
			}
		}
		
	}
	
}