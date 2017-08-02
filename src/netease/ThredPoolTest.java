package netease;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredPoolTest {

	public static void main(String[] args) {
		ExecutorService executor =  Executors.newCachedThreadPool();  
		executor.execute(new ThreadPoolT());
//		executor.shutdown();
		executor.shutdownNow();

		System.out.println("main end----------------------");
		String s = "1111113333";
		String[] ss = s.split("\\|");
	System.out.println(Arrays.toString(ss));
	}

}
class ThreadPoolT implements Runnable{
	@Override
	public void run() {
		try {
			System.out.println("start----------------------");
			while(true) {
				
			}
//			System.out.println("end----------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}