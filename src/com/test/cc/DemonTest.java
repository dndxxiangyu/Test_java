package com.test.cc;

public class DemonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T daemonThread = new T();
        // 设置为守护进程
        daemonThread.setDaemon(true);
        daemonThread.start();

	}
	static class T extends Thread{
		public void run() {
			 while (true) {
		            for (int i = 1; i <= 100; i++) {

		                System.out.println(i);
		                try {
		                    Thread.sleep(1000);
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		};
	};
}
