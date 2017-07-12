package com.seu.beauty;

public class 二进制中1的个数 {

	/**
	 * 对于一个字节的服务号整形变量，求二进制中1的个数
	 */
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(-10));
		System.out.println(getOne2(-10));
		
	}
	public static int get(int j){
		int num=0;
		while(j!=0){
			j = j&(j-1);
			num++;
		}
		return num;
	}
	//除2法
	public static int  getOne(int j){
		int num=0;
		int i=1;
		while(i<=8){
			if(j%2==1){
				num++;
			}
			j = j/2;
			i++;	
		}
		return num;
	}
	//位操作符
	public static int getOne2(int j){
		int num=0;
		int i=1;
		while(i<=32){
			num = num + (j&1);
			j = j>>>1;
			i++;
		}
		return num;
	}
	//相邻两位相与
	public static int  getOne3(int j){
		int num=0;
		while(j!=0){
			j = j&(j-1);
			num++;
		}
		return num;
	}
}
