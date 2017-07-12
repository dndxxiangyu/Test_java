package com.seu.cc;

import java.io.PrintStream;
import java.io.PrintWriter;

public class Counter {
	 
    public static int count = 0;
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        try {
        } catch (Exception e) {
        }
 
        count++;
    }
 
    public static void main(String[] args) throws Exception {
 
//        //同时启动1000个线程，去进行i++计算，看看实际结果
//        for (int i = 0; i < 10000; i++) {
//            new Thread(new Runnable() {
//                public void run() {
//                    Counter.inc();
//                }
//            }).start();
//        }
//        Thread.sleep(10001);
//        //这里每次运行的值都有可能不同,可能为1000
//        System.out.println("运行结果:Counter.count=" + Counter.count);
    	
//    	Thread a = new Thread(new Counte());
//    	Thread b = new Thread(new Counte());
//    	a.start();
//    	b.start();
    	
    	PrintWriter out = new PrintWriter(System.out);
    	PrintStream out1 = new PrintStream(System.out);
    	out.println("xx");
    }
}
class Counte implements Runnable{
	public void run() {
		synchronized (Counter.class) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("get1");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("get2");
		}
	}
}