package netease;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException{
//		Object object1 = new Object();
//		Object object2 = new Object();
//		Thread1 a = new Thread1(object1, object2);
//		a.start();
//		Thread1 b = new Thread1(object2, object1);
//		b.start();
//		Thread.sleep(3000);
//		a.interrupt();
//		b.interrupt();//只是做了个标记为为中断状态，但是不能被中断掉
//		System.out.println(a.isInterrupted()+"");
//		System.out.println(b.isInterrupted()+"");
		
		
		ReentrantLock lock1 = new ReentrantLock();
		ReentrantLock lock2 = new ReentrantLock();
		Thread2 c = new Thread2(lock1, lock2);
		Thread2 d = new Thread2(lock2, lock1);
		c.start();
		d.start();

		Thread.sleep(3000);
		c.interrupt();
		d.interrupt();
		System.out.println(c.isInterrupted()+"");
		System.out.println(d.isInterrupted()+"");
	}

}

class Thread1 extends Thread{
	Object object1;
	Object object2;
	public Thread1(Object object1, Object object2) {
		this.object1 = object1;
		this.object2 = object2;
	}
	@Override
	public void run() {
		synchronized (object1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread1 object1 out: "+Thread.currentThread().getName());
			synchronized (object2) {

				System.out.println("Thread1 object2 in: "+Thread.currentThread().getName());
			}
		}
	}
}
class Thread2 extends Thread{
	ReentrantLock lock1;
	ReentrantLock lock2;
	Thread2(ReentrantLock lock1, ReentrantLock lock2){
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	@Override
	public void run() {
		try {
			lock1.lockInterruptibly();
			Thread.sleep(1000);
			System.out.println("Thread2 lock1 out: "+Thread.currentThread().getName());
			try {
				lock2.lockInterruptibly();
			}finally {
				lock2.unlock();
			}
			System.out.println("Thread2 lock2 in: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock1.unlock();
		}
		
	}
}