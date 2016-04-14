package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2016-2-16 上午10:15:34
 */
public class JoinTest implements Runnable{

	private String temp;
	public static void main(String[] args) throws InterruptedException {
		JoinTest test = new JoinTest();
		test.temp = "wxy";
		Thread thread = new Thread(test);
		thread.start();
		test = null;
//		Thread thread = new Thread(r);
//		thread.start();
//		thread.join();
		System.out.println("-----------main end");
	}
	
	/**
	 * {简述，保留点号}.
	 * <p>
	 * {详述}
	 * <p>
	 * <code>{样例代码， 小于号大于号转义&lt; &gt;}</code>
	 * @author wuxiangyu 2016-2-16 上午10:39:32
	 * @modify {上次修改原因} by wuxiangyu 2016-2-16 上午10:39:32
	 */
	@Override
	public void run() {
		System.out.println("------start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------end");
		System.out.println(temp);
		
	}
}
