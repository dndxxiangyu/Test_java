package com.seu.beauty;

public class 阶乘求10_2_2 {

	/**
	 * 求出阶乘中5的个数
	 * num=n/5+n/5^2+......
	 */
	public static void main(String[] args) {
		System.out.println("10!="+f(10));
		System.out.println(Integer.toBinaryString(f(10)));
		System.out.println(get2(10));

	}
	public static int getZeroNum(int n){
		int num=0;
		while(n!=0){
			num = num+n/5;
			n = n/5;
		}
		return num;
	}
	//阶乘
	public static int f(int n){
		if(n==1)return 1;
		return f(n-1)*n;
	}
	//找出5的个数就行了
	public static int get10(int n){
		int num=0;
		while(n>0){
			num = num+n/5;
			n = n/5;
		}
		return num;
	}
	//找出2的个数就行了
	public static int get2(int n){
		int num=0;
		while(n>0){
			num=num+n/2;
			n = n/2;
		}
		return num;
	}
}
