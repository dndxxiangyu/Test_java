package com.seu.suanfa;

public class Fibonacci {

	/**
	 * 斐波那契额
	 */
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		new Fibonacci().recursive(50);
		long b = System.currentTimeMillis();
		new Fibonacci().fast(50);
		long c = System.currentTimeMillis();
		System.out.println(b-a);
		System.out.println(c-b);
	}
	//递归算法实现，比较简单，冗余比较多
	public int recursive(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		if(n>2){
			return recursive(n-1)+recursive(n-2);
		}
		return 0;
	}
	public int fast(int n){
		int a = 1;//先指向第一个
		int b = 1;//先指向第二个
		int temp = 0;//作为存放下一个
		if(n==1)return 1;
		if(n==2)return 1;
		if(n>2){
			for(int i=3;i<=n;i++){
				temp=a+b;
				a=b;
				b=temp;
			}
			return temp;
		}
		return 0;
	}

}
