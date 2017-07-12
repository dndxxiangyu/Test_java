package com.seu.cc;

public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0;i<10;i++){
			System.out.println("读取时间："+new java.util.Date());
			Thread.sleep(3000);
			
		}
	}
}
