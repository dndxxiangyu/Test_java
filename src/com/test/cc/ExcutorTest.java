package com.test.cc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		for(int i=0;i<10;i++){
//			executorService.execute(new Runnable() {
//				
//				@Override
//				public void run() {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName());
//				}
//			});
//		}
		System.out.println(executorService.isTerminated());  
		System.out.println("开始释放线程池资源");  
		executorService.shutdown();
		/**
		 * 强制关闭线程池中的所有线程。
		 */
//		executorService.shutdownNow();
		System.out.println("完成释放线程池资源");  
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("test111111111111111111111111111");  
				
			}
		});
	}

}
