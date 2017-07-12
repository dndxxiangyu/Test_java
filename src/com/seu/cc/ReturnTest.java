package com.seu.cc;

public class ReturnTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getReturn("1234"));
	}
	public static String getReturn(String string){
		
		for(int k=0;k<10;k++){
			for(int i=0;i<10;i++){
				if("123".equals(string)){
					return string;
				}
				System.out.println("i="+i);
			}
			System.out.println("k="+k);
		}
		return "wxt";
		
	}
}
