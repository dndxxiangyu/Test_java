package com.test.cc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		FutureTask<Integer> ft = new FutureTask<>(task);
		executor.submit(ft);
		
		executor.shutdown();
		try {
			System.out.println(ft.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		ExecutorService executor = Executors.newCachedThreadPool();
//		Task task = new Task();
//		Future<Integer> result = executor.submit(task);
//		executor.shutdown();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
//         
//        System.out.println("主线程在执行任务");
//         
//        try {
//            System.out.println("task运行结果"+result.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//         
//        System.out.println("所有任务执行完毕");
    }
}
class Task implements Callable<Integer>{
    
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<10;i++)
            sum += i;
        return sum;
    }
}