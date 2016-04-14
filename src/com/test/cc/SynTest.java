package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2016-2-2 上午10:00:18
 */
public class SynTest {

	public static void main(String[] args) {
		new SynTest().test();
		new SynTest().test();
		new SynTest().test();
		new SynTest().test();

	}
	
	public void test(){
		new Thread(){
			public void run() {
				System.out.println("do nothing........." + this);
				synchronized (SynTest.class) {
					System.out.println("start........." + this);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("end........." + this);
				}
			};
		}.start();
	}
}
