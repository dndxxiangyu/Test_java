package netease;

public class WaitTimeTest {

	public static void main(String[] args) {
		Object object = new Object();
		WaitThread thread = new WaitThread(object);
		thread.start();
		WaitThread1 thread1 = new WaitThread1(object);
		thread1.start();
	}

}
class WaitThread1 extends Thread {
	Object object;
	public WaitThread1(Object object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		synchronized (object) {
			try {
				System.out.println("waiting1 start---------------------");
				Thread.sleep(2000);
				System.out.println("waiting1 interrupt---------------------");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class WaitThread extends Thread {
	Object object;
	public WaitThread(Object object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		synchronized (object) {
			try {
				System.out.println("waiting start---------------------");
				object.wait(1000);
				System.out.println("waiting interrupt---------------------");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}