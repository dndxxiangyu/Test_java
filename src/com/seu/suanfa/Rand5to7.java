package com.seu.suanfa;

import java.util.Random;

public class Rand5to7 {

	/**
	 * rand5产生rand7
	 */
	public static void main(String[] args) {
		System.out.println(rand7());
		
	}
	public static int rand5(){
		//题目中给的。
		Random r = new Random();
		return r.nextInt(5)+1;
	}
	
	public static int rand7(){
		int i=0;
		do{
			i=5*(rand5() - 1) + rand5();
		}while(i > 21);
		return i%7 +1;
	}
}
