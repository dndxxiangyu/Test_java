package com.seu.beauty;

public class CPU_1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		while(true){
			int i=10;
		}
	}
	public static void get_50(){
		int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime)
                ;
            // idle loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
	}
}
