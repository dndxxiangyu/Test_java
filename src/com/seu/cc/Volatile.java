package com.seu.cc;

public class Volatile {
	
	public static void main(String[] args) {
		Thread threads[] = new VolatitleClass[100];
        for (int i = 0; i < threads.length; i++)
            // 建立100个线程
            threads[i] = new VolatitleClass();
        for (int i = 0; i < threads.length; i++)
            // 运行刚才建立的100个线程
            threads[i].start();
        for (int i = 0; i < threads.length; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        System.out.println("n=" + VolatitleClass.n);

	}

}
class VolatitleClass extends Thread{
	public static volatile int n = 0;
	public void run()
    {
        for (int i = 0; i < 10; i++)
            try
        {
                n = n + 1;//n=n+1,n++ long,不是原子级别的操作. long与double操作并不是原子的
                sleep(3); // 为了使运行结果更随机，延迟3毫秒

            }
            catch (Exception e)
            {
            }
    }
}