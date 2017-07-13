package netease;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredPoolTest {

	public static void main(String[] args) {
		ExecutorService executor =  Executors.newCachedThreadPool();  
		executor.execute(new ThreadPoolT());
		executor.shutdown();

		System.out.println("main end----------------------");
	}

}
class ThreadPoolT implements Runnable{
	@Override
	public void run() {
		try {
			System.out.println("start----------------------");
			Thread.sleep(5000);
			System.out.println("end----------------------");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}