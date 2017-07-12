package com.seu.cc;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSyn {

	/**
	 * 
	 */
	public static void main(String[] args) {
		final java.util.List<Integer> arr = Collections.synchronizedList(new ArrayList<Integer>());
//		final java.util.List<Integer> arr = new ArrayList<Integer>();//会不同步
		Thread t1 = new Thread(){
			public void run() {
				for(int i=0;i<25;i++){
					arr.add(i);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run() {
				for(int i=25;i<50;i++){
					arr.add(i);
				}
			}
		};
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(arr);
		System.out.println("length:"+arr.size());
	}

}
