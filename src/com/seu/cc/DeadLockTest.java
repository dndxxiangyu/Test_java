package com.seu.cc;


public class DeadLockTest implements Runnable {
    public boolean flag = true;
    static Object res1 = new Object();
    static Object res2 = new Object();
    
    public void run() {
        if(flag) {
            /* 锁定资源res1 */
            synchronized(res1) {
                System.out.println("Resource 1 is locked. Waiting for Resource 2.");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
                /* 锁定资源res2 */
                synchronized(res2) {
                    System.out.println("Complete.");
                }
            }
        }
        else {
            /* 锁定资源res2 */
            synchronized(res2) {
                System.out.println("Resource 2 is locked. Waiting for Resource 1.");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
                /* 锁定资源res1 */
                synchronized(res1) {
                    System.out.println("Complete.");
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
//        DeadLockTest r1 = new DeadLockTest();
//        DeadLockTest r2 = new DeadLockTest();
//        r2.flag = false;
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        t1.start();
//        t2.start();
    	
    	TestThread a1 = new TestThread();
    	Thread x1 = new Thread(a1);
    	Thread x2 = new Thread(a1);
    	Thread x3 = new Thread(a1);
    	x1.start();
    	x2.start();
    	Thread.sleep(1000);
    	a1.downed=true;
    	x3.start();
    	
//    	TestA a = new TestA("xx");
//    	TestA b = new TestA("cc");
//    	Thread a1 = new Thread(a);
//    	Thread b1 = new Thread(b);
//    	a1.start();
//    	b1.start();
    	
    	Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);   
//        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);   
//        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);   
           
           
//        new Thread(pa).start();
//        new Thread(pa).start();
//        Thread.sleep(10);
//        new Thread(pb).start();
//        Thread.sleep(10);
//        new Thread(pc).start();
    }
}
//wait和notify的使用
class TestThread implements Runnable{
	static Test obj = new Test();
	static Test obj1 = new Test();
	boolean flag = false;
	boolean downed = false;
	public void run() {
		if(downed){
			synchronized (obj) {
				flag = true;
				obj.down();
				obj.notify();
//				obj.notifyAll();
				
				System.out.println("notify is gone 快执行完了，代码块执行完了才释放obj的锁");
			}
		}else{
			synchronized(obj){
				if(!flag){
					try {
						System.out.println("waiting for show the picture");
						obj.wait();//把obj这个对象，主动释放对象锁，同时本线程休眠。直到有其它线程调用obj的notify()唤醒该线程，才能继续获取对象锁，并继续执行。
						System.out.println("obj.wait is gone");
						Thread.sleep(1000);//obj重新获得锁以后，但只能运行一个线程。
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				obj.doSome();
			}
		}
	}

}
class Test{
	public void doSome(){
		System.out.println("show the picture");
	}
	public void down(){
		System.out.println("downloaded the picture");
	}
}
class TestA implements Runnable{
	String name;
	int i=100;
	public TestA(String name){
		this.name = name;
	}
	public void run() {
		while(i > 0){
			i--;
			System.out.print(name +" ");
		}
	}
}

class MyThreadPrinter2 implements Runnable {   
	  
    private String name;   
    private Object prev;   
    private Object self;   
  
    MyThreadPrinter2(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    public void run() {     
        int count = 10;     
        while (count > 0) {     
            synchronized (prev) {     
                synchronized (self) {     
                    System.out.print(name);     
                    count--;    
                      
                    self.notify();     
                }
                try {     
                    prev.wait();     
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }  
  
    public static void main(String[] args) throws Exception {   
        Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);   
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);   
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);
           
           
        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();    }   
}  
