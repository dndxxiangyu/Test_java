package com.seu.cc;

public class BreakTest {

	private static int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("外面一层的第"+(++i)+"循环");
			while(true){
				System.out.println("---------里面一层的第"+(++i)+"循环");
				if(i==5){
					break;
				}
			}
		}
	}

}
