package com;

public class TestBlocked {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
			for(;;){
//				System.out.println("c");
				for(int i=0;i<96000000;i++){}//空循环会是cpu占用
				Thread.sleep(10);//sleep会是cup空闲
			}
		
	}

}
