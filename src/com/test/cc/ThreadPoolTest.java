package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-29 下午12:50:32
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		for(int i=0; i<134;i++){
			DownloadExecutor.EXECUTOR.execute(new myThread());
		}
	}
}
class myThread extends Thread{

	@Override
	public void run() {
		System.out.println("thread: "+Thread.currentThread().getName() +" :start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread: "+Thread.currentThread().getName()+" :end");
	}
}