package com.test.cc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Administrator
 *该程序用来模拟发送命令与执行命令，主线程代表指挥官，新建3个线程代表战士，战士一直等待着指挥官下达命令，
 *若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，战士们都去执行自己的任务，指挥官处于等待状态，战士们任务执行完毕则报告给
 *指挥官，指挥官则结束等待。
 */
public class CountdownLatchTest {

    public static void main(String[] args) {
    	ExecutorService service = Executors.newCachedThreadPool();
    	final CountDownLatch order = new CountDownLatch(1);
    	final CountDownLatch ans = new CountDownLatch(3);
    	for(int i=0; i<3; i++){
    		Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
						order.countDown();
						System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
						Thread.sleep((long)(Math.random()*10000));
						ans.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
				}
			};
			service.execute(runnable);
    	}
    	try {
    		Thread.sleep((long)(Math.random()*10000));
    		order.countDown();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}