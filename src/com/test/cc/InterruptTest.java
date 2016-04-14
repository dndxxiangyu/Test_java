package com.test.cc;

/** {描述: 功能，使用对象，使用方法等}
 * @author wuxiangyu
 * @since 版本号，从什么版本开始
 * @createDate 2015-12-15 下午3:26:58
 */
public class InterruptTest {

	/**
	 * {简述，保留点号}.
	 * <p>
	 * {详述}
	 * <p>
	 * <code>{样例代码， 小于号大于号转义&lt; &gt;}</code>
	 * @author wuxiangyu 2015-12-15 下午3:26:58
	 * @param args
	 * @modify {上次修改原因} by wuxiangyu 2015-12-15 下午3:26:58
	 */
	public static void main(String[] args) {
		Example1 ex = new Example1();
		ex.start();

	}

}
class Example1 extends Thread {
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
    Example1 thread = new Example1();
    System.out.println( "Starting thread..." );
    thread.start();
    Thread.sleep( 3000 );
    System.out.println( "Interrupting thread..." );
    thread.interrupt();
    Thread.sleep( 3000 );
    System.out.println("Stopping application..." );
    //System.exit(0);
    }
    public void run() {
    while(!stop){
    System.out.println( "Thread is running..." );
    long time = System.currentTimeMillis();
    while((System.currentTimeMillis()-time < 1000)) {
    }
    }
    System.out.println("Thread exiting under request..." );
    }
    }

